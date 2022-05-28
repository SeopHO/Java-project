package gamegame;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Enemy{
	private Image EnemyImage;
	private ImageIcon EnemySrc;
	private int EnemyWidth;
	private int EnemyHeight;
	
	public int HP = 990;
	
	public final int LEFT_TOP_X = 30;
	public final int LEFT_TOP_Y = 50;
	public final int LEFT_BOTTOM_X = 30;
	public final int LEFT_BOTTOM_Y = 250;
	
	public final int RIGHT_TOP_X = 750;
	public final int RIGHT_TOP_Y = 50;
	public final int RIGHT_BOTTOM_X = 750;
	public final int RIGHT_BOTTOM_Y = 250;
	
	public final int CENTER_X = 750;
	public final int CENTER_Y = 145;
	
	public int EnemyCx= RIGHT_TOP_X-114;
	public int EnemyCy= RIGHT_TOP_Y;
	
	private boolean checkDead;
	

	
	Enemy()
	{
		load();
	}
	public void load()
	{
		loadImage_default();
		EnemyWidth = EnemyImage.getWidth(null);
		EnemyHeight = EnemyImage.getHeight(null);
	}
	public void loadImage_default()
	{
		EnemySrc = new ImageIcon("src/image/bossResize.jpg");
		EnemyImage = EnemySrc.getImage();
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
		return HP;
	}

	

}


