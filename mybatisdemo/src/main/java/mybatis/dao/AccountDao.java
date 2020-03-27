package mybatis.dao;

import mybatis.domain.Account;
import mybatis.entity.OldNewProp;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountDao {
    @Select("select * from account")
    List<Account> findAll();

    @Update("update Account set money=#{money} where uId=#{uId}")
    void updateAccount(Account account);

    @Update("update Account set uId=#{newVal} where uId=#{oldVal}")
    void updateAccount(OldNewProp oldNewProp);
}
