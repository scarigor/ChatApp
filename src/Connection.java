import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Connection {
	public static final int port = 28411;
	public Socket SOCKET;
	private String nick;

	private OutputStream ops;
	private DataInputStream din;
	private DataOutputStream dout;

	public Connection(Socket s, String nick) {
		try {
			SOCKET = s;
			ops = s.getOutputStream();
			dout = new DataOutputStream(ops);
			din = new DataInputStream(s.getInputStream());
			nick = nick;
			System.out.println(nick + "( " + s.getInetAddress() + ")"
					+ "successfully connected. Type your message...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void accept() throws IOException {
		dout.write("Accepted\n".getBytes());
		dout.flush();
	}

	void disconnect() throws IOException {
		dout.write("Disconnected\n".getBytes());
		dout.flush();
		dout.close();
		close();
	}

	void close() throws IOException {
		SOCKET.close();
	}

	boolean isOpened() {
		return !SOCKET.isClosed();
	}

	// public Command receive (){
	//
	// }


	void reject() throws IOException {
		dout.write("Rejected\n".getBytes());
		dout.flush();
	}

	void sendMessage(String msg) throws IOException {
		dout.write("MESSAGE\n".getBytes());
		dout.write(msg.getBytes());
		dout.flush();
	}

	void sendNickBusy(String msg) throws IOException {
		dout.write(("ChatApp 2015 user" + nick + "is busy now!").getBytes());
		dout.flush();
	}

	void sendNickHello() throws IOException {
		dout.write(("ChatApp 2015 user" + nick).getBytes());
		dout.flush();
	}


}
