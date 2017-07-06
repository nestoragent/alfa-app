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
public class WSClickPaymentPasswordCheck {

    @ElementList
    private InCommonParms inCommonParms;

    @Path("inParms")
    @Element
    private String ref;
    @Path("inParms")
    @Element
    private String pwd;

    public WSClickPaymentPasswordCheck(@Element(name = "ref") String ref,
                                       @Element(name = "pwd") String pwd) {

        this.ref = ref;
        this.pwd = pwd;
    }

    public void setInCommonParms(InCommonParms inCommonParms) {
        this.inCommonParms = inCommonParms;
    }

}
