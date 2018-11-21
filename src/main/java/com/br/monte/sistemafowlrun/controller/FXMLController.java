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
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class FXMLController implements Initializable {
    
    @FXML
    private Button btnHome;
    @FXML
    private Button btnAviario;
    @FXML
    private Button btnAlojamento;
    @FXML
    private Button btnCadastros;
    @FXML
    private Button btnSair;
    @FXML
    private AnchorPane anchoPanePrincipal;
    @FXML
    private SplitPane spMenu;
    @FXML
    private AnchorPane appMenuEsquerdo;
    @FXML
    private ImageView imgLogotipo;
    @FXML
    private VBox cbMenu;
    @FXML
    private AnchorPane appMenuDireito;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       abrirComHome();
    }    

    
    public void abrirComHome()
    {
        try
        {
            //colocando no objeto a o FXMLMDI01
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/FXMLHome.fxml"));
            //deixar o AnchorPane FXMLMID02 fluido ou ancorado em todos os lados
            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);
            //chamar dentro do apMenuEsquerdo o FXMLMDI01
            appMenuDireito.getChildren().setAll(a);
           
        } 
        catch(IOException ex)
        {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void abrirTelaHome(ActionEvent event) {
        abrirComHome();
    }

    @FXML
    private void abrirTelaAviario(ActionEvent event) {
        try
        {
            //colocando no objeto a o FXMLMDI01
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/FXMLAviario.fxml"));
            //deixar o AnchorPane FXMLMID02 fluido ou ancorado em todos os lados
            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);
            //chamar dentro do apMenuEsquerdo o FXMLMDI01
            appMenuDireito.getChildren().setAll(a);
           
        } 
        catch(IOException ex)
        {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirTelaAlojamento(ActionEvent event) {
        try
        {
            //colocando no objeto a o FXMLMDI01
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/FXMLAlojamento.fxml"));
            //deixar o AnchorPane FXMLMID02 fluido ou ancorado em todos os lados
            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);
            //chamar dentro do apMenuEsquerdo o FXMLMDI01
            appMenuDireito.getChildren().setAll(a);
           
        } 
        catch(IOException ex)
        {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirTelaCadastros(ActionEvent event) {
        
    }

    @FXML
    private void Sair(ActionEvent event) {
        System.exit(0);
    }
}
