package com.astontech.dao;

import com.astontech.bo.Email;

import java.util.List;

public interface EmailDAO {
    //notes: GET METHODS
    public Email getEmailById(int emailId);
    public List<Email> getEmailList();

    //notes: EXECUTE METHODS
    public int insertEmail(Email email);
    public boolean updateEmail(Email email);
    public boolean deleteEmail(int emailId);

}
