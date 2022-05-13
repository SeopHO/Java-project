package gamegame;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Game extends JFrame {
	final int SCREEN_WIDTH = 1000;
	final int SCREEN_HEIGHT = 600;
    public Game() {
        initUI();
    }
    
    private void initUI() {
        add(new Screen(SCREEN_WIDTH,SCREEN_HEIGHT));

        setTitle("Moving sprite");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        
        setLocationRelativeTo(null);
        setResizable(false); //창 크기 조절 불가능.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//        	Game game = new Game();
//        	game.setVisible(true); //화면이 보이도록 한다.
//        });
    	Game game = new Game();
    	game.setVisible(true); //화면이 보이도록 한다.
    }
}