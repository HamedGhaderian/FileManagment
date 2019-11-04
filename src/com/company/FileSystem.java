package com.company;

import java.time.Instant;

public abstract class FileSystem {

    private String name;
    private String createdAt;
    private User createdBy;

    public FileSystem(String name) {
        createdBy = getCurrentUser();
        createdAt = Instant.now().toString();
        this.name = name;
    }

    private User getCurrentUser() {
        return new User(2, "user1");
    }

    public abstract long getSize();

    public abstract boolean rename(String newName) throws Exception;

    public User getWhoCreated() {
        return createdBy;
    }

    public String getDateCreated() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }
}
