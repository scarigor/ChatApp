import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;


public class CallListener {
	public String localNick = "Default user";
    public String localIP;
    public int port = 28411;
    Socket incomingSocket;
    InetAddress ipAddress;
    public SocketAddress Address;
    public String remoteNick;
    public SocketAddress remoteAddress;

    public CallListener() {

    }

    public CallListener(String localNick) {
        this.localNick = localNick;
    }


    public CallListener(String localNick, String localIP) {
        this(localNick);
        this.localIP = localIP;
        try {
            ipAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {

        }
    }

    public String getConnection() {
        System.out.println("Waiting for a client...");
        try {
            ServerSocket s = new ServerSocket(port);
            Socket incoming = s.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(incomingSocket.getOutputStream())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getLocalNick() {
        return localNick;
    }

    public boolean isBusy(){
    	return false;
    }

    public SocketAddress getListenAddress(){
        return Address;
    }

    public String getRemoteNick(){
        return remoteNick;
    }

    public SocketAddress getRemoteAddress(){
        return remoteAddress;
    }
}
