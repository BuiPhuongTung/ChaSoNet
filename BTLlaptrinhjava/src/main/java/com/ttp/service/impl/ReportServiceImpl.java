/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.service.impl;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.Report;
import com.ttp.repository.ReportRepository;
import com.ttp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired private ReportRepository reportRepository;

    @Override
    public List<Report> getReports() {
        return this.reportRepository.getReports();
    }

    @Override
    public boolean addReport(Report report) {
        return this.reportRepository.addReport(report);
    }
}
