/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpt.pojos;

<<<<<<< HEAD
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
=======
>>>>>>> 5c94eeab34c013143e389724a13a23c8cf297888
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
<<<<<<< HEAD
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
=======

/**
 *
 * @author ACER
 */
@Entity
@Table(name ="comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
>>>>>>> 5c94eeab34c013143e389724a13a23c8cf297888
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
<<<<<<< HEAD
     * @param content the content to set
=======
     * @param conten the content to set
>>>>>>> 5c94eeab34c013143e389724a13a23c8cf297888
     */
    public void setContent(String content) {
        this.content = content;
    }

<<<<<<< HEAD
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
    
    
=======
>>>>>>> 5c94eeab34c013143e389724a13a23c8cf297888
}
