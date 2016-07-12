import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Account {

  private long balance; 
  private ApplyFeesStrategy fees; 
  private GrantWithdrawalStrategy withd; 
  List<Withdrawal> withdrawals = new ArrayList<Withdrawal>(); 
  
  public Account(ApplyFeesStrategy afs, GrantWithdrawalStrategy gws, long balance) {
    fees = afs; 
    withd = gws; 
    this.balance = balance; 
  }
  
  public void setFeesStrategy(ApplyFeesStrategy afs) {
    fees = afs; 
  }
  
  public void setWithdStrategy(GrantWithdrawalStrategy gws) {
    withd = gws; 
  }
  
  private void transaction(String msg, long amt) {
    String transMsg = msg + " : " + amt; 
    System.out.println(transMsg);
    
    balance += amt; 
    System.out.println("New balance: " + balance);
  }
  
  public void deposit(long amt) {
    transaction("Deposit made!", amt); 
  }
  
  public boolean withdrawal(long amt) {
    // see if we can make withdrawal
    if(withd.allowWithdrawal(balance, amt, withdrawals)) {
      withdrawals.add(new Withdrawal(amt, Calendar.getInstance(), "withdrawal made"));      
      transaction("Withdrawal made!", -amt); 
      int withdFees = fees.getFees(balance, withdrawals); 
      if(withdFees > 0) {
        applyFees(withdFees); 
      }
      return true; 
    } else {
      System.out.println("Withdrawal refused!");
      return false; 
    }
  }
  
  private void applyFees(int fee) {
    transaction("fee applied! ", -fee); 
  }
}
