public class NickCommand extends Command {
	String version, nick;
	boolean busy;

	public NickCommand(String version, String nick, boolean busy) {
		super();
		this.version = version;
		this.nick = nick;
		this.busy = busy;
	}
}
