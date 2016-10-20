package edu.fjnu.Servlet.ForAndroid;

import edu.fjnu.DAO.UserFootNumberDAO;
import edu.fjnu.DAOImpl.UserFootNumberDAOImpl;
import edu.fjnu.Entity.Temp.TempMassage;
import edu.fjnu.Entity.UsersInformation.FootNumber;
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

public class AddFootNumberServlet extends HttpServlet {

    /**
     * 计步器接口
     */
    private static final long serialVersionUID = -3349230789383826606L;

    private static Logger logger = LoggerFactory.getLogger(AddFootNumberServlet.class);

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
        String userID = request.getParameter("userID");
        //传给后台的，只有步数即可，名字为number
        int number = Integer.parseInt((String) request.getParameter("number"));
        UserFootNumberDAO foot = new UserFootNumberDAOImpl();
        FootNumber user = new FootNumber();
        try {
            user = foot.queryFootNumber(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        TempMassage message = new TempMassage();
        //后台返回给安卓一个message信息
        if (user == null) {
            System.out.println("不存在该用户的信息，需要添加！");
            FootNumber info = new FootNumber();
            info.setFoot_Number(number);
            info.setUserID(userID);
            try {
                foot.add(info);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
            message.setMessage("已为您初始化您的信息！");
            message.setBoolValue(true);
        } else {
            int footNumber = number + user.getFoot_Number();
            user.setFoot_Number(footNumber);
            user.setUserID(userID);
            try {
                foot.set(user);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
            message.setMessage("步数已上传并累加成功！请继续保持运动！");
            message.setBoolValue(true);
        }
        List<TempMassage> list = new ArrayList<TempMassage>();
        list.add(message);
        @SuppressWarnings("static-access")
        JSONArray jsonArray = new JSONArray().fromObject(list);
        response.getOutputStream().write((jsonArray + "").getBytes());
    }
}

