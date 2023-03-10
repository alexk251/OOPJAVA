package com.astontech.dao;

import com.astontech.bo.Phone;

import java.util.List;

public interface PhoneDAO {
    //notes: GET METHODS
    public Phone getPhoneById(int phoneId);
    public List<Phone> getPhoneList();

    //notes: EXECUTE METHODS
    public int insertPhone(Phone phone);
    public boolean updatePhone(Phone phone);
    public boolean deletePhone(int phoneId);

}
