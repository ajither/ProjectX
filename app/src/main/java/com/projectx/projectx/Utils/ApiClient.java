package com.projectx.projectx.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ajith on 25/09/17.
 */

public class ApiClient {
    public static final String BASE_URL = "http://api.salesx.io/v1.0/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
