package ru.alfa.objects.codeValidation;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import ru.alfa.objects.InCommonParms;

/**
 *
 * @author Dmitry
 */
@Root(name = "wsc:WSCustomerOperationAuthorizationMethodsGet")
public class WSClickPaymentPasswordGet {

    @ElementList
    private InCommonParms inCommonParms;

    @Path("inParms")
    @Element
    private String ref;
    @Path("inParms")
    @Element
    private String methodCode;

    public WSClickPaymentPasswordGet(@Element(name = "cus") String ref,
                                     @Element(name = "xm") String methodCode) {
        this.ref = ref;
        this.methodCode = methodCode;
    }

    public void setInCommonParms(InCommonParms inCommonParms) {
        this.inCommonParms = inCommonParms;
    }

}
