package edu.fjnu.Servlet.getEchart;

import edu.fjnu.DAO.PrimaryInfoDAO;
import edu.fjnu.DAOImpl.PrimaryInfoDAOImpl;
import edu.fjnu.Entity.Infos.Primaryinfo;
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

public class PrimaryInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 7151683762777484104L;

    private static Logger logger = LoggerFactory.getLogger(PrimaryInfoServlet.class);

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
        PrimaryInfoDAO stu = new PrimaryInfoDAOImpl();
        Primaryinfo info = new Primaryinfo();
        try {
            info = stu.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        List<Primaryinfo> list = new ArrayList<Primaryinfo>();
        list.add(info);
        String jsonData = JSONArray.fromObject(list).toString();
        out.write(jsonData);
        out.close();
    }
}
