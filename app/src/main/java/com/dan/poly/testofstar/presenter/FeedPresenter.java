package com.dan.poly.testofstar.presenter;

import com.dan.poly.testofstar.model.api.RestApiManager;
import com.dan.poly.testofstar.model.pojo.Post;
import com.dan.poly.testofstar.model.pojo.Response;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Daniel on 6/8/2016.
 */
public class FeedPresenter implements FeedContract.FeedPresenter {

    FeedContract.FeedView mFeedView;
    RestApiManager mRestApiManager;

    public FeedPresenter(FeedContract.FeedView feedView) {
        mFeedView = feedView;
        mRestApiManager = new RestApiManager();
    }

    @Override
    public void loadPosts() {
        mRestApiManager.getPostsApi().getPosts().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                mFeedView.onPostsLoadedSuccess((ArrayList<Post>) response.body().getPosts());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                mFeedView.onPostsLoadedFail(t);
            }
        });
    }

    @Override
    public void loadDetailedPost(Post post) {
        if(post.getUrl()!= null) {
            mFeedView.onDetailedPostSuccess(post.getUrl());
        } else {
            mFeedView.onDetailedPostFailure("Url cannot be null..");
        }
    }
}
