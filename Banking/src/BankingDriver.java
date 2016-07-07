
public class BankingDriver {

    public static void main(String[] args) {
      Account[] accts = {
         new MortgageAccount("mrtg1", 100_000), 
         new CheckingAccount("chk1", 200), 
         new CheckingAccount("chk2", 1_000) 
      }; 
      
      for(Account acct : accts) {
        System.out.println("Processing acct: " + acct.getHolderName());
        
        printAcctStatus(acct.deposit(1000), acct); 
        printAcctStatus(acct.withdraw(500), acct); 
        printAcctStatus(acct.withdraw(1000), acct); 
        printAcctStatus(acct.withdraw(2000), acct); 
      }
    }
    
    public static void printAcctStatus(boolean status, Account acct) {
      System.out.println("Status: " + status + ", Balance: " + acct.getBalance());
    }
    
}
