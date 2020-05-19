package servidor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private static final int PORTA = 3322;

	public static void main(String args[]){
        try {
        	ServerSocket server = new ServerSocket(PORTA);  // inicializa um ponto de conexão (Socket) em uma porta definida
        	System.out.println("Servidor iniciado na porta:" + server.getLocalPort());
        	
        	Socket cliente = server.accept();  // aceita uma conexão de algum cliente
        	
        	
        	// lógica a ser executada após uma conexão ser feita
        	InetAddress serverAddress = server.getInetAddress();
        	System.out.println("IP Servidor: " + serverAddress.getHostAddress());
        	System.out.println("Porta Servidor: " + serverAddress.getHostName());
        	
        	InetAddress address = cliente.getInetAddress();
        	System.out.println("Cliente conectado do IP: " + address.getHostAddress());
        	System.out.println("Cliente conectado: " + address.getHostName());
        	
        	Scanner entrada = new Scanner(cliente.getInputStream());  // capturando dados do cliente
        	
        	while(entrada.hasNextLine()) {
        		System.out.println(entrada.nextLine());
        	}
        	
        	entrada.close();
        	server.close();
        	
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
