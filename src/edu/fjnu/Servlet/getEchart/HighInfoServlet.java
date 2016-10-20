package edu.fjnu.Servlet.getEchart;

import edu.fjnu.DAO.HighInfoDAO;
import edu.fjnu.DAOImpl.HighInfoDAOImpl;
import edu.fjnu.Entity.Infos.Highinfo;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HighInfoServlet extends HttpServlet {

    private static final long serialVersionUID = 3640079907285210196L;

    private static Logger logger = LoggerFactory.getLogger(HighInfoServlet.class);

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
        HighInfoDAO stu = new HighInfoDAOImpl();
        Highinfo info = new Highinfo();
        try {
            info = stu.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        List<Highinfo> list = new ArrayList<Highinfo>();
        list.add(info);
        String jsonData = JSONArray.fromObject(list).toString();
        out.write(jsonData);
        out.close();
    }
}
