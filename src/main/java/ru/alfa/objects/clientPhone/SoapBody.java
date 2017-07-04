
package ru.alfa.objects.clientPhone;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "Body")
@Namespace(reference = "soapenv")
public class SoapBody {
    
    @Element 
    private WSCustomerExtendedInfoCLGet cLGet;

    public void setcLGet(WSCustomerExtendedInfoCLGet cLGet) {
        this.cLGet = cLGet;
    }
    
}
