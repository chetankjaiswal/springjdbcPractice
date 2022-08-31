package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
         System.out.println( "programm started,..............." );
//        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
          ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class); 
//        JdbcTemplate jdbcTemplate=context.getBean("jdbcTemplate",JdbcTemplate.class);
        
//        String q="insert into student(id,name,city)values(?,?,?)";
//        int result=jdbcTemplate.update(q,711,"Rupesh","Kumathi");
//        System.out.println("row inserted "+result);
        
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        
        //insert into DB
        Student student=new Student();
        student.setId(113);
        student.setName("abhi");
        student.setCity("Kanpur");
        int result = studentDao.insert(student);
        System.out.println("student added "+result);
//        
        //update in DB
//         Student student= new Student();
//         student.setId(111);
//         student.setName("Lokesh");
//         student.setCity("khandwa");
//         int r=studentDao.change(student);
//         System.out.println("changed students "+r);
        
        //delete from DB
//        int r=studentDao.delete(245);
//        System.out.println("Delete record "+r);
        
        //select single objecg from database
        
//        Student student = studentDao.getStudent(709);
//        System.out.println(student);
         
         List<Student> allStudents = studentDao.getAllStudents();
         for(Student students:allStudents)
         {
        	 System.out.println(students);
         }
    }
}
