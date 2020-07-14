package com.pal.blog.queryvo;

/**
 * @Author pal
 * @Date Created in 2020/7/13 16:20
 * @Version: 1.0
 */
public class RecommendBlog {
    private Long id;
    private String title;
    private String firstPicture;
    private boolean recommend;

    public RecommendBlog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "RecommendBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}
