package udp.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

public class SocketServidor {
	private static final String HOST = "127.0.0.1";
	private static final int PORTA_SERVIDOR = 1234;
	private static final int PORTA_CLIENTE = 1235;
	private static final int BUFFER_LENGTH = 1024;
	
	
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(PORTA_SERVIDOR);  // determina porta para envio e recebimento de dados em pacotes
			InetAddress address = InetAddress.getByName(HOST);  // armazena o HOST a ser utilizado no envio de datagramas
			
			byte[] buffer = new byte[BUFFER_LENGTH];  // buffer para troca de dados 
			
			DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);  // monta datagrama a ser enviado 
			
			datagramSocket.receive(datagramPacket);  // recebimento de dados
			buffer = datagramPacket.getData(); 
			
			String mensagem = new String(buffer);
			
			System.out.println("Servidor: Mensagem recebida => " + mensagem);
			
			mensagem = "Mensagem recebida com sucesso às " + new Date();
			
			System.out.println("Servidor: Mensagem enviada => " + mensagem);
			
			buffer = mensagem.getBytes();
			
			datagramPacket = new DatagramPacket(buffer, buffer.length, address, PORTA_CLIENTE);
			datagramSocket.send(datagramPacket);
			datagramSocket.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
