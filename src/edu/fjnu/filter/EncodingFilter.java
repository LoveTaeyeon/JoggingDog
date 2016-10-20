package edu.fjnu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by vengeance on 16/3/26.
 * 请求响应编码过滤器
 */
public class EncodingFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//处理POST请求编码问题
        resp.setContentType("text/html;charset=utf-8");//设置响应编码
        HttpServletRequest request = (HttpServletRequest) req;

        /*
        在处理请求编码时有两种情况：GET与POST
        对于GET请求，使用包装过的request，对其设置编码
        对于POST请求，在上面进行POST编码处理
         */
        if (request.getMethod().equals("GET")) {
            EncodingRequest encodingRequest = new EncodingRequest(request);
            chain.doFilter(encodingRequest, resp);
        } else if (request.getMethod().equals("POST")) {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
