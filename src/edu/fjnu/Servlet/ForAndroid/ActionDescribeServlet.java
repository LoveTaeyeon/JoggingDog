package edu.fjnu.Servlet.ForAndroid;

import edu.fjnu.DAO.ActionDAO;
import edu.fjnu.DAOImpl.ActionDAOImpl;
import edu.fjnu.Entity.Usual.Action;
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

public class ActionDescribeServlet extends HttpServlet {

    //动作说明库接口。返回给你一个List集合。
    private static final long serialVersionUID = -7119215016320786161L;

    private static Logger logger = LoggerFactory.getLogger(ActionDescribeServlet.class);

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
        ActionDAO action = new ActionDAOImpl();
        List<Action> list = new ArrayList<Action>();

        try {
            list = action.queryAll();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        for (int i = 0; i < list.size(); i++) {
            String url = list.get(i).getImage_url().replace("\n", "");
            list.get(i).setImage_url(url);
        }
        //返回给你一个List集合，集合内容请追寻Action实体类
        @SuppressWarnings("static-access")
        JSONArray jsonArray = new JSONArray().fromObject(list);
        response.getOutputStream().write((jsonArray + "").getBytes());
    }
}
