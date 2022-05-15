package gamegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter; //키보드 이벤트를 받음.
import java.awt.event.KeyEvent; //키보드 입력 키를 받음.
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Screen extends JPanel implements ActionListener {
    private Timer timer;
    private int timing=0;
    private Player player;
    private Enemy boss;
    private EnemyBullet bossBullet;
    private final int DELAY = 10;
    private boolean bossAppear = false;
    
    EnemyPattern thread = new EnemyPattern();

    public Screen() 
    {
    	initScreen();
    }

    private void initScreen() 
    {
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        player = new Player();
        timer = new Timer(DELAY, this);
        timer.start();
        thread.start();
    }
    @Override
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
        graphic.drawImage(player.getImage(), 
        		player.getX(), 
        		player.getY(), 
        		this);
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
        if(timing==100)
        {
        	boss = new Enemy();
        	bossAppear=true;
        }
        if(bossAppear)
        {
        	graphic.drawImage(boss.getImage(), 
        			boss.getX(), 
        			boss.getY(), 
        			this);
            graphic.setColor(Color.YELLOW);
            graphic.fillRect(0,0,boss.getHp(),20);
            if(timing>500)
            {
                graphic.setColor(Color.GREEN);
            	bossBullet = new EnemyBullet(200,100,50,50);
            	graphic.fillOval(bossBullet.getX(),bossBullet.getY(),bossBullet.getWidth(),bossBullet.getHeight());
            }
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
    	timing++;
//    	System.out.println("timing="+timing);
    	movePlayerStep();
    	moveBulletStep();
    	repaint();
    }
    private void movePlayerStep() 
    {
    	player.move();
    	if(bossAppear)
    	{
        	if((player.getX()+25)>=boss.getX() && (player.getX()+25)<=boss.getWidth()+boss.getX())
        	{
        		if((player.getY()+9)>=boss.getY() && (player.getY()+9)<=boss.getHeight()+boss.getY())
        		{        			
        			player.conflict = true;
        			System.out.println("너 죽음");
        			timer.stop();
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
            	if(bossAppear)
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
    private void movebossBarStep()
    {
    	if(bossAppear)
    		boss.hp=boss.hp-1;
    }
    private class TAdapter extends KeyAdapter 
    {
        @Override
        public void keyReleased(KeyEvent e) 
        {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) 
        {
        	player.keyPressed(e);
        }
    }
}