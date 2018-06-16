package Dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StapleDao extends GetSession {
    public List list(int ID)
    {
        String hql = "from StapleEntity staple where staple.id = ? ";
        return getSession().createQuery(hql).setParameter(0,ID).list();
    }
}
