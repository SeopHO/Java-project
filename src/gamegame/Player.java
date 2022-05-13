package gamegame;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.HashMap;
import java.util.Map;
public class Player {
    int screenWidth;
	int screenHeight;
	private Image playerImage;
	private ImageIcon playerSrc;
	int playerWidth;
	int playerHeight;
	int playerCx=500;
	int playerCy=300;
	int px,py;
	int speed=3;

	HashMap<String, Integer> spriteState = new HashMap<String, Integer>(); 
	
	Player(int w, int h)
	{
		screenWidth = w;
		screenHeight = h;
		load();
	}
	public void checkSprite()
	{
		if(spriteState.get("STAY")==1)
		{
			playerSrc = new ImageIcon("src/image/playerSprite0.png");
		}
		if(spriteState.get("DOWN")==1)
		{
			playerSrc = new ImageIcon("src/image/playerSprite1.png");
		}
		if(spriteState.get("UP")==1)
		{
			playerSrc = new ImageIcon("src/image/playerSprite2.png");
		}
		playerImage = playerSrc.getImage();
	}
	public void load()
	{
		spriteState.put("STAY",1);
		spriteState.put("UP",0);
		spriteState.put("DOWN",0);

		checkSprite();
		
		playerWidth = playerImage.getWidth(null);
		playerHeight = playerImage.getHeight(null);
	}
	public void move()
	{
		playerCx = playerCx+px;
		playerCy = playerCy+py;
	}
	public int getX()
	{
		if(playerCx < 0)
		{
			System.out.println("너 가로 나감.");
			playerCx = 0;
		}
		if(playerCx>950)
		{
			System.out.println("너 가로 나감.");
			playerCx = 950;
		}
//		System.out.println("x="+playerCx);
		return playerCx;
	}
	public int getY()
	{
		if(playerCy < -3)
		{
			System.out.println("너 세로 나감.");
			playerCy = 0;
		}
		if(playerCy>540)
		{
			System.out.println("너 세로 나감.");
			playerCy = 540;
		}
//		System.out.println("y="+playerCy);
		return playerCy;
	}
	public int getWidth()
	{
		return playerWidth;
	}
	public int getHeight()
	{
		return playerHeight;
	}
	public Image getImage()
	{
		return playerImage;
	}
    public void keyPressed(KeyEvent e) 
    {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            px = -speed;
        }
        if (key == KeyEvent.VK_RIGHT) {
            px = speed;
        }
        if (key == KeyEvent.VK_UP) {
            py = -speed;
    		spriteState.put("STAY",0);
    		spriteState.put("UP",1);
    		spriteState.put("DOWN",0);
    		checkSprite();
        }
        if (key == KeyEvent.VK_DOWN) {
            py = speed;
    		spriteState.put("STAY",0);
    		spriteState.put("UP",0);
    		spriteState.put("DOWN",1);
    		checkSprite();
        }
    }
    public void keyReleased(KeyEvent e) 
    {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            px = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            px = 0;
        }
        if (key == KeyEvent.VK_UP) {
            py = 0;
    		spriteState.put("STAY",1);
    		spriteState.put("UP",0);
    		spriteState.put("DOWN",0);
    		checkSprite();
        }
        if (key == KeyEvent.VK_DOWN) {
            py = 0;
    		spriteState.put("STAY",1);
    		spriteState.put("UP",0);
    		spriteState.put("DOWN",0);
    		checkSprite();
        }
    }
}
