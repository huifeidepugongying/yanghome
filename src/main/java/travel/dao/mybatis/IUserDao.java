package travel.dao.mybatis;

import org.apache.ibatis.annotations.Select;
import travel.domain.mybatis.User;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
}
