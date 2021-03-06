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
import java.util.Date;
import java.util.List;

public interface StatsRepository {
    List<Object[]> categoryStats();
    List<Object[]> statusAuction();
    List<Long> overviewStats(Date fromDate, Date toDate);
    List<Object[]> postStats(String kw, Date fromDate, Date toDate);
    List<Object[]> auctionStats(Integer categoryId, Date fromDate, Date toDate);
}
