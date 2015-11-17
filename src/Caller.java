import java.net.SocketAddress;

public class Caller {
	String localNick, remoteNick;
	int remotePort;
	SocketAddress remoteAddress;
	CallStatus callstatus;

	Caller() {
		localNick = "Default User";
	}

	 Caller(String localNick) {
		this.localNick = localNick;
	}

	Caller(String localNick, SocketAddress remoteAddress) {
		this.localNick = localNick;
		this.remoteAddress = remoteAddress;
	}

	Caller(String localNick, String ipAddress) {
		this.localNick = localNick;
		this.remoteAddress = null;
	}

	Connection call() {
		Connection connection = new Connection(remoteAddress, 28411);
		return connection;
	}

	void setLocalNick(String localNick) {
		this.localNick = localNick;
	}

	void setRemoteAddress(SocketAddress remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	String getLocalNick() {
		return localNick;
	}

	SocketAddress getRemoteAddress() {
		return remoteAddress;
	}

	String getRemoteNick() {
		return null;
	}

	public String toString(){
        return localNick+ " " +remoteAddress.toString();
    }
	
	public CallStatus getStatus(){
		return callstatus;
	}

////	static enum CallStatus(){
//	BUSY, NO_SERVICE, NOT_ACCESSABLE, OK, REJECTED;
//	}
	
	public static void main(String[] args) {

	}
}
