package edu.fjnu.utils;

/**
 * @author ven_hxz
 * @create 2016-04-18 下午6:07
 */
public class UserTypeConvert {

    private static final String PRIMARY = "primary";

    private static final String MIDDLE = "middle";

    private static final String HIGH = "high";

    private static final String UNIVERSITY = "university";


    /**
     * 用户类型转换
     * student:userType -> healtheat:agePart
     *
     * @param userType
     * @return
     */
    public static String convertUserType(String userType) {
        if (StrKit.isBlank(userType))
            return null;

        String agePart = null;
        switch (userType.toLowerCase()) {
            case PRIMARY:
                agePart = "小学生";
                break;
            case MIDDLE:
                agePart = "初中生";
                break;
            case HIGH:
                agePart = "高中生";
                break;
            case UNIVERSITY:
                agePart = "大学生";
                break;
        }
        return agePart;
    }
}
