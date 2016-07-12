import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class Withdrawal {
  private long amt; 
  private Calendar date; 
  private String msg; 
  
  public Withdrawal(long amt, Calendar date, String msg) {
    this.amt = amt; 
    this.date = date; 
    this.msg = msg; 
  }
  
  public long getAmt() {
    return amt; 
  }
  
  public Calendar getDate() {
    return date; 
  }
  
  public String getMsg() {
    return msg; 
  }
  
  public static int numWithdrawalsInRange(List<Withdrawal> wList, 
      Calendar high, TransFreqInterval interval) {
    int daysBack = 0; 
    switch(interval) {
      case Day: 
        daysBack = 1; 
        break;
      case Month: 
        daysBack = high.get(Calendar.DAY_OF_MONTH); 
        break;
      case Year: 
        daysBack = high.get(Calendar.DAY_OF_YEAR); 
        break;
    }
   
    return numWithdrawalsInRange(wList, high, daysBack); 
  }
  
  // retreives the number of transactions from the last 
  // n days. 
  public static int numWithdrawalsInRange(List<Withdrawal> wList, 
      Calendar highDate, int days) {
    wList.sort(new Comparator<Withdrawal>() {
      @Override
      public int compare(Withdrawal o1, Withdrawal o2) {
        return o1.date.compareTo(o2.date); 
      }
    });
    
    int numIntervalTrans = 0;
    Calendar lowDate = (Calendar)highDate.clone(); 
    lowDate.set(Calendar.DAY_OF_YEAR, 
        highDate.get(Calendar.DAY_OF_YEAR) - days);
   
    for(Withdrawal w : wList) {
      if(w.getDate().after(highDate)) {
        return numIntervalTrans; 
      } else if(w.getDate().after(lowDate)) {
        numIntervalTrans++; 
      }
    }
    
    return numIntervalTrans; 
  }
}
