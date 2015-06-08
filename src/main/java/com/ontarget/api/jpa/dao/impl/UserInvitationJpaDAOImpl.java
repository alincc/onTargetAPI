package com.ontarget.api.jpa.dao.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.UserInvitationDAO;
import com.ontarget.api.repository.RegistrationRequestRepository;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.entities.RegistrationRequest;
import com.ontarget.entity.pojo.RegistrationRequestResponseDTO;

@Repository("userInvitationJpaDAOImpl")
public class UserInvitationJpaDAOImpl implements UserInvitationDAO {
	@Resource
	private RegistrationRequestRepository registrationRequestRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean saveRegistrationRequest(UserInvitationRequestDTO userInvitationRequestDTO) throws Exception {
		RegistrationRequest registrationRequest = new RegistrationRequest();
		registrationRequest.setFirstName(userInvitationRequestDTO.getFirstName());
		registrationRequest.setLastName(userInvitationRequestDTO.getLastName());
		registrationRequest.setEmail(userInvitationRequestDTO.getEmail());
		registrationRequest.setPhoneNumber(userInvitationRequestDTO.getPhoneNumber());
		registrationRequest.setMsg(userInvitationRequestDTO.getMsg());
		registrationRequest.setStatus(OnTargetConstant.REGISTRATION_PENDING);
		registrationRequest.setRegistrationToken(userInvitationRequestDTO.getToken());
        registrationRequest.setCompanyName(userInvitationRequestDTO.getCompanyName());
        registrationRequest.setCompanyAddress1(userInvitationRequestDTO.getCompanyAddress1());
        registrationRequest.setCompanyAddress2(userInvitationRequestDTO.getCompanyAddress2());
        registrationRequest.setCompanyCity(userInvitationRequestDTO.getCompanyCity());
        registrationRequest.setCompanyState(userInvitationRequestDTO.getCompanyState());
        registrationRequest.setCompanyCountry(userInvitationRequestDTO.getCompanyCountry());
        registrationRequest.setCompanyZip(userInvitationRequestDTO.getCompanyZip());
        registrationRequest.setCompanyId(userInvitationRequestDTO.getCompanyId());
		registrationRequestRepository.save(registrationRequest);
		return true;
	}

	@Override
	public List<RegistrationRequestResponseDTO> fetchPendingRequests() throws Exception {
		List<RegistrationRequestResponseDTO> userRegistrationRequests = new LinkedList<RegistrationRequestResponseDTO>();

		List<RegistrationRequest> pendingRequests = registrationRequestRepository.getPendingRegistrationRequests();

		if (pendingRequests != null && !pendingRequests.isEmpty()) {
			for (RegistrationRequest request : pendingRequests) {
				RegistrationRequestResponseDTO registrationRequest = new RegistrationRequestResponseDTO();
				registrationRequest.setStatus(request.getStatus());
				registrationRequest.setRegistrationToken(request.getRegistrationToken());
				registrationRequest.setPhoneNumber(request.getPhoneNumber());
				registrationRequest.setEmail(request.getEmail());
				registrationRequest.setId(request.getId().intValue());
				registrationRequest.setMsg(request.getMsg());
				registrationRequest.setFirstName(request.getFirstName());
				registrationRequest.setLastName(request.getLastName());
				registrationRequest.setTsCreate(request.getTsCreate().getTime());
				userRegistrationRequests.add(registrationRequest);
			}
		}
		return userRegistrationRequests;
	}

	@Override
	public boolean approvePendingRequest(int regRequestId) throws Exception {
		RegistrationRequest registrationRequest = registrationRequestRepository.findById((long) regRequestId);
		registrationRequest.setStatus(OnTargetConstant.REGISTRATION_REQUEST_NEW);
		registrationRequestRepository.save(registrationRequest);
		return true;
	}

	@Override
	public RegistrationRequestResponseDTO findRequestByToken(String token) throws Exception {
		RegistrationRequest registrationRequest = registrationRequestRepository.findByRegistrationToken(token);
		RegistrationRequestResponseDTO registrationRequestDTO = new RegistrationRequestResponseDTO();
		registrationRequestDTO.setStatus(registrationRequest.getStatus());
		registrationRequestDTO.setRegistrationToken(registrationRequest.getRegistrationToken());
		registrationRequestDTO.setPhoneNumber(registrationRequest.getPhoneNumber());
		registrationRequestDTO.setEmail(registrationRequest.getEmail());
		registrationRequestDTO.setId(registrationRequest.getId().intValue());
		registrationRequestDTO.setMsg(registrationRequest.getMsg());
		registrationRequestDTO.setFirstName(registrationRequest.getFirstName());
		registrationRequestDTO.setLastName(registrationRequest.getLastName());
		registrationRequestDTO.setTsCreate(registrationRequest.getTsCreate().getTime());
		return registrationRequestDTO;
	}

