package mybatis.domain;

import java.util.Objects;

public class Account {
    private Integer id;
    private Integer uId;
    private Double money;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(uId, account.uId) &&
                Objects.equals(money, account.money);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uId, money);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uId=" + uId +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
