package edu.fjnu.Servlet;

import edu.fjnu.Entity.UsersInformation.RunInformationTemp;
import edu.fjnu.system.Config;
import edu.fjnu.system.JiguangPush;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class PresentServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(PresentServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String page = request.getParameter("page");
        System.out.println("page:" + page);
        JiguangPush.push("101");
        if (page.equals("TestBodyFat")) {
            RunInformationTemp rr = new RunInformationTemp();
            rr.setFeetNumber("100");
            List<RunInformationTemp> temp = new ArrayList<RunInformationTemp>();
            temp.add(rr);
            String JsonData = JSONArray.fromObject(temp).toString();
            System.out.println(Config.number);
            out.write(JsonData);
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
