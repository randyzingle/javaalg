package com.bms.robotfx;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class WorldCanvasFX extends Canvas {
	
	public WorldCanvasFX() {
		super(600,450);
		GraphicsContext gc = this.getGraphicsContext2D();
		drawShapes(gc);
		addMouseHandler(gc);
	}
	
	private void addMouseHandler(GraphicsContext gc) {
		this.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				gc.clearRect(me.getX() - 2, me.getY() - 2, 5, 5);
			}
		});
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent me) {
				if (me.getClickCount() > 1) {
					gc.setFill(Color.BLUE);
					gc.fillRect(me.getX() - 2, me.getY() - 2, 5, 5);
				}
			}
		});
	}
	
	private void drawShapes(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, 600, 550);

        gc.setFill(Color.BLUE);
        gc.fillRect(50, 50, this.getWidth() - 100, this.getHeight() - 100);
        
		gc.setFill(Color.BLUEVIOLET);
		gc.setStroke(Color.BLUEVIOLET);
		gc.fillOval(120, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
	}

}
