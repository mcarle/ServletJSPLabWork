
public class Target {
  private String fieldA; 
  private String fieldB; 
  private String fieldC; 
  private String fieldD; 
  private String fieldE; 
  
  private Target() { }
  
  private void isValid() throws Exception {
    // A must not be null or empty 
    if(fieldA == null || fieldA.length() < 1) {
      throw new Exception("Invalid Target state! fieldA cannot be null or empty"); 
    }
    
    // field b and c must not be null
    if(fieldB == null || fieldC == null) {
      throw new Exception("Invalid target state! fieldB and fieldC cannot be null"); 
    }
    
    // both or neither fieldD and fieldE must be specified, if specified, fieldE must longer than d
    if((fieldD == null && fieldE != null)
        || (fieldD != null && fieldE == null)) {
      throw new Exception("Invalid target state! fieldE and fieldD must be both or neither specified"); 
    }
    
    if(fieldD != null && fieldE != null) {
      if(fieldE.length() < fieldD.length()) {
        throw new Exception("Invalid target state! fieldE must be longer than fieldD!"); 
      }
    }
  }
  
  public static Builder builder() {
    return new Builder(); 
  }
  
  public static class Builder {
    private Target t; 
    public Builder() {
      t = new Target(); 
    }
    
    public Builder fieldA(String val) {
      t.fieldA = val; 
      return this; 
    }
    
    
    public Builder fieldB(String val) {
      t.fieldB = val; 
      return this; 
    }
    
    public Builder fieldC(String val) {
      t.fieldC = val; 
      return this; 
    }
    
    public Builder fieldDAndE(String d, String e) {
      t.fieldD = d; 
      t.fieldE = e; 
      return this; 
    }
    
    
    public Target build() throws Exception {
      t.isValid(); 
      return t; 
    }
  }
}
