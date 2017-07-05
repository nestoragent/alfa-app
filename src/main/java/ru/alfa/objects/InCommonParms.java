
package ru.alfa.objects;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "inCommonParms")
public class InCommonParms {
    
    @Element
    private final String userID;   
    @Element
    private final int branchNumber;    
    @Element
    private final String externalSystemCode;    
    @Element
    private final String externalUserCode;
    
    public InCommonParms() {
      this.userID = "IBSR";  
      this.branchNumber = 0000;
      this.externalSystemCode = "RECOB01";
      this.externalUserCode = "AMWVBONDS";      
   }   

   public InCommonParms(String userID, int branchNumber, String externalSystemCode, String externalUserCode) {
      this.userID = userID;  
      this.branchNumber = branchNumber;
      this.externalSystemCode = externalSystemCode;
      this.externalUserCode = externalUserCode;      
   }   
    
}
