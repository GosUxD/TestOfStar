package com.dan.poly.testofstar.model.api;

import com.dan.poly.testofstar.model.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Daniel on 6/8/2016.
 */
public class RestApiManager {

    PostsApi mPostsApi;

    public PostsApi getPostsApi() {
        if (mPostsApi == null) {
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mPostsApi = client.create(PostsApi.class);
        }
        return mPostsApi;
    }

}
