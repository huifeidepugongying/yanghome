package travel.service;

import travel.domain.User;

public interface UserService {
    boolean userIsExist(String name);

    boolean saveUser(User user);

    User getUser(String userName, String password);
}
