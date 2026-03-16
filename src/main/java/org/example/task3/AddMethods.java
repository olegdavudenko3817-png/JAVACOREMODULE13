package org.example.task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.task3.dto.AddMethodDTO;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


public class AddMethods {

    private final HttpClient client = HttpClient.newHttpClient();

    public void createJsonWithAllOpenToDosByUserId(int userId) throws IOException, InterruptedException {
        String allTodosJson = getAllTodosByUserId(userId);
        List<AddMethodDTO> allTodos = getOpenTodosFromJson(allTodosJson);
        String jsonFilePath = "src/main/resources/" + "user-" + userId + "-open_todos.json";
        createJsonWithTodos(allTodos, jsonFilePath);
        System.out.println("JSON filepath: " + jsonFilePath);
    }

    private String getAllTodosByUserId(int userId) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + userId + "/todos";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private List<AddMethodDTO> getOpenTodosFromJson(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        AddMethodDTO[] todosArray = gson.fromJson(json, AddMethodDTO[].class);

        List<AddMethodDTO> openTodosList = new ArrayList<>();

        for (AddMethodDTO element : todosArray) {
            if (!element.isCompleted()) {
                openTodosList.add(element);
            }
        }

        return openTodosList;
    }

    private void createJsonWithTodos(List<AddMethodDTO> todos, String jsonFilePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String outputString = gson.toJson(todos);

        try (FileWriter output = new FileWriter(jsonFilePath)) {
            output.write(outputString);
        } catch (IOException e) {
            throw new RuntimeException("Error writing file: " + jsonFilePath, e);
        }
    }
}
