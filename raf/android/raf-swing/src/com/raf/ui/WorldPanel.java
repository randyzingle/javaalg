package com.raf.ui;

import java.awt.*;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WorldPanel extends JPanel {
	
	@Override
	public void paintComponent(Graphics g) {
		Dimension d = this.getSize();
		this.setBackground(Color.black);
		g.setColor(Color.green);
		g.fillRect(0, 0, d.width, d.height);
		
		g.setColor(Color.black);
		g.drawString("Baldursoft Games", 200, 200);
	}

}
