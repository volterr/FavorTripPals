package ru.ipccenter.favortrippals.core.socialconnection.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import ru.ipccenter.favortrippals.core.model.SocialConnection;
import ru.ipccenter.favortrippals.core.model.User;

/**
 * @author Ddiimmaann
 */
public class SocialConnectionDAO implements ISocialConnectionDAO
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addConnection(SocialConnection connection)
    {
        getSessionFactory().getCurrentSession().save(connection);
    }

    @Override
    public void deleteConnection(SocialConnection connection)
    {
        getSessionFactory().getCurrentSession().delete(connection);
    }

    @Override
    public SocialConnection getConnectionByUserAndType(User user, int networkType) {
        String stringQuery = "from SocialConnection where user=:user and networkType=:type";
        Query query = getSessionFactory().getCurrentSession().createQuery(stringQuery);
        query.setParameter("user", user);
        query.setInteger("type", networkType);
        List list = query.list();
        if (list.isEmpty())
            return null;
        return (SocialConnection)list.get(0);
    }

    @Override
    public List<SocialConnection> getAllConnectionsByUser(User user) {
        String query = "from SocialConnection where user=?";
        List list = getSessionFactory().getCurrentSession().createQuery(query)
				.setParameter(0, user.getId()).list();
        return (List<SocialConnection>)list;
    }
    
}