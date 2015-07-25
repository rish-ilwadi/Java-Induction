package OptimusBank;

public class Account {

	private long accountNo;
	private String typeOfAccount;
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getTypeOfAccount() {
		return typeOfAccount;
	}
	public void setTypeOfAcoount(String typeOfAccount)throws WrongAccountTypeException{
		
		for( TypeOfAccount account : TypeOfAccount.values()){
			 
			if(typeOfAccount.equals((String)account.name())){
				
				this.typeOfAccount=(String)account.name();
			}
		}
		if(this.typeOfAccount==null){			
				throw new WrongAccountTypeException("Wrong Account Type !!");
	    }
		
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	double balance;
}
