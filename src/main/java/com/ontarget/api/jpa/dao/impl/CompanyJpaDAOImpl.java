package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.CompanyDAO;
import com.ontarget.api.repository.CompanyInfoRepository;
import com.ontarget.bean.AddressDTO;
import com.ontarget.bean.Company;
import com.ontarget.bean.UserAddressInfo;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.entities.CompanyInfo;
import com.ontarget.entities.CompanyType;
import com.ontarget.entities.User;
import com.ontarget.request.bean.CompanyEditInfo;

@Repository("companyJpaDAOImpl")
public class CompanyJpaDAOImpl implements CompanyDAO {
	private Logger logger = Logger.getLogger(CompanyJpaDAOImpl.class);
	@Resource
	private CompanyInfoRepository companyInfoRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addCompanyInfo(Company company, int userId) throws Exception {
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setCompanyName(company.getCompanyName());
		AddressDTO addressDTO = company.getAddress();
		companyInfo.setAddress1(addressDTO.getAddress1());
		companyInfo.setAddress2(addressDTO.getAddress2());
		companyInfo.setCity(addressDTO.getCity());
		companyInfo.setState(addressDTO.getState());
		companyInfo.setZipcode(addressDTO.getZip());
		companyInfo.setCountry(addressDTO.getCountry());
		companyInfo.setWebsite(company.getWebsite());
		companyInfo.setStatus(OnTargetConstant.CompanyStatus.STATUS);
		companyInfo.setCompanyType(new CompanyType(company.getCompanyTypeId()));
		companyInfo.setLogoPath(company.getCompanyLogoPath());
		companyInfo.setAddedBy(new User(userId));
		companyInfo.setAddedDate(new Date());
		companyInfoRepository.save(companyInfo);
		logger.info("persist company: " + companyInfo.getCompanyId());
		return companyInfo.getCompanyId();
	}

	@Override
	public boolean update(CompanyEditInfo company, int modifiedBy) throws Exception {
		CompanyInfo companyInfo = companyInfoRepository.findByCompanyId(company.getCompanyId());
		companyInfo.setCompanyName(company.getCompanyName());
		companyInfo.setCompanyType(new CompanyType(company.getCompanyTypeId()));

		UserAddressInfo addressDTO = company.getAddress();
		companyInfo.setAddress1(addressDTO.getAddress1());
		companyInfo.setAddress2(addressDTO.getAddress2());
		companyInfo.setCity(addressDTO.getCity());
		companyInfo.setState(addressDTO.getState());
		companyInfo.setZipcode(addressDTO.getZip());
		companyInfo.setCountry(addressDTO.getCountry());
		companyInfo.setLogoPath(company.getLogoPath());
		companyInfo.setModifiedDate(new Date());
		companyInfo.setModifiedBy(new User(modifiedBy));
		companyInfoRepository.save(companyInfo);
		return true;
	}

	@Override
	public CompanyInfo getCompanyInfo(int companyId) throws Exception {
		return companyInfoRepository.findByCompanyId(companyId);
	}

	@Override
	public Company getCompany(int companyId) throws Exception {
		CompanyInfo companyInfo = companyInfoRepository.findByCompanyId(companyId);
		Company company = new Company();
		company.setCompanyName(companyInfo.getCompanyName());
		company.setCompanyId(companyInfo.getCompanyId());
		company.setCompanyTypeId(companyInfo.getCompanyType().getCompanyTypeId());
		company.setCompanyLogoPath(companyInfo.getLogoPath());

		AddressDTO address = new AddressDTO();
		address.setAddress1(companyInfo.getAddress1());
		address.setAddress2(companyInfo.getAddress2());
		address.setCity(companyInfo.getCity());
		address.setState(companyInfo.getState());
		address.setZip(companyInfo.getZipcode());
		address.setCountry(companyInfo.getCountry());

		company.setAddress(address);

		return company;
	}

	@Override
	public Map<String, Object> getCompanyByUser(int userId) throws Exception {
		return jdbcTemplate.queryForMap(OnTargetQuery.GET_CONTACT_BY_USER, new Object[] { userId });
	}

	@Override
	public List<Company> getCompanyList() throws Exception {
		List<CompanyInfo> companyList = companyInfoRepository.findAll();

		List<Company> companies = new ArrayList<>();

		if (companyList != null && !companyList.isEmpty()) {
			for (CompanyInfo companyInfo : companyList) {
				Company company = new Company();
				company.setCompanyId(companyInfo.getCompanyId());
				company.setCompanyName(companyInfo.getCompanyName());
				company.setWebsite(companyInfo.getWebsite());
				company.setCompanyTypeId(companyInfo.getCompanyType().getCompanyTypeId());

				AddressDTO addressDTO = new AddressDTO();
				addressDTO.setAddress1(companyInfo.getAddress1());
				addressDTO.setAddress2(companyInfo.getAddress2());
				addressDTO.setCity(companyInfo.getCity());
				addressDTO.setCountry(companyInfo.getCountry());
				addressDTO.setState(companyInfo.getState());
				addressDTO.setZip(companyInfo.getZipcode());

				company.setAddress(addressDTO);

				companies.add(company);
			}
		}

		return companies;
	}

}
