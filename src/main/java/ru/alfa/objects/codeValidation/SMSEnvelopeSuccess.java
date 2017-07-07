package ru.alfa.objects.codeValidation;

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
public class SMSEnvelopeSuccess {

    @Path("S:Header")
    @Element(name = "WorkContext")
    @Namespace(prefix = "work", reference = "http://oracle.com/weblogic/soap/workarea/")
    private String workContext;

    @Path("S:Body")
    @Element(name = "WSClickPaymentPasswordGetResponse")
    @NamespaceList({
        @Namespace(reference = "http://WSCommonTypes10.CS.ws.alfabank.ru", prefix = "ns2"),
        @Namespace(reference = "http://WSClickPaymentPassword10.PS.CS.ws.alfabank.ru", prefix = "ns3")})
    private WSClickPaymentPasswordGetResponse clickPaymentPasswordGetResponse;

    public String getWorkContext() {
        return workContext;
    }

    public WSClickPaymentPasswordGetResponse getClickPaymentPasswordGetResponse() {
        return clickPaymentPasswordGetResponse;
    }
}
