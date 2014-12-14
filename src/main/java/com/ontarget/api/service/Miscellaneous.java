package com.ontarget.api.service;

import java.util.Set;

/**
 * Created by Yam on 12-12-2014.
 */
public interface Miscellaneous {
    public Set<Long> getStatesByCountry(long countryId) throws Exception;

    public Set<Long> getCountryList() throws Exception;
}
