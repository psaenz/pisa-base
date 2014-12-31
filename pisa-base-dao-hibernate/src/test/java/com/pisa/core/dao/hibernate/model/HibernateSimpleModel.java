package com.pisa.core.dao.hibernate.model;

/**
 * Simple POJO in order to check if PisaHibernate Framework works with
 * entities non-based on the PisaModel Framework.
 * 
 * @author PISA
 */

public class HibernateSimpleModel {
    
    private Integer id;
    private String title;

    public HibernateSimpleModel(){
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}