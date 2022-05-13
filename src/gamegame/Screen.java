package gamegame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter; //Ű���� �̺�Ʈ�� ����.
import java.awt.event.KeyEvent; //Ű���� �Է� Ű�� ����.
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
        addKeyListener(new TAdapter()); //Ű���� �̺�Ʈ
        setBackground(Color.black);
        setFocusable(true); //Ű �̺�Ʈ�� ��Ŀ���� ��ġ�� �־�� Ű �̺�Ʈ�� �߻��ϹǷ�
        //������ ��Ŀ���� ��������� ��. �� �ڵ带 �ۼ��Ͽ�, ���� Ű�� �Է� ���� �� �ֵ��� �Ѵ�.

        player = new Player(screenWidth,screenHeight);
		System.out.println("test");
        timer = new Timer(DELAY, this); //DELAY���� ���� ������ �ݺ��Ѵ�.
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) { //JComponent�� �޼ҵ�� ���� ������Ʈ�� �ڽ��� ����� �ٽ� �׸� �ʿ䰡 ���� ������ ȣ��Ǵ� �޼ҵ��̴�.
        super.paintComponent(g);//�� ������ �׸��� �׷����� ������Ʈ�� JPanel�̳� JLabeló�� �׷��� ������Ʈ�� ���, 
        //paintComponent �޼ҵ带 ������ �� �� ���ο� ȣ��Ǹ� ���� �����̴�. �׷��� ������Ʈ�� ��ӹ޾��� ��, 
        //�θ� Ŭ������ �׷��� �� �κе� �ֱ� �����̴�. �ڱ� �׸��� �׸��� �����ع����� �θ� Ŭ������ �׸� ��ȸ�� ���� ���Ѵ�.
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