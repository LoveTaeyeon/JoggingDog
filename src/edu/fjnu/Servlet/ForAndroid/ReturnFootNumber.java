package edu.fjnu.Servlet.ForAndroid;

import edu.fjnu.DAO.UserFootNumberDAO;
import edu.fjnu.DAOImpl.UserFootNumberDAOImpl;
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

public class ReturnFootNumber extends HttpServlet {

    private static final long serialVersionUID = -8810505605205444134L;

    private Logger logger = LoggerFactory.getLogger(ReturnFootNumber.class);

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
        UserFootNumberDAO foot = new UserFootNumberDAOImpl();
        FootNumber number = new FootNumber();
        try {
            number = foot.queryFootNumber(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        if (number == null) {
            logger.debug("不存在用户信息，需要添加！");
            try {
                foot.set(new FootNumber(userID, 0));
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
            //还没有步数的用户，直接穿new的值给前端
            List<FootNumber> list = new ArrayList<FootNumber>();
            list.add(new FootNumber(userID, 0));
            @SuppressWarnings("static-access")
            String jsonData = new JSONArray().fromObject(list).toString();
            response.getOutputStream().write((jsonData + "").getBytes());
        } else {
            List<FootNumber> list = new ArrayList<FootNumber>();
            list.add(number);
            @SuppressWarnings("static-access")
            String jsonData = new JSONArray().fromObject(list).toString();
            response.getOutputStream().write((jsonData + "").getBytes());
        }
    }
}
