package gamegame;

import javax.swing.*;

class Frame extends JFrame {
	Frame() {
		setTitle("첫번째 프레임"); //창 타이틀
		setSize(1100,700); //frame size
		setVisible(true); //창 보이게
		setResizable(false); //창 크기 변경 못하게 하기.
		setLocationRelativeTo(null); //창이 가운데 나오게 하기.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame이 정상적으로 종료되도록.
	}
}

public class Screen {
	void createScreen()
	{
		Frame test = new Frame();
	}
}
