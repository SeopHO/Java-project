package gamegame;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class titleScreen extends JPanel{
	private Image titleImage;
	private ImageIcon titleSrc;
	titleScreen()
	{
    	titleSrc = new ImageIcon("src/image/title.jpg");
    	titleImage = titleSrc.getImage();
//        addKeyListener(new TAdapter_title());
//        setFocusable(true);
	}
	
    public void paintComponent(Graphics g) 
    { 
        super.paintComponent(g); 
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }
    private void doDrawing(Graphics g)
    {
        Graphics2D graphic = (Graphics2D) g;
    	graphic.drawImage(titleImage, 
    			0, 
    			0, 
    			this);
    	this.repaint();
    }
//    private class TAdapter_title extends KeyAdapter 
//    {
//        @Override
//        public void keyPressed(KeyEvent e) 
//        {
//        	int key = e.getKeyCode();
//
//            if (key == KeyEvent.VK_SPACE) 
//            {
//        		System.out.println("Game start! on jpanel ");
////        		gs.ScreenState = 1;
////        		gs.checkScreenState(gs.ScreenState);
//            }
//            if (key == KeyEvent.VK_ESCAPE) 
//            {
//                System.exit(0);
//            }
//        }
//        
//    }
}
