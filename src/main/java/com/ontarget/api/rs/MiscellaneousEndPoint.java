package com.ontarget.api.rs;

import com.ontarget.dto.CountryListResponse;
import com.ontarget.dto.StateListResponse;
import com.ontarget.dto.TaskIdListResponse;

/**
 * Created by Yam on 12-12-2014.
 */
public interface MiscellaneousEndPoint {
    public StateListResponse getStatesByCountry(long userId);

    public CountryListResponse getCountryList();
}
