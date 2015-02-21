package com.bms.robotfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;

public class WorldFX extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private boolean live = true;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Robot World");
		Button btn1 = new Button();
		btn1.setText("kick it off");
		
		VBox root = new VBox();
		root.setBackground(new Background(new BackgroundFill(Color.AZURE,null,null)));
		root.getChildren().add(btn1);
		root.setPadding(new Insets(15, 12, 15, 12));
		root.setSpacing(10);
		
		Image img1 = new Image(new FileInputStream("kareln.png"), 50, 90, true, true);
		Image img2 = new Image(new FileInputStream("karelnOff.png"), 50, 90, true, true);
		ImageView imageView = new ImageView();
		imageView.setImage(img1);
		root.getChildren().add(imageView);
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("bot it now!");
				if (live) {
					imageView.setImage(img2);
				} else {
					imageView.setImage(img1);
				}
				live = !live;
			}
		});
		
		WorldCanvasFX wc = new WorldCanvasFX();
		root.getChildren().add(wc);
		
		primaryStage.setScene(new Scene(root, 600, 550));
		primaryStage.show();

	}

}
