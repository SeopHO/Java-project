package gamegame;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Enemy {
	private Image EnemyImage;
	private ImageIcon EnemySrc;
	private int EnemyWidth;
	private int EnemyHeight;
	private int EnemyCx=500;
	private int EnemyCy=100;
	public int hp=990;
	private boolean checkDead;
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
	  	return EnemyWidth;
	}
	public int getHeight()
	{
		return EnemyHeight;
	}
	public Image getImage()
	{
		return EnemyImage;
	}
	public int getHp()
	{
		return hp;
	}
	public boolean IsDead()
	{
		return checkDead;
	}

}
