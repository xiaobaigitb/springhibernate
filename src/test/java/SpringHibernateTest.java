import com.dao.StudentDao;
import com.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class SpringHibernateTest {

    //使用注解引入hibernateTemplate
    @Autowired
    HibernateTemplate hibernateTemplate;

    //将studentDao注入到spring中
    @Autowired
    StudentDao studentDao;

    @Test
    public void getStudentTest(){
        //调用get方法获取id=1的student对象
        StudentEntity studentEntity = hibernateTemplate.get(StudentEntity.class, 1);
        System.out.println(studentEntity);
    }

    @Test
    public void testAdd(){
        //向数据库中添加一条student对象
        SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();

        //获取session对象
        Session session = sessionFactory.openSession();

        //创建一个student对象
        StudentEntity s1 = new StudentEntity();
        s1.setId(2);
        s1.setName("zhangsan");
        s1.setAge(10);

        //保存--将studentEntity对象持久化到数据库
        session.save(s1);

        //关闭资源
        session.close();

    }

}
