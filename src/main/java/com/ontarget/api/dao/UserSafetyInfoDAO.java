package com.ontarget.api.dao;

/**
 * Created by sumit on 12/3/14.
 */
public interface UserSafetyInfoDAO {
    public String getRandomSafetyInfo(long disciplineId);

    public String getRandomSafetyInfoByID();
}
