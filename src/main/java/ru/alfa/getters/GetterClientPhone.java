package ru.alfa.getters;

import java.io.StringWriter;
import java.io.Writer;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.alfa.objects.ResultClientPhone;
import ru.alfa.objects.clientPhone.ClientPhone;
import ru.alfa.objects.clientPhone.InCommonParms;
import ru.alfa.objects.clientPhone.InParams;
import ru.alfa.objects.clientPhone.SoapBody;
import ru.alfa.objects.clientPhone.WSCustomerExtendedInfoCLGet;
import ru.alfa.requests.RequestRetrofit;

public class GetterClientPhone {

    private final String clientPIN;

    /*   
    *Конструктор принимающий в качестве входных параметров ПИН клиента
    *String clientPIN - пин клиента
     */
    public GetterClientPhone(String clientPIN) {
        this.clientPIN = clientPIN;
    }

    /*
    * Синхронный метод
    * Конструктор принимающий в качестве входных параметров ПИН клиента
    * @param clientPIN - пин клиента
    * @return  - номер телефона
    * @throws - ошибка парсинга/получения ответа от сервера
     */
    public String getPhone() throws Exception {

        Writer writer = new StringWriter();
        Serializer serializer = new Persister();

        try {
            ClientPhone clientPhone = new ClientPhone();
            SoapBody soapBody = new SoapBody();
            WSCustomerExtendedInfoCLGet cLGet = new WSCustomerExtendedInfoCLGet();
            cLGet.setInCommonParms(new InCommonParms("WSEF", 0000, "NFR", "Хорошева"));
            cLGet.setInParams(new InParams(clientPIN));
            soapBody.setcLGet(cLGet);
            clientPhone.setBody(soapBody);

            serializer.write(clientPhone, writer);
            String xml = writer.toString();

            RequestRetrofit requestRetrofit = new RequestRetrofit();
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
