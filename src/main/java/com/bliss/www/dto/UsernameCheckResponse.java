package com.bliss.www.dto;

public class UsernameCheckResponse {

	private boolean exists;

    public UsernameCheckResponse(boolean exists) {
        this.exists = exists;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}
