package gamegame;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Bullet {
	private Image bulletImage;
	private ImageIcon bulletSrc;
	private int bulletCx;
	private int bulletCy;
	private int bulletWidth;
	private int bulletHeight;
	private int bulletSpeed = 10;
	public boolean bulletReady;
	
	Bullet(int x, int y)
	{
		bulletCx=x;	
		bulletCy=y;
		bulletReady = true;
		load();
	}
	public void load()
	{
		bulletSrc = new ImageIcon("src/image/bulletSprite_2.png");
		bulletImage = bulletSrc.getImage();
		bulletWidth = bulletImage.getWidth(null);
		bulletHeight = bulletImage.getHeight(null);
	}
	public int getX()
	{
		return bulletCx+20;
	}
	public int getY()
	{
		return bulletCy+9;
	}
	public int getWidth()
	{
		return bulletWidth;
	}
	public int getHeight()
	{
		return bulletHeight;
	}
	public Image getImage()
	{
		return bulletImage;
	}
	public boolean IsReady()
	{
		return bulletReady;
	}
	public void setReady(boolean bulletReady)
	{
		this.bulletReady = bulletReady;
	}
	public void move()
	{
		bulletCx+=bulletSpeed;
		if((bulletCx>Game.SCREEN_WIDTH))
		{
			bulletReady = false;
		}
	}
	
	
}
