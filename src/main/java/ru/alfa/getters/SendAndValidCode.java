package ru.alfa.getters;

import ru.alfa.objects.InCommonParms;
import ru.alfa.objects.OutParms;
import ru.alfa.objects.codeValidation.SMSEnvelope;
import ru.alfa.objects.codeValidation.WSClickPaymentPasswordGet;
import ru.alfa.requests.RequestRetrofitXML;
import ru.alfa.tools.XMLConventer;

/**
 *
 * @author Dmitry
 */
public class SendAndValidCode {

    private final String ref;
    private String methodCode;
    private int pwd;

    /*
    * Констуктор, используется для отправки SMS, значения по умолчанию
    * @param String ref - Передается значение ref, полученное в результате вызова 
    * сервиса WSCustomerOperationAuthorizationMethods10
     */
    public SendAndValidCode(String ref) {
        this.ref = ref;
        this.methodCode = "SMSPWD";
    }


    /*
    * Констуктор, используется для отправки SMS
    * @param String ref - Передается значение ref, полученное в результате вызова 
    * сервиса WSCustomerOperationAuthorizationMethods10
    *
    * @param String methodCode - Заполняется значением «SMSPWD». Значение должно быть настраиваемым
     */
    public SendAndValidCode(String ref, String methodCode) {
        this.ref = ref;
        this.methodCode = methodCode;
    }

    /*
    * Констуктор, используется для валидации кода
    * @param String ref - Передается значение ref, полученное в результате вызова 
    * сервиса WSCustomerOperationAuthorizationMethods10
    *
    * @param String pwd - Заполняется значением одноразового кода подтверждения, введенного держателем на форме.
     */
    public SendAndValidCode(String ref, int pwd) {
        this.ref = ref;
        this.pwd = pwd;
    }

    /*
    * Синхронный метод
    * Отправка СМС  
    * @return OutParms - выходные параметры ответа сервера.
    * @throws Exception - ошибка парсинга/получения ответа от сервера
     */
    public OutParms sendSMS() throws Exception {
        return requestServer(1);
    }

    /*
    * Синхронный метод
    * Валидация кода  
    * @return OutParmsg  - выходные параметры ответа сервера.
    * @throws Exception - ошибка парсинга/получения ответа от сервера
     */
    public OutParms codeValidation() throws Exception {
        return requestServer(2);
    }

    /*
    * Синхронный метод
    * вызов метода отправки запроса
    * @param int par - переменная-ключ для обозначения вызывающего метода
    * @return OutParms - выходные параметры ответа сервера
    * @throws Exception - ошибка парсинга/получения ответа от сервера
     */
    private OutParms requestServer(int par) throws Exception {
        SMSEnvelope envelope = new SMSEnvelope();
        WSClickPaymentPasswordGet passwordGet = new WSClickPaymentPasswordGet(ref, methodCode);
        passwordGet.setInCommonParms(new InCommonParms());
        passwordGet.setInCommonParms(new InCommonParms());
        envelope.setClickPaymentPasswordGet(passwordGet);

        String xml = new XMLConventer().serializerXML(envelope);
        return new RequestRetrofitXML().postWSClickPaymentPassword(xml, par);
    }

}
