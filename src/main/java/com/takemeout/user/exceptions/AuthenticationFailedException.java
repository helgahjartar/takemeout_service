package com.takemeout.user.exceptions;

public class AuthenticationFailedException extends Exception {
    private static final long serialVersionUID = 78439201428190L;

    public AuthenticationFailedException() {
        super("The username or password that was entered is wrong");
    }
}
