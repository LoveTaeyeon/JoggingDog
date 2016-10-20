package edu.fjnu.Servlet;

import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.utils.MD5;
import edu.fjnu.utils.StrKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@SuppressWarnings("serial")
@WebServlet("/AnotherLoginServlet")
public class AnotherLoginServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(AnotherLoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            if (StrKit.isBlank(username) || StrKit.isBlank(password)) {
                request.getRequestDispatcher("Login.html").forward(request, response);
                return;
            }
            StudentDAO stu = new StudentDAOImpl();
            Student ss = stu.queryById(username);
            ss.setPassword(MD5.GetMD5Code(ss.getPassword()));

            if (ss.getPassword().equals(password)) {
                request.getSession().setAttribute("userid", username);
                request.getRequestDispatcher("loginIndex.html").forward(request, response);
            } else {
                request.getRequestDispatcher("Login.html").forward(request, response);
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
