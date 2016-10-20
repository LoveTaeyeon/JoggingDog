package edu.fjnu.Servlet.ForAndroid;

import edu.fjnu.DAO.stu_CodoonDAO;
import edu.fjnu.DAOImpl.stu_CodoonDAOImpl;
import edu.fjnu.Entity.Temp.TempMassage;
import edu.fjnu.Entity.UsersInformation.stu_Codoon;
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

public class IsHaveGodoon extends HttpServlet {

    private static final long serialVersionUID = -470289668438951539L;

    private static Logger logger = LoggerFactory.getLogger(IsHaveGodoon.class);

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
        String userID = request.getParameter("userID");
        List<TempMassage> list = new ArrayList<TempMassage>();
        TempMassage message = new TempMassage();
        stu_CodoonDAO stu = new stu_CodoonDAOImpl();
        stu_Codoon user = new stu_Codoon();
        try {
            user = stu.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        if (user == null) {
            message.setBoolValue(false);
            message.setMessage("该用户没有绑定咕咚账号！请前往网页绑定！");
        } else {
            message.setBoolValue(true);
            message.setMessage("用户已绑定咕咚账号！");
        }
        list.add(message);
        @SuppressWarnings("static-access")
        String jsonData = new JSONArray().fromObject(list).toString();
        response.getOutputStream().write((jsonData + "").getBytes());
    }
}
