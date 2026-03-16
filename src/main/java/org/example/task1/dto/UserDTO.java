package org.example.task1.dto;

public class UsersDTO {

        public Integer id;
        public String name;
        public String username;
        public String email;

        public class UserDTO {
        }

        public UsersDTO(Integer id, String name, String username, String email) {
         this.id = id;
         this.name = name;
         this.username = username;
         this.email = email;
    }
}
