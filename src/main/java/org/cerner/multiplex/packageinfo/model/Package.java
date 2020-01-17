package org.cerner.multiplex.packageinfo.model;

import java.util.List;

public class Package {
    private int id;
    private String name;
    private String description;
    private String type;
    private String price;
    private List<String> procedures;
    private int hospitalId;

    public int getHospitalId()
    {
        return hospitalId;
    }
    public void setHospitalId(int hospitalId)
    {
        this.hospitalId = hospitalId;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getPrice()
    {
        return price;
    }
    public void setPrice(String price)
    {
        this.price = price;
    }
    public List<String> getProcedures()
    {
        return procedures;
    }
    public void setProcedures(List<String> procedures)
    {
        this.procedures = procedures;
    }

}
