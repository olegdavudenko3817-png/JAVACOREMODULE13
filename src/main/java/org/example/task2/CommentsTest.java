package org.example.task2;

import java.io.IOException;

public class CommentsTest {
    static void main(String[] args) throws IOException, InterruptedException {
        Comments comments = new Comments();
        comments.createJsonWithAllCommentsFromLastPostByUserId(1);
    }
}
