package ru.alfa.objects.clientPhone;

import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "WSCustomerExtendedInfoCLGet")
@Namespace(prefix = "wsc")
public class WSCustomerExtendedInfoCLGet {

    @ElementList
    private InCommonParms inCommonParms;
    @Element
    private InParams inParams;

    public void setInCommonParms(InCommonParms inCommonParms) {
        this.inCommonParms = inCommonParms;
    }

    public void setInParams(InParams inParams) {
        this.inParams = inParams;
    }

}
