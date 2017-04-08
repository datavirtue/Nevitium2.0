/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConnectionsShippingDialog.java
 *
 * Created on Aug 17, 2009, 2:00:19 AM
 */

package businessmanager.Connections;
import RuntimeManagement.GlobalApplicationDaemon;
import businessmanager.Common.LimitedDocument;

import datavirtue.*;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.table.*;
import java.util.*;
/**
 *
 * @author Data Virtue
 */
public class ConnectionsShippingDialog extends javax.swing.JDialog {

    private Image winIcon;
    private GlobalApplicationDaemon application;
    /** Creates new form ConnectionsShippingDialog */
    public ConnectionsShippingDialog(java.awt.Frame parent, boolean modal, 
            DbEngine dbe, int connKey, boolean select, GlobalApplicationDaemon g) {
        super(parent, modal);

        Toolkit tools = Toolkit.getDefaultToolkit();
        winIcon = tools.getImage(getClass().getResource("/businessmanager/res/Orange.png"));
        initComponents();
        application = g;
        java.awt.Dimension dim = DV.computeCenter((java.awt.Window) this);
        this.setLocation(dim.width, dim.height);

        selectButton.setVisible(select);
        this.select = select;

        companyField.setDocument(new LimitedDocument(35));
        nameField.setDocument(new LimitedDocument(20));
        streetField.setDocument(new LimitedDocument(40));
        addr2Field.setDocument(new LimitedDocument(40));
        cityField.setDocument(new LimitedDocument(30));
        stateField.setDocument(new LimitedDocument(20));
        postCodeField.setDocument(new LimitedDocument(10));
        phoneField.setDocument(new LimitedDocument(20));
        
        parentKey = connKey;
        db = dbe;
        init();
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        companyField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        streetField = new javax.swing.JTextField();
        addr2Field = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        stateField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        postCodeField = new javax.swing.JTextField();
        countryCombo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        defaultBox = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        selectButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        cloneButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        helpBox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Shipping Address");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Company");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Street");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Addr2");

        companyField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        companyField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                companyFieldMouseClicked(evt);
            }
        });

        nameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        streetField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        addr2Field.setFont(new java.awt.Font("Tahoma", 0, 14));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("City / Town");

        cityField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("St / Prov / Region");

        stateField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Post Code");

        postCodeField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        countryCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        countryCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "US", "CA", "GB", "ZA", "AU", "IN" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Format");

        defaultBox.setFont(new java.awt.Font("Tahoma", 0, 12));
        defaultBox.setText("Default Shipping Address");
        defaultBox.setToolTipText("Make this the Default Shipping Address");
        defaultBox.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .add(jLabel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(postCodeField)
                            .add(stateField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                        .add(18, 18, 18)
                        .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(cityField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 159, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(defaultBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, countryCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cityField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(defaultBox))
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(stateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(countryCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9)
                    .add(postCodeField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Phone");

        phoneField.setFont(new java.awt.Font("Tahoma", 0, 14));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        selectButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        selectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/businessmanager/res/Aha-16/enabled/OK.png"))); // NOI18N
        selectButton.setText("Select");
        selectButton.setToolTipText("Select a shipping address");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(selectButton);

        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/businessmanager/res/Aha-16/enabled/No.png"))); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("Cancel / Close window");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(cancelButton);

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/businessmanager/res/Aha-16/enabled/Floppy.png"))); // NOI18N
        saveButton.setText("Save");
        saveButton.setToolTipText("Saves changes");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(saveButton);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        cloneButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        cloneButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/businessmanager/res/Aha-16/enabled/Account cards.png"))); // NOI18N
        cloneButton.setText("Clone Original");
        cloneButton.setToolTipText("Copies the parent address information into the form.");
        cloneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cloneButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(cloneButton);

        clearButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/businessmanager/res/Aha-16/enabled/Corrupt text.png"))); // NOI18N
        clearButton.setText("Clear");
        clearButton.setToolTipText("Clears the fields to allow new record creation.");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(clearButton);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jToolBar2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .add(202, 202, 202)
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jToolBar2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        helpBox.setEditable(false);
        helpBox.setText("Hit 'Clear' and click the 'Company' field to start a new record");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(addr2Field)
                            .add(streetField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                                        .add(nameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 189, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, companyField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 256, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(phoneField))))
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(helpBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(companyField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(nameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(phoneField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(streetField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(addr2Field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(helpBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 119, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void init(){

        cDAO = new ConnectionsDAO(db, application, parentKey);
        
        refreshTable();
        
        populate();

    }

private void refreshTable(){

    shipToTableModel = cDAO.getShipToTable();

    if (shipToTableModel != null && shipToTableModel.getRowCount() > 0){
        jTable1.setModel(shipToTableModel);
        setView();
        jTable1.changeSelection(0, 0, false, false);
    }else {
        jTable1.setModel(new DefaultTableModel());
    }

}

public void setView(){

    int [] cols = {0,0,3,5,6}; //col view removal
        if (jTable1.getModel().getRowCount() > 0){
        TableColumnModel cm = jTable1.getColumnModel();
        TableColumn tc;
        if (cm.getColumnCount() < 11) return;

        for (int i =0; i < cols.length; i++){

            tc = cm.getColumn(cols[i]);
            jTable1.removeColumn(tc);

        }

    int a = jTable1.getColumnCount();
        javax.swing.JTextField tf = new javax.swing.JTextField();
        tf.setEditable(false);
        
        javax.swing.JCheckBox cb = new javax.swing.JCheckBox();
        cb.setEnabled(false);

        for (int i=0; i < a; i++){
            
            if (i < a-1){

                cm.getColumn(i).setCellEditor(new javax.swing.DefaultCellEditor(tf));

            }else {
                cm.getColumn(i).setCellEditor(new javax.swing.DefaultCellEditor(cb));

            }
        }
        }
}

private void populate() {

    if (shipToTableModel != null && shipToTableModel.getRowCount() > 0){
        int row = jTable1.getSelectedRow();
        if (row > -1) connShip = DV.getTableRow(shipToTableModel, row);
    }

    if (connShip != null){
        
        companyField.setText((String)connShip[2]);
        nameField.setText((String)connShip[3]);
        streetField.setText((String)connShip[4]);
        addr2Field.setText((String)connShip[5]);
        cityField.setText((String)connShip[6]);
        stateField.setText((String)connShip[7]);
        postCodeField.setText((String)connShip[8]);
        countryCombo.setSelectedItem((String)connShip[9]);
        phoneField.setText((String)connShip[10]);
        defaultBox.setSelected((Boolean)connShip[11]);
        setFieldsEnabled(true);

    }else {
        companyField.setText(cDAO.getCompany());
        connShip = new Object[12];
        connShip[0] = new Integer(0);
        connShip[1] = new Integer(parentKey);
    }

}

private void clearFields(){

    companyField.setText("");
    nameField.setText("");
    streetField.setText("");
    addr2Field.setText("");
    cityField.setText("");
    stateField.setText("");
    postCodeField.setText("");
    countryCombo.setSelectedItem("US");  //set to default country
    phoneField.setText("");
    defaultBox.setSelected(false);
    
    connShip = new Object[12];
    connShip[0] = new Integer(0);
    connShip[1] = new Integer(parentKey);
    helpBox.setText("Click the 'Company' field to start a new record.");
}

private void setFieldsEnabled(boolean b){
    companyField.setEnabled(b);
    nameField.setEnabled(b);
    streetField.setEnabled(b);
    addr2Field.setEnabled(b);
    cityField.setEnabled(b);
    stateField.setEnabled(b);
    postCodeField.setEnabled(b);
    countryCombo.setEnabled(b);
    phoneField.setEnabled(b);
    defaultBox.setEnabled(b);
}

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        
        if (select) {
            rValue = 0;
            this.setVisible(false);
        }else this.dispose();


    }//GEN-LAST:event_cancelButtonActionPerformed

    private void cloneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cloneButtonActionPerformed
        clearFields();
        companyField.setText(cDAO.getCompany());
        nameField.setText(cDAO.getContact());
        streetField.setText(cDAO.getStreet());
        addr2Field.setText(cDAO.getAddr2());
        cityField.setText(cDAO.getCity());
        stateField.setText(cDAO.getState());
        postCodeField.setText(cDAO.getPostCode());
        countryCombo.setSelectedItem(cDAO.getAlphaCountryCode());
        phoneField.setText(cDAO.getPhone());
        setFieldsEnabled(true);
    }//GEN-LAST:event_cloneButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        saveAction();
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void companyFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyFieldMouseClicked
        if (!companyField.isEnabled()) {

            setFieldsEnabled(true);
            companyField.setText(cDAO.getCompany());
            connShip = new Object[12];
            connShip[0] = new Integer(0);
            connShip[1] = new Integer(parentKey);
            helpBox.setText("Remember to click 'Save' after making changes.");
            companyField.requestFocus();

        }
    }//GEN-LAST:event_companyFieldMouseClicked

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearFields();
        setFieldsEnabled(false);
    }//GEN-LAST:event_clearButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int mouseButton = evt.getButton();
    if (mouseButton == evt.BUTTON2 || mouseButton == evt.BUTTON3) return;    

  
        
        if (select && evt.getClickCount() == 2){
                      
            int row = jTable1.rowAtPoint(new Point(evt.getX(), evt.getY()));
            
            if (jTable1.getSelectedRow() > -1) {                  
                rValue = (Integer) jTable1.getModel().getValueAt(row, 0);              
                this.setVisible(false);
            }            
    }


        populate();
    }//GEN-LAST:event_jTable1MouseClicked
    

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        populate();
    }//GEN-LAST:event_jTable1KeyPressed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        selectAction();
    }//GEN-LAST:event_selectButtonActionPerformed

    private void selectAction() {
        if (!select) return;
        
        rValue = (Integer)connShip[0];
        this.setVisible(false);
    }

    public int getShipToKey() {

        return rValue;
    }
private void saveAction(){

        if (defaultBox.isSelected()){

            ArrayList stl = cDAO.getShiptoList();

            if (stl != null){

                for (int x = 0; x < stl.size(); x++){

                    ShipToDAO std = (ShipToDAO) stl.get(x);
                    if (std.isDefault()){
                        std.setDefault(false);
                        std.save();
                    }

                }

            }


        }
        connShip[1] = new Integer(parentKey);
        connShip[2] = new String(companyField.getText());
        connShip[3] = new String(nameField.getText());
        connShip[4] = new String(streetField.getText());
        connShip[5] = new String(addr2Field.getText());
        connShip[6] = new String(cityField.getText());
        connShip[7] = new String(stateField.getText());
        connShip[8] = new String(postCodeField.getText());
        connShip[9] = new String((String)countryCombo.getSelectedItem());
        connShip[10] = new String(phoneField.getText());
        connShip[11] = new Boolean(defaultBox.isSelected());
        db.saveRecord("connship", connShip, false);
        refreshTable();
        clearFields();
        setFieldsEnabled(false);
}
private int rValue=0;
private int parentKey = 0;
private DbEngine db;
private ConnectionsDAO cDAO;
private Object [] connShip = null;
private DefaultTableModel shipToTableModel;
private boolean select = false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addr2Field;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cityField;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton cloneButton;
    private javax.swing.JTextField companyField;
    private javax.swing.JComboBox countryCombo;
    private javax.swing.JCheckBox defaultBox;
    private javax.swing.JTextField helpBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JTextField postCodeField;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton selectButton;
    private javax.swing.JTextField stateField;
    private javax.swing.JTextField streetField;
    // End of variables declaration//GEN-END:variables

}