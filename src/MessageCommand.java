
public class MessageCommand extends Command {
	String message;
	
	
	
	public MessageCommand(String message) {
		super();
		this.message = message;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}
}
