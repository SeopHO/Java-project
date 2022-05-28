package gamegame;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;

public class EnemyBullet {
	private Image EnemybulletImage;
	private ImageIcon EnemybulletSrc;
	
	private Player tempPlayer=null;
	private int EnemyBulletCx;
	private int EnemyBulletCy;
	private int EnemyBulletWidth;
	private int EnemyBulletHeight;
	public boolean EnemybulletReady;
	public int bulletType;
	public int EnemybulletSpeed;
	EnemyBullet(int x, int y, int type, Player tempPlayer)
	{
		EnemyBulletCx = x;
		EnemyBulletCy = y;
		this.tempPlayer = tempPlayer;
		EnemybulletReady = true;
		bulletType = type;
		checkSprite(type);
		load();
	}
	public void load()
	{
		EnemyBulletWidth = EnemybulletImage.getWidth(null);
		EnemyBulletHeight = EnemybulletImage.getHeight(null);
	}
	public void checkSprite(int x)
	{
		if(x == 0)
		{
			EnemybulletSrc = new ImageIcon("src/image/EnemyBullet_1.png");
		}
		if(x == 1)
		{
			EnemybulletSrc = new ImageIcon("src/image/EnemyBullet_2_resize.png");
		}
		if(x == 2)
		{
			EnemybulletSrc = new ImageIcon("src/image/EnemyBullet_3_resize.png");
		}
		EnemybulletImage = EnemybulletSrc.getImage();
	}
	public int getX()
	{
		return EnemyBulletCx;
	}
	public int getY()
	{
		return EnemyBulletCy;
	}
	public int getWidth()
	{
		return EnemyBulletWidth;
	}
	public int getHeight()
	{
		return EnemyBulletHeight;
	}
	public Image getImage()
	{
		return EnemybulletImage;
	}
	public boolean IsReady()
	{
		return EnemybulletReady;
	}
	public void move()
	{
		switch(bulletType)
		{
			case 0:
				break;
			case 1:
				EnemybulletSpeed = 4;
				EnemyBulletCx+=EnemybulletSpeed;
//				if((EnemyBulletCx<Game.SCREEN_WIDTH))
//				{
//					EnemybulletReady = false;
//				}
				break;
			case 2:
				break;
		}
	}

}
