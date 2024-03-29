package com.company;

import java.time.Instant;

public abstract class FileSystem {

    private String name;
    private String createdAt;
    private User createdBy;

    public FileSystem(String name) throws Exception {
        createdBy = getCurrentUser();
        createdAt = Instant.now().toString();
        if (CommonUtils.isValidName(name))
            this.name = name;
        else
            throw new Exception("name is not valid");
    }

    private User getCurrentUser() {
        return new User(2, "user1");
    }

    public abstract long getSize();

    public boolean rename(String newName) throws Exception {
        setName(newName);
        return true;
    }

    public User getWhoCreated() {
        return createdBy;
    }

    public String getDateCreated() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
