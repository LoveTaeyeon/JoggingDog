package edu.fjnu.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ven_hxz on 16/4/3.
 * 字符串处理工具
 */
public class StrKit {

    //下划线
    public static final char UNDERLINE = '_';

    /**
     * 判断字符串是否为null或者""
     *
     * @param str 字符串
     * @return 是否为空;true : 为空 ; false : 不为空
     */
    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * 判断字符串是否为null或者""
     *
     * @param str 字符串
     * @return 是否为空;true : 不为空 ; false : 为空
     */
    public static boolean notBlank(String str) {
        return str != null && !"".equals(str.trim());
    }

    /**
     * 判断字符串数组是否为空,或者数组是否存在空字符串
     *
     * @param strings 可变数组
     * @return 是否为空;true : 不为空 ; false : 为空
     */
    public static boolean notBlank(String... strings) {
        if (strings == null)
            return false;

        for (String str : strings) {
            if (str == null || "".equals(str.trim()))
                return false;
        }
        return true;
    }

    /**
     * 判断数组是否为null,或者数组是否存在null的元素
     *
     * @param params 可变数组
     * @return 是否为空;true : 不为空 ; false : 为空
     */
    public static boolean notNull(Object... params) {
        if (params == null)
            return false;

        for (Object obj : params) {
            if (obj == null)
                return false;
        }
        return true;
    }

    /**
     * 首字母小写
     *
     * @param str 字符串
     * @return 首字母为小写的字符串
     */
    public static String toFirstLowerCase(String str) {
        char c = str.charAt(0);

        if (c >= 'A' && c <= 'Z') {
            char[] chars = str.toCharArray();
            chars[0] += ('a' - 'A');
            return new String(chars);
        }
        return str;
    }

    /**
     * 首字母大写
     *
     * @param str 字符串
     * @return 首字母为小写的字符串
     */
    public static String toFirstUpperCase(String str) {
        char c = str.charAt(0);

        if (c >= 'a' && c <= 'z') {
            char[] chars = str.toCharArray();
            chars[0] -= ('a' - 'A');
            return new String(chars);
        }
        return str;
    }

    /**
     * 驼峰命名转为下划线命名
     *
     * @param str 驼峰命名字符串
     * @return 下划线命名字符串
     */
    public static String camelCase2Underline(String str) {
        if (str == null || "".equals(str.trim())) return "";

        int len = str.length();
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 将下划线命名转为驼峰命名
     *
     * @param str 字符串
     * @return 驼峰命名字符串
     */
    public static String underline2CamelCase(String str) {
        if (str == null || "".equals(str.trim())) return "";

        int len = str.length();
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            if (c == UNDERLINE) {
                if (++i < len)
                    sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 使用匹配的方式将下划线命名转为驼峰命名
     *
     * @param str 字符串
     * @return 驼峰命名字符串
     */
    public static String underline2CamelByMatcher(String str) {
        if (str == null || "".equals(str.trim())) return "";

        StringBuilder sb = new StringBuilder(str);
        Matcher matcher = Pattern.compile("_").matcher(str);
        int index = 0;

        while (matcher.find()) {
            int pos = matcher.end() - (index++);
            sb.replace(pos - 1, pos + 1, sb.substring(pos, pos + 1).toUpperCase());
        }

        return sb.toString();
    }

    /**
     * 将字符串数组中的所有字符串拼成一个字符串
     *
     * @param strings 字符串数组
     * @return 拼接而成的字符串
     */
    public static String join(String[] strings) {
        StringBuilder sb = new StringBuilder();

        for (String str : strings) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static String join(String[] strings, String separator) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            if (i > 0) {
                sb.append(separator);
            }
            sb.append(strings[i]);
        }

        return sb.toString();
    }

}
