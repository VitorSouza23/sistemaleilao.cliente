/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.leilao;

import cliente.Cliente;
import connection.server.ConnectToServer;
import exceptions.lance.ValorLanceInvalidoException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import lance.Lance;
import produto.Produto;

/**
 *
 * @author Vitor
 */
public class ControlePrincipal {
    private final ClienteControllerLeilao _clienteController;
    private final LanceControllerLailao _lanceController;
    private final ProdutoControllerLeilao _produtoController;
    private Cliente _clienteAtual;

    public ControlePrincipal() throws RemoteException, NotBoundException, IOException {
        ConnectToServer.connectToServerClienteLeilao();
        ConnectToServer.connectToServerProdutoLeilao();
        ConnectToServer.connectToServerLanceLeilao();
        this._clienteController = ClienteControllerLeilao.getInstance();
        this._lanceController = LanceControllerLailao.getInstance();
        this._produtoController = ProdutoControllerLeilao.getInstance();
    }
    
    
    
    public void novoCliente(Cliente cliente) throws RemoteException{
        this._clienteAtual = this._clienteController.cadastrarClienteNoServidor(cliente);
    }
    
    public List<Produto> getListaDeProdutos() throws RemoteException{
        return this._produtoController.getAllProdutos();
    }
    
    public Produto getProduto(int index) throws RemoteException{
        return this._produtoController.getAllProdutos().get(index);
    }
    
    public Lance getlanceAtualDoProduto(Produto produto) throws RemoteException{
        return this._lanceController.getLanceCombaseEmUmProduto(produto);
    }

    /**
     * @return the _clienteAtual
     */
    public Cliente getClienteAtual() {
        return _clienteAtual;
    }

    /**
     * @param _clienteAtual the _clienteAtual to set
     */
    public void setClienteAtual(Cliente _clienteAtual) {
        this._clienteAtual = _clienteAtual;
    }
    
    public Lance fazerUmLance(Lance lance) throws RemoteException, ValorLanceInvalidoException{
        return this._lanceController.fazerUmlance(lance);
    }
}
