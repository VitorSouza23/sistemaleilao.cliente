/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.leilao;

import cliente.Cliente;
import java.rmi.RemoteException;
import rmiinterfaces.cliente.IClienteLeilaoController;
import rmiinterfaces.lance.ILanceLeiaoController;

/**
 *
 * @author Vitor
 */
public class ClienteControllerLeilao {
    private static ClienteControllerLeilao INSTANCE;

    private ClienteControllerLeilao() {
    }
    
    public static ClienteControllerLeilao getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ClienteControllerLeilao();
        }
        return INSTANCE;
    }
    
    private IClienteLeilaoController _clienteControllerLeilao;

    /**
     * @return the _clienteControllerLeilao
     */
    public IClienteLeilaoController getClienteControllerLeilao() {
        return _clienteControllerLeilao;
    }

    /**
     * @param _clienteControllerLeilao the _clienteControllerLeilao to set
     */
    public void setClienteControllerLeilao(IClienteLeilaoController _clienteControllerLeilao) {
        this._clienteControllerLeilao = _clienteControllerLeilao;
    }
    
    
    public Cliente cadastrarClienteNoServidor(Cliente cliente) throws RemoteException{
        return this._clienteControllerLeilao.cadstrarClienteNoServidor(cliente);
    }
    
    public boolean removerClienteDoServidor(Cliente cliente) throws RemoteException{
        return this._clienteControllerLeilao.removerClienteDoServidor(cliente);
    }
    
}
