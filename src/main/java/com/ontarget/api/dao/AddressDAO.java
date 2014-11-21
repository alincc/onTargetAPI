package com.ontarget.api.dao;

import com.ontarget.bean.Address;

/**
 * Created by Owner on 11/5/14.
 */
public interface AddressDAO {

    public int addAddress(Address address) throws Exception;

    public Address getAddress(int addressId) throws Exception;

    public boolean updateAddress(Address projectAddress) throws Exception;
}
