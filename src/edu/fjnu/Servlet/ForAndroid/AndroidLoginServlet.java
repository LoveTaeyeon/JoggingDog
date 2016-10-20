package edu.fjnu.Servlet.ForAndroid;

import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAO.stu_CodoonDAO;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.DAOImpl.stu_CodoonDAOImpl;
import edu.fjnu.Entity.Temp.AndroidLoginTemp;
import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.Entity.UsersInformation.stu_Codoon;
import edu.fjnu.utils.MD5;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AndroidLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 5273515330921574032L;

    private static Logger logger = LoggerFactory.getLogger(AndroidLoginServlet.class);

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
        //PrintWriter out = response.getWriter();
        //从安卓取两个参数名，userID和password
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");
        StudentDAO stu = new StudentDAOImpl();
        Student user = new Student();
        try {
            user = stu.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        List<AndroidLoginTemp> list = new ArrayList<AndroidLoginTemp>();
        //List<TempMassage> list = new ArrayList<TempMassage>();
        AndroidLoginTemp message = new AndroidLoginTemp();
        //message类里面封装了信息和是否通过，message为信息，boolValue为是否通过
        if (user == null) {
            message.setBoolValue(false);
        } else {
            try {
                if (user.getPassword().equals(MD5.GetMD5Code(password))) {
                    message.setBoolValue(true);
                } else {
                    message.setBoolValue(false);
                }
            } catch (NoSuchAlgorithmException e1) {
                logger.error(e1.getMessage());
            }
        }
        if (user.getUserType() == null) {
            message.setHaveChange(false);
        } else {
            message.setHaveChange(true);
        }
        stu_CodoonDAO codoon = new stu_CodoonDAOImpl();
        stu_Codoon stu_codoon = new stu_Codoon();
        try {
            stu_codoon = codoon.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        if (stu_codoon == null) {
            message.setHaveGodoon(false);
        } else {
            message.setHaveGodoon(true);
        }
        message.setUserType(user.getUserType());
        list.add(message);
        @SuppressWarnings("static-access")
        JSONArray jsonArray = new JSONArray().fromObject(list);
        response.getOutputStream().write((jsonArray + "").getBytes());
    }
}
