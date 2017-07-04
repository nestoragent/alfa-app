/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alfa.objects.clientPhone;

import ru.alfa.objects.clientPhone.SoapBody;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
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
public class ClientPhone {

    @Element(name = "Header")
    @Namespace(reference = "soapenv")
    private String mHeader;

    @Element
    private SoapBody body;

    public void setmHeader(String mHeader) {
        this.mHeader = mHeader;
    }

    public void setBody(SoapBody body) {
        this.body = body;
    }
}
