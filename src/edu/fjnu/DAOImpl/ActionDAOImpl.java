package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.ActionDAO;
import edu.fjnu.Entity.Usual.Action;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ActionDAOImpl implements ActionDAO {
    private QueryRunner qr = new QueryRunnerWrapper();

    @Override
    public List<Action> queryAll() throws SQLException {
        String sql = "select * from action";
        return qr.query(sql, new BeanListHandler<Action>(Action.class));
    }

}
