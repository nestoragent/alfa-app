
package ru.alfa.requests;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *
 * @author Dmitry
 */
public interface GetRequestService {
    
    @GET("assets/{id}")
    Call<ResponseBody> getAssetsId(@Path("id") String assetsId);
    
}
