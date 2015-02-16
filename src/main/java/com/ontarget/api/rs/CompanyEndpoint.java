package com.ontarget.api.rs;

import com.ontarget.dto.CompanyListResponse;
import com.ontarget.request.bean.BaseRequestBean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by sumit on 12/24/14.
 */
public interface CompanyEndpoint {
	CompanyListResponse getCompanyList(BaseRequestBean baseRequest);
}
