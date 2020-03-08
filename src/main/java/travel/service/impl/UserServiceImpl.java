package travel.service.impl;

import travel.dao.UserDao;
import travel.dao.impl.UserDaoImpl;
import travel.domain.User;
import travel.service.UserService;


/**
 * 用户信息
 */
public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();

    @Override
    public boolean userIsExist(String name) {
        return dao.userIsExist(name);
    }

    @Override
    public boolean saveUser(User user) {
        return dao.saveUser(user);
    }

    @Override
    public User getUser(String userName, String password) {
        return dao.getUser(userName,password);
    }
}
