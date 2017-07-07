package ru.alfa.objects.codeValidation;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import ru.alfa.objects.InCommonParms;

/**
 *
 * @author Dmitry
 */
public class WSClickPaymentPasswordCheck {

    @Element
    private InCommonParms inCommonParms;

    @Path("inParms")
    @Element
    private String ref;
    @Path("inParms")
    @Element
    private int pwd;

    public WSClickPaymentPasswordCheck(@Element(name = "ref") String ref,
                                       @Element(name = "pwd") int pwd) {

        this.ref = ref;
        this.pwd = pwd;
    }

    public void setInCommonParms(InCommonParms inCommonParms) {
        this.inCommonParms = inCommonParms;
    }

}
