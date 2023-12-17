





public class AccountManager2 {
	public static void main(String[] args)
	{ 
		 BankReader reader = new BankReader();
		 BankAccount primary_account = new BankAccount("계좌#1", 0);
		 BankWriter primary_writer = new BankWriter(primary_account);
		 BankAccount secondary_account = new BankAccount("계좌#2", 0);
		 BankWriter secondary_writer = new BankWriter(secondary_account);
		 AccountController2 controller = new AccountController2(reader, primary_account, secondary_account, primary_writer,  secondary_writer);
		 controller.processTransaction();
	}
}