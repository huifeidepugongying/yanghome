package travel.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import travel.dao.UserDao;
import travel.domain.User;
import travel.util.JdbcUtils;
import travel.util.StringUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public boolean userIsExist(String name) {
        if (name == null) return false;
        try {
            long count = jdbcTemplate.queryForObject("select count(1) from tab_user where username=?", long.class, name);
            if (count == 0) return false;
        } catch (Exception e) {
            String message = e.getMessage();
        }

        return true;
    }

    @Override
    public boolean saveUser(User user) {
        if (user == null) return false;
        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)";
        //2.执行sql

        int count = jdbcTemplate.update(sql, user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
        );
        return count > 0;
    }

    @Override
    public User getUser(String userName, String password) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) return null;
        List<User> userList = jdbcTemplate.query("select * from tab_user where username=? and password=?", new BeanPropertyRowMapper<User>(User.class), userName, password);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }
}
