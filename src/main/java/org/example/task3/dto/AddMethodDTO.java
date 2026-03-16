package org.example.task3.dto;

import java.util.Objects;

public class AddMethodDTO {

    private int userId;
    private int id;
    private String title;
    private boolean isCompleted;

    public AddMethodDTO() {
    }

    public AddMethodDTO(int userId, int id, String title, boolean isCompleted) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "AddMethodDTO{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }

    public boolean isCompleted() {
        return isCompleted;
    }

}
