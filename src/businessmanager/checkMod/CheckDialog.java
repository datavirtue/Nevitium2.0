/*
 * CheckDialog.java
 *
 * Created on July 13, 2007, 11:39 AM
 */

package businessmanager.checkMod;
import RuntimeManagement.KeyCard;
import RuntimeManagement.GlobalApplicationDaemon;
import businessmanager.Connections.MyConnectionsApp;
import businessmanager.Common.JTextFieldFilter;
import datavirtue.*;
import java.awt.*;
import businessmanager.*;

import businessmanager.Common.Tools;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author  Data Virtue
 */
public class CheckDialog extends javax.swing.JDialog {
    private KeyCard accessKey;
    private GlobalApplicationDaemon application;
    /** Creates new form CheckDialog */
    public CheckDialog(java.awt.Frame parent, boolean modal, GlobalApplicationDaemon application, int customerKey, float amount, String memo) {
        super(parent, modal);
        initComponents();
        amtField.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
        this.application = application;
        db = application.getDb();
        workingPath = application.getWorkingPath();
        accessKey = application.getKey_card();
        java.awt.Dimension dim = DV.computeCenter((java.awt.Window) this);
        this.setLocation(dim.width, dim.height);
        this.populateItemList();
        props = new Settings(workingPath);

        /* init */
        if (amount > 0) amtField.setText(DV.money(amount));
        if (customerKey > 0) setCustomer(customerKey);
        if (memo.length() > 0) forField.setText(memo);

        toField.requestFocus();
        
        //datePicker1.setDateFormat(new SimpleDateFormat(props.getProp("DATEFORMAT")));
         /* Close dialog on escape */
        ActionMap am = getRootPane().getActionMap();
        InputMap im = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        Object windowCloseKey = new Object();
        KeyStroke windowCloseStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        Action windowCloseAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        };
        im.put(windowCloseStroke, windowCloseKey);
        am.put(windowCloseKey, windowCloseAction);
        /**/
        
