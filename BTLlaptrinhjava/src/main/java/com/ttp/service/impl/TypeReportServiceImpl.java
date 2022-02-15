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
import com.ttp.pojos.TypeReport;
import com.ttp.repository.TypeReportRepository;
import com.ttp.service.TypeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeReportServiceImpl implements TypeReportService {
    @Autowired private TypeReportRepository typeReportRepository;

    @Override
    public List<TypeReport> getTypeReports() {
        return this.typeReportRepository.getTypeReports();
    }

    @Override
    public boolean addTypeReport(TypeReport typeReport) {
        return this.typeReportRepository.addTypeReport(typeReport);
    }

    @Override
    public TypeReport getTypeReportById(Integer id) {
        return this.typeReportRepository.getTypeReportById(id);
    }
}
