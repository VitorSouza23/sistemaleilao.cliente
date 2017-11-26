/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection.server;

import cliente.Cliente;
import controller.leilao.ClienteControllerLeilao;
import controller.leilao.LanceControllerLailao;
import controller.leilao.ProdutoControllerLeilao;
import exceptions.lance.ValorLanceInvalidoException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lance.Lance;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import produto.Produto;

/**
 *
 * @author Vitor
 */
public class ConectToServerTest {
    
    public ConectToServerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        Cliente cliete = new Cliente("Teste");
        try {
            ConnectToServer.connectToServerClienteLeilao();
            ClienteControllerLeilao controller = ClienteControllerLeilao.getInstance();
            cliete = controller.cadastrarClienteNoServidor(cliete);
            System.out.println(cliete.getId());
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ConectToServerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Produto produto = new Produto("teste", "teste", 0, true);
        try {
            ConnectToServer.connectToServerProdutoLeilao();
            ProdutoControllerLeilao controllerLeilao = ProdutoControllerLeilao.getInstance();
            produto = controllerLeilao.adicionarProduto(produto);
            System.out.println(produto.getId());
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ConectToServerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Lance lance = new Lance(cliete, produto, 10);
        try {
            ConnectToServer.connectToServerLanceLeilao();
            LanceControllerLailao lanceControllerLailao = LanceControllerLailao.getInstance();
            lance = lanceControllerLailao.fazerUmlance(lance);
            System.out.println(lance.getId());
        } catch (RemoteException | NotBoundException | ValorLanceInvalidoException ex) {
            Logger.getLogger(ConectToServerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
