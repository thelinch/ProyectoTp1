/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.ServiceImpl;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antony
 */
public class Padre {

    protected DefaultTableModel pintarTabla(JTable tabla, List<Object> objeto) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
         for (Object object : objeto) {
            modelo.addRow(rowData);
        }
        return modelo;
    }
}
