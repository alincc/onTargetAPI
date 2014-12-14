package com.ontarget.dto;

import java.util.Set;

/**
 * Created by Yam on 13-12-2014.
 */
public class CountryListResponse extends OnTargetResponse{
    private Set<Long> countryId;

    public Set<Long> getCountryId() {
        return countryId;
    }

    public void setCountryId(Set<Long> countryId) {
        this.countryId = countryId;
    }
}
