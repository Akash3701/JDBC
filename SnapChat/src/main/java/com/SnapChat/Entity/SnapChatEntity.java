package com.SnapChat.Entity;

public class SnapChatEntity {
    private String username;
    private String email;
    private int phoneno;
    private String password;

    public SnapChatEntity() {
    }

    public SnapChatEntity(String username, String email, int phoneno, String password) {
        this.username = username;
        this.email = email;
        this.phoneno = phoneno;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
