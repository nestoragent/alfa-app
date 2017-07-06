package ru.alfa.objects.clientPhone;

import ru.alfa.objects.InCommonParms;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(name = "WSCustomerExtendedInfoCLGet")
@Namespace(prefix = "wsc")
public class WSCustomerExtendedInfoCLGet {

    @ElementList
    private InCommonParms inCommonParms;
    
    @Path("inParms")
    @Element
    private String cus;
    
    public WSCustomerExtendedInfoCLGet(@Element(name = "cus") String cus){
        this.cus = cus;
    }

    public void setInCommonParms(InCommonParms inCommonParms) {
        this.inCommonParms = inCommonParms;
    }
}
