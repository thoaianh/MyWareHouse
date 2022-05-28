package myStore;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GUI extends JFrame{
	public GUI() {
		setTitle("WareHouse Management");
		
		getContentPane().add(new SwingForWareHouse());
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUI();
	}
	
}
