/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.pojos;

/**
 *
 * @author Hau Exoty
 */
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "typereport")
public class TypeReport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type")
    private String name;

    public TypeReport() {
    }

    public TypeReport(Integer id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the type to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
