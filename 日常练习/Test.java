import bean.User;
import dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Date: 2019/6/13
 * Time: 16:15
 * Author: vincent-Dou
 * Description：
 */
public class Test {

    @org.junit.Test
    public void test() throws IOException {
        //1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("MyBatis.xml");
        //2. 创建工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(in);
        //3. 使用工厂生产Sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //4. 使用Sqlsession创建Dao接口的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //5. 使用代理对象执行方法
        List<User> uses = userDao.selectAll();
        for(User user : uses){
            System.out.println(user);
        }
        //6. 释放资源
        sqlSession.close();
        in.close();
    }
}
