package org.example.task3;

import java.io.IOException;

public class AddMethodsTest {
    static void main(String[] args) throws IOException, InterruptedException {
        AddMethods src = new AddMethods();
        src.createJsonWithAllOpenToDosByUserId(8);
    }
}
