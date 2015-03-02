package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.CompanyListResponse;
import com.ontarget.request.bean.CompanyList;

/**
 * Created by sumit on 12/24/14.
 */
public interface CompanyEndpoint {
	CompanyListResponse getCompanyList(@Valid CompanyList companyList);
}
