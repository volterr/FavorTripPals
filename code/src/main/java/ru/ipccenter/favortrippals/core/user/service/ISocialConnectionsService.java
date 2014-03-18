package ru.ipccenter.favortrippals.core.user.service;

import java.util.List;
import ru.ipccenter.favortrippals.core.model.SocialConnections;
import ru.ipccenter.favortrippals.core.model.User;

/**
 * @author Ddiimmaann
 */
public interface ISocialConnectionsService
{
    public void addConnection (SocialConnections connection);
    public void deleteConnection (SocialConnections connection);
    /**
     * @param userId
     * @param networkType
     * Use constants in SocialConnections
     * @return 
     */
    public SocialConnections getConnectionByUserAndType (User user, int networkType);
    public List<SocialConnections> getAllConnectionsByUser (User user);
}