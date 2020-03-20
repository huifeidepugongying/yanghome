package mybatis.dao;

import mybatis.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    User findOne(Integer id);
}
