package com.sistema.entryway.enumeration;

public enum SubjectType {
    ADMIN("admin"),
    USER("user");

    private final String role;

    SubjectType(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
