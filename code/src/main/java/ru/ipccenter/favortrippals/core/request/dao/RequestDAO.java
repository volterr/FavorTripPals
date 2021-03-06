package ru.ipccenter.favortrippals.core.request.dao;
/**
 *
 * @author Anton
 */
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import ru.ipccenter.favortrippals.core.model.Goods;
import ru.ipccenter.favortrippals.core.model.Request;
import ru.ipccenter.favortrippals.core.model.User;
import ru.ipccenter.favortrippals.core.model.Trip;

public class RequestDAO implements IRequestDAO
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
    public void addRequest(Request request)
    {
        getSessionFactory().getCurrentSession().save(request);
    }
    
    @Override
    public void deleteRequest(Request request)
    {
        getSessionFactory().getCurrentSession().delete(request);
    }
    
    @Override
    public void updateRequest(Request request)
    {
        getSessionFactory().getCurrentSession().update(request);
    }
    
    @Override
    public List<Request> getAllRequestsByCustomer(User customer)
    {
        String query = "from Request where customer=? and status!='deleted'";
        List list = getSessionFactory().getCurrentSession().createQuery(query)
				.setParameter(0, customer).list();
        return (List<Request>)list;
    }
    
    @Override
    public List<Request> getAllRequestsByTrip(Trip trip)
    {
        String query = "from Request where trip=? and status!='deleted'";
        List list = getSessionFactory().getCurrentSession().createQuery(query)
				.setParameter(0, trip).list();
        return (List<Request>)list;
    }
    
    @Override
    public List<Request> getAllRequestsByGoods(Goods goods)
    {
        String query = "from Request where goods=? and status!='deleted'";
        List list = getSessionFactory().getCurrentSession().createQuery(query)
				.setParameter(0, goods).list();
        return (List<Request>)list;
    }
    
    @Override
    public Request getRequestByAllIds(User customer, Trip trip, Goods goods)
    {
        String stringQuery = "from Request where customer=:customer and trip=:trip and goods=:goods";
        Query query = getSessionFactory().getCurrentSession().createQuery(stringQuery);
        query.setParameter("customer", customer);
        query.setParameter("trip", trip);
        query.setParameter("goods", goods);
        List list = query.list();
        if (list.isEmpty())
            return null;
        return (Request)list.get(0);
    }
    
    @Override
    public List<Request> getAllRequestsByUser(User user)
    {
        String stringQuery = "from Request where trip.traveller=:traveller or customer=:customer";
        Query query = getSessionFactory().getCurrentSession().createQuery(stringQuery);
        query.setParameter("customer", user);
        query.setParameter("traveller", user);
        List list = query.list();
        return (List<Request>)list;
    }
    
    @Override
    public List<Request> getAllRequestsByTraveller(User traveller)
    {
        String query = "from Request where trip.traveller=? and status!='deleted'";
        List list = getSessionFactory().getCurrentSession().createQuery(query)
				.setParameter(0, traveller).list();
        return (List<Request>)list;
    }
}
