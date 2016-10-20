package edu.fjnu.filter;

import edu.fjnu.utils.StrKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * Created by vengeance on 16/3/26.
 * 继承Http请求包装类，对客户端请求进行处理
 * 装饰request
 */
public class EncodingRequest extends HttpServletRequestWrapper {
    private static Logger logger = LoggerFactory.getLogger(EncodingRequest.class);
    private HttpServletRequest request;

    public EncodingRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    /**
     * 对request的获取参数方法进行包装
     *
     * @param s 参数
     * @return 参数值
     */
    public String getParameter(String s) {
        String value = request.getParameter(s);
        if (StrKit.isBlank(value)) return null;
        try {
            value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return value;
    }


}
