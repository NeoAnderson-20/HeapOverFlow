import dao.UserMapper;
import myBatisTest.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.MyBatisUtils;

import java.util.List;
import org.springframework.context.*;

public class mTest {

    @Test
    public void test01(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user.toString());

        }


    }


    @Test
    public void test02(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getByname("zyh01");
        System.out.println(user.toString());
    }

    @Test
    public void test03(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.addUser(new User("Taylor", "12"));
        sqlSession.commit();   //事务(增删改查)一定要提交
        System.out.println(result);
        sqlSession.close();

    }

    @Test
    public  void  test04(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int taylor = mapper.update(new User("Taylor", "2020"));
        sqlSession.commit();
        System.out.println(taylor);
        sqlSession.close();

    }

    @Test
    public void test05(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int del = mapper.del("zyh01");
        sqlSession.commit();
        System.out.println(del);
        sqlSession.close();
    }

    @Test
    public  void test06(){
        String config = "ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        String[] names = applicationContext.getBeanDefinitionNames();  //容器中的对象
        for (String name : names) {
            //System.out.println(name+applicationContext.getBean(name));

        }

        UserMapper user = (UserMapper) applicationContext.getBean("userMapper");  //类名的首字母小写形式
        User user1 = new User("Swift","August");
        int result = user.addUser(user1);
        System.out.println(result);



    }

}
