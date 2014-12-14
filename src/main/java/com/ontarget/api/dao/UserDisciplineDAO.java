package com.ontarget.api.dao;

import java.util.Set;

/**
 * Created by Yam on 13-12-2014.
 */
public interface UserDisciplineDAO {
    public Set<Long> getDisciplineByUser(long userId) throws Exception;
}
