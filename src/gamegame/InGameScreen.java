package gamegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class InGameScreen extends JPanel implements ActionListener{
    private Timer timer;
    public int timeCnt=0;
    public Player player;
    private Enemy boss;
    private boolean bossAppear = false;
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
        if(bossAppear)
        {
           	graphic.drawImage(boss.getImage(), 
        			boss.getX(), 
        			boss.getY(), 
        			this);
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
        	bossAppear=true;
        }
        if(bossAppear)
        {
        	drawBoss(graphic);
        }
    }
    private void drawPlayer(Graphics2D graphic)
    {
        graphic.drawImage(player.getImage(), 
        		player.getX(), 
        		player.getY(), 
        		this);
    }
    private void drawBoss(Graphics2D graphic)
    {
    	graphic.drawImage(boss.getImage(), 
    			boss.getX(), 
    			boss.getY(), 
    			this);
        graphic.setColor(Color.YELLOW);
        graphic.fillRect(0,0,boss.getHp(),20);
    }
    public void actionPerformed(ActionEvent e) 
    {
    	timeCnt++;
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
        			System.out.println("³Ê Á×À½");
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
}
