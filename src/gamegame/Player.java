package gamegame;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
public class Player {
	Image playerImage;
	int playerWidth;
	int playerHeight;
	int playerCx=50;
	int playerCy=50;
	int px,py;
	int speed=3;
	Player()
	{
		load();
	}
	public void load()
	{
		ImageIcon playerSrc = new ImageIcon("/image/playerSprite.png");
		playerImage = playerSrc.getImage();
		
		playerWidth = playerImage.getWidth(null);
		playerHeight = playerImage.getHeight(null);
	}
	public void move()
	{
		playerCx = playerCx+px;
		playerCy = playerCy+py;
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
        }

        if (key == KeyEvent.VK_DOWN) {
            py = speed;
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
        }

        if (key == KeyEvent.VK_DOWN) {
            py = 0;
        }
    }
}
