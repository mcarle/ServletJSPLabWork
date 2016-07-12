import java.util.List;

public interface ApplyFeesStrategy {
  public int getFees(long currBalance, List<Withdrawal> withdHist); 
}
