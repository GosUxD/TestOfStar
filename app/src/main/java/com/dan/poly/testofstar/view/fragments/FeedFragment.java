package com.dan.poly.testofstar.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dan.poly.testofstar.R;
import com.dan.poly.testofstar.model.adapter.PostsAdapter;
import com.dan.poly.testofstar.model.pojo.Post;
import com.dan.poly.testofstar.presenter.FeedContract;
import com.dan.poly.testofstar.presenter.FeedPresenter;
import com.dan.poly.testofstar.view.activities.DetailedActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Daniel on 6/8/2016.
 */
public class FeedFragment extends Fragment implements FeedContract.FeedView {

    private static final String TAG = "FeedFragment";
    @BindView(R.id.fragment_feed_recycler_view)
    RecyclerView mRecyclerView;
    private FeedPresenter mFeedPresenter;
    private ArrayList<Post> posts;
    private PostsAdapter mPostsAdapter;
    boolean isDescending = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_feed, container, false);
        ButterKnife.bind(this, root);

        posts = new ArrayList<>();
        mPostsAdapter = new PostsAdapter(posts, mClickListener);
        mRecyclerView.setAdapter(mPostsAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mFeedPresenter.loadPosts();
        return root;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFeedPresenter = new FeedPresenter(this);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    @OnClick(R.id.fab_sort)
    public void Sort(View view) {
        if (isDescending) {
            isDescending = false;
            Toast.makeText(getActivity(), "Ascending order", Toast.LENGTH_SHORT).show();
            mPostsAdapter.sort();
        } else {
            isDescending = true;
            Toast.makeText(getActivity(), "Descending order", Toast.LENGTH_SHORT).show();
            mPostsAdapter.sort();
        }
    }

    @Override
    public void onPostsLoadedSuccess(ArrayList<Post> posts) {
        mPostsAdapter.addPosts(posts);
    }

    @Override
    public void onPostsLoadedFail(Throwable t) {
        Toast.makeText(getActivity(), "Oops theres been an error.", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onPostsLoadedFail: ", t);
    }

    @Override
    public void onDetailedPostSuccess(String url) {
        Intent intent = new Intent(getActivity(), DetailedActivity.class);
        intent.putExtra(DetailedActivity.EXTRA_URL, url);
        startActivity(intent);
    }

    @Override
    public void onDetailedPostFailure(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }

    public PostClickListener mClickListener = new PostClickListener() {
        @Override
        public void onPostClicked(Post post) {
            mFeedPresenter.loadDetailedPost(post);
        }
    };

    public interface PostClickListener {
        void onPostClicked(Post post);
    }
}