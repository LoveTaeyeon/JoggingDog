package edu.fjnu.Servlet;

import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAO.stu_CodoonDAO;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.DAOImpl.stu_CodoonDAOImpl;
import edu.fjnu.Entity.Temp.AndroidLoginTemp;
import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.Entity.UsersInformation.stu_Codoon;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IsOperatedServlet extends HttpServlet {

    private static final long serialVersionUID = -6140280491960492266L;

    private static Logger logger = LoggerFactory.getLogger(IsOperatedServlet.class);

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        String userID = (String) request.getSession().getAttribute("userid");
        List<AndroidLoginTemp> list = new ArrayList<AndroidLoginTemp>();
        //List<TempMassage> list = new ArrayList<TempMassage>();
        AndroidLoginTemp message = new AndroidLoginTemp();
        StudentDAO student = new StudentDAOImpl();
        Student stu = new Student();
        try {
            stu = student.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        if (stu == null || stu.getUserType() == null) {
            message.setHaveChange(false);
        } else {
            message.setHaveChange(true);
        }
        stu_CodoonDAO codoon = new stu_CodoonDAOImpl();
        stu_Codoon cod = new stu_Codoon();
        try {
            cod = codoon.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        if (cod == null) {
            message.setHaveGodoon(false);
        } else {
            message.setHaveGodoon(true);
        }
        list.add(message);
        @SuppressWarnings("static-access")
        String jsonData = new JSONArray().fromObject(list).toString();
        out.write(jsonData);
        out.close();
    }
}
