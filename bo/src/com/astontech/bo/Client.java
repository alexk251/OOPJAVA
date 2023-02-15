package com.astontech.bo;

import java.util.Date;

public class Client extends BaseBO {
    private int ClientId;
    private String ClientName;
    private Date CreateDate;

    public Client() {}

    public Client(String clientName) {
        this.setClientName(clientName);
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public String GetClientDetails() {
        if(isNullOrEmpty(this.ClientName))
            return "No Name Set";
        else {
                return this.ClientName;
        }

    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
