package main;

import javax.swing.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame windows = new JFrame ();
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windows.setResizable(false);
		windows.setTitle("Pixe Hunt");
		
		GamePanel gamepanel = new GamePanel ();
		windows.add(gamepanel);
		
		windows.pack();
		
		windows.setLocationRelativeTo(null);
		windows.setVisible(true);
		
		gamepanel.startGameThread();
		
	}

}
