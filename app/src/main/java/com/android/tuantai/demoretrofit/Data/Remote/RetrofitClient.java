package com.android.tuantai.demoretrofit.Data.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shine on 03-Apr-17.
 */

class RetrofitClient {
    private static Retrofit retrofit = null;

    static Retrofit getClient(String baseUrl) {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
        return retrofit;
    }

    private RetrofitClient() {
    }
}
