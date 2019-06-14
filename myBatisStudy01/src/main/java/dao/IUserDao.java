package dao;

import domain.User;
import domain.UserVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Date: 2019/6/13
 * Time: 18:16
 * Author: vincent-Dou
 * Description：
 */
public interface IUserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    int findMaxId();
    void delUser(int id);
    User findUserrById(int id);
    List<User> findUserByName(String name);
    int countAllUser();
    List<User> userVo(UserVo userVo);
}
