package travel.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import travel.dao.mybatis.IUserDao;
import travel.domain.mybatis.User;

import java.io.InputStream;
import java.util.List;

public class MybatisUtil {
    public static void xmlWay()
    {
        try {
            InputStream is = Resources.getResourceAsStream("db.config/SqlMapperConfig.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession session = factory.openSession();

            IUserDao userDao = session.getMapper(IUserDao.class);
            List<User> userList = userDao.findAll();
            for (int i = 0; i < userList.size(); i++) {
                System.out.println(userList.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void nodeWay()
    {
        try {
            InputStream is = Resources.getResourceAsStream("db.config/SqlMapperConfig.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession session = factory.openSession();
            IUserDao userDao = session.getMapper(IUserDao.class);
            List<User> userList = userDao.findAll();
            for (int i = 0; i < userList.size(); i++) {
                System.out.println(userList.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
