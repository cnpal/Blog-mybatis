package com.pal.blog.queryvo;

/**
 * @Author pal
 * @Date Created in 2020/7/13 12:29
 * @Version: 1.0
 */
public class SearchBlog {

    private String title;
    private Long typeId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "SearchBlog{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}