/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alfa.requests;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.alfa.objects.resultClientPhone.ResultClientPhone;

/**
 *
 * @author Dmitry
 */
public class RequestRetrofitXML {

    public ResultClientPhone postWSCustomerExtendedInfoCL(String xml) throws IOException, Exception {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vuwsint:9081/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        PostRequestService service = retrofit.create(PostRequestService.class);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/xml; charset=utf-8"), xml);

        Call<ResponseBody> call = service.postClietnPhone(body);
        Response<ResponseBody> responseBody = call.execute();
        String bodyXML = responseBody.body().string();
        if (bodyXML != null) {
            Serializer serializer = new Persister();
            ResultClientPhone resultClientPhone = serializer.read(ResultClientPhone.class, bodyXML);
            return resultClientPhone;
        }
        return null;
    }

}
