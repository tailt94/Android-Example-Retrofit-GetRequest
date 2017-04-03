package com.android.tuantai.demoretrofit.Data.Remote;

import com.android.tuantai.demoretrofit.Data.Model.SOAnswersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Shine on 03-Apr-17.
 */

public interface SOService {
    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers(@Query("tagged") String tags);
}
