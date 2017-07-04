package ru.alfa.getters;

import java.io.StringWriter;
import java.io.Writer;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.alfa.objects.resultClientPhone.ResultClientPhone;
import ru.alfa.objects.clientPhone.ClientPhone;
import ru.alfa.objects.clientPhone.InCommonParms;
import ru.alfa.objects.clientPhone.InParams;
import ru.alfa.objects.clientPhone.SoapBody;
import ru.alfa.objects.clientPhone.WSCustomerExtendedInfoCLGet;
import ru.alfa.requests.RequestRetrofitXML;

public class GetterClientPhone {

    private final String clientPIN;

    /*
     */
    public GetterClientPhone(String clientPIN) {
        this.clientPIN = clientPIN;
    }

    /*
     */
    public String getPhone() throws Exception {

        Writer writer = new StringWriter();
        Serializer serializer = new Persister();

        try {
            ClientPhone clientPhone = new ClientPhone();
            SoapBody soapBody = new SoapBody();
            WSCustomerExtendedInfoCLGet cLGet = new WSCustomerExtendedInfoCLGet();
            cLGet.setInCommonParms(new InCommonParms("WSEF", 0000, "NFR", "asdad"));
            cLGet.setInParams(new InParams(clientPIN));
            soapBody.setcLGet(cLGet);
            clientPhone.setBody(soapBody);

            serializer.write(clientPhone, writer);
            String xml = writer.toString();

            RequestRetrofitXML requestRetrofit = new RequestRetrofitXML();
            ResultClientPhone resultClientPhone = requestRetrofit.postWSCustomerExtendedInfoCL(xml);
            if (resultClientPhone != null) {
                return resultClientPhone.getClientList().getAdt();
            }
        } catch (Exception e) {
            System.err.println("Error serialization " + e.getMessage());
        }
        return null;
    }

}
