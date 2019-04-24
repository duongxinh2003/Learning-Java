package com.sonnh.first.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.sonnh.first.entity.First;

@Repository
public class FirstDAOImp implements FirstDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<First> getAllFirst() {
		String sql = "select * from user.first";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<First>>() {

			@Override
			public List<First> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<First> list = new ArrayList<>();
				while (rs.next()) {
					Long id = rs.getLong(1);
					String name = rs.getString(2);
					list.add(new First(id, name));
				}
				return list;
			}
			
		});
	}

}
