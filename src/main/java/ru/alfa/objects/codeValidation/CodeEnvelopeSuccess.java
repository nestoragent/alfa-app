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
public class CodeEnvelopeSuccess {

    @Path("S:Header")
    @Element(name = "WorkContext")
    @Namespace(prefix = "work", reference = "http://oracle.com/weblogic/soap/workarea/")
    private String workContext;

    @Path("S:Body")
    @Element
    private WSClickPaymentPasswordCheckResponse clickPaymentPasswordCheckResponse;

    public String getWorkContext() {
        return workContext;
    }

    public void setWorkContext(String workContext) {
        this.workContext = workContext;
    }

    public WSClickPaymentPasswordCheckResponse getClickPaymentPasswordCheckResponse() {
        return clickPaymentPasswordCheckResponse;
    }

    public void setClickPaymentPasswordCheckResponse(WSClickPaymentPasswordCheckResponse clickPaymentPasswordCheckResponse) {
        this.clickPaymentPasswordCheckResponse = clickPaymentPasswordCheckResponse;
    }
}
