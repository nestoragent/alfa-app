
package ru.alfa.objects.pipe;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import ru.alfa.objects.InCommonParms;

/**
 *
 * @author Dmitry
 */
@Root(name = "ns3:WSCustomerOperationAuthorizationMethodsGet")
@NamespaceList({
    @Namespace(reference = "http://WSCommonTypes10.CS.ws.alfabank.ru", prefix = "ns2")
    ,
    @Namespace(reference = "http://WSCustomerOperationAuthorizationMethods10.PS.CS.ws.alfabank.ru", prefix = "ns3")
})
public class WSCustomerOperationAuthorizationMethodsGet {

    @ElementList
    private InCommonParms inCommonParms;

    @Path("inParms")
    @Element
    private String cus;
    @Path("inParms")
    @Element
    private String xm;
    @Path("inParms")
    @Element
    private String typ;

    @Path("inParms/additionalInfo/additionalInfoRow[1]")
    private String name;
    @Path("inParms/additionalInfo/additionalInfoRow[1]")
    private String value;

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
