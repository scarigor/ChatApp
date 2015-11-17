import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SOK_1_SERVER {

	public void run() throws Exception {

		System.out.println("SERVER");
		int port = 4444;

		try {
			ServerSocket SOCKET = new ServerSocket(port);
			System.out.println("Waiting for connection.");
			Socket socket = SOCKET.accept();
			System.out.println("Connected!");

			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());

			String message = null;
			while (true) {
				message = in.readUTF();
				System.out.println("Client`s message: " + message);
				out.writeUTF(message);
				out.flush();
			}
		} catch (Exception e) {
			System.out.println("Cant find client");
		}

	}

	public static void main(String[] args) throws Exception {

		SOK_1_SERVER SERVER = new SOK_1_SERVER();
		SERVER.run();
	}

}
