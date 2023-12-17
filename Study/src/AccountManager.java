
public class AccountManager {
	
	public static void main(String[] args) {
		BankReader reader = new BankReader();
		BankAccount account = new BankAccount("my account" , 0);
		BankWriter writer = new BankWriter(account);
		AccountController controller = new AccountController(reader, writer, account);
		
		
		controller.processTransaction();
		
		
	}

}
