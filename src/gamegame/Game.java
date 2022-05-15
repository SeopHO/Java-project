package gamegame;

import javax.swing.JFrame;

public class Game extends JFrame {
	private final int SCREEN_WIDTH = 1000;
	private final int SCREEN_HEIGHT = 600;
	
    public Game() 
    {
        initUI();
    }
    
    private void initUI() 
    {
        add(new Screen());

        setTitle("test");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        
        setLocationRelativeTo(null);
        setResizable(false); //â ũ�� ���� �Ұ���.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) 
    {
    	Game game = new Game();
    	game.setVisible(true); //ȭ���� ���̵��� �Ѵ�.
    }
}