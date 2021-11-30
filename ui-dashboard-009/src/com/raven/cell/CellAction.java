package com.raven.cell;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class CellAction extends TableCustomCell {

    public CellAction() {
        initComponents();
    }

    private void addEvent(TableCustom table, TableRowData data, int row) {
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (data.isEditing()) {
                    table.cancelEditRowAt(row);
                    cmdEdit.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/edit.png")));
                } else {
                    table.editRowAt(row);
                    cmdEdit.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/cancel.png")));
                }
            }
        });
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                table.deleteRowAt(getRow(), true);
            }
        });
    }

    private void checkIcon(TableRowData data) {
        if (data.isEditing()) {
            cmdEdit.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/cancel.png")));
        } else {
            cmdEdit.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/edit.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdEdit = new com.raven.swing.Button();
        cmdDelete = new com.raven.swing.Button();

        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/edit.png"))); // NOI18N

        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/delete.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setData(Object o) {

    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public Component createComponentCellRender(TableCustom table, TableRowData data, int row, int column) {
        CellAction cell = new CellAction();
        cell.checkIcon(data);
        cell.addEvent(table, data, row);
        return cell;
    }

    @Override
    public Component createComponentCellRenderOnEditor(TableCustom table, TableRowData data, int row, int column) {
        return null;
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom table, TableRowData data, Object o, int row, int column) {
        CellAction cell = new CellAction();
        cell.checkIcon(data);
        cell.addEvent(table, data, row);
        return cell;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button cmdDelete;
    private com.raven.swing.Button cmdEdit;
    // End of variables declaration//GEN-END:variables
}
