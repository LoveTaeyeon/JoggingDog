package edu.fjnu.Servlet;

import edu.fjnu.DAO.PlanForUserDAO;
import edu.fjnu.DAO.UserHavePlanDAO;
import edu.fjnu.DAOImpl.PlanForUserDAOImpl;
import edu.fjnu.DAOImpl.UserHavePlanDAOImpl;
import edu.fjnu.Entity.UsersInformation.UserHavePlan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class ToNotHavePlan
 */
@WebServlet("/ToNotHavePlan")
public class ToNotHavePlan extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Logger logger = LoggerFactory.getLogger(ToNotHavePlan.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
//		PrintWriter out = response.getWriter();
        String userID = (String) request.getSession().getAttribute("userid");
        PlanForUserDAO stuList = new PlanForUserDAOImpl();
        UserHavePlanDAO user = new UserHavePlanDAOImpl();
        UserHavePlan stu = new UserHavePlan();
        try {
            stu = user.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        if (stu == null) {
            //创建一个新的条目
            UserHavePlan temp = new UserHavePlan(userID, 0);
            try {
                user.add(temp);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        } else {
            //已经含有了条目
            try {
                //变成含有plan
                user.setNo(userID);
                stuList.delete(userID);
                //
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