        this.setVisible(true);
    }


    private DbEngine db;
    private String workingPath="";
    
    private java.util.ArrayList itemList;
    
    private void populateItemList () {
        
        itemList = new java.util.ArrayList();
        itemList.trimToSize();
        
        TableModel cat_tm = db.createTableModel("chkpayee");
        
        if (cat_tm != null && cat_tm.getRowCount() > 0){
            
            for (int r = 0; r < cat_tm.getRowCount(); r++){
            
                itemList.add((String) cat_tm.getValueAt(r, 1));
                   
            
            }
        
            
        }else {
            //catList.add("");
            itemList.add("N/A");
        }
        
        toField.setDocument(new AutoCompleteDocument( toField, itemList ));
        
        
    }
    
    private void normalizeItemList(String s) {
        
        
        String txm;
        
        java.util.ArrayList al;
        
        al = db.search("chkpayee", 1, s, false);
        
        if (al == null){
            
            db.saveRecord("chkpayee",new Object [] {new Integer(0), new String (s)} ,false);
            //db.close();
            
                        
        }
        
        
    }
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        datePicker1 = new com.michaelbaranov.microba.calendar.DatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        toField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        forField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        indRadio = new javax.swing.JRadioButton();
        coRadio = new javax.swing.JRadioButton();
        addBox = new javax.swing.JCheckBox();
        amtField = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        selectButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        goButton = new javax.swing.JButton();
        printSetupButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Print Check");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/businessmanager/res/prnchk.gif"))); // NOI18N
        jLabel1.setToolTipText("Basic Check On Top Ink Jet / Laser Checks");

        jLabel5.setText("Standard Three-Part");

        jLabel6.setText("8.5 x 11 (A4) Voucher Checks");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 245, Short.MAX_VALUE)
                .add(datePicker1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 135, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel6))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, datePicker1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        toField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        toField.setNextFocusableComponent(amtField);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setText("To:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel3.setText("Amount");

        forField.setFont(new java.awt.Font("Tahoma", 0, 14));
        forField.setNextFocusableComponent(goButton);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel4.setText("For:");

        buttonGroup1.add(indRadio);
        indRadio.setText("Individual");
        indRadio.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        indRadio.setEnabled(false);
        indRadio.setMargin(new java.awt.Insets(0, 0, 0, 0));
        indRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(coRadio);
        coRadio.setSelected(true);
        coRadio.setText("Company");
        coRadio.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        coRadio.setEnabled(false);
        coRadio.setMargin(new java.awt.Insets(0, 0, 0, 0));
        coRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coRadioActionPerformed(evt);
            }
        });

        addBox.setText("Print Address");
        addBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addBox.setEnabled(false);
        addBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        amtField.setFont(new java.awt.Font("Tahoma", 1, 14));
        amtField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        selectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/businessmanager/res/Aha-16/enabled/Customers.png"))); // NOI18N
        selectButton.setText("Select");
        selectButton.setMargin(new java.awt.Insets(2, 7, 2, 7));
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(selectButton);

        clearButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/businessmanager/res/Aha-16/enabled/Corrupt text.png"))); // NOI18N
        clearButton.setText("Clear");
        clearButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(clearButton);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(jLabel2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(indRadio)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(coRadio)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(addBox)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(toField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 378, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 124, Short.MAX_VALUE)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(amtField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(10, 10, 10))
                    .add(jLabel4)
                    .add(forField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 218, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel2)
                        .add(jLabel3)
                        .add(indRadio)
                        .add(coRadio)
                        .add(addBox))
                    .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(toField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(amtField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(forField)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        goButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/businessmanager/res/Aha-24/enabled/Play.png"))); // NOI18N
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        printSetupButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        printSetupButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/businessmanager/res/Aha-24/enabled/Form.png"))); // NOI18N
        printSetupButton.setText("Layout");
        printSetupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printSetupButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(printSetupButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 436, Short.MAX_VALUE)
                .add(goButton)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(goButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(printSetupButton))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed

        
            clearAction();
            
            return;
        
        
    }//GEN-LAST:event_clearButtonActionPerformed

    private void coRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coRadioActionPerformed
        
        toField.setText(address[0]);
        
    }//GEN-LAST:event_coRadioActionPerformed

    private void indRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indRadioActionPerformed
        
        toField.setText(address[1]);
        
        
    }//GEN-LAST:event_indRadioActionPerformed

    private String co = "";
    private String name = "";
    private String street = "";
    private String city = "";
    private Settings props;
    
    private void clearAction() {
        
         indRadio.setEnabled(false);
            coRadio.setEnabled(false);
            addBox.setEnabled(false);
            addBox.setSelected(false);
            toField.setText("");
            toField.requestFocus();
            
        
    }
    
    
    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        
        MyConnectionsApp cd = new MyConnectionsApp (null, true, application, true, false, true);
        
        int rv;
        rv = cd.getReturnValue() ;  //real value
        
        cd.dispose(); //dont call dispose before finsihing with method
        cd = null;
        
        if (rv == 0 || rv == -1) {
            
           clearAction();
            return;
            
        }else {
            setCustomer(rv);
        }
        
        
    }//GEN-LAST:event_selectButtonActionPerformed

    private void setCustomer(int key){
       
        Object [] rec = db.getRecord("conn", key);
        
        if (rec != null){

            address = Tools.formatAddress(rec);
            
            if (address[0].trim().equals("")){

                toField.setText(address[1]);
                indRadio.setSelected(true);

            }else {

                indRadio.setEnabled(true);
                coRadio.setEnabled(true);
                toField.setText(address[0]);
            }

                addBox.setEnabled(true);
                addBox.setSelected(true);
        }


    }

    private void printSetupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printSetupButtonActionPerformed
        
        new CheckPrintSettingsDialog(null, true, workingPath);
        
        
    }//GEN-LAST:event_printSetupButtonActionPerformed

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed

        float amt;
        try {
            
            amt = Float.parseFloat(amtField.getText());
        } catch (NumberFormatException ex) {
            
            javax.swing.JOptionPane.showMessageDialog(null, "You need to enter a valid amount.");
            return;
        }
        
        
        if (toField.getText().trim().equals("")){
            
            javax.swing.JOptionPane.showMessageDialog(null, "You need to enter a payee.");
            return;
        }
        
       this.normalizeItemList (toField.getText().trim()); 
        
       Settings props = new Settings(workingPath + "checks.ini");
        
       boolean printAddress = false;
       boolean printSig = Boolean.parseBoolean(props.getProp("PRINTSIG"));
       
       if (addBox.isEnabled() && addBox.isSelected()) printAddress = true;
       
        CheckPrinter cp = new CheckPrinter(printSig, false, printAddress, true);        
       
        cp.setDocFont(new java.awt.Font(props.getProp("DOCFONT"), Font.PLAIN, 
                        CheckPrintSettingsDialog.conv(props.getProp("DOCPS"),12)));
                
        cp.setDocFont(new java.awt.Font(props.getProp("TOFONT"), Font.PLAIN, 
                        CheckPrintSettingsDialog.conv(props.getProp("TOPS"),12)));
        
        
        
        if (printSig) cp.setSignatureImage(props.getProp("SIGPATH"));
        
        
        /* add a check */
        cp.add(new CheckStub(toField.getText(), address, DV.datetoString(datePicker1.getDate().getTime()),
                "", DV.money(amt), forField.getText()));
                
        if (!new java.io.File(workingPath + "checks.ini").exists()){
            
            cp.go();
            this.dispose();
            
        }else {
            
            /* get settings */
           
            if (props.getProp("DEF").equalsIgnoreCase("true")){
                
                cp.go();
                this.dispose();
                
            }else {
                
                /* Plug in all the custom coordinates to cp */
                
                cp.setDateDim(CheckPrintSettingsDialog.conv(props.getProp("DATEX")),
                        CheckPrintSettingsDialog.conv(props.getProp("DATEY")));
                
                cp.setAmountDim(CheckPrintSettingsDialog.conv(props.getProp("AMTX")),
                        CheckPrintSettingsDialog.conv(props.getProp("AMTY")));
                
                cp.setPayToDim(CheckPrintSettingsDialog.conv(props.getProp("PAYEEX")),
                        CheckPrintSettingsDialog.conv(props.getProp("PAYEEY")));
                
                cp.setSpellDim(CheckPrintSettingsDialog.conv(props.getProp("SPELLX")),
                        CheckPrintSettingsDialog.conv(props.getProp("SPELLY")));
                
                cp.setMemoDim(CheckPrintSettingsDialog.conv(props.getProp("MEMOX")),
                        CheckPrintSettingsDialog.conv(props.getProp("MEMOY")));
                
                cp.setSigDim(CheckPrintSettingsDialog.conv(props.getProp("SIGX")),
                        CheckPrintSettingsDialog.conv(props.getProp("SIGY")));
                
                cp.setDocFont(new java.awt.Font(props.getProp("DOCFONT"), Font.PLAIN, 
                        CheckPrintSettingsDialog.conv(props.getProp("DOCPS"),12)));
                
                cp.setDocFont(new java.awt.Font(props.getProp("TOFONT"), Font.PLAIN, 
                        CheckPrintSettingsDialog.conv(props.getProp("TOPS"),12)));
                
                cp.go();
                
            }
            
        }
        
        
    }//GEN-LAST:event_goButtonActionPerformed
    
  String [] address = new String [6];
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox addBox;
    private javax.swing.JTextField amtField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearButton;
    private javax.swing.JRadioButton coRadio;
    private com.michaelbaranov.microba.calendar.DatePicker datePicker1;
    private javax.swing.JTextField forField;
    private javax.swing.JButton goButton;
    private javax.swing.JRadioButton indRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton printSetupButton;
    private javax.swing.JButton selectButton;
    private javax.swing.JTextField toField;
    // End of variables declaration//GEN-END:variables
    
}
