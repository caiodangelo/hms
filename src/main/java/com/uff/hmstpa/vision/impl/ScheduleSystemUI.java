package com.uff.hmstpa.vision.impl;

import com.uff.hmstpa.controller.ScheduleSystemController;
import com.uff.hmstpa.model.ScheduleSystemModel;
import com.uff.hmstpa.model.domain.entity.Doctor;
import com.uff.hmstpa.model.domain.valueobject.Appointment;
import com.uff.hmstpa.util.command.Command;
import com.uff.hmstpa.util.command.impl.CreateScheduleCommand;
import com.uff.hmstpa.util.exception.BusinessRuleException;
import com.uff.hmstpa.util.observer.Observer;
import com.uff.hmstpa.vision.ScheduleSystemView;
import com.uff.hmstpa.vision.frames.CreateScheduleFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/*
 * A View é uma janela para observarmos o estado do modelo. Para isso, ela
 * implementa a interface Observer, de modo a saber quando houve uma alteração
 * no estado do modelo.
 */
public class ScheduleSystemUI extends javax.swing.JFrame implements Observer, ActionListener, ScheduleSystemView {

    CreateScheduleFrame createSchedule;
    ScheduleSystemController controller;
    DefaultListModel<Appointment> listModel = null;

    public ScheduleSystemUI(ScheduleSystemModel model, ScheduleSystemController controller) {
        this.controller = controller;
        this.createView();

        //Registra esta View como observadora do modelo
        model.registerObserver(this);

        createSchedule = new CreateScheduleFrame(this, new CreateScheduleCommand(controller));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_appointmentsList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_DoctorName = new javax.swing.JTextField();
        jTextField_CRM = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Doctor = new javax.swing.JMenu();
        jMenuItem_Todos = new javax.swing.JMenuItem();
        jMenu_NewSchedule = new javax.swing.JMenu();
        jMenuItem_CreateAppointment = new javax.swing.JMenuItem();
        jMenuItem_EditAppointment = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Schedule System");
        setAutoRequestFocus(false);

        jList_appointmentsList.setModel(new DefaultListModel());
        jList_appointmentsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_appointmentsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_appointmentsListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList_appointmentsList);

        jLabel1.setText("Próximas consultas:");

        jLabel2.setText("Nome do médico:");

        jLabel3.setText("CRM:");

        jTextField_DoctorName.setEditable(false);

        jTextField_CRM.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 285, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_DoctorName, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jTextField_CRM, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_DoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_CRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu_Doctor.setText("Doutor");
        jMenu_Doctor.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu_DoctorMenuSelected(evt);
            }
        });

        jMenuItem_Todos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_Todos.setText("Todos");
        jMenuItem_Todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_TodosActionPerformed(evt);
            }
        });
        jMenu_Doctor.add(jMenuItem_Todos);

        jMenuBar1.add(jMenu_Doctor);

        jMenu_NewSchedule.setText("Consulta");

        jMenuItem_CreateAppointment.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_CreateAppointment.setText("Criar Consulta");
        jMenuItem_CreateAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CreateAppointmentActionPerformed(evt);
            }
        });
        jMenu_NewSchedule.add(jMenuItem_CreateAppointment);

        jMenuItem_EditAppointment.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_EditAppointment.setText("Editar Consulta");
        jMenuItem_EditAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_EditAppointmentActionPerformed(evt);
            }
        });
        jMenu_NewSchedule.add(jMenuItem_EditAppointment);

        jMenuBar1.add(jMenu_NewSchedule);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_TodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_TodosActionPerformed
        controller.setSelectedDoctor(null);
    }//GEN-LAST:event_jMenuItem_TodosActionPerformed

    private void jMenu_DoctorMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu_DoctorMenuSelected
        jMenu_Doctor.removeAll();
        jMenu_Doctor.add(jMenuItem_Todos);
        for (Doctor doctor : controller.retrieveDoctors()) {
            JMenuItem menuItem = new JMenuItem(doctor.getName());
            menuItem.addActionListener(this);
            jMenu_Doctor.add(menuItem);
        }
    }//GEN-LAST:event_jMenu_DoctorMenuSelected

    private void jList_appointmentsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_appointmentsListMouseClicked
        if (evt.getClickCount() >= 2) {
            Appointment app = listModel.getElementAt(jList_appointmentsList.getSelectedIndex());
            JOptionPane.showMessageDialog(this, "Função não implementada!", "Editar Consulta", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_jList_appointmentsListMouseClicked

    private void jMenuItem_CreateAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CreateAppointmentActionPerformed
        this.createSchedule.fillDoctors(controller.retrieveDoctors());
        this.createSchedule.setVisible(true);
    }//GEN-LAST:event_jMenuItem_CreateAppointmentActionPerformed

    private void jMenuItem_EditAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_EditAppointmentActionPerformed
        JOptionPane.showMessageDialog(this, "Função não implementada!", "Editar Consulta", JOptionPane.OK_OPTION);
    }//GEN-LAST:event_jMenuItem_EditAppointmentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList_appointmentsList;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_CreateAppointment;
    private javax.swing.JMenuItem jMenuItem_EditAppointment;
    private javax.swing.JMenuItem jMenuItem_Todos;
    private javax.swing.JMenu jMenu_Doctor;
    private javax.swing.JMenu jMenu_NewSchedule;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_CRM;
    private javax.swing.JTextField jTextField_DoctorName;
    // End of variables declaration//GEN-END:variables

    private void createView() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScheduleSystemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScheduleSystemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScheduleSystemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScheduleSystemUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        this.initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.listModel = (DefaultListModel<Appointment>) this.jList_appointmentsList.getModel();

    }

    /**
     * Atualiza a lista de Appointments na janela principal
     */
    public void updateAppointmentsList(List<Appointment> appointments) {
        listModel.removeAllElements();
        if (appointments != null && appointments.size() > 0) {
            for (Appointment app : appointments) {
                listModel.addElement(app);
            }
        }

        if (controller.getSelectedDoctor() != null) {
            this.setTitle("Appointments - " + controller.getSelectedDoctor().getName());
            this.jTextField_DoctorName.setText(controller.getSelectedDoctor().getName());
            this.jTextField_CRM.setText(controller.getSelectedDoctor().getCRM());
        } else {
            this.setTitle("Appointments - Todos");
            this.jTextField_DoctorName.setText("(Todos)");
            this.jTextField_CRM.setText("N/A");
        }
    }

    /**
     * Controla a seleção de um doutor no menu da janela principal
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JMenuItem) {
            JMenuItem source = (JMenuItem) (e.getSource());
            controller.setSelectedDoctor(source.getText());
        }
    }

    public Map<String, String> getCreateAppointmentParams() {
        return this.createSchedule.getCreateAppointmentParams();
    }

    public void showError(BusinessRuleException e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Erro - " + e.getLocation().getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
        //restaurar sistema com memento
    }

    public void update(ScheduleSystemModel subject, Command cmd) {
        cmd.execute();
    }
}
