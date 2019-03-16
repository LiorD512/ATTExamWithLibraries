package com.att.attexamwithlibraries;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit mRetrofit;


//Define the base URL//

    private static final String BASE_URL = "https://randomuser.me/";



//Create the Retrofit instance//

    public static Retrofit getRetrofitInstance() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)

//Add the converter//

                    .addConverterFactory(GsonConverterFactory.create())

//Build the Retrofit instance//

                    .build();
        }
        return mRetrofit;
    }




}
