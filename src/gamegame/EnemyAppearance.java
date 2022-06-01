package gamegame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class EnemyAppearance {
	private Image EnemyAppearanceImage;
	private ImageIcon EnemyAppearanceSrc;
	private int EnemyAppearanceCx;
	private int EnemyAppearanceCy;
	private int EnemyAppearanceWidth;
	private int EnemyAppearanceHeight;
	
	public int timing=0;
	public static boolean EnemyAppearanceCheck=false;
	
	EnemyAppearance()
	{
		load();
		EnemyAppearanceCx = (Game.SCREEN_WIDTH/2) - getWidth()+250;
		EnemyAppearanceCy = Game.SCREEN_HEIGHT;
		EnemyAppearanceCheck = true;
	}
	public void load()
	{
		loadImage();
		EnemyAppearanceWidth = EnemyAppearanceImage.getWidth(null);
		EnemyAppearanceHeight = EnemyAppearanceImage.getHeight(null);
	}
	public void loadImage()
	{
		EnemyAppearanceSrc = new ImageIcon("src/image/bossOriginal.jpg");
		EnemyAppearanceImage = EnemyAppearanceSrc.getImage();
	}
	public int getX()
	{
		return EnemyAppearanceCx;
	}
	public int getY()
	{
		return EnemyAppearanceCy;
	}
	public int getWidth()
	{
	  	return EnemyAppearanceWidth;
	}
	public int getHeight()
	{
		return EnemyAppearanceHeight;
	}
	public Image getImage()
	{
		return EnemyAppearanceImage;
	}
	public void move()
	{
		if(EnemyAppearanceCy<200)
		{
			EnemyAppearanceCy-=8;
			if(EnemyAppearanceCy<-800)
			{
				EnemyAppearanceCheck = false;
			}
		}
		else
		{
			timing++;
			if(timing == 5)
			{
				EnemyAppearanceCy-=1;
				timing=0;
			}
		}	
	}
}
