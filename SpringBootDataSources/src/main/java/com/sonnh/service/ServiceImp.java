package com.sonnh.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


@Service
public class ServiceImp implements MyService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Object> joinByID() {
		String sql = "select * from user.first f join mytestdb.second s on f.id = s.stt";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Object>>() {

			@Override
			public List<Object> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Object> list = new ArrayList<>();
				while (rs.next()) {
					Long id = rs.getLong(1);
					String name = rs.getString(2);
					list.add(new Object());
				}
				return list;
			}
			
		});
	}

}
