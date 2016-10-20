package edu.fjnu.Servlet;

import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.Entity.Infos.Info;
import edu.fjnu.Entity.Temp.TempPlanGrade;
import edu.fjnu.Service.UserGradeUtils.BMILevelToGrade;
import edu.fjnu.Service.UserGradeUtils.JumpLevelToGrade;
import edu.fjnu.Service.UserGradeUtils.LongRunLevelToGrade;
import edu.fjnu.Service.UserGradeUtils.PullUpLevelToGrade;
import edu.fjnu.Service.UserGradeUtils.ShortRunLevelToGrade;
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
 * Servlet implementation class SendPlanGradeServlet
 */
@WebServlet("/SendPlanGradeServlet")
public class SendPlanGradeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Logger logger = LoggerFactory.getLogger(SendPlanGradeServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        String getMassage = "SendGrade";
        if (page.equals(getMassage)) {
            String userID = (String) request.getSession().getAttribute("userid");
            InfoDAO inf = new InfoDAOImpl();
            Info stu = new Info();
            try {
                stu = inf.queryById(userID);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
            TempPlanGrade temp = new TempPlanGrade(LongRunLevelToGrade.getGrade(userID), ShortRunLevelToGrade.getGrade(userID), PullUpLevelToGrade.getGrade(userID), JumpLevelToGrade.getGrade(userID), BMILevelToGrade.getGrade(userID));
            List<TempPlanGrade> jsonList = new ArrayList<TempPlanGrade>();
            jsonList.add(temp);
            String jsonData = JSONArray.fromObject(jsonList).toString();
            out.write(jsonData);
            out.close();
        }
    }
}
