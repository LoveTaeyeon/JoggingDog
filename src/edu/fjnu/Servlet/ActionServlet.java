package edu.fjnu.Servlet;

import edu.fjnu.Entity.Usual.Action;
import edu.fjnu.Service.ActionService;
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
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ActionServlet.class);
    private ActionService actionService = new ActionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        String ACTIONLIST = "ActionList";
        if (ACTIONLIST.equals(page)) {
            Map<String, List<Action>> actionList = actionService.findAll();
            String jsonData = JSONArray.fromObject(actionList).toString();
            out.write(jsonData);
            out.close();
        }
    }

}
