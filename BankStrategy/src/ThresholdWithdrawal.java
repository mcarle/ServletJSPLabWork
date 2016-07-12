import java.util.List;

/**
 * Determines whether a withdrawal should be allowed based on whether
 * the new balance after the transaction is below the specified threshold
 * balance. 
 */
public class ThresholdWithdrawal implements GrantWithdrawalStrategy{
  
  private long thresholdBalance; 
  
  public ThresholdWithdrawal(long thresholdBalance) {
    this.thresholdBalance = thresholdBalance; 
  }

  @Override
  public boolean allowWithdrawal(long currBalance, long amt, List<Withdrawal> withdHist) {
    return (currBalance - amt) >= thresholdBalance; 
  }
}
