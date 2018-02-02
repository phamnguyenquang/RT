package ServerClientModel;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MasterServer extends Thread {
	private DatagramSocket MasterSocket;
	private byte[] receivedData;
	private byte[] sendData;
	private InetAddress destIP;
	private Thread t;

	public MasterServer() throws SocketException {
		MasterSocket = new DatagramSocket(12000);
		receivedData = new byte[1024];
		sendData = new byte[1024];
	}

	public void run() {
		String send = "SeekSlave";
		sendData = send.getBytes();

		try {
			destIP = InetAddress.getByName("localhost");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, destIP, 13000);

		try {
			MasterSocket.send(sendPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DatagramPacket receivePacket = new DatagramPacket(receivedData, receivedData.length);

		try {
			MasterSocket.receive(receivePacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(receivePacket.getPort());

		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("FROM CLIENT:" + modifiedSentence);
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, "master");
			t.start();
		}
	}
}
