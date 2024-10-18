/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.reserva;

import controller.IReservaDao;
import controllerImpl.ReservaDaoImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Reserva;

/**
 *
 * @author tpp
 */
public class ListReserva extends javax.swing.JPanel {
    IReservaDao rDao = new ReservaDaoImpl();
    Reserva re = new Reserva();
    
    
    public ListReserva() {
        initComponents();
        cargarReserva();
    }

    private void cargarReserva(){
        List<Reserva> lista = rDao.listAll();
        
        DefaultTableModel tableModel = (DefaultTableModel) TableReserva.getModel();
        tableModel.setNumRows(0);

        for (Reserva r : lista) {
            String estado;
            if (r.getEstado().equals("R")) {
                estado = "Reservado";
            } else {
                estado = "Cancelado";
            }
            Object[] rowData
                    = {
                        r.getIdReserva(),
                        r.getFechaIngreso(),
                        r.getFechaSalida(),
                        r.getCliente().getNombre(),
                        r.getNumeroPiso(),
                        r.getNumeroHabitacion(),
                        r.getCosto(),
                        estado
                    };
            tableModel.addRow(rowData);
        }

        TableReserva.setModel(tableModel);
        JOptionPane.showMessageDialog(null, "Carga Completada :) ", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);

    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableReserva = new javax.swing.JTable();
        btnReload = new javax.swing.JButton();
        btnNuevaReserva = new javax.swing.JButton();
        btnEditarReserva = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        TableReserva.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TableReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Ingreso", "Salida", "Cliente", "Piso", "Habitacion", "Costo", "Estado"
            }
        ));
        jScrollPane1.setViewportView(TableReserva);

        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/reload.png"))); // NOI18N

        btnNuevaReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/mas.png"))); // NOI18N
        btnNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaReservaActionPerformed(evt);
            }
        });

        btnEditarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/edit.png"))); // NOI18N

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/delete.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnReload)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaReserva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditarReserva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addGap(63, 63, 63))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReload)
                    .addComponent(btnNuevaReserva)
                    .addComponent(btnEditarReserva)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaReservaActionPerformed
    CreateReserva cr = new CreateReserva();
        cr.setSize(700, 500);
        cr.setLocation(0, 0);
        cr.setVisible(true);
        cr.setLocationRelativeTo(null);       
        
    }//GEN-LAST:event_btnNuevaReservaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableReserva;
    private javax.swing.JButton btnEditarReserva;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevaReserva;
    private javax.swing.JButton btnReload;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
