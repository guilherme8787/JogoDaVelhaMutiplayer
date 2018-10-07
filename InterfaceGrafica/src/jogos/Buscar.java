/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogos;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Orion
 */
public class Buscar {
    int porta;
    int ip;
    Socket socket;
    ServerSocket server;

    public Buscar(int porta, int ip, Socket socket, ServerSocket server) {
        this.porta = porta;
        this.ip = ip;
        this.socket = socket;
        this.server = server;
    }
}