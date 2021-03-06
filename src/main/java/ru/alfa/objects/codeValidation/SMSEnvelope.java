package ru.alfa.objects.codeValidation;

import ru.alfa.objects.pipe.*;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 *
 * @author Dmitry
 */
@Root(name = "soapenv:Envelope")
@NamespaceList({
    @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soapenv"),
    @Namespace(reference = "http://WSClickPaymentPassword10.PS.CS.ws.alfabank.ru", prefix ="wsc")})
public class SMSEnvelope {

    @Element(name = "Header")
    @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/")
    private String header="";

    @Path("soapenv:Body")
    @Element(name = "wsc:WSClickPaymentPasswordGet")
    private WSClickPaymentPasswordGet clickPaymentPasswordGet;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setClickPaymentPasswordGet(WSClickPaymentPasswordGet clickPaymentPasswordGet) {
        this.clickPaymentPasswordGet = clickPaymentPasswordGet;
    }
}
