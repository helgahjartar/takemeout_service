package com.takemeout.user.exceptions;

public class UserNameConflictException extends Exception {
    public UserNameConflictException() {
        super("User name already exists, can't register user");
    }
}
