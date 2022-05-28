package gamegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.lang.Math;
import java.util.Vector;

import javax.swing.ImageIcon;
public class EnemyPattern extends Thread{
	private Image EnemybulletImage;
	private ImageIcon EnemybulletSrc;
	private int EnemyBulletCx;
	private int EnemyBulletCy;
	private int EnemyBulletWidth;
	private int EnemyBulletHeight;
	
    private Enemy tempBoss = null;
    private Player tempPlayer = null;
    public static boolean bossAppear = false;
	Vector<EnemyBullet> Enemybullets; 
    EnemyPattern(Enemy e,Player p)
    {
    	bossAppear = true;
    	tempBoss = e;
    	tempPlayer = p;
    	Enemybullets = new Vector<>();
    }
	public Vector<EnemyBullet> getBullet()
	{
		return Enemybullets;
	}
    public void mvPattern_1() //8자 모양으로 움직임.
    {
    	final int cntPatternGoal=2;
    	int cntPattern=0;
    	int passState=-1;
    	double speedX=6.5; //6.5
    	double speedY=2.5; //2.5

    	while(true)
    	{
    		try
    		{
    			if(passState==-1)
    			{
    				Thread.sleep(10);
    			}
    			else
    			{
    				Thread.sleep(7);
    			}
    			
    		}
    		catch(InterruptedException e)
    		{
    			return;
    		}
    		if(passState == -1)
    		{
    			tempBoss.EnemyCx+=speedX;
    			if(tempBoss.getX() == tempBoss.RIGHT_TOP_X)
    			{
    				passState = 0;
    			}
    		}
    		if(passState == 0) //왼쪽 아래대각선 방향
    		{
    			tempBoss.EnemyCx-=speedX;
    			tempBoss.EnemyCy+=speedY;
    			
            	if(tempBoss.EnemyCx<=tempBoss.LEFT_BOTTOM_X && tempBoss.EnemyCy>=tempBoss.LEFT_BOTTOM_Y)
            	{
            		tempBoss.EnemyCx = tempBoss.LEFT_BOTTOM_X;
            		tempBoss.EnemyCy = tempBoss.LEFT_BOTTOM_Y;
            		Enemybullets.add(new EnemyBullet(tempBoss.EnemyCx,tempBoss.EnemyCy,1,tempPlayer));
            		passState = 1;
            	}
    		}
    		if(passState == 1) //왼쪽 위로 이동
    		{
    			tempBoss.EnemyCy-=speedY;
    			if(tempBoss.EnemyCy<=tempBoss.LEFT_TOP_Y)
    			{
    				tempBoss.EnemyCy = tempBoss.LEFT_TOP_Y;
    				passState = 2;
    			}
    		}
    		if(passState == 2) //오른쪽 아래 대각선 방향
    		{
    			tempBoss.EnemyCx+=speedX;
    			tempBoss.EnemyCy+=speedY;
    			if(tempBoss.EnemyCx>=tempBoss.RIGHT_BOTTOM_X && tempBoss.EnemyCy>=tempBoss.RIGHT_BOTTOM_Y)
    			{
    				tempBoss.EnemyCx = tempBoss.RIGHT_BOTTOM_X;
    				passState = 3;
    			}
    		}
    		if(passState == 3) //오른쪽 위로 이동 
    		{
    			tempBoss.EnemyCy-=speedY;
    			if(tempBoss.EnemyCy<=tempBoss.RIGHT_TOP_Y)
    			{
    				tempBoss.EnemyCy = tempBoss.LEFT_TOP_Y;
    				cntPattern++;
    				if(cntPattern == cntPatternGoal)
    				{
    					passState = 4;
    				}
    				else
    				{
    					passState = 0;
    					
    				}
    			}
    		}
    		if(passState == 4) //왼쪽 대각선 아래로 이동.(화면 밖으로 나감.)
    		{
    			tempBoss.EnemyCx-=speedX;
    			tempBoss.EnemyCy+=speedY;
    			if(tempBoss.getX() == -491 && tempBoss.getY() == 428)
    				passState = 5;
    		}
    		if(passState == 5) //화면 밖의 센터로 이동.
    		{
    			tempBoss.EnemyCx = tempBoss.CENTER_X+300;
    			tempBoss.EnemyCy = tempBoss.CENTER_Y;
    			passState = 6;
    		}
    		if(passState == 6) //화면 안쪽 센터로 이동.
    		{
    			tempBoss.EnemyCx -=2;
    			if(tempBoss.getX() == tempBoss.CENTER_X)
    			{
    				break;
    			}
    		}
    	}
    }
    public void mvPattern_2(int speed) //위 아래로 움직임.
    {
    	int goUpCheck=0;
    	int goDownCheck=0;                                                                                                    
    	while(true)
    	{
    		try
    		{
    			Thread.sleep(10);
    		}
    		catch(InterruptedException e)
    		{
    			return;
    		}
    		if(tempBoss.getY()>0 && tempBoss.getY()<300 && goUpCheck!=1 && goDownCheck!=1)
    			tempBoss.EnemyCy-=speed;
    		if(tempBoss.getY()>=300)
    		{
    			goDownCheck=0;
    			goUpCheck=1;
    		}
    		if(tempBoss.getY()<=0)
    		{
    			goDownCheck=1;
    			goUpCheck=0;
    		}
    		if(goDownCheck==1 && goUpCheck==0)
    			tempBoss.EnemyCy+=speed;
    		if(goUpCheck==1 && goDownCheck==0)
    			tempBoss.EnemyCy-=speed;
    	}
    }
    public void mvPattern_3()
    {
                                            
    }

    public void run()
    {
        mvPattern_1();
        mvPattern_3();
        mvPattern_2(4);

    }    
}

