package ServerClientModel;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SlaveClient extends Thread {
	private DatagramSocket SlaveSocket;
	private byte[] receivedData;
	private byte[] sendData;
	private InetAddress destIP;
	private Thread t;

	public SlaveClient() throws SocketException {
		SlaveSocket = new DatagramSocket(13000);
		receivedData = new byte[1024];
		sendData = new byte[1024];
	}

	public void run() {
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receivedData, receivedData.length);
			try {
				SlaveSocket.receive(receivePacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String sentence = new String(receivePacket.getData());
			// System.out.println("RECEIVED: " + sentence);

			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();

			sendData = "done".getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

			try {
				SlaveSocket.send(sendPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, "Slave");
			t.start();
		}
	}
}
