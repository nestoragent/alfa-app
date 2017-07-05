package ru.alfa.objects.codeValidation;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
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
    @Element
    private WSClickPaymentPasswordGetResponse clickPaymentPasswordGetResponse;

    public String getWorkContext() {
        return workContext;
    }

    public void setWorkContext(String workContext) {
        this.workContext = workContext;
    }

    public WSClickPaymentPasswordGetResponse getClickPaymentPasswordGetResponse() {
        return clickPaymentPasswordGetResponse;
    }

    public void setClickPaymentPasswordGetResponse(WSClickPaymentPasswordGetResponse clickPaymentPasswordGetResponse) {
        this.clickPaymentPasswordGetResponse = clickPaymentPasswordGetResponse;
    }
    
    

}
