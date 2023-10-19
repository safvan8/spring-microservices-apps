package com.safvan.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.safvan.model.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {
    
	private String KEY = "STUDENT";
	
	
	@Resource(name="rt")
	private HashOperations<String, Integer, Student> opr;
	
	@Override
	public void addStudent(Student s) {
		
		//create new record in HashMemory if given id not exist
		
		opr.putIfAbsent(KEY, s.getStdId(), s);
	}

	@Override
	public void modifyStudent(Student s) {
	 //update record with given id
		opr.put(KEY, s.getStdId(), s);
		
	}

	@Override
	public Student getOneStudent(Integer id) {

		return opr.get(KEY, id);
	}

	@Override
	public Map<Integer, Student> getAllStudent() {
		
		return opr.entries(KEY);
	}

	@Override
	public void removeStudent(Integer id) {

		opr.delete(KEY, id);
	}

}
