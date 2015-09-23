package com.raf.ui;

import java.awt.BorderLayout;

import javax.swing.*;

public class MainFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Baldursoft Inc");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(480, 270);
		WorldPanel worldPanel = new WorldPanel();
		frame.add(BorderLayout.CENTER, worldPanel);
//		frame.getContentPane().add(worldPanel);
		
		frame.setVisible(true);
	}

}
