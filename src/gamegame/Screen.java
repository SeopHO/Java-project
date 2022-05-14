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
    private Player player;
//    private Enemy boss;
    private final int DELAY = 10;

    public Screen() 
    {
    	initScreen();
    }

    private void initScreen() 
    {
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true); 
//        boss = new Enemy();
        player = new Player();
        timer = new Timer(DELAY, this);
        timer.start();
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
//        graphic.drawImage(boss.getImage(), 
//        		boss.getX(), 
//        		boss.getY(), 
//        		this);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
    	movePlayerStep();
    	moveBulletStep();
    	repaint();
    }
    
    private void movePlayerStep() 
    {
    	player.move();
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
            } 
            else
            {
            	bullets.remove(i);
            }
        }
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