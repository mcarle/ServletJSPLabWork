import java.util.List;

public interface GrantWithdrawalStrategy {
  public boolean allowWithdrawal(long currBalance, long amt, List<Withdrawal> withdHist); 
}
