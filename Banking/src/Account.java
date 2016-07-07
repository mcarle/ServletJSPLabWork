
public abstract class Account {

  private long balance; 
  private String holderName; 
  
  public Account(String holderName) {
    this.holderName = holderName; 
  }
  
  public final void transaction(String message, long amount) {
    
    System.out.println("Holder name: " + holderName);
    System.out.println("Message: " + message);
    System.out.println("Amount: " + amount); 
    
    balance += amount; 
  }
  
  public long getBalance() {
    return balance; 
  }
  
  public String getHolderName() {
    return holderName; 
  }
  
  public abstract boolean deposit(long amount); 
  
  public abstract boolean withdraw(long amount); 
}
