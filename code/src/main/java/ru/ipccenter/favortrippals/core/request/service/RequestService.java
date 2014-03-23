package ru.ipccenter.favortrippals.core.request.service;
/**
 *
 * @author Anton
 */
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import ru.ipccenter.favortrippals.core.model.Goods;
import ru.ipccenter.favortrippals.core.model.Request;
import ru.ipccenter.favortrippals.core.model.User;
import ru.ipccenter.favortrippals.core.model.Trip;
import ru.ipccenter.favortrippals.core.request.dao.IRequestDAO;

public class RequestService implements IRequestService
{
    Request currentRequest;
    IRequestDAO requestDAO;
    
    public IRequestDAO getRequestDAO ()
    {
        return requestDAO;
    }

    public void setRequestDAO (IRequestDAO requestDAO)
    {
        this.requestDAO = requestDAO;
    }
    
    @Override
    public Request getCurrentRequest()
    {
        return currentRequest;
    }
    
    @Override
    public void setCurrentRequest(Request currentRequest)
    {
        this.currentRequest = currentRequest;
    }
    
    @Transactional
    @Override
    public void addRequest(Request request)
    {
        getRequestDAO().addRequest(request);
    }
    
    @Transactional
    @Override
    public void deleteRequest(Request request)
    {
        getRequestDAO().deleteRequest(request);
    }
    
    @Transactional
    @Override
    public void updateRequest(Request request)
    {
        getRequestDAO().updateRequest(request);
    }
    
    @Override
    public List<Request> getAllRequestsByCustomer(User customer)
    {
        return getRequestDAO().getAllRequestsByCustomer(customer);        
    }
    
    @Override
    public List<Request> getAllRequestsByTrip(Trip trip)
    {
        return getRequestDAO().getAllRequestsByTrip(trip);
    }
    
    @Override
    public List<Request> getAllRequestsByGoods(Goods goods)
    {
        return getRequestDAO().getAllRequestsByGoods(goods);
    }
}