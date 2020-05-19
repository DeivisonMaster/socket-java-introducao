package tcp.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class SocketCliente {
	private static final String HOST = "127.0.0.1";
	private static final int PORTA = 1234;
	
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket(HOST, PORTA);
			
			DataInputStream dis = new DataInputStream(socket.getInputStream()); 
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			String mensagem = "Conectado às: " + new Date();
			
			System.out.println("Cliente: Mensagem enviada => " + mensagem);
			
			dos.writeUTF(mensagem);
			
			mensagem = dis.readUTF();
			
			System.out.println("Cliente: + Mensagem recebida => " + mensagem);
			
			dis.close();
			dos.close();
			socket.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
