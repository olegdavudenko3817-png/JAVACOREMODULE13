package org.example.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.task2.dto.PostDTO;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Comments {

    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void createJsonWithAllCommentsFromLastPostByUserId(int userId) throws IOException, InterruptedException {
        String allPostsJson = getPostsByUserId(userId);
        PostDTO[] posts = gson.fromJson(allPostsJson, PostDTO[].class);

        int lastPostId = getLastPostId(posts);

        String allCommentsJson = getAllCommentsByPostId(lastPostId);
        String jsonFilePath = "src/main/resources/user-" + userId + "-post-" + lastPostId + "-comments.json";

        createJsonWithComments(allCommentsJson, jsonFilePath);
        System.out.println("JSON filepath: " + jsonFilePath);
    }

    private String getPostsByUserId(int userId) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + userId + "/posts";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private PostDTO[] createPostsFromJson(String json) {
        return gson.fromJson(json, PostDTO[].class);
    }

    private int getLastPostId(PostDTO[] posts) {
        int maxId = posts[0].getId();

        for (PostDTO post : posts) {
            if (post.getId() > maxId) {
                maxId = post.getId();
            }
        }
        return maxId;
    }

    private String getAllCommentsByPostId(int postId) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/posts/" + postId + "/comments";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private void createJsonWithComments(String json, String jsonFilePath) {
        PostDTO[] comments = createCommentsFromJson(json);
        String outputString = gson.toJson(comments);

        try (FileWriter output = new FileWriter(jsonFilePath)) {
            output.write(outputString);
        } catch (IOException e) {
            throw new RuntimeException("Error writing file: " + jsonFilePath, e);
        }
    }

    private PostDTO[] createCommentsFromJson(String json) {
        return gson.fromJson(json, PostDTO[].class);
    }
}

