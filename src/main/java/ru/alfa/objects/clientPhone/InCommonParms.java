
package ru.alfa.objects.clientPhone;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "inCommonParms")
public class InCommonParms {
    
    @Element
    private String userID;   
    @Element
    private int branchNumber;    
    @Element
    private String externalSystemCode;    
    @Element
    private String externalUserCode;

   public InCommonParms(String userID, int branchNumber, String externalSystemCode, String externalUserCode) {
      this.userID = userID;  
      this.branchNumber = branchNumber;
      this.externalSystemCode = externalSystemCode;
      this.externalUserCode = externalUserCode;      
   }   
    
}
