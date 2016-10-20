package edu.fjnu.Servlet;

import edu.fjnu.DAO.PlanForUserDAO;
import edu.fjnu.DAO.UserHavePlanDAO;
import edu.fjnu.DAOImpl.PlanForUserDAOImpl;
import edu.fjnu.DAOImpl.UserHavePlanDAOImpl;
import edu.fjnu.Entity.Plan.HealthPlan;
import edu.fjnu.Entity.UsersInformation.PlanForUser;
import edu.fjnu.Entity.UsersInformation.UserHavePlan;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToHavePlanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Logger logger = LoggerFactory.getLogger(ToHavePlanServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @SuppressWarnings("static-access")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String userID = (String) request.getSession().getAttribute("userid");
        UserHavePlanDAO user = new UserHavePlanDAOImpl();
        UserHavePlan stu = new UserHavePlan();
        try {
            stu = user.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        if (stu == null) {
            //创建一个新的条目
            UserHavePlan temp = new UserHavePlan(userID, 1);
            try {
                user.add(temp);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        } else {
            //已经含有了条目
            try {
                //变成含有plan
                user.setHave(userID);
                System.out.println("修改条目");
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        PlanForUserDAO pfu = new PlanForUserDAOImpl();
        List<PlanForUser> planList = new ArrayList<PlanForUser>();
        String strList = request.getParameter("gdata");
        JSONArray jb = JSONArray.fromObject(strList);
        System.out.println("jb:" + jb);
        List<HealthPlan> planForUserList = new ArrayList<HealthPlan>();
        for (int index = 0; index < jb.size(); index++) {
            net.sf.json.JSONObject JSONObject = jb.getJSONObject(index);
            planForUserList.add((HealthPlan) JSONObject.toBean(JSONObject, HealthPlan.class));
        }
        for (int i = 0; i < planForUserList.size(); i++) {
            HealthPlan h = planForUserList.get(i);
            PlanForUser p = new PlanForUser(userID, h.getName(), h.getLevel(), h.getGroupNum(), h.getExercisePart(), h.getHardLevel(), h.getForWhat());
            planList.add(p);
        }
        try {
            pfu.addAll(planList);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
