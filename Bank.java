/* Assignment 8.1: Generating BankATMException whenever withdrawal is done for balance less than 10000.
*/

class BankATMException extends Exception {	// User defined class BankATMException
	BankATMException(String s) {
		super(s);	// Super used to call parent class constructor
   	}
}

class BankAtm {		// Class BankATM

	int atmId;
	String bankName;
	String location;
	Double balance;
	Double limit=10000.00;

	public BankAtm(int id, String bName, String loc){	// BankAtm constructor initialise the variables
		this.atmId = id;
		this.bankName = bName;
		this.location = loc;
	}	

	void withdraw(double amt){	// Withdraw method
		try{
			if (balance < limit){
				status();	// Method to check status
				throw new BankATMException("Withdrawal declined! Balance is less than 10000!");	// Throw used to invoke user defined exception
			} else if (balance < amt){
				status();
				throw new BankATMException("Withdrawal declined! Balance is less than withdrawal amount!");	// Throw used to invoke user defined exception
			} else
			{
				balance = balance - amt;
				status();		
			}
		} catch (BankATMException bae) {System.out.println(bae);}	// Display exception!
	}
	void deposit(double amt){
		balance = amt;
		status();
	}

	void status(){
		System.out.println("\nBank: " + bankName + "\nATM: " + atmId + "\nLocation: " + location + "\nBalance: " + balance);
	}
}

class Bank {
	
	public static void main(String[] args){
	
		BankAtm ggn = new BankAtm(001,"HDFC","Gurgaon");	
		BankAtm del = new BankAtm(002,"HDFC","Delhi");	
		BankAtm noi = new BankAtm(003,"HDFC","Noida");
//
		System.out.println("========");
		System.out.println("Deposits");
		System.out.println("========");
		ggn.deposit(5000);
		del.deposit(50000);
		noi.deposit(30000);	
//
		System.out.println("\n========");
		System.out.println("Withdraw");
		System.out.println("========");
		ggn.withdraw(30000);
		del.withdraw(40000);
		noi.withdraw(40000);	
	}
}