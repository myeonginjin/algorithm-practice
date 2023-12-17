import java.text.*;


public class BankWriter {
	private BankAccount bank;
	private String last_transaction = "";
	
	public BankWriter(BankAccount b) {
		bank = b;
	}
	
	private String unconvert(int i ) {
		return new DecimalFormat("0.00").format(i/100.0);
	}
	
	public void showTransaction(String message, int amount) {
		last_transaction = message + " " + unconvert(amount);
		System.out.println(bank.account_name + ": " + last_transaction);
		System.out.println("Current balance = $" + unconvert(bank.getBalcne()));
	}
	
	public void showTransaction(String message) {
		last_transaction = message;
		System.out.print(bank.account_name+ ": "+last_transaction);
	}
	
	
	
	

}
