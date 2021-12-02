package com.raven.service;

import com.raven.chart.ModelChart;
import com.raven.connection.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceReport {

    public List<ModelChart> getData() throws SQLException {
        List<ModelChart> list = new ArrayList<>();
        String sql = "select DATE_FORMAT(Date,'%M') as M, SUM(Total) as Total, SUM(Cost) as Cost, SUM(Profit) as Profit from invoice GROUP BY DATE_FORMAT(Date,'%Y-%M') order by Date DESC limit 6";
        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            String month = r.getString(1);
            double total = r.getDouble(2);
            double cost = r.getDouble(3);
            double profit = r.getDouble(4);
            list.add(new ModelChart(month, new double[]{total, cost, profit}));
        }
        r.close();
        p.close();
        return list;
    }
}
