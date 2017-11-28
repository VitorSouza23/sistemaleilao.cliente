/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection.server;

import controller.leilao.ClienteControllerLeilao;
import controller.leilao.LanceControllerLailao;
import controller.leilao.ProdutoControllerLeilao;
import helpers.rmicofigs.RMIHelper;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import multcast.thread.VerificadorDeLanceMaisAlto;
import rmiinterfaces.cliente.IClienteLeilaoController;
import rmiinterfaces.lance.ILanceLeiaoController;
import rmiinterfaces.produto.IProdutoLeilaoController;

/**
 *
 * @author Vitor
 */
public class ConnectToServer {
    public  static boolean connectToServerClienteLeilao() throws  RemoteException, NotBoundException{
            System.out.println("Inciciando cliente...");
            System.out.println("\tConectando ao servidor de Clientes...");
            Registry registro = LocateRegistry.getRegistry(RMIHelper.SERVER_ADRESS, RMIHelper.CLIENTE_LEILAO_CONTROLLER_PORT);
            ClienteControllerLeilao clienteControllerLeilao = ClienteControllerLeilao.getInstance();
            clienteControllerLeilao.setClienteControllerLeilao((IClienteLeilaoController) registro.lookup(RMIHelper.CLIENTE_LEILAO_CONTROLLER_NAEME));
            System.out.println("Cliente conectado!");
            System.out.println("\tstatus [OK]");
            return true;
    }
    
    public  static boolean connectToServerProdutoLeilao() throws  RemoteException, NotBoundException{
            System.out.println("Inciciando produtos...");
            System.out.println("\tConectando ao servidor de Produtos...");
            Registry registro = LocateRegistry.getRegistry(RMIHelper.SERVER_ADRESS, RMIHelper.PRODUTO_LEILAO_CONTROLLER_PORT);
            ProdutoControllerLeilao produtoControllerLeilao = ProdutoControllerLeilao.getInstance();
            produtoControllerLeilao.setProdutoLeilaoController((IProdutoLeilaoController) registro.lookup(RMIHelper.PRODUTO_LEILAO_CONTROLLER_NAEME));
            System.out.println("Produtos conectado!");
            System.out.println("\tstatus [OK]");
            return true;
    }
    
    public  static boolean connectToServerLanceLeilao() throws  RemoteException, NotBoundException, IOException{
            System.out.println("Inciciando lances...");
            System.out.println("\tConectando ao servidor de Lances...");
            Registry registro = LocateRegistry.getRegistry(RMIHelper.SERVER_ADRESS, RMIHelper.LANCE_LEILAO_CONTROLLER_PORT);
            LanceControllerLailao lanceControllerLailao = LanceControllerLailao.getInstance();
            lanceControllerLailao.setLanceLeilaoController((ILanceLeiaoController) registro.lookup(RMIHelper.LANCE_LEILAO_CONTROLLER_NAEME));
            System.out.println("Lances conectado!");
            System.out.println("\tstatus [OK]");
            VerificadorDeLanceMaisAlto vdlma = new VerificadorDeLanceMaisAlto();
            System.out.println("Começando a ouvir lances mais altos...");
            vdlma.start();
            return true;
    }
}
