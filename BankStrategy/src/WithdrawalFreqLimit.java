import java.util.List;
import java.util.Calendar;
import java.util.Date; 

/**
 *  Determines whether a withdrawal should be allowed based on the number 
 *  of existing withdrawals in a particular month
 */
public class WithdrawalFreqLimit implements GrantWithdrawalStrategy {
    
    private int numAllowedTrans; 
    private TransFreqInterval interval; 
    
  public WithdrawalFreqLimit(int numAllowedTrans, TransFreqInterval interval) {
    this.numAllowedTrans = numAllowedTrans; 
    this.interval = interval; 
  }
  
  @Override
  public boolean allowWithdrawal(long currBalance, long amt, List<Withdrawal> withdHist) {
    // assumes withdhist list is sorted with most recent trans last
    int numTrans = Withdrawal.numWithdrawalsInRange(withdHist, Calendar.getInstance(), 
        interval); 
    
    return numTrans < numAllowedTrans; 
  }
}
