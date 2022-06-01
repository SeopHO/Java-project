package gamegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class InGameScreen extends JPanel implements ActionListener{
    public Timer timer;
    public static int timeCnt=0;
    public int deadCnt=0;
    public EnemyAppearance enemyAppearance = null;
    public Player player=null;
    public Enemy boss=null;
    public EnemyPattern pattern;
    public DeadScreen deadTitle;
    private final int DELAY = 10;

	InGameScreen()
	{
		setBackground(Color.black);
        player = new Player(); 
    	enemyAppearance = new EnemyAppearance();
    	System.out.println(EnemyAppearance.EnemyAppearanceCheck);
        timer = new Timer(DELAY, this);
        timer.start();
	}
    public void paintComponent(Graphics g) 
    { 
    	super.paintComponent(g); 
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }
    private void doDrawing(Graphics g) 
    {
        Graphics2D graphic = (Graphics2D) g;
        //draw Player
        doDrawingPlayer(graphic);
        //draw Appearance Boss
        if(EnemyAppearance.EnemyAppearanceCheck)
        {
        	doDrawingAppearanceBoss(graphic);
        }
        //draw Boss
        if(Enemy.bossAppear)
        {
            doDrawingBoss(graphic);
        	doDrawingBossBar(graphic);
        }
        //draw Boss Bullet
        if(Enemy.bossAppear) 
        {
            Vector<EnemyBullet> Enemybullets = pattern.getBullet();
            for(EnemyBullet Enemybullet:Enemybullets) 
            {
                graphic.drawImage(Enemybullet.getImage(), 
                		Enemybullet.getX(), 
                		Enemybullet.getY(), 
                		this);
                
            }

        }
        //draw player Bullet
        Vector<Bullet> bullets = player.getBullet();
        for(Bullet bullet:bullets) 
        {
            graphic.drawImage(bullet.getImage(), 
            		bullet.getX(), 
            		bullet.getY(), 
            		this);
        }
        //draw deadScreen
        if(player.conflict == true)
        {
        	deadTitle = new DeadScreen();
        	deadTitle.doDrawingDeadScreen(graphic);
        }
    }
    public void doDrawingAppearanceBoss(Graphics g)
    {
      	g.drawImage(enemyAppearance.getImage(),enemyAppearance.getX(),enemyAppearance.getY(),this);
     }
    public void doDrawingBoss(Graphics g)
    {
    	g.drawImage(boss.getImage(),boss.getX(),boss.getY(),this);
    }
    private void doDrawingPlayer(Graphics2D graphic)
    {
        graphic.drawImage(player.getImage(), 
        		player.getX(), 
        		player.getY(), 
        		this);
    }
    public void doDrawingBossBar(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,boss.getHp(),20);
    }
    public void createBoss()
    {
    	enemyAppearance = null;
    	boss = new Enemy();
    	pattern = new EnemyPattern(boss,player);
    	pattern.start();
    }
    public void actionPerformed(ActionEvent e) 
    {
        if(!EnemyAppearance.EnemyAppearanceCheck && !Enemy.bossAppear)
        {
        	createBoss();
        }
    	if(player.conflict == true)
    	{
			deadCnt++;
			player.dead(deadCnt);
    	}
    	movePlayerStep();
    	moveBulletStep();
    	if(Enemy.bossAppear)
    	{
        	moveEnemyBulletStep();
    	}
    	if(EnemyAppearance.EnemyAppearanceCheck)
    	{
    		moveEnemyAppearanceStep();
    	}

    	repaint();
    }
    private void movePlayerStep() 
    {
    	player.move();
    	if(Enemy.bossAppear)
    	{
        	if((player.getX()+25)>=boss.getX() && (player.getX()+25)<=boss.getWidth()+boss.getX())
        	{
        		if((player.getY()+9)>=boss.getY() && (player.getY()+9)<=boss.getHeight()+boss.getY())
        		{        			
        			player.conflict = true;
        		}
        	}
    	}
    }   
    private void moveBulletStep()
    {
        Vector<Bullet> bullets = player.getBullet();

        for (int i = 0; i < bullets.size(); i++) 
        {
        	Bullet bullet = bullets.get(i);
            if (bullet.IsReady()) 
            {
            	bullet.move();
            	if(Enemy.bossAppear)
            	{
                	if(bullet.getX()>=boss.getX() && bullet.getX()<=boss.getWidth()+boss.getX())
                	{
                		if(bullet.getY()>=boss.getY() && bullet.getY()<=boss.getHeight()+boss.getY())
                		{
                			movebossBarStep();
                			bullets.remove(i);
                		}
                	}
            	}
            } 
            else
            {
            	bullets.remove(i);
            }
        }
    }
    private void moveEnemyAppearanceStep()
    {
    	enemyAppearance.move();
    }
    private void moveEnemyBulletStep()
    {
        Vector<EnemyBullet> Enemybullets = pattern.getBullet();
        for (int i = 0; i < Enemybullets.size(); i++) 
        {
        	EnemyBullet enemyBullet = Enemybullets.get(i);
        	if(enemyBullet.IsReady())
        	{
        		enemyBullet.move();
            	if(player.getX()>=enemyBullet.getX() && player.getX()<=enemyBullet.getWidth()+enemyBullet.getX())
            	{
            		if(player.getY()>=enemyBullet.getY() && player.getY()<=enemyBullet.getHeight()+enemyBullet.getY())
            		{
            			player.conflict = true;
            		}
            	}
        	}
        	else
        	{
        		Enemybullets.remove(i);
        	}
        }
    }
    private void movebossBarStep()
    {
    	if(Enemy.bossAppear)
    		boss.HP=boss.HP-1;
    }
}
