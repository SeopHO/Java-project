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
    public int timeCnt=0;
    public int deadCnt=0;
    public Player player=null;
    public Enemy boss=null;
    public EnemyPattern pattern;
    public DeadScreen deadTitle;
    private final int DELAY = 10;

	InGameScreen()
	{
		setBackground(Color.black);
        player = new Player(); 
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
        drawPlayer(graphic);
        //draw Boss
        if(EnemyPattern.bossAppear)
        {
            doDrawingBoss(graphic);
        	doDrawingBossBar(graphic);
        }
        //draw Bullet
        Vector<Bullet> bullets = player.getBullet();
        for(Bullet bullet:bullets) 
        {
            graphic.drawImage(bullet.getImage(), 
            		bullet.getX(), 
            		bullet.getY(), 
            		this);
        }

        //draw Enemy
        if(timeCnt==100)
        {
        	boss = new Enemy();
        	pattern = new EnemyPattern(boss,player);
        	pattern.start();
        	EnemyPattern.bossAppear=true;
        }
        //draw EnemyBullet
        if(EnemyPattern.bossAppear)
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

        //draw deadScreen
        if(player.conflict == true)
        {
        	deadTitle = new DeadScreen();
        	deadTitle.doDrawingDeadScreen(graphic);
        }
    }
    public void doDrawingBoss(Graphics g)
    {
    	g.drawImage(boss.getImage(),boss.getX(),boss.getY(),this);
    }
    private void drawPlayer(Graphics2D graphic)
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
    public void actionPerformed(ActionEvent e) 
    {
    	timeCnt++;
    	if(player.conflict == true)
    	{
			deadCnt++;
			player.dead(deadCnt);
    	}
    	movePlayerStep();
    	moveBulletStep();
    	if(EnemyPattern.bossAppear)
    	{
        	moveEnemyBulletStep();
    	}

    	repaint();
    }
    private void movePlayerStep() 
    {
    	player.move();
    	if(EnemyPattern.bossAppear)
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
            	if(EnemyPattern.bossAppear)
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
    private void moveEnemyBulletStep()
    {
        Vector<EnemyBullet> Enemybullets = pattern.getBullet();
        for (int i = 0; i < Enemybullets.size(); i++) 
        {
        	EnemyBullet enemyBullet = Enemybullets.get(i);
        	if(enemyBullet.IsReady())
        	{
        		enemyBullet.move();
        	}
        	else
        	{
        		Enemybullets.remove(i);
        	}
        }
    }
    private void movebossBarStep()
    {
    	if(EnemyPattern.bossAppear)
    		boss.HP=boss.HP-1;
    }
}
