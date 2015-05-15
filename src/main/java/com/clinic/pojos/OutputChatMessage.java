package com.clinic.pojos;

public class OutputChatMessage {
    private String content;
    private String userEmail;

    public OutputChatMessage(String content, String userEmail) {
        this.content = content;
        this.userEmail = userEmail;
    }

    public String getContent() {
        return this.content;
    }

    public String getUserEmail() {
        return this.userEmail;
    }
}
