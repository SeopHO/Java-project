package gamegame;
import java.awt.Image;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.HashMap;
import java.util.Vector;

public class Player 
{
	private Image playerImage;
	private ImageIcon playerSrc;
	private int playerWidth;
	private int playerHeight;
	private int playerCx=100;
	private int playerCy=200;
	private int px,py;
	private int speed=3;
	public boolean conflict=false;
	
	int tempX,tempY;
	Vector<Bullet> bullets;
	HashMap<String, Integer> spriteState = new HashMap<String, Integer>(); 
	
	Player()
	{
		load();
	}
	public void checkSprite()
	{
		if(spriteState.get("STAY")==1)
		{
			playerSrc = new ImageIcon("src/image/playerSprite0.png");
		}
		if(spriteState.get("DOWN")==1)
		{
			playerSrc = new ImageIcon("src/image/playerSprite1.png");
		}
		if(spriteState.get("UP")==1)
		{
			playerSrc = new ImageIcon("src/image/playerSprite2.png");
		}
		playerImage = playerSrc.getImage();
	}
	public void load()
	{
		spriteState.put("STAY",1);
		spriteState.put("UP",0);
		spriteState.put("DOWN",0);

		checkSprite();
		bullets = new Vector<>();
		playerWidth = playerImage.getWidth(null);
		playerHeight = playerImage.getHeight(null);
	}
	public void move()
	{
		playerCx = playerCx+px;
		playerCy = playerCy+py;
	}
	public int getX()
	{
		if(playerCx < 0)
		{
			playerCx = 0;
		}
		if(playerCx>950)
		{
			playerCx = 950;
		}
		return playerCx;
	}
	public int getY()
	{
		if(playerCy < -3)
		{
			playerCy = 0;
		}
		if(playerCy>540)
		{
			playerCy = 540;
		}
		return playerCy;
	}
	public int getWidth()
	{
		return playerWidth;
	}
	public int getHeight()
	{
		return playerHeight;
	}
	public Image getImage()
	{
		return playerImage;
	}
	public boolean IsDead()
	{
		return conflict;
	}
	public Vector<Bullet> getBullet()
	{
		return bullets;
	}
    public void keyPressed(KeyEvent e) 
    {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT)  
        {
            px = -speed;
        }
        if (key == KeyEvent.VK_RIGHT) 
        {
            px = speed;
        }
        if (key == KeyEvent.VK_UP) 
        {
            py = -speed;
    		spriteState.put("STAY",0);
    		spriteState.put("UP",1);
    		spriteState.put("DOWN",0);
    		checkSprite();
        }
        if (key == KeyEvent.VK_DOWN) 
        {
            py = speed;
    		spriteState.put("STAY",0);
    		spriteState.put("UP",0);
    		spriteState.put("DOWN",1);
    		checkSprite();
        }
        if (key == KeyEvent.VK_SPACE) 
        {
        	tempX = playerCx;
        	tempY = playerCy;
        	bullets.add(new Bullet(tempX,tempY));
        }
        
    }
    public void keyReleased(KeyEvent e) 
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) 
        {
            px = 0;
        }
        if (key == KeyEvent.VK_RIGHT) 
        {
            px = 0;
        }
        if (key == KeyEvent.VK_UP) 
        {
            py = 0;
    		spriteState.put("STAY",1);
    		spriteState.put("UP",0);
    		spriteState.put("DOWN",0);
    		checkSprite();
        }
        if (key == KeyEvent.VK_DOWN) 
        {
            py = 0;
    		spriteState.put("STAY",1);
    		spriteState.put("UP",0);
    		spriteState.put("DOWN",0);
    		checkSprite();
        }
    }
}
