
package ru.alfa.requests;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * @author Dmitry
 */
public interface PostRequestService {

    @POST("CS/EQ/WSCustomerExtendedInfoCL/WSCustomerExtendedInfoCL12")
    Call<ResponseBody> postClietnPhone(@Body RequestBody body);
    
    @POST("order")
    Call<ResponseBody> postOrder(@Body RequestBody body);
    
    @POST("/order/validation")
    Call<ResponseBody> postOrderValidation(@Body RequestBody body);

}
