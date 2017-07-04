/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public interface PostRequest {

    @POST("CS/EQ/WSCustomerExtendedInfoCL/WSCustomerExtendedInfoCL12")
    Call<ResponseBody> postClietnPhone(@Body RequestBody body);

}
