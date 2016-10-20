package edu.fjnu.Servlet.getEchart;

import edu.fjnu.Entity.Temp.TempHighGrade;
import edu.fjnu.Service.UserGradeUtils.HighUtils;
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

public class SendHighGradeServlet extends HttpServlet {

    private static final long serialVersionUID = 2861202396003018353L;

    private static Logger logger = LoggerFactory.getLogger(SendHighGradeServlet.class);

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
        int BMI = HighUtils.getBMILevel(userID);
        int benchTest = HighUtils.getBenchTestGrade(userID);
        int longRun = HighUtils.getLongRunGrade(userID);
        int throwBall = HighUtils.getThrowBallGrade(userID);
        int sitAndReach = HighUtils.getSitAndReachGrade(userID);
        TempHighGrade temp = new TempHighGrade(BMI, benchTest, longRun, throwBall, sitAndReach);
        List<TempHighGrade> list = new ArrayList<TempHighGrade>();
        list.add(temp);
        String jsonData = JSONArray.fromObject(list).toString();
        out.write(jsonData);
        out.close();
    }
}
