package gamegame;

public class EnemyPattern extends Thread{
	public void run()
	{
		for(int i=0;i<=300;i++)
		{
			System.out.println(i);
		}

		super.run();
	}
}
