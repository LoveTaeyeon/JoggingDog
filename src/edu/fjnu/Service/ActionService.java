package edu.fjnu.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fjnu.DAO.ActionDAO;
import edu.fjnu.DAOImpl.ActionDAOImpl;
import edu.fjnu.Entity.Usual.Action;

public class ActionService {
	private ActionDAO actionDAO = new ActionDAOImpl();
	public Map<String,List<Action>> findAll(){
		try {
			List<Action> action_list = actionDAO.queryAll();
			Map<String,List<Action>> map = new HashMap<>();
			for(Action action:action_list){
				List<Action> actions = map.get(action.getAction_type());
				if(actions == null){
					actions = new ArrayList<>();
					map.put(action.getAction_type(), actions);
					actions.add(action);
				}else{
					actions.add(action);
				}
			}
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
