package edu.fjnu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import edu.fjnu.Entity.Foot.FootWraper;
import edu.fjnu.Service.MovementService;
import edu.fjnu.exception.ApplicationException;
import edu.fjnu.exception.FootException;
import net.sf.json.JSONObject;
@WebServlet("/MovementServlet")
public class MovementServlet extends HttpServlet {
	private MovementService movementService = new MovementService();
	private Logger logger = LoggerFactory.getLogger(MovementServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		String page = request.getParameter("page");
		String whereyouare = "runaway";
		String share = "sharelink";
		try{
			if(whereyouare.equals(page)){
				HttpSession session = request.getSession();
				String name = (String) session.getAttribute("userid");
				FootWraper footWraper =  movementService.getDistance(name);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("status", 1);
				JSONObject dataObject = new JSONObject();
				dataObject.put("distance", footWraper.getDistance());
				dataObject.put("footNum", footWraper.getFootNum());
				dataObject.put("perStepDis", footWraper.getPerStepDis());
				dataObject.put("ud", name);
				jsonObject.put("data",dataObject);
				out.write(jsonObject.toString());
				out.flush();
			}else if(share.equals(page)){
			    String name = request.getParameter("ud");
			    FootWraper footWraper =  movementService.getDistance(name);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("status", 1);
				JSONObject dataObject = new JSONObject();
				dataObject.put("distance", footWraper.getDistance());
				dataObject.put("footNum", footWraper.getFootNum());
				dataObject.put("perStepDis", footWraper.getPerStepDis());
				jsonObject.put("data",dataObject);
				out.write(jsonObject.toString());
				out.flush();
			}
		}catch(FootException footException){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", footException.getStatus());
			jsonObject.put("msg",footException.getMessage());
			out.write(jsonObject.toString());
			out.flush();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			out.close();
		} 
		
	}
}
