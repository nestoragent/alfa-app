package ru.alfa.objects.pipe;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 *
 * @author Dmitry
 */
@Root(name = "Envelope")
@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "S")
public class PipeEnvelopeSuccess {

    @Path("S:Header")
    @Element(name = "WorkContext")
    @Namespace(prefix = "work", reference = "http://oracle.com/weblogic/soap/workarea/")
    private String workContext;

    @Path("S:Body")
    @Element(name = "WSCustomerOperationAuthorizationMethodsGetResponse")
    @NamespaceList({
        @Namespace(reference = "http://WSCommonTypes10.CS.ws.alfabank.ru", prefix = "ns2"),
        @Namespace(reference = "http://WSCustomerOperationAuthorizationMethods10.PS.CS.ws.alfabank.ru", prefix = "ns3")})
    private WSCustomerOperationAuthorizationMethodsGetResponse authorizationMethodsGetResponse;

    public String getWorkContext() {
        return workContext;
    }

    public void setWorkContext(String workContext) {
        this.workContext = workContext;
    }

    public WSCustomerOperationAuthorizationMethodsGetResponse getAuthorizationMethodsGetResponse() {
        return authorizationMethodsGetResponse;
    }

    public void setAuthorizationMethodsGetResponse(WSCustomerOperationAuthorizationMethodsGetResponse authorizationMethodsGetResponse) {
        this.authorizationMethodsGetResponse = authorizationMethodsGetResponse;
    }
}
