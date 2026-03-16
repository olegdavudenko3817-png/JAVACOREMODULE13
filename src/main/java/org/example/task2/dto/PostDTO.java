package org.example.task2.dto;

public class CommentDTO {

        String postId;
        int id;
        String name;
        String email;
        String body;

        public CommentDTO(String postId, int id, String name, String email, String body) {
            this.postId = postId;
            this.id = id;
            this.name = name;
            this.email = email;
            this.body = body;
        }

        @Override
        public String toString() {
            return "CommentDTO-{" +
                    "postId='" + postId + '\'' +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", body='" + body + '\'' +
                    '}';
        }
    }

