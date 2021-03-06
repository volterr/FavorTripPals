package ru.ipccenter.favortrippals.core.model;
/**
 *
 * @author Anton
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GOODS")
public class Goods implements Serializable
{
    private long id;
    private String name;
    private String description;
    private String location;
    
    @Id
    @Column(name="ID", unique = true, nullable = false)
    public long getId()
    {
        return id;
    }
    
    @Column(name="NAME", unique = false, nullable = true)
    public String getName()
    {
        return name;
    }
    
    @Column(name="DESCRIPTION", unique = false, nullable = true)
    public String getDescription()
    {
        return description;
    }
    
    @Column(name="LOCATION", unique = false, nullable = true)
    public String getLocation()
    {
        return location;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    @Override
    public String toString()
    {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("id : ").append(getId());
        strBuff.append(", name : ").append(getName());
        strBuff.append(", description : ").append(getDescription());
        strBuff.append(", location : ").append(getLocation());
        return strBuff.toString();
    }
}