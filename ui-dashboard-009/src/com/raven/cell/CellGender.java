package com.raven.cell;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

public class CellGender extends TableCustomCell {

    public CellGender() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jrMale = new javax.swing.JRadioButton();
        jrFemale = new javax.swing.JRadioButton();

        jLabel1.setForeground(new java.awt.Color(200, 200, 200));
        jLabel1.setText("Gender");

        group.add(jrMale);
        jrMale.setForeground(new java.awt.Color(200, 200, 200));
        jrMale.setSelected(true);
        jrMale.setText("Male");

        group.add(jrFemale);
        jrFemale.setForeground(new java.awt.Color(200, 200, 200));
        jrFemale.setText("Female");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrMale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrFemale)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrMale, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setData(Object o) {
        if (o.toString().equals("Male")) {
            jrMale.setSelected(true);
        } else {
            jrFemale.setSelected(true);
        }
    }

    @Override
    public Object getData() {
        return jrMale.isSelected() ? "Male" : "Female";
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellGender cell = new CellGender();
        cell.setData(o);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jrFemale;
    private javax.swing.JRadioButton jrMale;
    // End of variables declaration//GEN-END:variables
}
