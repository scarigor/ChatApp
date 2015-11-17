import java.net.Socket;
import java.net.SocketAddress;

public class Connection {
	private String nick, mes, ver;
	SocketAddress socket;
	
	public Connection(SocketAddress s, int port){
		this.socket = s;
	}
	void accept() {
		 
	}

	void close() {

	}

	void disconnect() {

	}

	boolean isOpened() {
		return null != null;
	}

	// public Command receive (){
	//
	// }

	void receive() {

	}

	void reject() {

	}

	void sendMessage(String msg) {

	}

	void sendNickBusy(String msg) {

	}
	
	void sendNickHello(){
		
	}
	
	public static void main(String[] args) {
		
	}

}
