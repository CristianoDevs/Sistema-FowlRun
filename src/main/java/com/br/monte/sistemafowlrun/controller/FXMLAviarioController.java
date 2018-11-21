/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.monte.sistemafowlrun.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLAviarioController implements Initializable {

    @FXML
    private Label asdas;
    @FXML
    private Button btnAbrirTelaCadCidade;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abrirTelaCadCidade(ActionEvent event) {
        try
        {
            
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLCadCidade.fxml"));  
            Scene scene = new Scene(root);
           
            //para retirar todos os botões de minimizar, maximizar e fechar
            stage.initStyle(StageStyle.UNDECORATED);
                       
            stage.setScene(scene);

            stage.show();//abria a stage

        } 
        catch (IOException ex)
        {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
