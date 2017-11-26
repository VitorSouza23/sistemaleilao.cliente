/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.leilao;

import java.rmi.RemoteException;
import java.util.List;
import produto.Produto;
import rmiinterfaces.produto.IProdutoLeilaoController;

/**
 *
 * @author Vitor
 */
public class ProdutoControllerLeilao {
    private static ProdutoControllerLeilao INSTANCE;

    private ProdutoControllerLeilao() {
    }
    
    public static ProdutoControllerLeilao getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ProdutoControllerLeilao();
        }
        return INSTANCE;
    }
    
    private IProdutoLeilaoController _produtoLeilaoController;

    /**
     * @return the _produtoLeilaoController
     */
    public IProdutoLeilaoController getProdutoLeilaoController() {
        return _produtoLeilaoController;
    }

    /**
     * @param _produtoLeilaoController the _produtoLeilaoController to set
     */
    public void setProdutoLeilaoController(IProdutoLeilaoController _produtoLeilaoController) {
        this._produtoLeilaoController = _produtoLeilaoController;
    }
    
    public Produto adicionarProduto(Produto produto) throws RemoteException{
        return this._produtoLeilaoController.adicionarProduto(produto);
    }
    
    public boolean removerProduto(Produto produto) throws RemoteException{
        return this._produtoLeilaoController.removerProduto(produto);
    }
    
    public List<Produto> getAllProdutos() throws RemoteException{
        return this._produtoLeilaoController.getAllProdutos();
    }
}
