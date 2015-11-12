package com.ontarget.util;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.User;

public class CompanyUtil {
	/*
	 * User allowed to edit company info if he himself is a creator or if he is
	 * a project manager
	 */
	public static boolean isUserAllowedToEditCompany(User creator, int modifiedBy) {
		if (creator.getUserId() == modifiedBy) {
			return true;
		}
		if (creator.getUserType().getUserType().equalsIgnoreCase(OnTargetConstant.UserType.PROJECT_MANAGER) || creator.getUserType().getUserType().equalsIgnoreCase(OnTargetConstant.UserType.SUPER_USER)) {
			return true;
		}
		return false;
	}

}
