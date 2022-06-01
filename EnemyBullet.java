package gamegame;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Vector;
import java.util.Random;

import javax.swing.ImageIcon;

public class EnemyBullet{
	private Image EnemybulletImage;
	private ImageIcon EnemybulletSrc;
	private Player tempPlayer = null;
	private Enemy tempEnemy = null;
	private int EnemyBulletCx;
	private int EnemyBulletCy;
	private int EnemyBulletWidth;
	private int EnemyBulletHeight;
	public boolean EnemybulletReady;
	public int bulletType;
	public int EnemybulletSpeed;
	
	public int timing=0;
	public int EnemybulletSpeedX;
	public int EnemybulletSpeedY;
	public int randQuadrant;
	
	public int tempX, tempY;
	EnemyBullet(int x, int y, int type, Player tempPlayer,Enemy tempEnemy)
	{
		this.tempPlayer = tempPlayer;
		this.tempEnemy = tempEnemy;
		checkBullet(x,y,type);
		EnemybulletReady = true;
		bulletType = type;
		tempX = tempPlayer.getX();
		tempY = tempPlayer.getY();
		checkSprite(type);
		load();
	}
	public void load()
	{
		EnemyBulletWidth = EnemybulletImage.getWidth(null);
		EnemyBulletHeight = EnemybulletImage.getHeight(null);
	}
	public void checkBullet(int x, int y, int type)
	{
		if(type == 0 || type == 1 || type == 4)
		{
			EnemyBulletCx = x;
			EnemyBulletCy = y;
		}
		if(type == 2)
		{
			EnemyBulletCx = tempPlayer.getX();
			EnemyBulletCy = 0-Game.SCREEN_HEIGHT;
		}
		if(type == 3)
		{
			EnemyBulletCx = x;
			EnemyBulletCy = y;
			EnemybulletSpeed=10;
			Random rand = new Random();
			EnemybulletSpeedX=rand.nextInt(EnemybulletSpeed)+4;
			EnemybulletSpeedY=rand.nextInt(EnemybulletSpeed)+2;
			randQuadrant=rand.nextInt(4)+1;
		}
	}
	public void checkSprite(int x)
	{
		if(x == 0 || x == 1)
		{
			EnemybulletSrc = new ImageIcon("src/image/EnemyBullet_0_resize.png");
		}
		if(x == 2)
		{
			EnemybulletSrc = new ImageIcon("src/image/EnemyBullet_1.png");
		}
		if(x == 3)
		{
			EnemybulletSrc = new ImageIcon("src/image/EnemyBullet_0.png");
		}
		if(x == 4)
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
				EnemybulletSpeed=3;
				EnemyBulletCx+=EnemybulletSpeed;
				if((EnemyBulletCx>Game.SCREEN_WIDTH))
				{
					EnemybulletReady = false;
				}
				break;
			case 1:
				EnemybulletSpeed=3;
				EnemyBulletCx-=EnemybulletSpeed;
				if((EnemyBulletCx<0))
				{
					EnemybulletReady = false;
				}
				break;
			case 2:
				EnemybulletSpeed=15;

				if(EnemyBulletCy==0)
				{
					EnemyBulletCy = 0;
					timing++;
					System.out.println(timing);
					if(timing == 20)
						EnemybulletReady = false;
				}
				else
				{
					EnemyBulletCy+=EnemybulletSpeed;
				}
				break;
			case 3:
				if(randQuadrant == 1)
				{
					EnemyBulletCx+=EnemybulletSpeedX;
					EnemyBulletCy+=EnemybulletSpeedY;
				}
				else if(randQuadrant == 2)
				{
					EnemyBulletCx+=EnemybulletSpeedX;
					EnemyBulletCy-=EnemybulletSpeedY;
				}
				else if(randQuadrant == 3)
				{
					EnemyBulletCx-=EnemybulletSpeedX;
					EnemyBulletCy+=EnemybulletSpeedY;
				}
				else if(randQuadrant == 4)
				{
					EnemyBulletCx-=EnemybulletSpeedX;
					EnemyBulletCy-=EnemybulletSpeedY;
				}

				if((EnemyBulletCx<0 && EnemyBulletCy>Game.SCREEN_HEIGHT) || (EnemyBulletCx > Game.SCREEN_WIDTH && EnemyBulletCy<0))
				{
					EnemybulletReady = false;
				}
				break;
			case 4:
				EnemybulletSpeed=5;
				EnemyBulletCy+=EnemybulletSpeed;
				if(EnemyBulletCy>Game.SCREEN_HEIGHT)
				{
					EnemybulletReady = false;
				}
		}
	}

}
