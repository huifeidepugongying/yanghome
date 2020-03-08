package travel.dao;

import travel.domain.User;

public interface UserDao {
    boolean userIsExist(String name);

    boolean saveUser(User user);

    User getUser(String userName, String password);
}
