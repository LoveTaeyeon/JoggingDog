package edu.fjnu.Service;

import edu.fjnu.DAO.HealthPassageDAO;
import edu.fjnu.DAOImpl.HealthPassageDAOImpl;
import edu.fjnu.Entity.Usual.HealthPassage;
import edu.fjnu.exception.HealthPassageException;
import edu.fjnu.webCrawlers.main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ven_hxz on 16/4/4.
 * 首页健康信息业务处理
 */
public class HealthPassageService {
    private HealthPassageDAO healthPassageDAO = new HealthPassageDAOImpl();

    private static final String PASSAGE_1 = "passage1";

    private static final String PASSAGE_2 = "passage2";

    private static final String PASSAGE_3 = "passage3";

    /**
     * 根据配置文件的文章ID获取首页的健康信息文章
     *
     * @return 首页的健康信息文章
     * @throws HealthPassageException
     */
    public Map<String, HealthPassage> getIndexHealthPassage() throws HealthPassageException {
        Map<String, HealthPassage> healthPassageMap = new HashMap<>();
        Properties props = new Properties();
        InputStream input = getClass().getResourceAsStream("health_config.properties");
        try {
            props.load(input);

            healthPassageMap.put("left",
                    healthPassageDAO.queryById(props.getProperty(PASSAGE_1)));
            healthPassageMap.put("right1",
                    healthPassageDAO.queryById(props.getProperty(PASSAGE_2)));
            healthPassageMap.put("right2",
                    healthPassageDAO.queryById(props.getProperty(PASSAGE_3)));
        } catch (IOException e) {
            throw new HealthPassageException("读取首页的健康信息配置文件失败," + e.getMessage());
        } catch (SQLException e) {
            throw new HealthPassageException("查询首页健康信息失败," + e.getMessage());
        }
        return healthPassageMap;
    }  
    
    
    public HealthPassage getHealthPassageByNumber(String id) throws SQLException{
    	return healthPassageDAO.queryById(id);
    }
    
    
}
