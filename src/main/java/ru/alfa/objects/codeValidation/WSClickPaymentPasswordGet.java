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
public class WSClickPaymentPasswordGet {

    @Element
    private InCommonParms inCommonParms;

    @Path("inParms")
    @Element
    private String ref;
    @Path("inParms")
    @Element
    private String methodCode;

    public WSClickPaymentPasswordGet(@Element(name = "ref") String ref,
                                     @Element(name = "methodCode") String methodCode) {
        this.ref = ref;
        this.methodCode = methodCode;
    }

    public void setInCommonParms(InCommonParms inCommonParms) {
        this.inCommonParms = inCommonParms;
    }

}
