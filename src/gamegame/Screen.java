package gamegame;

import javax.swing.*;

class Frame extends JFrame {
	Frame() {
		setTitle("ù��° ������"); //â Ÿ��Ʋ
		setSize(1100,700); //frame size
		setVisible(true); //â ���̰�
		setResizable(false); //â ũ�� ���� ���ϰ� �ϱ�.
		setLocationRelativeTo(null); //â�� ��� ������ �ϱ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame�� ���������� ����ǵ���.
	}
}

public class Screen {
	void createScreen()
	{
		Frame test = new Frame();
	}
}
