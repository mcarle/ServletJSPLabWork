import java.util.List;

/**
 * Determines fee amount based on whether trasnaction resulting balance
 * is not in credit. 
 */
public class FeeTransNotCredit implements ApplyFeesStrategy {
    
    int feeAmt;
    public FeeTransNotCredit(int feeAmt) {
      this.feeAmt = feeAmt; 
    }
  
    @Override
    public int getFees(long currBalance
        , List<Withdrawal> withdHist) {
      if(currBalance < 0) {
        return feeAmt; 
      } else {
        return 0; 
      }
    }
}
