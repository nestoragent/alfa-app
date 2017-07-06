package ru.alfa.requests;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.alfa.objects.OutParms;
import ru.alfa.objects.clientPhone.ResultSet;
import ru.alfa.objects.codeValidation.CodeEnvelopeSuccess;
import ru.alfa.objects.codeValidation.SMSEnvelopeSuccess;
import ru.alfa.objects.pipe.AuthOutParms;
import ru.alfa.objects.pipe.PipeEnvelopeSuccess;

/**
 *
 * @author Dmitry
 */
public class RequestRetrofitXML {

    private static final String PATH_PIPE = "WSCustomerOperationAuthorizationMethods/WSCustomerOperationAuthorizationMethods10/WSCustomerOperationAuthorizationMethods10Service";
    private static final String PATH_SMS = "WSClickPaymentPassword/WSClickPaymentPassword10/WSClickPaymentPassword10Service";

    /*
    * Синхронный метод
    * Получение телефонного номера клиента
    * @param String xml - запрос в формате xml
    * @return ResultSet - выходные параметры ответа сервера
    * @throws Exception - ошибка парсинга/получения ответа от сервера
     */
    public ResultSet postWSCustomerExtendedInfoCL(String xml) throws Exception {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vuwsint:9081/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        PostRequestService service = retrofit.create(PostRequestService.class);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/xml; charset=utf-8"), xml);

        Call<ResponseBody> call = service.postClientPhone(body);
        Response<ResponseBody> responseBody = call.execute();
        String bodyXML = responseBody.body().string();
        if (bodyXML != null) {
            Serializer serializer = new Persister();
            ResultSet resultSet = serializer.read(ResultSet.class, bodyXML);
            return resultSet;
        }
        return null;
    }

    /*
    * Синхронный метод
    * Создание операции PIPE
    * @param String xml - запрос в формате xml
    * @return AuthOutParms - выходные параметры ответа сервера
    * @throws Exception - ошибка парсинга/получения ответа от сервера
     */
    public AuthOutParms postWSCustomerOperationAuthorizationMethods10(String xml) throws IOException, Exception {

        String bodyXML = getResponseWSServer(PATH_PIPE, xml);
        AuthOutParms authOutParms = null;
        if (bodyXML != null) {
            Serializer serializer = new Persister(new AnnotationStrategy());
            PipeEnvelopeSuccess envelopeSuccess = serializer.read(PipeEnvelopeSuccess.class, bodyXML);
            authOutParms = envelopeSuccess.getAuthorizationMethodsGetResponse().getAuthOutParms();
        }
        return authOutParms;
    }

    /*
    * Синхронный метод
    * Получение телефонного номера клиента 
    * @param String xml - запрос в формате xml
    * @param int par - переменная-ключ для обозначения вызывающего метода
    * @return OutParms - выходные параметры ответа сервера
    * @throws Exception - ошибка парсинга/получения ответа от сервера
     */
    public OutParms postWSClickPaymentPassword(String xml, int par) throws IOException, Exception {

        OutParms outParms = null;
        String bodyXML = getResponseWSServer(PATH_SMS, xml);
        if (bodyXML != null) {
            Serializer serializer = new Persister(new AnnotationStrategy());
            if (par == 1) {
                SMSEnvelopeSuccess envelopeSuccess = serializer.read(SMSEnvelopeSuccess.class, bodyXML);
                outParms = envelopeSuccess.getClickPaymentPasswordGetResponse().getOutParms();
            } else if (par == 2) {
                CodeEnvelopeSuccess envelopeSuccess = serializer.read(CodeEnvelopeSuccess.class, bodyXML);
                outParms = envelopeSuccess.getClickPaymentPasswordCheckResponse().getOutParms();
            }
        }
        return outParms;
    }

    private String getResponseWSServer(String path, String xml) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vc2pipet7:8001/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        PostRequestService service = retrofit.create(PostRequestService.class);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/xml; charset=utf-8"), xml);

        Call<ResponseBody> call = service.postWSService(path, body);
        Response<ResponseBody> responseBody = call.execute();
        return responseBody.body().string();
    }
}
