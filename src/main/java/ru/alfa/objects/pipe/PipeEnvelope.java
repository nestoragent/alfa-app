
package ru.alfa.objects.pipe;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 *
 * @author Dmitry
 */
@Root(name = "soap:Envelope")
@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
public class PipeEnvelope {
   
    @Element(name = "Header")
    @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/")
    private String header;
    
    @Path("soap:Body")
    @Element
    private WSCustomerOperationAuthorizationMethodsGet authorizationMethodsGet;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setAuthorizationMethodsGet(WSCustomerOperationAuthorizationMethodsGet authorizationMethodsGet) {
        this.authorizationMethodsGet = authorizationMethodsGet;
    }
}
