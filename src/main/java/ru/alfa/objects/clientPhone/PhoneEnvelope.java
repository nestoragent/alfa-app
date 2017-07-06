
package ru.alfa.objects.clientPhone;


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
    @Namespace(reference = "http://WSCustomerExtendedInfoCL12.EQ.CS.ws.alfabank.ru", prefix = "wsc")
})
public class PhoneEnvelope {

    @Element(name = "Header")
    @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/")
    private String mHeader;

    @Path("soapenv:Body")
    @Element
    private WSCustomerExtendedInfoCLGet cLGet;
    

    public void setmHeader(String mHeader) {
        this.mHeader = mHeader;
    }

    public void setcLGet(WSCustomerExtendedInfoCLGet cLGet) {
        this.cLGet = cLGet;
    }
    
    

}
