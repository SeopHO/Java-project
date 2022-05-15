package gamegame;

public class EnemyBullet {
	private int EnemyBulletCx;
	private int EnemyBulletCy;
	private int EnemyBulletWidth;
	private int EnemyBulletHeight;
	
	EnemyBullet(int x, int y, int w, int h)
	{
		EnemyBulletCx = x;
		EnemyBulletCy = y;
		EnemyBulletWidth = w;
		EnemyBulletHeight = h;
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
}