	@Override
	public RegistrationRequestResponseDTO findRegRequestById(int id) throws Exception {

		RegistrationRequest registrationRequest = registrationRequestRepository.findById((long) id);
		RegistrationRequestResponseDTO registrationRequestDTO = new RegistrationRequestResponseDTO();
		registrationRequestDTO.setStatus(registrationRequest.getStatus());
		registrationRequestDTO.setRegistrationToken(registrationRequest.getRegistrationToken());
		registrationRequestDTO.setPhoneNumber(registrationRequest.getPhoneNumber());
		registrationRequestDTO.setEmail(registrationRequest.getEmail());
		registrationRequestDTO.setId(registrationRequest.getId().intValue());
		registrationRequestDTO.setMsg(registrationRequest.getMsg());
		registrationRequestDTO.setFirstName(registrationRequest.getFirstName());
		registrationRequestDTO.setLastName(registrationRequest.getLastName());
		registrationRequestDTO.setTsCreate(registrationRequest.getTsCreate().getTime());
		return registrationRequestDTO;
	}

	@Override
	public RegistrationRequestResponseDTO findRegRequestByEmail(String email) {
		try {
			String hql = "SELECT r FROM RegistrationRequest r WHERE r.email = :email order by r.id desc";
			Query query = entityManager.createQuery(hql);
			query.setParameter("email", email);
			query.setMaxResults(1);
			RegistrationRequest registrationRequest = (RegistrationRequest) query.getSingleResult();

			RegistrationRequestResponseDTO registrationRequestDTO = new RegistrationRequestResponseDTO();
			registrationRequestDTO.setStatus(registrationRequest.getStatus());
			registrationRequestDTO.setRegistrationToken(registrationRequest.getRegistrationToken());
			registrationRequestDTO.setPhoneNumber(registrationRequest.getPhoneNumber());
			registrationRequestDTO.setEmail(registrationRequest.getEmail());
			registrationRequestDTO.setId(registrationRequest.getId().intValue());
			registrationRequestDTO.setMsg(registrationRequest.getMsg());
			registrationRequestDTO.setFirstName(registrationRequest.getFirstName());
			registrationRequestDTO.setLastName(registrationRequest.getLastName());
			registrationRequestDTO.setTsCreate(registrationRequest.getTsCreate().getTime());
            registrationRequestDTO.setCompanyId(registrationRequest.getcompanyId());
            registrationRequestDTO.setCompanyName(registrationRequest.getCompanyName());
            registrationRequestDTO.setCompanyAddress1(registrationRequest.getCompanyAddress1());
            registrationRequestDTO.setCompanyAddress2(registrationRequest.getCompanyAddress2());
            registrationRequestDTO.setCompanyCity(registrationRequest.getCompanyCity());
            registrationRequestDTO.setCompanyState(registrationRequest.getCompanyState());
            registrationRequestDTO.setCompanyZip(registrationRequest.getCompanyZip());
            registrationRequestDTO.setCompanyCountry(registrationRequest.getCompanyCountry());

			return registrationRequestDTO;
		} catch (NoResultException nre) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

    @Override
    public RegistrationRequestResponseDTO findRegRequestByUserId(long userId) {
        try {
            String hql = "SELECT r FROM RegistrationRequest r WHERE r.userId = :userId order by r.id desc";
            Query query = entityManager.createQuery(hql);
            query.setParameter("userId", userId);
            query.setMaxResults(1);
            RegistrationRequest registrationRequest = (RegistrationRequest) query.getSingleResult();

            RegistrationRequestResponseDTO registrationRequestDTO = new RegistrationRequestResponseDTO();
            registrationRequestDTO.setStatus(registrationRequest.getStatus());
            registrationRequestDTO.setRegistrationToken(registrationRequest.getRegistrationToken());
            registrationRequestDTO.setPhoneNumber(registrationRequest.getPhoneNumber());
            registrationRequestDTO.setEmail(registrationRequest.getEmail());
            registrationRequestDTO.setId(registrationRequest.getId().intValue());
            registrationRequestDTO.setMsg(registrationRequest.getMsg());
            registrationRequestDTO.setFirstName(registrationRequest.getFirstName());
            registrationRequestDTO.setLastName(registrationRequest.getLastName());
            registrationRequestDTO.setTsCreate(registrationRequest.getTsCreate().getTime());
            registrationRequestDTO.setCompanyId(registrationRequest.getcompanyId());
            registrationRequestDTO.setCompanyName(registrationRequest.getCompanyName());
            registrationRequestDTO.setCompanyAddress1(registrationRequest.getCompanyAddress1());
            registrationRequestDTO.setCompanyAddress2(registrationRequest.getCompanyAddress2());
            registrationRequestDTO.setCompanyCity(registrationRequest.getCompanyCity());
            registrationRequestDTO.setCompanyState(registrationRequest.getCompanyState());
            registrationRequestDTO.setCompanyZip(registrationRequest.getCompanyZip());
            registrationRequestDTO.setCompanyCountry(registrationRequest.getCompanyCountry());



            return registrationRequestDTO;
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
