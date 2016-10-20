package edu.fjnu.Servlet.ForAndroid;

import edu.fjnu.DAO.stu_CodoonDAO;
import edu.fjnu.DAOImpl.stu_CodoonDAOImpl;
import edu.fjnu.Entity.Temp.TempMassage;
import edu.fjnu.Entity.UsersInformation.stu_Codoon;
import edu.fjnu.Entity.Usual.TestBodyFatTemp;
import edu.fjnu.webCrawlers.Crawlers;
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

public class GedoonServlet extends HttpServlet {

    private static final long serialVersionUID = -798828198906767110L;

    private static Logger logger = LoggerFactory.getLogger(GedoonServlet.class);

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
        String userID = request.getParameter("userID");
        stu_CodoonDAO codoon = new stu_CodoonDAOImpl();
        stu_Codoon user = new stu_Codoon();
        try {
            user = codoon.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        if (user == null) {
            TempMassage message = new TempMassage();
            message.setMessage("用户还未绑定咕咚！请登录网页版绑定！");
            message.setBoolValue(false);
            List<TempMassage> list = new ArrayList<TempMassage>();
            list.add(message);
            @SuppressWarnings("static-access")
            JSONArray jsonArray = new JSONArray().fromObject(list);
            response.getOutputStream().write((jsonArray + "").getBytes());
        } else {
            TestBodyFatTemp temp = new TestBodyFatTemp();
            try {
                //调用函数，完成封装
                temp = Crawlers.getTemp(userID, user.getC_username(), user.getC_password());
            } catch (SQLException e1) {
                logger.error(e1.getMessage());
            }
            List<TestBodyFatTemp> tempList = new ArrayList<TestBodyFatTemp>();
            tempList.add(temp);
            @SuppressWarnings("static-access")
            JSONArray jsonArray = new JSONArray().fromObject(tempList);
            response.getOutputStream().write((jsonArray + "").getBytes());
        }
    }
}
