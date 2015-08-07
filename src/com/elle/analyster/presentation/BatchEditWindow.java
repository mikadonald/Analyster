
package com.elle.analyster.presentation;

import com.elle.analyster.database.ModifiedData;
import com.elle.analyster.database.ModifiedTableData;
import com.elle.analyster.logic.JTableCellRenderer;
import com.elle.analyster.logic.Tab;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author Louis W.
 */
public class BatchEditWindow extends JFrame {
    
    // attributes
    private AnalysterWindow analysterWindow;
    private Map<String,Tab> tabs;
    private String selectedTab;

    
    /**
     * CONSTRUCTOR
     * Creates new form TableEdit
     * @param selectedTable
     * @param analysterWindow
     */
    public BatchEditWindow() {
        initComponents();
        analysterWindow = AnalysterWindow.getInstance();
        tabs = analysterWindow.getTabs();
        selectedTab = analysterWindow.getSelectedTab();
        
        comboBoxFieldSelect
                .setModel(new DefaultComboBoxModel(tabs.get(selectedTab)
                        .getBatchEditFields()));
        
        // set the interface to the middle of the window
        this.setLocationRelativeTo(analysterWindow);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setTitle("Batch Editor");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        comboBoxFieldSelect = new javax.swing.JComboBox();
        textFieldNewValue = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboBoxFieldSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "analyst", "priority", "dateAssigned", "notes", "symbol", " ", " ", " " }));
        comboBoxFieldSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFieldSelectActionPerformed(evt);
            }
        });

        textFieldNewValue.setText("Please enter new value");
        textFieldNewValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldNewValueFocusGained(evt);
            }
        });
        textFieldNewValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNewValueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxFieldSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textFieldNewValue, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxFieldSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldNewValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnConfirm)
                    .addComponent(btnQuit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * clears the text field
     * @param evt 
     */
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        textFieldNewValue.setText("");
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * submit changes to the database
     * @param evt 
     */
    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed

        JTable table = tabs.get(selectedTab).getTable();                           // the selected table
        ModifiedTableData data = tabs.get(selectedTab).getTableData();             // modified table data object
        String columnName = String.valueOf(comboBoxFieldSelect.getSelectedItem()); // column name   
        String newValue = textFieldNewValue.getText();                             // new value to replace old value(s)
        int[] rows = table.getSelectedRows();                                      // selected rows
        int columnIndex;                                                           // column index
        int rowIndex;                                                              // row index
        int rowCount = table.getSelectedRowCount();                                // number of rows

        //List<ModifiedData> modifiedDataBatchEdit = new ArrayList<>();
        
        // get column index for the combobox selection
        for (columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
            if (columnName.equals(table.getColumnName(columnIndex))) {
                break;
            }
        }

        for (rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            
            String tableName = table.getName();
            int id = (Integer)table.getModel().getValueAt(rows[rowIndex],0);
            data.getNewData().add(new ModifiedData(tableName, columnName, newValue, id));

            // set the value to the table model
            table.setValueAt(newValue, rows[rowIndex], columnIndex);
        }
        
        //analysterWindow.updateTable(table, modifiedDataBatchEdit);
        
        // get the filter items for this column
        ArrayList<Object> filterItems 
                = new ArrayList<>(tabs.get(selectedTab)
                        .getFilter().getFilterItems().get(columnIndex));

        if(!filterItems.isEmpty()){
            if(!filterItems.contains(newValue)){
                
                // add item to the array
                filterItems.add(newValue);
                
                // add the array to the filter items list
                tabs.get(selectedTab).getFilter().addFilterItems(columnIndex, filterItems);
            }
        }
        
        // reload table 
        //analysterWindow.loadTable(table);
    }//GEN-LAST:event_btnConfirmActionPerformed

    /**
     * This terminates the window and returns resources
     * @param evt 
     */
    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnQuitActionPerformed

    private void textFieldNewValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNewValueActionPerformed
//        jString.setText("");
    }//GEN-LAST:event_textFieldNewValueActionPerformed

    private void textFieldNewValueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldNewValueFocusGained
        textFieldNewValue.setText("");
    }//GEN-LAST:event_textFieldNewValueFocusGained

    private void comboBoxFieldSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFieldSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxFieldSelectActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnQuit;
    private javax.swing.JComboBox comboBoxFieldSelect;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textFieldNewValue;
    // End of variables declaration//GEN-END:variables
}
