
public class AccountController2 {
	private BankReader reader;
	private BankWriter primary_writer, secondary_writer, writer;
	private BankAccount primary_account, secondary_accont, account;
	
	
	public AccountController2 (BankReader r, BankAccount a1, BankAccount a2 , BankWriter w1 , BankWriter w2) {
		
		
		reader = r;
		primary_account = a1;
		primary_writer = w1;
		secondary_accont = a2;
		secondary_writer = w2;
		account =  primary_account;
		writer = primary_writer;
	}
	
	public void resetAccount(BankAccount new_account, BankWriter new_writer) {
		writer.showTransaction("비활성");
		account = new_account;
		writer = new_writer;
		writer.showTransaction("활성");
	}
	
	public void processTransaction() {
		char command = reader.readCommand("명령 P/S/D/W/Q와 금액을 입력하세요.");
		
		switch (command) {
			case 'P':
				resetAccount(primary_account, primary_writer);
				break;
				
			case 'S':
				resetAccount(secondary_accont, secondary_writer);
				break;
				
			case 'Q' :
				return;
				
			case 'D':
			{
				int amount = reader.readAmount();
				
				if (account.deposit(amount)) writer.showTransaction("입금 $", amount);
				else 						  writer.showTransaction("입금 오류", amount);
				break;
			}
			case 'W':
			{
				int amount = reader.readAmount();
				if(account.withdraw(amount)) writer.showTransaction("출 $", amount);
				else 						writer.showTransaction("출금 오류", amount);
				break;
			}
			
			
			default:
				writer.showTransaction("잘못된 명령 " + command);
				
		}
		this.processTransaction();
			
			 
	}

}
