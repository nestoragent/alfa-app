package ru.alfa.requests;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.alfa.objects.clientPhone.ResultSet;

/**
 *
 * @author Dmitry
 */
public class RequestRetrofitXML {

    public static final String PATH_PIPE = "WSCustomerOperationAuthorizationMethods/WSCustomerOperationAuthorizationMethods10/WSCustomerOperationAuthorizationMethods10Service";
    public static final String PATH_SMS = "WSClickPaymentPassword/WSClickPaymentPassword10/WSClickPaymentPassword10Service";

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

    public String postWSCustomerOperationAuthorizationMethods10(String path, String xml) throws IOException, Exception {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vc2pipet7:8001/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        PostRequestService service = retrofit.create(PostRequestService.class);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/xml; charset=utf-8"), xml);

        Call<ResponseBody> call = service.postWSService(path, body);
        Response<ResponseBody> responseBody = call.execute();
        String bodyXML = responseBody.body().string();
        if (bodyXML != null) {
            Serializer serializer = new Persister();
            String actionId = null;
            if (path.equals(PATH_PIPE)) {
                  = serializer.read(ResultSet.class, bodyXML);
            }else{
                
            }
           
            return actionId;
        }
        return null;
    }

}
