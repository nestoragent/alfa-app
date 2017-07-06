
package ru.alfa.objects.clientPhone;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import ru.alfa.objects.pipe.WSCustomerOperationAuthorizationMethodsGetResponse;

/**
 *
 * @author Dmitry
 */
@Root(name = "Envelope", strict = false)
@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soapenv")
public class PhoneEnvelopeSuccess {
    
    @Path("S:Body")
    @Element(name = "WSCustomerExtendedInfoCLGetResponse")
    @NamespaceList({
        @Namespace(reference = "http://WSCommonTypes10.CS.ws.alfabank.ru", prefix = "ns2"),
        @Namespace(reference = "http://WSCustomerExtendedInfoCL12.EQ.CS.ws.alfabank.ru", prefix = "ns3")})
    private WSCustomerExtendedInfoCLGetResponse cLGetResponse;

    public WSCustomerExtendedInfoCLGetResponse getcLGetResponse() {
        return cLGetResponse;
    }    
}
