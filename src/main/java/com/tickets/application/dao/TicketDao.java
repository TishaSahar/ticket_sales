package com.tickets.application.datamodel;

public class TicketDto {

    private int userId;
    private String itemId;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String anItem) {
        this.itemId = anItem;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int anId) {
        this.userId = anId;
    }
}