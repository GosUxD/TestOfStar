
package com.dan.poly.testofstar.model.pojo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("count_total")
    @Expose
    private int countTotal;
    @SerializedName("pages")
    @Expose
    private int pages;
    @SerializedName("posts")
    @Expose
    private List<Post> posts = new ArrayList<Post>();

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return The countTotal
     */
    public int getCountTotal() {
        return countTotal;
    }

    /**
     * @param countTotal The count_total
     */
    public void setCountTotal(int countTotal) {
        this.countTotal = countTotal;
    }

    /**
     * @return The pages
     */
    public int getPages() {
        return pages;
    }

    /**
     * @param pages The pages
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * @return The posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * @param posts The posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
