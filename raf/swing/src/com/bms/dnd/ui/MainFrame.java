package com.bms.dnd.ui;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public MainFrame() {
		super("D&D Helper");
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		// add a button
		JButton jb1 = new JButton("Press Me!");
		c.add(jb1, BorderLayout.NORTH);
		
		// add a status field
		JTextPane jtp1 = new JTextPane();
		jtp1.setMinimumSize(new Dimension(400,300));
		jtp1.setBackground(Color.cyan);
		c.add(jtp1, BorderLayout.CENTER);

		this.pack();
		this.setVisible(true);
	}

}
