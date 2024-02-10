package com.tickets.application.dao;

public class TicketDao {

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