package ru.ipccenter.favortrippals.web.managedbeans;
/**
 *
 * @author Anton
 */
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import ru.ipccenter.favortrippals.core.goods.service.IGoodsService;
import ru.ipccenter.favortrippals.core.model.Request;
import ru.ipccenter.favortrippals.core.model.Trip;
import ru.ipccenter.favortrippals.core.model.User;
import ru.ipccenter.favortrippals.core.request.service.IRequestService;
import ru.ipccenter.favortrippals.core.user.service.IUserService;
import ru.ipccenter.favortrippals.core.trip.service.ITripService;

@ManagedBean(name="requestMB")
@RequestScoped
public class RequestMB 
{
    @ManagedProperty(value="#{requestService}")
    IRequestService requestService;
    @ManagedProperty(value="#{userService}")
    IUserService userService;
    @ManagedProperty(value="#{goodsService}")
    IGoodsService goodsService;
    @ManagedProperty(value="#{tripService}")
    ITripService tripService;
    
    private int count;
    
    public IRequestService getRequestService() 
    {
        return requestService;
    }

    public void setRequestService(IRequestService requestService) 
    {
        this.requestService = requestService;
    }
    
    public IUserService getUserService() 
    {
        return userService;
    }

    public void setUserService(IUserService userService) 
    {
        this.userService = userService;
    }
    
    public IGoodsService getGoodsService() 
    {
        return goodsService;
    }

    public void setGoodsService(IGoodsService goodsService) 
    {
        this.goodsService = goodsService;
    }
    
    public ITripService getTripService() 
    {
        return tripService;
    }

    public void setTripService(ITripService tripService) 
    {
        this.tripService = tripService;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public void setCount(int count)
    {
        this.count = count;
    }
    
    public List<Request> getRequests()
    {
        return getRequestService().getAllRequestsByCustomer(
                getUserService().getCurrentUser());
    }
    
    public List<Request> getAllRequestsByTrip(Trip trip)
    {
        return getRequestService().getAllRequestsByTrip(trip);
    }
    
    public List<Request> getAllRequestsByCurrentUser()
    {
        return new ArrayList<>();
    }
}
