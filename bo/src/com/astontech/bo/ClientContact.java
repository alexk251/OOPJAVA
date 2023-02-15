package com.astontech.bo;

public class ClientContact extends Client {
    private int ClientContactId;
    private int ClientId;
    private int EntityTypeId;

    public ClientContact() {};

    public ClientContact(int clientId) {
        this.setClientId(clientId);
    }

    public int getClientContactId() {
        return ClientContactId;
    }

    public void setClientContactId(int clientContactId) {
        ClientContactId = clientContactId;
    }

    @Override
    public int getClientId() {
        return ClientId;
    }

    @Override
    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }
}
