package com.android.tuantai.demoretrofit.Data.Remote;

/**
 * Created by Shine on 03-Apr-17.
 */

public class ApiUtil {
    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
