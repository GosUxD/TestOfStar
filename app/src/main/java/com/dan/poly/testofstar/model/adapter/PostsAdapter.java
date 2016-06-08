package com.dan.poly.testofstar.model.adapter;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dan.poly.testofstar.R;
import com.dan.poly.testofstar.model.pojo.Post;
import com.dan.poly.testofstar.view.fragments.FeedFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 6/8/2016.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostHolder> {
    ArrayList<Post> mPosts;
    FeedFragment.PostClickListener mPostClickListener;

    public PostsAdapter(ArrayList<Post> posts, FeedFragment.PostClickListener postClickListener) {
        mPosts = posts;
        mPostClickListener = postClickListener;
    }

    public void addPosts(ArrayList<Post> posts) {
        for (int i = 0; i < posts.size(); i++) {
            mPosts.add(posts.get(i));
        }
        notifyDataSetChanged();
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_post_layout, parent, false);
        return new PostHolder(itemView, mPostClickListener);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        Post post = mPosts.get(position);
        holder.mPostTitle.setText(post.getTitle());
        Picasso.with(holder.itemView.getContext())
                .load(post.getThumbnail())
                .placeholder(R.drawable.picture)
                .into(holder.mPostImage);
        holder.mPostAuthor.setText(post.getAuthor());
        holder.mPostDate.setText(post.getDate());
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public void sort() {
        // at this moment its simple, no need for making comparators for sorting, if they are sorted
        // in descending order as you stated, just simple reverse will make them ascending by date.
        Collections.reverse(mPosts);
        notifyDataSetChanged();
    }

    class PostHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.post_picture)
        ImageView mPostImage;
        @BindView(R.id.post_title)
        TextView mPostTitle;
        @BindView(R.id.post_author)
        TextView mPostAuthor;
        @BindView(R.id.post_date)
        TextView mPostDate;
        FeedFragment.PostClickListener mPostClickListener;

        public PostHolder(View itemView, FeedFragment.PostClickListener postClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mPostClickListener = postClickListener;
        }

        @Override
        public void onClick(View v) {
            Post post = mPosts.get(getAdapterPosition());
            mPostClickListener.onPostClicked(post);
        }
    }
}
