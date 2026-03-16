package org.example.task1;

import org.example.task1.dto.UserDTO;

import java.io.IOException;

public class UsersTest {
    static void main(String[] args) throws IOException, InterruptedException {
        Users api = new Users();

        String newUserFile = "src/main/resources/new_user.json";
        String updatedUserFile = "src/main/resources/updated_user.json";
        String allUsersFile = "src/main/resources/all_users.json";
        String userByIdFile = "src/main/resources/user_by_id.json";
        String userByUsernameFile = "src/main/resources/user_by_username.json";
        String createdUserFile = "src/main/resources/created_user.json";
        String updatedResultFile = "src/main/resources/updated_result.json";

        // 1. створення нового об'єкта:
        String createdUserJson = api.createUser(newUserFile);
        System.out.println("Created user:");
        System.out.println(createdUserJson);
        UserDTO createdUser = api.parseUser(createdUserJson);
        api.saveToFile(createdUser, createdUserFile);

        // 2. оновлення об'єкту:
        String updatedUserJson = api.updateUserById(5, updatedUserFile);
        System.out.println("\nUpdated user:");
        System.out.println(updatedUserJson);
        UserDTO updatedUser = api.parseUser(updatedUserJson);
        api.saveToFile(updatedUser, updatedResultFile);

        // 3. видалення об'єкта:
        int deleteStatus = api.deleteUserById(7);
        System.out.println("\nDelete status: " + deleteStatus);

        // 4. отримання інформації про всіх користувачів:
        String allUsersJson = api.getAllUsers();
        System.out.println("\nAll users:");
        System.out.println(allUsersJson);
        UserDTO[] allUsers = api.parseUsers(allUsersJson);
        api.saveToFile(allUsers, allUsersFile);

        // 5. отримання інформації про користувача за id:
        String userByIdJson = api.getUserById(2);
        System.out.println("\nUser by id:");
        System.out.println(userByIdJson);
        UserDTO userById = api.parseUser(userByIdJson);
        api.saveToFile(userById, userByIdFile);

        // 6. отримання інформації про користувача за username:
        String userByUsernameJson = api.getUserByUsername("Karianne");
        System.out.println("\nUser by username:");
        System.out.println(userByUsernameJson);
        UserDTO[] userByUsername = api.parseUsers(userByUsernameJson);
        api.saveToFile(userByUsername, userByUsernameFile);

    }
}
