package ru.ipccenter.favortrippals.core.goods.dao;
/**
 *
 * @author Anton
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import ru.ipccenter.favortrippals.core.model.Goods;

public class GoodsDAO implements IGoodsDAO
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
    public void addGoods(Goods goods)
    {
        long id;
        do
        {
            id = UUID.randomUUID().getLeastSignificantBits();
            id *= Long.signum(id);
        }
        while (getGoodsById(id)!=null);
        goods.setId(id);
        getSessionFactory().getCurrentSession().save(goods);
    }
    
    @Override
    public void deleteGoods(Goods goods)
    {
        getSessionFactory().getCurrentSession().delete(goods);
    }
    
    @Override
    public void updateGoods(Goods goods)
    {
        getSessionFactory().getCurrentSession().update(goods);
    }
    
    @Override
    public Goods getGoodsById(long id)
    {
        String query = "from Goods where id=?";
        List list = getSessionFactory().getCurrentSession()
				.createQuery(query)
				.setParameter(0, id)
				.list();
        if(!list.isEmpty())
            return (Goods)list.get(0);
        else return null;
    }
    
    @Override
    public List<Goods> getAllGoods()
    {
        String query = "from Goods";
        List list = getSessionFactory().getCurrentSession()
                    .createQuery(query)
                    .list();
        return list;
    }
    
    @Override
    public List<String> findGoodsByNameBeginning(String query)
    {
        String stringQuery = "select name from Goods where name like :query";
        List list = getSessionFactory().getCurrentSession()
                    .createQuery(stringQuery).setParameter("query", query+"%")
                    .list();
        return list;
    }
    
    @Override
    public Goods getGoodsByName(String name)
    {
        String stringQuery = "from Goods where name=:name";
        Query query = getSessionFactory().getCurrentSession().createQuery(stringQuery);
        query.setParameter("name", name);
        List list = query.list();
        if (list.isEmpty()) return null;
        return (Goods)list.get(0);
    }
    
    @Override
    public Map<String, String> getMapOfCostsByName(String name)
    {
        String query = "select cost from Goods where name=?";
        List list = getSessionFactory().getCurrentSession().createQuery(query)
				.setParameter(0, name).list();
        Map<String, String> map = new HashMap<>();
        if (list.isEmpty()) return map;
        for (Object x : list)
            map.put(x.toString(), x.toString());
        return map;
    }
    
    @Override
    public Map<String, String> getMapOfCurrenciesByNameAndCost(String name, String cost)
    {
        String stringQuery = "select currency from Goods where name=:name and cost=:cost";
        Query query = getSessionFactory().getCurrentSession().createQuery(stringQuery);
        query.setParameter("name", name);
        query.setParameter("cost", Integer.parseInt(cost));
        List list = query.list();
        Map<String, String> map = new HashMap<>();
        if (list.isEmpty()) return map;
        for (Object x : list)
            map.put(x.toString(), x.toString());
        return map;
    }
}
