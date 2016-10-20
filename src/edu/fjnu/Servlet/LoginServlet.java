package edu.fjnu.Servlet;

import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.Entity.UsersInformation.Student;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            StudentDAO stu = new StudentDAOImpl();
            Student ss = new Student();
            ss = stu.queryById(username);
            JSONObject object = new JSONObject();

            if (ss.getPassword().equals(password)) {
                object.put("result", "success");
                request.getSession().setAttribute("session_user", username);
            } else {
                object.put("result", "failure");
            }
            response.getOutputStream().write(
                    (object.toString()).getBytes("utf-8"));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
