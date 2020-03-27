package mybatis;

import mybatis.dao.AccountDao;
import mybatis.dao.UserDao;
import mybatis.domain.Account;
import mybatis.entity.OldNewProp;
import mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class MyBatisTest {
    InputStream config = null;
    SqlSession session = null;
    UserDao userDao = null;
    AccountDao accountDao = null;

    @Before
    public void init() throws Exception {
        config = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(config);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
        accountDao = session.getMapper(AccountDao.class);
    }

    @Test
    public void userFindAll() {
        List<User> userList = userDao.findAll();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
            if (userList.get(i).getAccountList() != null) {
                for (int j = 0; j < userList.get(i).getAccountList().size(); j++) {
                    System.out.println(userList.get(i).getAccountList().get(j));
                }
            }
        }

    }

    @After
    public void after() throws IOException {
        session.commit();
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
    public void updateAccount(){
        Account account=new Account();
        account.setuId(45);
        account.setMoney(2300.0);
        accountDao.updateAccount(account);
    }

    @Test
    public void updateAccountNew(){
        OldNewProp oldNewProp=new OldNewProp();
        oldNewProp.setNewVal(46);
        oldNewProp.setOldVal(45);
        accountDao.updateAccount(oldNewProp);
    }

    @Test
    public void userFindOne() {
        UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {
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
