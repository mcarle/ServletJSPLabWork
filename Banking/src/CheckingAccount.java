
public class CheckingAccount extends Account {
  
  private static final String WITHD_MSG = "Checking Withdrawal"; 
  private static final String DEPOSIT_MSG = "Checking Deposit"; 
  private long overdraftLmt; 
  
  public CheckingAccount(String holderName, long overdraftLmt) {
    super(holderName); 
    this.overdraftLmt = overdraftLmt; 
  }
  
  @Override
  public boolean withdraw(long amount) {
    if((getBalance() - amount) < (0 - overdraftLmt)) {
      // exceeds overdraft limit
      return false; 
    } else {
      transaction(WITHD_MSG, 0-amount);
      return true; 
    }
  }
  
  @Override
  public boolean deposit(long amount) {
    transaction(DEPOSIT_MSG, amount); 
    return true; 
  }
}
