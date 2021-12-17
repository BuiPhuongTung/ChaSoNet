/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpt.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Hau Exoty
 */
@Entity
@Table(name = "comments")
public class Comments implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    @Column(name = "content")
    private String content;
    @Column(name = "createdCmt")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdCmt;

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the createdCmt
     */
    public Date getCreatedCmt() {
        return createdCmt;
    }

    /**
     * @param createdCmt the createdCmt to set
     */
    public void setCreatedCmt(Date createdCmt) {
        this.createdCmt = createdCmt;
    }
    
    
}
