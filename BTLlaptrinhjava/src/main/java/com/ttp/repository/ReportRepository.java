/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.repository;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.Report;

import java.util.List;

public interface ReportRepository {
    List<Report> getReports();
    boolean addReport(Report report);
}
