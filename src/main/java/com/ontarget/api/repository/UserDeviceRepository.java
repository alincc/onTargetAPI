package com.ontarget.api.repository;

import com.ontarget.entities.UserDevice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/24/15.
 */
public interface UserDeviceRepository extends JpaRepository<UserDevice, Integer> {

    @Query("select userDevice from UserDevice userDevice where userDevice.user.userId=?1")
    public List<UserDevice> findByUserId(Integer userId);

    public List<UserDevice> findByDeviceUUID(String userDeviceUUID, Pageable pageable);

}
