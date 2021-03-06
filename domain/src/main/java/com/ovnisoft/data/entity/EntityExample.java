package com.ovnisoft.data.entity;

public class EntityExample implements BaseEntity {

    private int userId;
    private String title;
    private String body;

    public EntityExample(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public EntityExample(String title, String body) {
        this.userId = EMPTY_ID;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "EntityExample{" + "\n" +
                "userId=" + userId + "\n" +
                ", title='" + title + "\n" +
                ", body='" + body + "\n" +
                '}';
    }
}
