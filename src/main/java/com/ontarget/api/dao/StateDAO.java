package com.ontarget.api.dao;

import java.util.List;
import java.util.Set;

/**
 * Created by Yam on 09-12-2014.
 */
public interface StateDAO {
    public Set<Long> getStatesByCountry(long countryId) throws Exception;
}
