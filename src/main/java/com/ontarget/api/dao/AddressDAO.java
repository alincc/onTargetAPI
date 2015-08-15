package com.ontarget.api.dao;

import com.ontarget.bean.AddressDTO;



/**
 * Created by Owner on 11/5/14.
 */
public interface AddressDAO {

    public int addAddress(AddressDTO addressDTO) throws Exception;

    public AddressDTO getAddress(int addressId) throws Exception;

    public boolean updateAddress(AddressDTO addressDTO) throws Exception;
    
    public com.ontarget.response.bean.Address getAddressById(int addressId) throws Exception;
}
