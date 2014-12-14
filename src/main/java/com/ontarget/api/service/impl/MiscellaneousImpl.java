package com.ontarget.api.service.impl;

import com.ontarget.api.dao.CountryDAO;
import com.ontarget.api.dao.StateDAO;
import com.ontarget.api.service.Miscellaneous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Yam on 12-12-2014.
 */
@Service
public class MiscellaneousImpl implements Miscellaneous {

    @Autowired
    private StateDAO stateDAO;

    @Autowired
    private CountryDAO countryDAO;

    @Override
    public Set<Long> getStatesByCountry(long countryId) throws Exception {
        return stateDAO.getStatesByCountry(countryId);
    }

    @Override
    public Set<Long> getCountryList() throws Exception {
        return countryDAO.getCountryList();
    }
}
