package com.ontarget.enums;

/**
 * Created by sanjeevghimire on 12/10/15.
 */
public enum MemberShipType {

    PROJECTOWNER("SU","PROJ_OWNER"),
    PROJECTMANAGER("PM","PROJ_MANAGER"),
    PROJUSER("RU","PROJ_USER");

    private String profileCode;
    private String memberShipCode;

    MemberShipType(String profileCode,String memberShipCode) {
        this.profileCode=profileCode;
        this.memberShipCode=memberShipCode;
    }

    public static String getMemberShipCodeByProfileCode(String profileCode) {
        String memberShipCode=null;
        for(MemberShipType memberShipType : MemberShipType.values()){
            if(memberShipType.profileCode.equals(profileCode)){
                memberShipCode=memberShipType.memberShipCode;
                break;
            }
        }
        return memberShipCode;
    }
}
