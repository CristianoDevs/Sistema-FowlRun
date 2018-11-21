package com.br.monte.sistemafowlrun.controller;

import com.br.monte.sistemafowlrun.dao.CidadeDAO;
import com.br.monte.sistemafowlrun.domain.Cidade;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("FowlRun");
        //stage.initStyle(StageStyle.UNDECORATED);
        //stage.setMaximized(true);
        //stage.setFullScreen(true);  
        //stage.setResizable(false);
        stage.centerOnScreen();
        stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight()); 
        stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth()); 
        stage.setScene(scene);
        stage.show();
    }

    
    public static void main(String[] args) {
              
                launch(args);
    }

}
