package ru.alfa.objects.pipe;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import ru.alfa.objects.InCommonParms;

/**
 *
 * @author Dmitry
 */
public class WSCustomerOperationAuthorizationMethodsGet {

    @Element
    private InCommonParms inCommonParms;

    @Path("inParms")
    @Element
    private final String cus;
    @Path("inParms")
    @Element
    private final String xm;
    @Path("inParms")
    @Element
    private final String typ;

    @Path("inParms/additionalInfo/additionalInfoRow[1]")
    @Element
    private final String name;
    @Path("inParms/additionalInfo/additionalInfoRow[1]")
    @Element
    private final String value;

    public WSCustomerOperationAuthorizationMethodsGet(@Element(name = "cus") String cus,
                                                      @Element(name = "xm") String xm,
                                                      @Element(name = "typ") String typ,
                                                      @Element(name = "name") String name,
                                                      @Element(name = "value") String value) {

        this.cus = cus;
        this.xm = xm;
        this.typ = typ;
        this.name = name;
        this.value = "+" + value;
    }

    public void setInCommonParms(InCommonParms inCommonParms) {
        this.inCommonParms = inCommonParms;
    }

}
