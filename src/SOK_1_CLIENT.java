import java.net.*;
import java.awt.EventQueue;
import java.awt.Window;
import java.io.*;

public class SOK_1_CLIENT {

	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					MainGUI window = new MainGUI();
					window.frameMain.setVisible(true);
					System.out.println(window.frameMain.getSize());
					SOK_1_CLIENT s1 = new SOK_1_CLIENT();
					s1.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private void run() throws Exception {
		System.out.println("CLIENT");
		int port = 4444;
		String ip = "127.0.0.1";

		try {
			Socket socket = new Socket(ip, port);

			InputStream sin = socket.getInputStream();
			OutputStream sout = socket.getOutputStream();

			DataInputStream in = new DataInputStream(sin);
			DataOutputStream out = new DataOutputStream(sout);

			BufferedReader keyboard = new BufferedReader(new InputStreamReader(
					System.in));
			String message = null;
			System.out.println("Type your message");
			while (true) {
				message = keyboard.readLine();
				out.writeUTF(message);
				out.flush();
				message = in.readUTF();
				System.out.println("Server send me this: " + message);
				System.out.println("IP: " + socket.getInetAddress() + " Port: "
						+ socket.getPort());
				System.out.println();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
