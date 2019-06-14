import dao.IUserDao;
import domain.User;
import domain.UserVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * Date: 2019/6/13
 * Time: 18:31
 * Author: vincent-Dou
 * Description：
 */
public class TestMain {
    private InputStream resourceAsStream;
    private SqlSession session;
    private IUserDao userDao;
    @Before
    public void before() throws IOException {
        //读取配置文件
        resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建工厂
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = factoryBuilder.build(resourceAsStream);
        //创建session
        session = factory.openSession();
        //创建代理对象
        userDao = session.getMapper(IUserDao.class);
    }
    @After
    public void after() throws IOException {
        session.close();
        resourceAsStream.close();
    }

    /**
     * 插入
     */
    @Test
    public void test1(){
        User user = new User();
        user.setName("gncent");
        user.setPassword("556");
        System.out.println(user);
        userDao.saveUser(user);
        System.out.println(user);
        session.commit();
    }

    /**
     * 查询所有
     */
    @Test
    public void test2(){
        List<User> lists = userDao.findAll();
        for(User u : lists){
            System.out.println(u);
        }
    }
    /**
     * 更新
     */
    @Test
    public void test3(){
        User user = new User();
        user.setId(4);
        user.setPassword("5");
        user.setName("vincent");
        if(user.getId() > userDao.findMaxId()){
            System.out.println("所要更新的不存在");
        }else {
            userDao.updateUser(user);
            session.commit();
        }
    }

    /**
     * 删除
     */
    @Test
    public void test4(){
        userDao.delUser(4);
        session.commit();
    }

    /**
     * 查询
     */
    @Test
    public void test5(){
        System.out.println(userDao.findUserrById(2));
    }

    /**
     * 模糊查询
     */
    @Test
    public void test6(){
        List<User> lists = userDao.findUserByName("%d%");
        for(User u : lists){
            System.out.println(u);
        }
    }


    /**
     * 查询用户总数
     */
    @Test
    public void test7(){
        System.out.println(userDao.countAllUser());
    }

    /**
     *
     */
    @Test
    public void test8(){
        User user = new User();
        user.setName("%dg%");
        UserVo userVo = new UserVo();
        userVo.setUser(user);
        List<User> userList = userDao.userVo(userVo);
        for(User u : userList){
            System.out.println(u);
        }
    }
}
