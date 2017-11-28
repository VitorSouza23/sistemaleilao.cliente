/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multcast.thread;

import controller.leilao.LanceControllerLailao;
import helpers.multcastconfig.MultcastConfig;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vitor
 */
public class VerificadorDeLanceMaisAlto extends Thread {

    private final MulticastSocket _socket;

    public VerificadorDeLanceMaisAlto() throws UnknownHostException, IOException {
        this._socket = new MulticastSocket(MultcastConfig.MULTCAST_PORT);
        this._socket.joinGroup(InetAddress.getByName(MultcastConfig.MULTCAST_ADDRESS));
    }

    @Override
    public void run() {
        while (true) {
            byte[] buffer = new byte[MultcastConfig.MULTCAST_MESSAGE_LENGTH];
            DatagramPacket msgIn = new DatagramPacket(buffer, buffer.length);
            try {
                this._socket.receive(msgIn);
                System.out.println("\tMensagem multcast recebida!");
                String resultado = new String(msgIn.getData());
                System.out.println(resultado);
                if(resultado.equals(MultcastConfig.YES_MESSAGE)){
                    LanceControllerLailao.getInstance().getAllLances();
                    System.out.println("\tNovo lance mais alto detectado, atualizando listas...");
                }
            } catch (IOException ex) {
                Logger.getLogger(VerificadorDeLanceMaisAlto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
