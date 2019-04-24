package com.sonnh.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.sonnh.model.Account;

@Repository
public class AccountDAOImp implements AccountDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BigDecimal getCurrentAmount(int id) {
		String sql = "select amount from account where id= " + id;
		return jdbcTemplate.query(sql, new ResultSetExtractor<BigDecimal>() {
			@Override
			public BigDecimal extractData(ResultSet rs) throws SQLException, DataAccessException {
				BigDecimal amount = null;
				while (rs.next()) {
					amount = rs.getBigDecimal("amount");
				}
				return amount;
			}
		});
	}

	@Override
	public void updateAmount(int id, BigDecimal amount) {
		String sql = String.format("update account set amount=%f where id=%d", amount, id);
		jdbcTemplate.execute(sql);
	}

	@Override
	public List<Account> getAllAccount() {
		String sql = "select * from account";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Account>>() {

			@Override
			public List<Account> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Account> list = new ArrayList<>();
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					BigDecimal amount = rs.getBigDecimal(3);
					list.add(new Account(id, name, amount));
				}
				return list;
			}
			
		});
	}

}
