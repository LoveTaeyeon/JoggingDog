package edu.fjnu.Service;

import java.sql.SQLException;
import edu.fjnu.DAO.FootDAO;
import edu.fjnu.DAO.HighInfoDAO;
import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAO.MiddleInfoDAO;
import edu.fjnu.DAO.PrimaryInfoDAO;
import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAOImpl.FootDAOImpl;
import edu.fjnu.DAOImpl.HighInfoDAOImpl;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.DAOImpl.MiddleInfoDAOImpl;
import edu.fjnu.DAOImpl.PrimaryInfoDAOImpl;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.Entity.Foot.Foot;
import edu.fjnu.Entity.Foot.FootWraper;
import edu.fjnu.Entity.Infos.Highinfo;
import edu.fjnu.Entity.Infos.Info;
import edu.fjnu.Entity.Infos.Middleinfo;
import edu.fjnu.Entity.Infos.Primaryinfo;
import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.exception.ApplicationException;
import edu.fjnu.exception.FootException;
//import edu.fjnu.utils.StrKit;
//import sun.text.resources.cldr.or.FormatData_or;

public class MovementService {
	public FootWraper getDistance(String name) throws SQLException, ApplicationException{
		String heightStr; 
		int height;
		StudentDAO studentDAO = new StudentDAOImpl();
		FootWraper footWraper = new FootWraper();
		Student student = studentDAO.queryById(name);
		if(student==null){
			throw new FootException(-2,"此用户未注册");
		}
		String userType = student.getUserType();
		if("Primary".equals(userType)){
			PrimaryInfoDAO infoDAO = new PrimaryInfoDAOImpl();
			Primaryinfo primaryinfo = infoDAO.queryById(name);
			heightStr = primaryinfo.getHeight();
		}else if("Middle".equals(userType)){
			MiddleInfoDAO infoDAO = new MiddleInfoDAOImpl();
			Middleinfo middleInfo = infoDAO.queryById(name);
			heightStr = middleInfo.getHeight();
		}else if("High".equals(userType)){
			HighInfoDAO highInfoDAO = new HighInfoDAOImpl();
			Highinfo highinfo = highInfoDAO.queryById(name);
			heightStr = highinfo.getHeight();
		}else if("university".equals(userType)||"graduate".equals(userType)){
			InfoDAO infoDAO = new InfoDAOImpl();
			Info info = infoDAO.queryById(name);
			heightStr = info.getHeight();
		}else{
			throw new FootException(-5,"此用户没有身份说明");
		}
		height = (int)(Float.parseFloat(heightStr)*100);
		System.out.println("height:"+height);
		FootDAO footDAO = new FootDAOImpl();
		Foot foot = footDAO.findLatsOne(name);
		if(foot==null){
			throw new FootException(-10,"暂时没有步数数据");
		}
		footWraper.setFootNum(foot.getFoot_Number());
		int perStepDis = (height-105)<=20?20:(height-105);
		footWraper.setDistance(perStepDis*foot.getFoot_Number());
		footWraper.setPerStepDis(perStepDis);
		System.out.println("footNum"+foot.getFoot_Number());
		System.out.println("perStepDis:"+perStepDis);
		System.out.println("distance:"+footWraper.getDistance());
		return footWraper;
	}
}
