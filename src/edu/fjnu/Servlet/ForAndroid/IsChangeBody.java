package edu.fjnu.Servlet.ForAndroid;

import edu.fjnu.DAO.HighInfoDAO;
import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAO.MiddleInfoDAO;
import edu.fjnu.DAO.PrimaryInfoDAO;
import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAOImpl.HighInfoDAOImpl;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.DAOImpl.MiddleInfoDAOImpl;
import edu.fjnu.DAOImpl.PrimaryInfoDAOImpl;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.Entity.Temp.TempMassage;
import edu.fjnu.Entity.UsersInformation.Student;
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

public class IsChangeBody extends HttpServlet {

    private static final long serialVersionUID = 4392455826331271535L;

    private static Logger logger = LoggerFactory.getLogger(IsChangeBody.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userID = request.getParameter("userID");
        StudentDAO stu = new StudentDAOImpl();
        Student user = new Student();
        List<TempMassage> list = new ArrayList<TempMassage>();
        TempMassage message = new TempMassage();
        try {
            user = stu.queryById(userID);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        if (user.getUserType() == null) {
            message.setBoolValue(false);
            message.setMessage("用户未修改体测信息或修改失败！请重新修改！");
        } else if (user.getUserType().equals("Primary")) {
            PrimaryInfoDAO info = new PrimaryInfoDAOImpl();
            try {
                if (info.queryById(userID) == null) {
                    message.setBoolValue(false);
                    message.setMessage("数据库故障！请您重新修改体测信息！");
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        } else if (user.getUserType().equals("Middle")) {
            MiddleInfoDAO info = new MiddleInfoDAOImpl();
            try {
                if (info.queryById(userID) == null) {
                    message.setBoolValue(false);
                    message.setMessage("数据库故障！请您重新修改体测信息！");
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        } else if (user.getUserType().equals("High")) {
            HighInfoDAO info = new HighInfoDAOImpl();
            try {
                if (info.queryById(userID) == null) {
                    message.setBoolValue(false);
                    message.setMessage("数据库故障！请您重新修改体测信息！");
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        } else if (user.getUserType().equals("university")) {
            InfoDAO info = new InfoDAOImpl();
            try {
                if (info.queryById(userID) == null) {
                    message.setBoolValue(false);
                    message.setMessage("数据库故障！请您重新修改体测信息！");
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        } else {
            message.setBoolValue(true);
            message.setMessage("用户已修改信息并且可以使用！");
        }
        list.add(message);
        @SuppressWarnings("static-access")
        String jsonArray = new JSONArray().fromObject(list).toString();
        response.getOutputStream().write((jsonArray + "").getBytes());
    }

}
