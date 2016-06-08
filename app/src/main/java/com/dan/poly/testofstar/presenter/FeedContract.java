package com.dan.poly.testofstar.presenter;

import com.dan.poly.testofstar.model.pojo.Post;

import java.util.ArrayList;

/**
 * Created by Daniel on 6/8/2016.
 */
public interface FeedContract {

    interface FeedPresenter {
        void loadPosts();

        void loadDetailedPost(Post post);
    }

    interface FeedView {
        void onPostsLoadedSuccess(ArrayList<Post> posts);

        void onPostsLoadedFail(Throwable t);

        void onDetailedPostSuccess(String url);

        void onDetailedPostFailure(String s);

    }
}
