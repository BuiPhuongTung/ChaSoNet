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
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "report")
public class Report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "typereport_id", referencedColumnName = "id")
    private TypeReport typeReport;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_report", referencedColumnName = "id")
    private User userReport;

    @Transient
    private String typeReportId;
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
     * @return the typeReport
     */
    public TypeReport getTypeReport() {
        return typeReport;
    }

    /**
     * @param typeReport the typeReport to set
     */
    public void setTypeReport(TypeReport typeReport) {
        this.typeReport = typeReport;
    }

    /**
     * @return the createAt
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * @param createAt the createAt to set
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the userReport
     */
    public User getUserReport() {
        return userReport;
    }

    /**
     * @param userReport the userReport to set
     */
    public void setUserReport(User userReport) {
        this.userReport = userReport;
    }

    public String getTypeReportId() {
        return typeReportId;
    }

    public void setTypeReportId(String typeReportId) {
        this.typeReportId = typeReportId;
    }
}
