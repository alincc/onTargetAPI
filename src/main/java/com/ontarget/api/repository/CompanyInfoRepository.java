package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.CompanyInfo;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Integer> {

	CompanyInfo findByCompanyId(Integer companyId);
}
