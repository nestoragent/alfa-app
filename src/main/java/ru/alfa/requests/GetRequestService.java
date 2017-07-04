/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
