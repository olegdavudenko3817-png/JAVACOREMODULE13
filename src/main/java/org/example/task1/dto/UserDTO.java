package org.example.task1.dto;

public class UserDTO {
    private int id;
    private String name;
    private String username;
    private String email;
    private Object address;
    private String phone;
    private String website;
    private Object company;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String username, String email,
                   Object address, String phone, String website, Object company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}