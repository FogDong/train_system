package Dao;

import bean.LoginEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//定义为Bean
public class LoginDao extends GetSession {
    //写Hql语句

    public void add(String username, String password,String phone) {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUsername(username);
        loginEntity.setPassword(password);
        loginEntity.setPhone(phone);
        getSession().save(loginEntity);
    }

    public void delete(String username) {
        String hql = "delete from LoginEntity login  where login.username = ?";
        getSession().createQuery(hql).setParameter(0, username).executeUpdate();

    }

    public void update(String username, String password) {
        String hql = "update LoginEntity login set login.password = ? where login.username = ?";
        getSession().createQuery(hql).setParameter(0, password).setParameter(1, username).executeUpdate();
    }

    public String Seach(String username) {
        String hql = "select login.password from LoginEntity login where login.username = ?";
        return (String) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
    }

    public List list(String username)
    {
        String hql = "from LoginEntity login where login.username=?";
        return getSession().createQuery(hql).setParameter(0,username).list();
    }

}
