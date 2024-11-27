package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DAO {

	@Autowired
	private JdbcTemplate jt;

//	@Transactional
	public void insert(Student s) {
		String qry = "insert into spring values(?,?,?)";
		jt.update(qry, s.getId(), s.getName(), s.getSalary());
		System.out.println("Inserted");
	}
	
	public void update(Student s) {
		String qry="update spring set salary=?  where id=?";
		jt.update(qry,s.getSalary(),s.getId());
		System.out.println("Updated");
	}
	
	public void delete(Student s) {
		String qry="delete from spring where id=?";
		jt.update(qry, s.getId());
		System.out.println("Deleted");
	}
	
	public List<Student> getAllDetails(String table) {
		String qry = "select * from "+table;
		return jt.query(qry, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setSalary(rs.getDouble(3));
				return s;
			}
		});
	}
}
