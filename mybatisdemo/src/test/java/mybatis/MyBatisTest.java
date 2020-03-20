package mybatis;

import mybatis.dao.AccountDao;
import mybatis.dao.UserDao;
import mybatis.dao.impl.UserDaoImpl;
import mybatis.domain.Account;
import mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class MyBatisTest {
    InputStream config=null;
    SqlSession session = null;
    UserDao userDao = null;
    AccountDao accountDao=null;

    @Before
    public void init() throws Exception {
        config = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(config);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
//        accountDao = session.getMapper(AccountDao.class);
    }

    @Test
    public void userFindAll() {
        List<User> userList = userDao.findAll();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }

    public void after() throws IOException {
        config.close();
        session.close();
    }

    @Test
    public void accountFindAll() {
        List<Account> accountList = accountDao.findAll();
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println(accountList.get(i));
        }
    }

    @Test
    public void userFindOne(){
        UserDao proxy= (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理执行了");
                System.out.println(userDao.getClass().getInterfaces().toString());
                return method.invoke(userDao, args);
            }
        });

        User one = proxy.findOne(43);
        System.out.println(one);
    }
}
