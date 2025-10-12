package org.controler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    @FXML
    private Label labelModo;
    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldPreco;
    @FXML
    private TextField textFieldQuantidade;
    @FXML
    private Button buttonPrincipal;
    @FXML
    private Button buttonSecundario;

    private ObservableList<Produto> listaProdutos;
    private Produto produtoSelecionado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        tableViewProdutos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableView(newValue)
        );

        carregarProdutos();
        calcularValorTotalEstoque();
    }

    private void selecionarItemTableView(Produto produto) {
        produtoSelecionado = produto;
        if (produto != null) {
            labelModo.setText("Editando Produto");
            buttonPrincipal.setText("Salvar");
            buttonSecundario.setText("Excluir");

            textFieldNome.setText(produto.getNome());
            textFieldPreco.setText(String.valueOf(produto.getPreco()));
            textFieldQuantidade.setText(String.valueOf(produto.getQuantidade()));
        } else {
            labelModo.setText("Adicionar Produto");
            buttonPrincipal.setText("Adicionar");
            buttonSecundario.setText("Cancelar");
            limparCampos();
        }
    }

    @FXML
    private void handleButtonPrincipalAction() {
        if (produtoSelecionado == null) {
            adicionarProduto();
        } else {
            editarProduto();
        }
    }

    @FXML
    private void handleButtonSecundarioAction() {
        if (produtoSelecionado == null) {
            limparCampos();
        } else {
            excluirProduto();
        }
    }

    private void adicionarProduto() {
        if (validarCampos()) {
            String nome = textFieldNome.getText();
            double preco = Double.parseDouble(textFieldPreco.getText());
            int quantidade = Integer.parseInt(textFieldQuantidade.getText());

            Produto novoProduto = new Produto(nome, preco, quantidade);
            listaProdutos.add(novoProduto);
            // A tabela atualiza automaticamente ao adicionar/remover itens da lista observável

            limparCampos();
            calcularValorTotalEstoque();
        }
    }

    private void editarProduto() {
        if (validarCampos()) {
            // Modifica o objeto Produto diretamente
            produtoSelecionado.setNome(textFieldNome.getText());
            produtoSelecionado.setPreco(Double.parseDouble(textFieldPreco.getText()));
            produtoSelecionado.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));

            // ESSA LINHA É CRUCIAL para que a tabela seja atualizada ao usar um POJO.
            // Ela força a TableView a reler os dados do objeto modificado.
            tableViewProdutos.refresh();

            calcularValorTotalEstoque();
            tableViewProdutos.getSelectionModel().clearSelection();
        }
    }

    private void excluirProduto() {
        listaProdutos.remove(produtoSelecionado);
        calcularValorTotalEstoque();
        // A limpeza da seleção já chama o listener para resetar a UI
        tableViewProdutos.getSelectionModel().clearSelection();
    }

    private boolean validarCampos() {
        boolean valido = true;
        textFieldNome.setStyle(null);
        textFieldPreco.setStyle(null);
        textFieldQuantidade.setStyle(null);

        if (textFieldNome.getText() == null || textFieldNome.getText().trim().isEmpty()) {
            textFieldNome.setStyle("-fx-border-color: red;");
            valido = false;
        }
        try {
            if (textFieldPreco.getText() == null || textFieldPreco.getText().trim().isEmpty()) {
                textFieldPreco.setStyle("-fx-border-color: red;");
                valido = false;
            }
            Double.parseDouble(textFieldPreco.getText());
        } catch (NumberFormatException e) {
            textFieldPreco.setStyle("-fx-border-color: red;");
            valido = false;
        }
        try {
            if (textFieldQuantidade.getText() == null || textFieldQuantidade.getText().trim().isEmpty()){
                textFieldQuantidade.setStyle("-fx-border-color: red;");
                valido = false;
            }
            Integer.parseInt(textFieldQuantidade.getText());
        } catch (NumberFormatException e) {
            textFieldQuantidade.setStyle("-fx-border-color: red;");
            valido = false;
        }

        return valido;
    }

    private void limparCampos() {
        textFieldNome.clear();
        textFieldPreco.clear();
        textFieldQuantidade.clear();
        textFieldNome.setStyle(null);
        textFieldPreco.setStyle(null);
        textFieldQuantidade.setStyle(null);
        tableViewProdutos.getSelectionModel().clearSelection();
    }

    public void carregarProdutos() {
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