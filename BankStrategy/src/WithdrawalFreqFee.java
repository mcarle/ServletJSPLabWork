import java.util.Calendar;
import java.util.List;

/**
 * 
 *
 */
public class WithdrawalFreqFee implements ApplyFeesStrategy {
  int feeAmt; 
  int numDays; 
  int freqLimit; 
  public WithdrawalFreqFee(int feeAmt, int freqLimit, int numDays) {
    this.feeAmt = feeAmt; 
    this.freqLimit = freqLimit; 
    this.numDays = numDays; 
  }

  @Override
  public int getFees(long currBalance, List<Withdrawal> withdHist) {
    int numTransactions = Withdrawal.numWithdrawalsInRange(withdHist, Calendar.getInstance(), 
        numDays); 
    
    if(numTransactions > freqLimit) {
      return feeAmt; 
    } else {
      return 0; 
    }
  }
}
