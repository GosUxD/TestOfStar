package com.dan.poly.testofstar.model.api;

import com.dan.poly.testofstar.model.pojo.Post;
import com.dan.poly.testofstar.model.pojo.Response;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Daniel on 6/8/2016.
 */
public interface PostsApi {

    @GET("get_recent_summary")
    Call<Response> getPosts();
}
