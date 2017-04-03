package com.android.tuantai.demoretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.tuantai.demoretrofit.Adapter.AnswerAdapter;
import com.android.tuantai.demoretrofit.Data.Model.Item;
import com.android.tuantai.demoretrofit.Data.Model.SOAnswersResponse;
import com.android.tuantai.demoretrofit.Data.Remote.ApiUtil;
import com.android.tuantai.demoretrofit.Data.Remote.SOService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AnswerAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SOService mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = ApiUtil.getSOService();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_answers);
        mAdapter = new AnswerAdapter(this, new ArrayList<Item>(0), new AnswerAdapter.PostItemListener() {
            @Override
            public void onPostClick(long id) {
                Toast.makeText(MainActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        loadAnswers();
    }

    public void loadAnswers() {
        mService.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {
                if(response.isSuccessful()) {
                    mAdapter.updateAnswers(response.body().getItems());
                    Log.d("MainActivity", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
    }
}
