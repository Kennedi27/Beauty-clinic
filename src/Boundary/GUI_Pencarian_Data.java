/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundary;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lenovo
 */
public class GUI_Pencarian_Data extends javax.swing.JFrame {
    private DefaultTableModel model;
    public GUI_Transaksi AmbilNamaPelanggan = null;
    Connection con;
    Statement stat;
    ResultSet  rs;
    String sql;
    /**
     * Creates new form GUI_Pencarian_Data
     */
    public GUI_Pencarian_Data() {
        initComponents();
        
        TampilDataPelanggan();
        
        TampilDataLayanan();
        
        TampilDataProduk();
        
        TampilDataDokter();
    }
    public void TampilDataPelanggan(){
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        model = new DefaultTableModel();
        tblPelanggan.setModel(model);
        model.addColumn("ID Pelanggan");
        model.addColumn("Nama");
        model.addColumn("Telp");
                
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            sql = "SELECT * FROM customer";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                Object[] obj = new Object[3];
                obj[0] = rs.getString("id");
                obj[1] = rs.getString("nama");
                obj[2] = rs.getString("telp");
                
                model.addRow(obj);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public void TampilDataLayanan(){
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        model = new DefaultTableModel();
        tblLayanan.setModel(model);
        model.addColumn("Kode Layanan");
        model.addColumn("Nama Layanan");
        model.addColumn("Harga Layanan");
                
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            sql = "SELECT * FROM layanan";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                Object[] obj = new Object[3];
                obj[0] = rs.getString("kode");
                obj[1] = rs.getString("nama");
                obj[2] = rs.getString("harga");
                
                model.addRow(obj);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void TampilDataDokter(){
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        model = new DefaultTableModel();
        tblDokter.setModel(model);
        model.addColumn("ID Dokter");
        model.addColumn("Nama Dokter");
        model.addColumn("Alamat Dokter");
        model.addColumn("Telp Dokter");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            sql = "SELECT * FROM dokter";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                Object[] obj = new Object[4];
                obj[0] = rs.getString("id");
                obj[1] = rs.getString("nama");
                obj[2] = rs.getString("alamat");
                obj[3] = rs.getString("telp");
                
                model.addRow(obj);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void TampilDataProduk(){
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        model = new DefaultTableModel();
        tblProduk.setModel(model);
        model.addColumn("Kode Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Harga Produk");
        model.addColumn("Jumlah Stok");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String cariPelanggan = txtCariPelanggan.getText();
        try {
            sql = "SELECT * FROM produk";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                Object[] obj = new Object[4];
                obj[0] = rs.getString("kode");
                obj[1] = rs.getString("nama");
                obj[2] = rs.getString("harga");
                obj[3] = rs.getString("stok");
                
                model.addRow(obj);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void CariPelanggan(){
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        model = new DefaultTableModel();
        tblPelanggan.setModel(model);
        model.addColumn("ID Pelanggan");
        model.addColumn("Nama");
        model.addColumn("Telp");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String cariPelanggan = txtCariPelanggan.getText();
        try {
            sql = "SELECT * FROM customer WHERE nama LIKE '%"+cariPelanggan+"%'";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                Object[] obj = new Object[3];
                obj[0] = rs.getString("id");
                obj[1] = rs.getString("nama");
                obj[2] = rs.getString("telp");
                
                model.addRow(obj);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void CariLayanan(){
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        model = new DefaultTableModel();
        tblLayanan.setModel(model);
        model.addColumn("Kode Layanan");
        model.addColumn("Nama Layanan");
        model.addColumn("Harga Layanan");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String cariLayanan = txtCariLayanan.getText();
        try {
            sql = "SELECT * FROM layanan WHERE kode LIKE '%"+cariLayanan+"%' OR nama LIKE '%"+cariLayanan+"%'";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                Object[] obj = new Object[3];
                obj[0] = rs.getString("kode");
                obj[1] = rs.getString("nama");
                obj[2] = rs.getString("harga");
                
                model.addRow(obj);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void CariProduk(){
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        model = new DefaultTableModel();
        tblProduk.setModel(model);
        model.addColumn("Kode Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Harga Produk");
        model.addColumn("Jumlah Stok");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String cariProduk = txtCariProduk.getText();
        String kodeProduk = txtCariProduk.getText();
        try {
            sql = "SELECT * FROM produk WHERE kode LIKE '"+kodeProduk+"' OR nama LIKE '%"+cariProduk+"%'";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                Object[] obj = new Object[4];
                obj[0] = rs.getString("kode");
                obj[1] = rs.getString("nama");
                obj[2] = rs.getString("harga");
                obj[3] = rs.getString("stok");
                
                model.addRow(obj);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void CariDokter(){
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        model = new DefaultTableModel();
        tblDokter.setModel(model);
        model.addColumn("ID Dokter");
        model.addColumn("Nama Dokter");
        model.addColumn("Alamat Dokter");
        model.addColumn("Telp Dokter");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String cariDokter = txtCariDokter.getText();
        String idDokter = txtCariDokter.getText();
        try {
            sql = "SELECT * FROM dokter WHERE id LIKE '"+idDokter+"' OR nama LIKE '%"+cariDokter+"%'";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                Object[] obj = new Object[4];
                obj[0] = rs.getString("id");
                obj[1] = rs.getString("nama");
                obj[2] = rs.getString("alamat");
                obj[3] = rs.getString("telp");
                
                model.addRow(obj);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
//    public String getPelanggan(){
//        
//        return 
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PencarianData = new javax.swing.JTabbedPane();
        tabPelanggan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPelanggan = new javax.swing.JTable();
        txtCariPelanggan = new javax.swing.JTextField();
        btnCariPelanggan = new javax.swing.JButton();
        tabLayanan = new javax.swing.JPanel();
        btnCariLayanan = new javax.swing.JButton();
        txtCariLayanan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLayanan = new javax.swing.JTable();
        tabProduk = new javax.swing.JPanel();
        btnCariProduk = new javax.swing.JButton();
        txtCariProduk = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        tabDokter = new javax.swing.JPanel();
        btnCariDokter = new javax.swing.JButton();
        txtCariDokter = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDokter = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabPelanggan.setBackground(new java.awt.Color(132, 169, 172));

        tblPelanggan.setBackground(new java.awt.Color(231, 223, 213));
        tblPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPelanggan);

        btnCariPelanggan.setText("Cari");
        btnCariPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPelangganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabPelangganLayout = new javax.swing.GroupLayout(tabPelanggan);
        tabPelanggan.setLayout(tabPelangganLayout);
        tabPelangganLayout.setHorizontalGroup(
            tabPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPelangganLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabPelangganLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtCariPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCariPelanggan))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabPelangganLayout.setVerticalGroup(
            tabPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPelangganLayout.createSequentialGroup()
                .addGroup(tabPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabPelangganLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtCariPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabPelangganLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCariPelanggan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        PencarianData.addTab("Pelanggan", tabPelanggan);

        tabLayanan.setBackground(new java.awt.Color(132, 169, 172));

        btnCariLayanan.setText("Cari");
        btnCariLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariLayananActionPerformed(evt);
            }
        });

        tblLayanan.setBackground(new java.awt.Color(231, 223, 213));
        tblLayanan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLayanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLayananMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLayanan);

        javax.swing.GroupLayout tabLayananLayout = new javax.swing.GroupLayout(tabLayanan);
        tabLayanan.setLayout(tabLayananLayout);
        tabLayananLayout.setHorizontalGroup(
            tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabLayananLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addGroup(tabLayananLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtCariLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariLayanan)))
                .addContainerGap())
        );
        tabLayananLayout.setVerticalGroup(
            tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabLayananLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCariLayanan)
                    .addComponent(txtCariLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );

        PencarianData.addTab("Layanan", tabLayanan);

        tabProduk.setBackground(new java.awt.Color(132, 169, 172));

        btnCariProduk.setText("Cari");
        btnCariProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariProdukActionPerformed(evt);
            }
        });

        tblProduk.setBackground(new java.awt.Color(231, 223, 213));
        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdukMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProduk);

        javax.swing.GroupLayout tabProdukLayout = new javax.swing.GroupLayout(tabProduk);
        tabProduk.setLayout(tabProdukLayout);
        tabProdukLayout.setHorizontalGroup(
            tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProdukLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addGroup(tabProdukLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtCariProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariProduk)))
                .addContainerGap())
        );
        tabProdukLayout.setVerticalGroup(
            tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProdukLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCariProduk)
                    .addComponent(txtCariProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );

        PencarianData.addTab("Produk", tabProduk);

        tabDokter.setBackground(new java.awt.Color(132, 169, 172));

        btnCariDokter.setText("Cari");
        btnCariDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariDokterActionPerformed(evt);
            }
        });

        tblDokter.setBackground(new java.awt.Color(231, 223, 213));
        tblDokter.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDokterMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDokter);

        javax.swing.GroupLayout tabDokterLayout = new javax.swing.GroupLayout(tabDokter);
        tabDokter.setLayout(tabDokterLayout);
        tabDokterLayout.setHorizontalGroup(
            tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDokterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addGroup(tabDokterLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtCariDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariDokter)))
                .addContainerGap())
        );
        tabDokterLayout.setVerticalGroup(
            tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDokterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCariDokter)
                    .addComponent(txtCariDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );

        PencarianData.addTab("Dokter", tabDokter);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PencarianData, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PencarianData, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPelangganActionPerformed
        // TODO add your handling code here:
        CariPelanggan();
    }//GEN-LAST:event_btnCariPelangganActionPerformed

    private void tblPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPelangganMouseClicked
        // TODO add your handling code here:
        int baris = tblPelanggan.getSelectedRow();
        AmbilNamaPelanggan.DapatNamaPelanggan = tblPelanggan.getValueAt(baris, 1).toString();
        AmbilNamaPelanggan.NamaPelangganTerpilih();
    }//GEN-LAST:event_tblPelangganMouseClicked

    private void btnCariLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariLayananActionPerformed
        // TODO add your handling code here:
        CariLayanan();
    }//GEN-LAST:event_btnCariLayananActionPerformed

    private void btnCariDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariDokterActionPerformed
        // TODO add your handling code here:
        CariDokter();
    }//GEN-LAST:event_btnCariDokterActionPerformed

    private void btnCariProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariProdukActionPerformed
        // TODO add your handling code here:
        CariProduk();
    }//GEN-LAST:event_btnCariProdukActionPerformed

    private void tblLayananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLayananMouseClicked
        // TODO add your handling code here:
        int baris = tblLayanan.getSelectedRow();
        AmbilNamaPelanggan.DapatNamaLayanan = tblLayanan.getValueAt(baris, 1).toString();
        AmbilNamaPelanggan.DapatHargaLayanan = tblLayanan.getValueAt(baris, 2).toString();
        AmbilNamaPelanggan.NamaLayananTerpilih();
    }//GEN-LAST:event_tblLayananMouseClicked

    private void tblProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdukMouseClicked
        // TODO add your handling code here:
        int baris = tblProduk.getSelectedRow();
        AmbilNamaPelanggan.DapatNamaProduk = tblProduk.getValueAt(baris, 1).toString();
        AmbilNamaPelanggan.DapatHargaProduk = tblProduk.getValueAt(baris, 2).toString();
        AmbilNamaPelanggan.NamaProdukTerpilih();
        AmbilNamaPelanggan.PerkalianProduk();
    }//GEN-LAST:event_tblProdukMouseClicked

    private void tblDokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDokterMouseClicked
        // TODO add your handling code here:
        int baris = tblDokter.getSelectedRow();
        AmbilNamaPelanggan.DapatNamaDokter = tblDokter.getValueAt(baris, 1).toString();
        AmbilNamaPelanggan.NamaDokterTerpilih();
    }//GEN-LAST:event_tblDokterMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Pencarian_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Pencarian_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Pencarian_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Pencarian_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Pencarian_Data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PencarianData;
    private javax.swing.JButton btnCariDokter;
    private javax.swing.JButton btnCariLayanan;
    private javax.swing.JButton btnCariPelanggan;
    private javax.swing.JButton btnCariProduk;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel tabDokter;
    private javax.swing.JPanel tabLayanan;
    private javax.swing.JPanel tabPelanggan;
    private javax.swing.JPanel tabProduk;
    private javax.swing.JTable tblDokter;
    private javax.swing.JTable tblLayanan;
    private javax.swing.JTable tblPelanggan;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTextField txtCariDokter;
    private javax.swing.JTextField txtCariLayanan;
    private javax.swing.JTextField txtCariPelanggan;
    private javax.swing.JTextField txtCariProduk;
    // End of variables declaration//GEN-END:variables

}
