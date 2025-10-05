package org.controler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.model.Produto;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaPrincipalController implements Initializable {

    @FXML
    private TableView<Produto> tableViewProdutos;

    @FXML
    private TableColumn<Produto, String> tableColumnNome;

    @FXML
    private TableColumn<Produto, Double> tableColumnPreco;

    @FXML
    private TableColumn<Produto, Integer> tableColumnQuantidade;

    @FXML
    private Label labelValorTotal;

    private ObservableList<Produto> listaProdutos;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        carregarProdutos();
        calcularValorTotalEstoque();
    }


    public void carregarProdutos() {
        // Create a sample array of products
        Produto p1 = new Produto("PC Fodão", 5499.90, 15);
        Produto p2 = new Produto("Cabo sem fio P/XBOX 360", 120.99, 50);
        Produto p3 = new Produto("Teclado Mecânico (faz troca de óleo)", 350.00, 30);
        Produto p4 = new Produto("Monitor dos bons", 2800.75, 22);

        listaProdutos = FXCollections.observableArrayList(p1, p2, p3, p4);

        tableViewProdutos.setItems(listaProdutos);
    }


    public void calcularValorTotalEstoque() {
        double valorTotal = 0.0;

        for (Produto produto : listaProdutos) {
            valorTotal += produto.getPreco() * produto.getQuantidade();
        }

        labelValorTotal.setText(String.format("Valor Total do Estoque: R$ %.2f", valorTotal));
    }
}