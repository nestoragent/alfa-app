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
@Root(name = "Envelope",strict = false)
@Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "S")
public class CodeEnvelopeSuccess {        

    @Path("S:Body")
    @Element(name = "WSClickPaymentPasswordCheckResponse")
    @NamespaceList({
        @Namespace(reference = "http://WSCommonTypes10.CS.ws.alfabank.ru", prefix = "ns2"),
        @Namespace(reference = "http://WSClickPaymentPassword10.PS.CS.ws.alfabank.ru", prefix = "ns3")})
    private WSClickPaymentPasswordCheckResponse clickPaymentPasswordCheckResponse;

    public WSClickPaymentPasswordCheckResponse getClickPaymentPasswordCheckResponse() {
        return clickPaymentPasswordCheckResponse;
    }
}
