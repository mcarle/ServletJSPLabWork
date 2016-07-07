
public class MortgageAccount extends Account {
  private static final String INIT_BORROWD_MSG = 
      "Initial Borrowed Amount"; 
  private static final String DEPOSIT_MSG = "Mortgage Payment"; 
  private long initAmtBorrowed; 
  
  public MortgageAccount(String holderName, long initAmtBorrowed) {
    super(holderName); 
    this.initAmtBorrowed = initAmtBorrowed; 
    transaction(INIT_BORROWD_MSG, 0 - initAmtBorrowed);
  }
  
  @Override
  public boolean deposit(long amount) {
    transaction(DEPOSIT_MSG, amount); 
    return true; 
  }
  
  @Override
  public boolean withdraw(long amount) {
    return false; 
  }
}
