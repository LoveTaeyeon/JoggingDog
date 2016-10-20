package edu.fjnu.Servlet;

import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.Entity.Infos.Info;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class SendPlanServlet
 */
@WebServlet("/SendPlanServlet")
public class SendPlanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Logger logger = LoggerFactory.getLogger(SendPlanServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        String sendPlan = "SendNumber";
        if (page.equals(sendPlan)) {
            String userID = (String) request.getSession().getAttribute("userid");
            InfoDAO inf = new InfoDAOImpl();
            Info stu = new Info();
            try {
                stu = inf.queryById(userID);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
            List<Info> stuList = new ArrayList<Info>();
            stuList.add(stu);
            String jsonData = JSONArray.fromObject(stuList).toString();
            out.write(jsonData);
            out.close();
        }
    }
}
