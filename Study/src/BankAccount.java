



import javax.swing.JOptionPane;




public class BankAccount {
	public String account_name;
	private int balance;
	
	public BankAccount(String name , int initial_amount) {
		account_name = name;
		
		if (initial_amount >= 0)
			balance = initial_amount;
		else
			balance = 0;
	}
	
	public int getBalcne() {
		return balance;
	}
	
	public boolean deposit (int amount) {
		boolean result = false;
		
		if (amount < 0)
			JOptionPane.showMessageDialog(null, "잘못된 입금금액이라무시합니다.");
		
		else {
			balance = balance + amount;
			result = true;
		}
		
		return result;
	}
	
	public boolean withdraw (int amount) {
		boolean result = false;
		
		if(amount < 0)
			JOptionPane.showMessageDialog(null, "잘못된 출금액이라 무시합니다.");
		
		else if (amount > balance)
			JOptionPane.showMessageDialog(null, "잔고가 부족합니다.");
		
		else {
			balance = balance - amount;
			result = true;
		}
		return result;
	}
}