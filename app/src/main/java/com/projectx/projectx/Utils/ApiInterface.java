package com.projectx.projectx.Utils;

import com.projectx.projectx.Model.LoginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by dexter on 25/09/17.
 */

public interface ApiInterface {

    @Headers({"PXL-API-KEY : 5js2ADNOR9sTaW3M68m8P1mQkLalwsut0KcU801T3APUqKSjT83R3VyFen9xXzOg","Content-Type: application/json"})

    @POST("login")
    Call<LoginModel>doLogin(@Body String body);

    @POST("signup")
    Call<LoginModel>doSignUp(@Body String body);
}
