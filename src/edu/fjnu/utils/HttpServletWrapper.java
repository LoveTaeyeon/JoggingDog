package edu.fjnu.utils;


import edu.fjnu.Servlet.ForAndroid.HealthEatServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by vengeance on 16/3/26.
 * 通过指定方法去调用不同的方法，减少Servlet数量
 */
public abstract class HttpServletWrapper extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Logger logger = LoggerFactory.getLogger(HealthEatServlet.class);

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("act");//获取请求中的方法参数

        if (methodName == null || methodName.trim().isEmpty()) {
            logger.error("请求没有给出方法名");
            throw new RuntimeException("请求中没有给出方法名！");
        }


        Class clazz = this.getClass();
        Method method = null;

        try {
            method = clazz.getMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            logger.error(methodName + "方法不存在");
            throw new RuntimeException(methodName + "方法不存在！");
        }

        String result = "";
        try {
            /*
            调用方法，得到方法返回的结果
             */
            result = (String) method.invoke(this, request, response);

            /*
            如果没有指定操作，则什么都不做
             */
            if (result == null || result.trim().isEmpty())
                return;

            /*
            如果指定了操作，则以":"为切割符，得到操作的指令；
            否则默认为转发操作
             */
            if (result.contains(":")) {
                int index = result.indexOf(":");
                String functionStr = result.substring(0, index);//截取字符串前缀，得到操作指令
                String pathStr = result.substring(index + 1);//截取字符串后缀，得到操作路径

                if ("forward".equalsIgnoreCase(functionStr)) {//执行转发操作
                    request.getRequestDispatcher(pathStr).forward(request, response);
                } else if ("redirect".equalsIgnoreCase(functionStr)) {//执行重定向操作
                    response.sendRedirect(request.getContextPath() + pathStr);
                } else {
                    logger.error("指令" + functionStr + "尚未实现");
                    throw new RuntimeException("所指定的" + functionStr + "指令尚未实现！");
                }
            } else {//默认为转发操作
                request.getRequestDispatcher(result).forward(request, response);
            }
        } catch (IllegalAccessException e) {
            logger.error(methodName + "方法无法访问");
            throw new RuntimeException(methodName + "方法无法访问！");
        } catch (InvocationTargetException e) {
            logger.error(methodName + "方法内部抛出异常");
            throw new RuntimeException(methodName + "方法内部抛出异常！");
        }
    }
}
