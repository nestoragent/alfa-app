
package ru.alfa.requests;

import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.alfa.model.Order;
import ru.alfa.model.OrderValidation;
import ru.alfa.objects.ServerResponse;

/**
 *
 * @author Dmitry
 */
public class RequestRetrofitJson {

    private static Retrofit mRetrofit;
    private static RequestRetrofitJson requestRetrofitJson;

     /*   
      *����������� �� ��������� ���������������� ��������� Retrofit
     */
    private RequestRetrofitJson() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://alfabond2:448/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RequestRetrofitJson getInstance() {
        if (null == mRetrofit)
            requestRetrofitJson = new RequestRetrofitJson();
        return requestRetrofitJson;
    }

     /*
    * ���������� �����
    * ������ ���������� ������ �� �� id
    * @param String assetsId - id ������
    * @return  - ������ ���������� ���� ������ � ��� ������ �������
    * @throws IOException - ������ ��������� ������ �� �������
     */
    public ServerResponse getAssetsIdRequest(String assetsId) throws IOException {

        GetRequestService service = mRetrofit.create(GetRequestService.class);
        Call<ResponseBody> call = service.getAssetsId(assetsId);
        Response<ResponseBody> response = call.execute();
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setCode(response.code());
        serverResponse.setJsonMessage(response.body().string());
        return serverResponse;
    }
    
    
     /*
    * ���������� �����
    * ���������� ��������� ���������
    * @param Order order - ��������� Order
    * @return  - ������ ���������� ���� ������ � ��� ������ �������
    * @throws IOException - ������ ��������� ������ �� �������
     */
    public ServerResponse postOrder(Order order) throws IOException {

        PostRequestService service = mRetrofit.create(PostRequestService.class);
        
        Gson gson = new Gson();       
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                gson.toJson(order));
        
        Call<ResponseBody> call = service.postOrder(body);
        Response<ResponseBody> response = call.execute();
        
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setCode(response.code());
        serverResponse.setJsonMessage(response.body().string());
        
        return serverResponse;
    }
    
    
    /*
    * ���������� �����
    * ���������� ��������� ���������
    * @param orderValidation OrderValidation - ��������� OrderValidation
    * @return  - ������ ���������� ���� ������ � ��� ������ �������
    * @throws IOException - ������ ��������� ������ �� �������
     */
    public ServerResponse postOrderValidation(OrderValidation orderValidation) throws IOException {

        PostRequestService service = mRetrofit.create(PostRequestService.class);
        
        Gson gson = new Gson();       
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                gson.toJson(orderValidation));
        
        Call<ResponseBody> call = service.postOrderValidation(body);
        Response<ResponseBody> response = call.execute();
        
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setCode(response.code());
        serverResponse.setJsonMessage(response.body().string());
        
        return serverResponse;
    }

}
