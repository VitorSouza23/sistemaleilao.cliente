/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.leilao;

import exceptions.lance.ValorLanceInvalidoException;
import java.rmi.RemoteException;
import java.util.List;
import lance.Lance;
import produto.Produto;
import rmiinterfaces.lance.ILanceLeiaoController;

/**
 *
 * @author Vitor
 */
public class LanceControllerLailao {
    private static LanceControllerLailao INSTANCE;
    
    private LanceControllerLailao() {
    }
    
    public static LanceControllerLailao getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LanceControllerLailao();
        }
        return INSTANCE;
    }
    
    private ILanceLeiaoController _lanceLeilaoController;

    /**
     * @return the _lanceLeilaoController
     */
    public ILanceLeiaoController getLanceLeilaoController() {
        return _lanceLeilaoController;
    }

    /**
     * @param _lanceLeilaoController the _lanceLeilaoController to set
     */
    public void setLanceLeilaoController(ILanceLeiaoController _lanceLeilaoController) {
        this._lanceLeilaoController = _lanceLeilaoController;
    }
    
    public Lance fazerUmlance(Lance lance) throws RemoteException, ValorLanceInvalidoException{
        return this._lanceLeilaoController.fazerUmLance(lance);
    }
    
    public boolean removerLance(Lance lance) throws RemoteException{
        return this._lanceLeilaoController.removerLance(lance);
    }
    
    public List<Lance> getAllLances() throws RemoteException{
        return this._lanceLeilaoController.getAlllances();
    }
    
    public Lance getLanceCombaseEmUmProduto(Produto produto) throws RemoteException{
        return this._lanceLeilaoController.getlanceComBaseEmUmProduto(produto);
    }
}
