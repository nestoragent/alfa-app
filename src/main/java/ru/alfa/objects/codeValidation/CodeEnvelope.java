package ru.alfa.objects.codeValidation;

import org.simpleframework.xml.*;

/**
 * @author Dmitry
 */
@Root(name = "soapenv:Envelope")
@NamespaceList({
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soapenv"),
        @Namespace(reference = "http://WSClickPaymentPassword10.PS.CS.ws.alfabank.ru", prefix = "wsc")})
public class CodeEnvelope {


    @Element(name = "Header")
    @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/")
    private String header = "";

    @Path("soapenv:Body")
    @Element(name = "wsc:WSClickPaymentPasswordCheck")
    private WSClickPaymentPasswordCheck clickPaymentPasswordCheck;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setClickPaymentPasswordCheck(WSClickPaymentPasswordCheck clickPaymentPasswordCheck) {
        this.clickPaymentPasswordCheck = clickPaymentPasswordCheck;
    }

}
