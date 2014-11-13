package com.tanwar.classcourt.dwr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tanwar.classcourt.bo.ClassBO;
import com.tanwar.classcourt.dwr.db.ConnectionManager;
import com.tanwar.classcourt.service.ClassService;

public class DWRService {

	public DWRService() {
	}
	
	private ClassService classService;
	
	@Autowired
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}


	public Map<String, String> getAllClassMap(String boardId) {
		System.out.println("dwr:: getAllClassMap: "+boardId);
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "Please select Class");
		Connection conn = null;

        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement s = conn.prepareStatement("select class_id, class_name from class_master where board_id=? order by class_id");
            s.setInt(1, Integer.parseInt(boardId));

            ResultSet rs = s.executeQuery();

            while (rs.next()) {
            	map.put(String.valueOf(rs.getInt(1)), rs.getString(2));
            }

            System.out.println("getAllClassMap:: " + map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionManager.dropConnection(conn);
            } catch (Exception fe) {
            }
        }
		
		return map;
		

	}
	
	
	
}
