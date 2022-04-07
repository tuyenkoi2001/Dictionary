package com.example.mydictionary;

import android.app.Activity;
import android.widget.Toast;

import com.example.mydictionary.Models.APIrespond;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RequestManager {
    Activity context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Activity context) {
        this.context = context;
    }

    public void GetWordMeaning(OnFetchDataListener listener,  String word){
        CallDictionary callDictionary = retrofit.create(CallDictionary.class);
        Call<List<APIrespond>> call = callDictionary.callMeanings(word);

        try{
            call.enqueue(new Callback<List<APIrespond>>() {
                @Override
                public void onResponse(Call<List<APIrespond>> call, Response<List<APIrespond>> response) {
                    if(!response.isSuccessful()){
                        listener.onError("Word not found");
                    }
                    else listener.onFetchData(response.body().get(0), response.message());
                }

                @Override
                public void onFailure(Call<List<APIrespond>> call, Throwable t) {
                    listener.onError("Word not found");
                }
            });
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(context, "Lỗi rồi", Toast.LENGTH_SHORT).show();
        }
    }

    public interface CallDictionary{
        @GET("entries/en/{word}")
        Call<List<APIrespond>> callMeanings(
                @Path("word") String word
        );
    }
}
