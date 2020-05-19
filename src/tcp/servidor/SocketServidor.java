package tcp.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SocketServidor {
	private static final int PORTA = 1234;
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(PORTA); // Socket de Servidor para monitoramento de porta
			Socket socket = server.accept();  // criando Socket a partir de accept() de ServerSocket
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());  // obtem fluxo de dados para leitura 
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());  // obtem fluxo de dados para escrita
			
			String utf = dis.readUTF();
			System.out.println("Servidor: Mensagem recebida => " + utf );
			
			System.out.println("Mensagem recebida com sucesso às " + new Date());
			
			System.out.println("Servidor: Mensagem enviada => " + utf);
			
			dos.writeUTF(utf);
			
			dis.close();
			dos.close();
			socket.close();
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}




















