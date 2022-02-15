/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.controllers;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.Report;
import com.ttp.pojos.TypeReport;
import com.ttp.pojos.User;
import com.ttp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ApiReportController {
    @Autowired private ReportService reportService;

    @PostMapping(value = "/api/add-report/{userReportId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus addReport(@RequestBody Report report, @PathVariable Integer userReportId,
                                HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        report.setUser(user);
        report.setUserReport(new User(userReportId));
        report.setTypeReport(new TypeReport(Integer.parseInt(report.getTypeReportId())));

        if (this.reportService.addReport(report)==false) return HttpStatus.BAD_REQUEST;

        return  HttpStatus.OK;
    }
}
