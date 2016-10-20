package edu.fjnu.Servlet;

import edu.fjnu.system.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
public class ReceiveMsgServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ReceiveMsgServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String countStep = request.getParameter("countStep");    //步数信息
        Config.number = countStep;
//		String page = request.getParameter("page");
//		JiguangPush.push("101");
//		System.out.println(countStep);
//		if(page.equals("TestBodyFat")){
//			RunInformationTemp rr = new RunInformationTemp();
//			rr.setFeetNumber(countStep);
//			String JsonData = JSONArray.fromObject(rr).toString();
//			out.write(JsonData);
//			System.out.println(countStep);
//			out.close();
//		}else{
//			System.out.println("error!");
//		}
        System.out.println("步数:" + countStep);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
