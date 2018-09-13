package com.dao;

import com.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

//仓库--标注dao层
@Repository
public class StudentDao {

    @Autowired
    HibernateTemplate hibernateTemplate;

    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        dao.getStudent(1);
    }

    public StudentEntity getStudent(int id){
        StudentEntity studentEntity = hibernateTemplate.get(StudentEntity.class, id);
        return studentEntity;
    }
}
