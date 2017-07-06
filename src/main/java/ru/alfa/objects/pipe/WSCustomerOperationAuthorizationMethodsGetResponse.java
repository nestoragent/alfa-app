package ru.alfa.objects.pipe;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import ru.alfa.objects.OutCommonParms;

/**
 *
 * @author Dmitry
 */
@Root(name = "ns3:WSCustomerOperationAuthorizationMethodsGetResponse")
@NamespaceList({
    @Namespace(reference = "http://WSCommonTypes10.CS.ws.alfabank.ru", prefix = "ns2")
    ,
    @Namespace(reference = "http://WSClickPaymentPassword10.PS.CS.ws.alfabank.ru", prefix = "ns3")})
public class WSCustomerOperationAuthorizationMethodsGetResponse {

    @Path("response")
    @Element
    private OutCommonParms outCommonParms;

    @Path("response")
    @Element 
    private AuthOutParms authOutParms;

    public OutCommonParms getOutCommonParms() {
        return outCommonParms;
    }

    public void setOutCommonParms(@Element(name = "outCommonParms") OutCommonParms outCommonParms) {
        this.outCommonParms = outCommonParms;
    }

    public AuthOutParms getAuthOutParms() {
        return authOutParms;
    }

    public void setAuthOutParms(@Element (name = "outParms") AuthOutParms authOutParms) {
        this.authOutParms = authOutParms;
    }

    
}
