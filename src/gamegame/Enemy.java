package gamegame;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Enemy {
	private Image EnemyImage;
	private ImageIcon EnemySrc;
	private int EnemyWidth;
	private int EnemyHeight;
	private int EnemyCx=650;
	private int EnemyCy=60;
	Enemy()
	{
		load();
	}
	public void load()
	{
		EnemySrc = new ImageIcon("src/image/bossResize.jpg");
		EnemyImage = EnemySrc.getImage();
		EnemyWidth = EnemyImage.getWidth(null);
		EnemyHeight = EnemyImage.getHeight(null);
	}
	public int getX()
	{
		return EnemyCx;
	}
	public int getY()
	{
		return EnemyCy;
	}
	public int getWidth()
	{
		System.out.println(EnemyWidth);
	  	return EnemyWidth;
	}
	public int getHeight()
	{
		System.out.println(EnemyHeight);
		return EnemyHeight;
	}
	public Image getImage()
	{
		return EnemyImage;
	}
}
