package ru.alfa.objects.clientPhone;

import ru.alfa.objects.InCommonParms;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;


public class WSCustomerExtendedInfoCLGet {

    @Element
    private InCommonParms inCommonParms;
    
    @Path("inParms")
    @Element
    private final String cus;
    
    public WSCustomerExtendedInfoCLGet(@Element(name = "cus") String cus){
        this.cus = cus;
    }

    public void setInCommonParms(InCommonParms inCommonParms) {
        this.inCommonParms = inCommonParms;
    }
}
