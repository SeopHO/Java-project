package gamegame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DeadScreen extends JPanel{
	private Image DeadScreenImage;
	private ImageIcon DeadScreenSrc;
	private int DeadScreenWidth;
	private int DeadScreenHeight;
	private int DeadScreenX=0;
	private int DeadScreenY=0;
	DeadScreen()
	{
		load();
	}
	public void load()
	{
		DeadScreenSrc = new ImageIcon("src/image/GameOverTitle.png");
		DeadScreenImage = DeadScreenSrc.getImage();
		DeadScreenWidth = DeadScreenImage.getWidth(null);
		DeadScreenHeight = DeadScreenImage.getHeight(null);
	}
    public void doDrawingDeadScreen(Graphics g)
    {
    	Graphics2D graphicBoss = (Graphics2D) g;
    	graphicBoss.drawImage(getImage(),getX(),getY(),this);
    }
	public int getWidth()
	{
	  	return DeadScreenWidth;
	}
	public int getHeight()
	{
		return DeadScreenHeight;
	}
	public Image getImage()
	{
		return DeadScreenImage;
	}
	public int getX()
	{
		return DeadScreenX;
	}
	public int getY()
	{
		return DeadScreenY;
	}
}
