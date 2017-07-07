package ru.alfa.getters;

import ru.alfa.objects.InCommonParms;
import ru.alfa.objects.pipe.AuthOutParms;
import ru.alfa.objects.pipe.PipeEnvelope;
import ru.alfa.objects.pipe.WSCustomerOperationAuthorizationMethodsGet;
import ru.alfa.requests.RequestRetrofitXML;
import ru.alfa.tools.XMLConventer;

/**
 *
 * @author Dmitry
 */
public class GetterPipeOperation {

    private final String clientPIN;
    private final String systemCode;
    private final String type;
    private final String name;
    private final String value;

    /*
    * Констуктор со значениями по умолчанию и тестовым клиентом
    * @param String value - номер телефона без знака +
     */
    public GetterPipeOperation(String value) {
        this.clientPIN = "B81206";
        this.systemCode = "NF";
        this.type = "PC3";
        this.name = "PHCL";
        this.value = value;
    }

    /*
    * Констуктор со значениями по умолчанию 
    * @param String clientPIN - пин клиента
    * @param String value - номер телефона без знака +
     */
    public GetterPipeOperation(String clientPIN, String value) {
        this.clientPIN = clientPIN;
        this.systemCode = "NF";
        this.type = "PC3";
        this.name = "PHCL";
        this.value = value;
    }

    /*
    * Констуктор
    * @param String clientPIN - пин клиента
    * @param String systemCode - системы (D1PF.D1XM). Значение должно быть настраиваемым 
    * @param String value - номер телефона без знака +
     */
    public GetterPipeOperation(String clientPIN, String systemCode, String type,
                               String name, String value) {
        this.clientPIN = clientPIN;
        this.systemCode = systemCode;
        this.type = type;
        this.name = name;
        this.value = value;
    }

    /*
    * Синхронный метод
    * Создание Pipe операции
    * @param clientPIN - пин клиента
    * @return AuthOutParms - выходные параметры ответа сервера
    * @throws Exception - ошибка парсинга/получения ответа от сервера
     */
    public AuthOutParms getRefCode() throws Exception {

        PipeEnvelope envelope = new PipeEnvelope();
        WSCustomerOperationAuthorizationMethodsGet authorizationMethodsGet
                = new WSCustomerOperationAuthorizationMethodsGet(clientPIN, systemCode,
                        type, name, value);
        authorizationMethodsGet.setInCommonParms(new InCommonParms());
        envelope.setAuthorizationMethodsGet(authorizationMethodsGet);

        String xml = new XMLConventer().serializerXML(envelope);
        return new RequestRetrofitXML().postWSCustomerOperationAuthorizationMethods10(xml);
    }

}
