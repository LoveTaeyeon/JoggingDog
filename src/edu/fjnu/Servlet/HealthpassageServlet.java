package edu.fjnu.Servlet;

import edu.fjnu.Entity.Usual.HealthPassage;
import edu.fjnu.Service.HealthPassageService;
import edu.fjnu.exception.HealthPassageException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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


@WebServlet("/HealthpassageServlet")
public class HealthpassageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static Logger logger = LoggerFactory.getLogger(HealthpassageServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String page = request.getParameter("page");
        HealthPassageService healthPassageService = new HealthPassageService();
        PrintWriter out = response.getWriter();
        try {
            if ("passagelist".equals(page)) {
                String jsonData = JSONArray.fromObject(healthPassageService.getIndexHealthPassage()).toString();
                out.write(jsonData);
            } else if ("passage".equals(page)) {
                String id = (String) request.getParameter("id");
                HealthPassage healthPassage = healthPassageService.getHealthPassageByNumber(id);
                out.write(JSONObject.fromObject(healthPassage).toString());
            }
        } catch (HealthPassageException e) {
            logger.error(e.getMessage());
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            out.close();
        }
    }

}
