package gamegame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter; //키보드 이벤트를 받음.
import java.awt.event.KeyEvent; //키보드 입력 키를 받음.
import javax.swing.JPanel;
import javax.swing.Timer;

public class Screen extends JPanel implements ActionListener {

    private Timer timer;
    private Player player;
    private final int DELAY = 10;
    int screenWidth;
	int screenHeight;

    public Screen(int w, int h) {
    	screenWidth = w;
    	screenHeight = h;
    	initScreen();
    }

    private void initScreen() {
        addKeyListener(new TAdapter()); //키보드 이벤트
        setBackground(Color.black);
        setFocusable(true); //키 이벤트는 포커스가 위치해 있어야 키 이벤트가 발생하므로
        //강제로 포커스를 설정해줘야 함. 이 코드를 작성하여, 먼저 키를 입력 받을 수 있도록 한다.

        player = new Player(screenWidth,screenHeight);
		System.out.println("test");
        timer = new Timer(DELAY, this); //DELAY마다 같은 동작을 반복한다.
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) { //JComponent의 메소드로 스윙 컴포넌트가 자신의 모양을 다시 그릴 필요가 있을 때마다 호출되는 메소드이다.
        super.paintComponent(g);//이 문장은 그림이 그려지는 컴포넌트가 JPanel이나 JLabel처럼 그래픽 컴포넌트인 경우, 
        //paintComponent 메소드를 재정의 할 때 내부에 호출되면 좋은 문장이다. 그래픽 컴포넌트를 상속받았을 때, 
        //부모 클래스가 그려야 될 부분도 있기 때문이다. 자기 그림만 그리고 종료해버리면 부모 클래스는 그릴 기회를 얻지 못한다.
        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g) {
        
        Graphics2D graphic = (Graphics2D) g;

        graphic.drawImage(player.getImage(), player.getX(), 
        		player.getY(), this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	moveStep();
    }
    
    private void moveStep() {
    	player.move();
        
//        repaint(player.getX()-1, player.getY()-1, 
//        		player.getWidth()+2, player.getHeight()+2);     
        repaint(player.getX(), player.getY(), 
        		player.getWidth(), player.getHeight());  
    }    

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
        	player.keyPressed(e);
        }
    }
}