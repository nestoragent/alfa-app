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
@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
public class PipeEnvelope {

    @Element(name = "Header")
    @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/")
    private String header = "";

    @Path("soap:Body")
    @Element(name = "ns3:WSCustomerOperationAuthorizationMethodsGet")
    @NamespaceList({
        @Namespace(reference = "http://WSCommonTypes10.CS.ws.alfabank.ru", prefix = "ns2"),
    @Namespace(reference = "http://WSCustomerOperationAuthorizationMethods10.PS.CS.ws.alfabank.ru", prefix = "ns3")
    })
    private WSCustomerOperationAuthorizationMethodsGet authorizationMethodsGet;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setAuthorizationMethodsGet(WSCustomerOperationAuthorizationMethodsGet authorizationMethodsGet) {
        this.authorizationMethodsGet = authorizationMethodsGet;
    }
}
