package gamegame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Game extends JFrame {
	private final int SCREEN_WIDTH = 1000;
	private final int SCREEN_HEIGHT = 600;
    public static int ScreenState;
    private titleScreen titlePanel;
    private InGameScreen inGamePanel;
    public Game() 
    {
    	ScreenState = 0;
        initUI();
    }
    private void initUI() 
    {
        setTitle("Fighting Luxury Java");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);        
        setLocationRelativeTo(null);
        setResizable(false); //â ũ�� ���� �Ұ���.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true); //ȭ���� ���̵��� �Ѵ�.
        addKeyListener(new TAdapter_title());
        checkScreenState(ScreenState);
    }
    public void checkScreenState(int state)
    {
    	switch(state)
    	{     
    		case 0:
    			getContentPane().removeAll();
    			inGamePanel = null;
    			getContentPane().add(titlePanel = new titleScreen());
    			setVisible(true); 
                revalidate();
                repaint();
    			break;
    		case 1:
    			getContentPane().removeAll();
    			getContentPane().add(inGamePanel = new InGameScreen());
       			setVisible(true);
                revalidate();
                repaint();
    			break;
    		case 2:
    			break;
    	}
    }
    private class TAdapter_title extends KeyAdapter 
    {
        @Override
        public void keyPressed(KeyEvent e) 
        {
        	int key = e.getKeyCode();
        	if(ScreenState == 1)
        	{
        		inGamePanel.player.keyPressed(e);
        	}
            if (key == KeyEvent.VK_SPACE) 
            {
            	if(ScreenState == 0)
            	{
            		ScreenState=1;
            		checkScreenState(ScreenState);
            	}

            }
            if (key == KeyEvent.VK_ESCAPE) 
            {
            	if(ScreenState == 0)
            	{
            		System.exit(0);
            	}
            	if(ScreenState == 1)
            	{
            		ScreenState=0;
            		checkScreenState(ScreenState);
            	}
                
            }
        }
        public void keyReleased(KeyEvent e) 
        {
        	if(ScreenState == 1)
        	{
        		inGamePanel.player.keyReleased(e);
        	}
        }
        
    }
}