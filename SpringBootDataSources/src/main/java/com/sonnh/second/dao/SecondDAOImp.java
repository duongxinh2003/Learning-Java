package com.sonnh.second.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.sonnh.second.entity.Second;

@Repository
public class SecondDAOImp implements SecondDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Second> getAllFirst() {
		String sql = "select * from mytestdb.second";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Second>>() {

			@Override
			public List<Second> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Second> list = new ArrayList<>();
				while (rs.next()) {
					Long id = rs.getLong(1);
					String name = rs.getString(2);
					list.add(new Second(id, name));
				}
				return list;
			}
			
		});
	}

}
