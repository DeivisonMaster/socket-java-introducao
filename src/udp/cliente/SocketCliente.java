package udp.cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class SocketCliente {
	private static final String HOST = "127.0.0.1";
	private static final int PORTA_SERVIDOR = 1234;
	private static final int PORTA_CLIENTE = 1235;
	private static int BUFFER_LENGTH = 1024;

	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket = new DatagramSocket(PORTA_CLIENTE);

		InetAddress address = InetAddress.getByName(HOST);

		String mensagem = "Conectado às " + new Date();

		System.out.println("Cliente: Mensagem enviada => \"" + mensagem + "\"");

		byte[] buffer = mensagem.getBytes();

		DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, address, PORTA_SERVIDOR);

		datagramSocket.send(datagramPacket);

		buffer = new byte[BUFFER_LENGTH];

		datagramPacket = new DatagramPacket(buffer, buffer.length);

		datagramSocket.receive(datagramPacket);

		buffer = datagramPacket.getData();

		mensagem = new String(buffer);

		System.out.println("Cliente: Mensagem recebida => \"" + mensagem + "\"");

		datagramSocket.close();
	}
}
