
public class Main {

    public static void main(String[] args) {
      /*Account act = new Account(new WithdrawalFreqFee(
          150, 5, 30), new ThresholdWithdrawal(0), 0); */
      
      Account act = new Account(new FeeTransNotCredit(150)
          , new WithdrawalFreqLimit(5, TransFreqInterval.Month), 0); 
      
      act.deposit(250);
      act.deposit(500);
      act.withdrawal(150); 
      act.withdrawal(200); 
      act.withdrawal(700);
      act.withdrawal(50); 
      act.withdrawal(50); 
      act.withdrawal(50); 
    }
}
