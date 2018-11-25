/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.monte.sistemafowlrun.controller;

import com.br.monte.sistemafowlrun.controller.lista.CidadeTabela;
import com.br.monte.sistemafowlrun.dao.CidadeDAO;
import com.br.monte.sistemafowlrun.domain.Cidade;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLCadCidadeController implements Initializable {

    @FXML
    private Label lblSair;
    @FXML
    private JFXTextField txtCodigoCidade;
    @FXML
    private JFXTextField txtNomeCidade;
    @FXML
    private JFXComboBox<String> cmbEstado;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnLimpar;  
    @FXML
    private TableView<Cidade> tbCidades;
    @FXML
    private TableColumn<Cidade, Integer> colunaCodigoCidade;
    @FXML
    private TableColumn<Cidade, String> colunaNomeCidade;
    @FXML
    private TableColumn<Cidade, String> colunaEstado;
    @FXML
    private Button btnListar;
    
    private final CidadeDAO cidadeDAO = new CidadeDAO();
    private Cidade cidade = new Cidade();
    private List<Cidade> listCidade;
    private ObservableList<Cidade> observableCidades;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherComboBox();
        carregaCidadeTableView();
    }    
    
    @FXML
    private void sairJanela(MouseEvent event) {
        Stage st = (Stage) lblSair.getScene().getWindow();// obtem a janela atual
        st.close();//fecha a stage
    }

    @FXML
    private void salvarCidade(ActionEvent event) throws Exception{  
        cidade.setNome(txtNomeCidade.getText());             
        cidade.setUf(cmbEstado.getValue());
        cidade.setCodigo(Integer.parseInt(txtCodigoCidade.getText()));
        try {
            cidadeDAO.salvar(cidade);
            cidade = new Cidade();
            JOptionPane.showMessageDialog(null, "Sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
	    e.printStackTrace();
        }
        limparCampos();
        carregaCidadeTableView();
    }

    @FXML
    private void ExcluirCidade(ActionEvent event) {    
        cidade.setCodigo(Integer.parseInt(txtCodigoCidade.getText()));
        
        try {
            cidadeDAO.excluir(cidade);
           
            JOptionPane.showMessageDialog(null, "Excluido");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
	    e.printStackTrace();
        }
    }

    @FXML
    private void Limpar(ActionEvent event) {
        limparCampos();
    }
    
    public void limparCampos(){
        txtCodigoCidade.setText("");
        txtNomeCidade.setText("");
        cmbEstado.setValue("");
        cmbEstado.setPromptText("Estado");   
    }

    
    @FXML
    private void selecionarLinhaViewTable(MouseEvent event) {
        txtCodigoCidade.setText(String.valueOf(tbCidades.getSelectionModel().getSelectedItem().getCodigo()));
        txtNomeCidade.setText(tbCidades.getSelectionModel().getSelectedItem().getNome()); 
        cmbEstado.setValue(tbCidades.getSelectionModel().getSelectedItem().getUf());
    }
    
    public void carregaCidadeTableView(){
               
        listCidade = cidadeDAO.buscarTodos();
		for (Cidade cid : listCidade) {
                                cid.getCodigo();
                                cid.getNome();
                                cid.getUf();                          	
		}
               
        colunaCodigoCidade.setCellValueFactory(new PropertyValueFactory<Cidade, Integer>("codigo"));
        colunaNomeCidade.  setCellValueFactory(new PropertyValueFactory<Cidade, String>("nome"));
        colunaEstado.      setCellValueFactory(new PropertyValueFactory<Cidade, String>("uf"));
             
        observableCidades =  FXCollections.observableArrayList(listCidade);
        
        tbCidades.setItems(observableCidades);
    }
    
    public void preencherComboBox(){
        cmbEstado.getItems().add("AC");  
        cmbEstado.getItems().add("AL");  
        cmbEstado.getItems().add("AM");  
        cmbEstado.getItems().add("AP");  
        cmbEstado.getItems().add("BA");  
        cmbEstado.getItems().add("CE");  
        cmbEstado.getItems().add("DF");  
        cmbEstado.getItems().add("ES");  
        cmbEstado.getItems().add("GO");  
        cmbEstado.getItems().add("MA");  
        cmbEstado.getItems().add("MG");  
        cmbEstado.getItems().add("MS");  
        cmbEstado.getItems().add("MT");  
        cmbEstado.getItems().add("PA");  
        cmbEstado.getItems().add("PB");  
        cmbEstado.getItems().add("PE");  
        cmbEstado.getItems().add("PI");  
        cmbEstado.getItems().add("PR");  
        cmbEstado.getItems().add("RJ");  
        cmbEstado.getItems().add("RN");  
        cmbEstado.getItems().add("RO");  
        cmbEstado.getItems().add("RR");  
        cmbEstado.getItems().add("RS");  
        cmbEstado.getItems().add("SC");  
        cmbEstado.getItems().add("SE");  
        cmbEstado.getItems().add("SP");  
        cmbEstado.getItems().add("TO");   
    }

    @FXML
    private void listarTabela(ActionEvent event) {
        carregaCidadeTableView();
    }
    
}
