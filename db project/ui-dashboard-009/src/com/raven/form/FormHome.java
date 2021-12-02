package com.raven.form;

import com.raven.cell.CellAction;
import com.raven.cell.CellAddress;
import com.raven.cell.CellAge;
import com.raven.cell.CellGender;
import com.raven.cell.CellName;
import com.raven.cell.CellTel;
import com.raven.chart.ModelChart;
import com.raven.model.ModelName;
import com.raven.model.ModelStaff;
import com.raven.service.ServiceReport;
import com.raven.service.ServiceStaff;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;

public class FormHome extends javax.swing.JPanel {

    public FormHome() {
        initComponents();
        setOpaque(false);
        table1.addTableStyle(jScrollPane1);
        init();
        initDataTable();
    }

    private void init() {
        chart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        chart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        try {
            List<ModelChart> datas = new ServiceReport().getData();
            for (int i = datas.size() - 1; i >= 0; i--) {
                chart.addData(datas.get(i));
            }
            chart.start();
        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    private void initDataTable() {
        table1.addTableCell(new CellName(), 0);
        table1.addTableCell(new CellGender(), 1);
        table1.addTableCell(new CellAge(), 2);
        table1.addTableCell(new CellAddress(), 3);
        table1.addTableCell(new CellTel(), 4);
        table1.addTableCell(new CellAction(), 5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (ModelStaff staff : new ServiceStaff().getStaff()) {
                        table1.addRow(staff, false);
                    }
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        chart = new com.raven.chart.CurveChart();
        roundPanel2 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.Table();
        cmdAddNew = new com.raven.swing.Button();

        roundPanel1.setBackground(new java.awt.Color(60, 60, 60));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel2.setBackground(new java.awt.Color(60, 60, 60));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Gender", "Age", "Email", "Tel", "Action"
            }
        ));
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setPreferredWidth(200);
            table1.getColumnModel().getColumn(4).setPreferredWidth(50);
            table1.getColumnModel().getColumn(5).setMinWidth(75);
            table1.getColumnModel().getColumn(5).setPreferredWidth(75);
            table1.getColumnModel().getColumn(5).setMaxWidth(75);
        }

        cmdAddNew.setForeground(new java.awt.Color(200, 200, 200));
        cmdAddNew.setText("+ Add New");
        cmdAddNew.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        cmdAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(cmdAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddNewActionPerformed
        table1.insertRowWithEdit(new ModelStaff(0, new ModelName("", "", null, ""), "Male", 0, "", ""), 0, true);
    }//GEN-LAST:event_cmdAddNewActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.chart.CurveChart chart;
    private com.raven.swing.Button cmdAddNew;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
