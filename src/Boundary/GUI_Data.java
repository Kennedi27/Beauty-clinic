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

public class GUI_Data extends javax.swing.JFrame {
    private DefaultTableModel model;
    Connection con;
    Statement stat;
    ResultSet  rs;
    String sql;
    /**
     * Creates new form GUI_Data
     */
    public GUI_Data() {
        initComponents();
//        Data Dokter
        TampilDataDokter();

//        Data Kasir
        TampilDataKasir();
        
//        Data Produk
        TampilDataProduk();
        
//      Data Layanan 
        TampilDataLayanan();
        
//      Data Pelanggan
        TampilDataCustomer();
        
//        Data Transaksi
        TampilDataTransaksi();
        
    }
    public void TampilDataLayanan(){
        model = new DefaultTableModel();
        tblLayanan.setModel(model);
        model.addColumn("Kode Layanan");
        model.addColumn("Jenis Layanan");
        model.addColumn("Harga");
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
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
    public void TampilDataCustomer(){
        model = new DefaultTableModel();
        tblCustomer.setModel(model);
        model.addColumn("ID Pelanggan");
        model.addColumn("Nama");
        model.addColumn("Telp");
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
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
    
    public void TampilDataProduk(){
        model = new DefaultTableModel();
        tblProduk.setModel(model);
        model.addColumn("Kode Produk");
        model.addColumn("Nama");
        model.addColumn("Harga");
        model.addColumn("Stok");
        
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
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
    public void TampilDataKasir(){
        model = new DefaultTableModel();
        tblKasir.setModel(model);
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("Telp");
        model.addColumn("Username");
        model.addColumn("Akses");
        
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            sql = "SELECT * FROM pengguna";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                Object[] obj = new Object[6];
                obj[0] = rs.getString("id");
                obj[1] = rs.getString("nama");
                obj[2] = rs.getString("alamat");
                obj[3] = rs.getString("telp");
                obj[4] = rs.getString("username");
                obj[5] = rs.getString("posisi");
                
                model.addRow(obj);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void AfterTambahDokter(){
        idDokter.setText("");
        namaDokter.setText("");
        alamatDokter.setText("");
        telpDokter.setText("");
    }
    
    public void TampilDataTransaksi(){
        model = new DefaultTableModel();
        tblTransaksi.setModel(model);
        model.addColumn("Nomor Transaksi");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Nama Dokter");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Nama Kasir");
        model.addColumn("Total Pembayaran");
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            sql = "SELECT * FROM detail_transaksi";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                Object[] obj = new Object[6];
                obj[0] = rs.getString("no_transaksi");
                obj[1] = rs.getString("tanggal");
                obj[2] = rs.getString("pelanggan");
                obj[3] = rs.getString("dokter");
                obj[4] = rs.getString("kasir");
                obj[5] = rs.getString("total_harga_bayar");
                
                model.addRow(obj);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void TampilDataDokter(){
        model = new DefaultTableModel();
        tblDokter.setModel(model);
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("Telp");
        
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
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
    public void tabKsr(){
        tabPanelData.setSelectedIndex(1);
        pack();
        setVisible(true);
    }
    public void tabPrk(){
        tabPanelData.setSelectedIndex(2);
        pack();
        setVisible(true);
    }
    public void tabLyn(){
        tabPanelData.setSelectedIndex(3);
        pack();
        setVisible(true);
    }
    public void tabPlgn(){
        tabPanelData.setSelectedIndex(4);
        pack();
        setVisible(true);
    }
    public void tabTrsk(){
        tabPanelData.setSelectedIndex(5);
        pack();
        setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanelData = new javax.swing.JTabbedPane();
        tabDokter = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        btnUbahDokter = new javax.swing.JButton();
        btnHapusDokter = new javax.swing.JButton();
        btnSimpanDokter = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        namaDokter = new javax.swing.JTextField();
        telpDokter = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        alamatDokter = new javax.swing.JTextArea();
        idDokter = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblDokter = new javax.swing.JTable();
        btnResetDokter = new javax.swing.JButton();
        tabKasir = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        btnUbahKasir = new javax.swing.JButton();
        btnHapusKasir = new javax.swing.JButton();
        btnTambahKasir = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        namaPengguna = new javax.swing.JTextField();
        telpPengguna = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        alamatPengguna = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblKasir = new javax.swing.JTable();
        jLabel77 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        usernamePengguna = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        aksesPengguna = new javax.swing.JComboBox();
        jLabel69 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        passwordPengguna = new javax.swing.JPasswordField();
        btnReset = new javax.swing.JButton();
        tabProduk = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        btnUbahProduk = new javax.swing.JButton();
        btnHapusProduk = new javax.swing.JButton();
        btnTambahProduk = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        namaProduk = new javax.swing.JTextField();
        stokProduk = new javax.swing.JTextField();
        kodeProduk = new javax.swing.JTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        hargaProduk = new javax.swing.JTextField();
        btnResetProduk = new javax.swing.JButton();
        tabLayanan = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        btnUbahLayanan = new javax.swing.JButton();
        btnHapusLayanan = new javax.swing.JButton();
        btnTambahLayanan = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        namaLayanan = new javax.swing.JTextField();
        kodeLayanan = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblLayanan = new javax.swing.JTable();
        hargaLayanan = new javax.swing.JTextField();
        btnResetLayanan = new javax.swing.JButton();
        tabCustomer = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        btnUbahPelanggan = new javax.swing.JButton();
        btnHapusPelanggan = new javax.swing.JButton();
        btnTambahPelanggan = new javax.swing.JButton();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        namaPelanggan = new javax.swing.JTextField();
        telpPelanggan = new javax.swing.JTextField();
        idPelanggan = new javax.swing.JTextField();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        btnResetPelanggan = new javax.swing.JButton();
        tabTransaksi = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabDokter.setBackground(new java.awt.Color(181, 234, 215));
        tabDokter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 206, 234), 10));
        tabDokter.setMaximumSize(new java.awt.Dimension(1080, 720));
        tabDokter.setMinimumSize(new java.awt.Dimension(1080, 720));

        jLabel53.setText("Copyright by CynKenDo");

        jLabel54.setFont(new java.awt.Font("Dialog", 1, 60)); // NOI18N
        jLabel54.setText("Data Dokter");

        btnUbahDokter.setBackground(new java.awt.Color(199, 206, 234));
        btnUbahDokter.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnUbahDokter.setForeground(new java.awt.Color(0, 153, 255));
        btnUbahDokter.setText("Ubah");
        btnUbahDokter.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUbahDokter.setBorderPainted(false);
        btnUbahDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahDokterActionPerformed(evt);
            }
        });

        btnHapusDokter.setBackground(new java.awt.Color(199, 206, 234));
        btnHapusDokter.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnHapusDokter.setForeground(new java.awt.Color(0, 153, 255));
        btnHapusDokter.setText("Hapus");
        btnHapusDokter.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHapusDokter.setBorderPainted(false);
        btnHapusDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusDokterActionPerformed(evt);
            }
        });

        btnSimpanDokter.setBackground(new java.awt.Color(199, 206, 234));
        btnSimpanDokter.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSimpanDokter.setForeground(new java.awt.Color(0, 153, 255));
        btnSimpanDokter.setText("Simpan");
        btnSimpanDokter.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSimpanDokter.setBorderPainted(false);
        btnSimpanDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanDokterActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel55.setText("ID");

        jLabel57.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel57.setText("Nama");

        jLabel58.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel58.setText("No_Telp");

        jLabel59.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel59.setText("Alamat");

        jLabel60.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel60.setText(":");

        jLabel62.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel62.setText(":");

        jLabel63.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel63.setText(":");

        jLabel64.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel64.setText(":");

        namaDokter.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        telpDokter.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        telpDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telpDokterActionPerformed(evt);
            }
        });

        alamatDokter.setColumns(20);
        alamatDokter.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        alamatDokter.setRows(5);
        jScrollPane7.setViewportView(alamatDokter);

        idDokter.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

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
        jScrollPane10.setViewportView(tblDokter);

        btnResetDokter.setBackground(new java.awt.Color(199, 206, 234));
        btnResetDokter.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnResetDokter.setForeground(new java.awt.Color(0, 153, 255));
        btnResetDokter.setText("Reset");
        btnResetDokter.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnResetDokter.setBorderPainted(false);
        btnResetDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetDokterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabDokterLayout = new javax.swing.GroupLayout(tabDokter);
        tabDokter.setLayout(tabDokterLayout);
        tabDokterLayout.setHorizontalGroup(
            tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDokterLayout.createSequentialGroup()
                .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDokterLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel59)
                            .addComponent(jLabel58)
                            .addComponent(jLabel57))
                        .addGap(30, 30, 30)
                        .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tabDokterLayout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addGap(18, 18, 18)
                                .addComponent(namaDokter))
                            .addGroup(tabDokterLayout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addGap(18, 18, 18)
                                .addComponent(telpDokter))
                            .addGroup(tabDokterLayout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(18, 18, 18)
                                .addComponent(idDokter))
                            .addGroup(tabDokterLayout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addGap(18, 18, 18)
                                .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSimpanDokter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(tabDokterLayout.createSequentialGroup()
                                        .addComponent(btnUbahDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnHapusDokter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane7)
                                    .addComponent(btnResetDokter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(34, 34, 34)
                        .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabDokterLayout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jLabel54)))
                .addGap(0, 55, Short.MAX_VALUE))
        );
        tabDokterLayout.setVerticalGroup(
            tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDokterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addGap(44, 44, 44)
                .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDokterLayout.createSequentialGroup()
                        .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(jLabel55)
                            .addComponent(idDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(jLabel62)
                            .addComponent(namaDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(jLabel63)
                            .addComponent(telpDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel59)
                                .addComponent(jLabel64))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(btnSimpanDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(tabDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUbahDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapusDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnResetDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jLabel53)
                .addContainerGap())
        );

        tabPanelData.addTab("Doktor", tabDokter);

        tabKasir.setBackground(new java.awt.Color(181, 234, 215));
        tabKasir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 206, 234), 10));
        tabKasir.setMaximumSize(new java.awt.Dimension(1080, 720));
        tabKasir.setMinimumSize(new java.awt.Dimension(1080, 720));

        jLabel56.setText("Copyright by CynKenDo");

        jLabel61.setFont(new java.awt.Font("Dialog", 1, 60)); // NOI18N
        jLabel61.setText("Data Pengguna");

        btnUbahKasir.setBackground(new java.awt.Color(199, 206, 234));
        btnUbahKasir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnUbahKasir.setForeground(new java.awt.Color(0, 153, 255));
        btnUbahKasir.setText("Ubah");
        btnUbahKasir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUbahKasir.setBorderPainted(false);
        btnUbahKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahKasirActionPerformed(evt);
            }
        });

        btnHapusKasir.setBackground(new java.awt.Color(199, 206, 234));
        btnHapusKasir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnHapusKasir.setForeground(new java.awt.Color(0, 153, 255));
        btnHapusKasir.setText("Hapus");
        btnHapusKasir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHapusKasir.setBorderPainted(false);
        btnHapusKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusKasirActionPerformed(evt);
            }
        });

        btnTambahKasir.setBackground(new java.awt.Color(199, 206, 234));
        btnTambahKasir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnTambahKasir.setForeground(new java.awt.Color(0, 153, 255));
        btnTambahKasir.setText("Simpan");
        btnTambahKasir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTambahKasir.setBorderPainted(false);
        btnTambahKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahKasirActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel66.setText("Nama");

        jLabel67.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel67.setText("No_Telp");

        jLabel68.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel68.setText("Alamat");

        jLabel70.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel70.setText(":");

        jLabel71.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel71.setText(":");

        jLabel72.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel72.setText(":");

        namaPengguna.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        telpPengguna.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        telpPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telpPenggunaActionPerformed(evt);
            }
        });

        alamatPengguna.setColumns(20);
        alamatPengguna.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        alamatPengguna.setRows(5);
        jScrollPane11.setViewportView(alamatPengguna);

        tblKasir.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKasirMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblKasir);

        jLabel77.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel77.setText("Username");

        jLabel81.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel81.setText(":");

        usernamePengguna.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        usernamePengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernamePenggunaActionPerformed(evt);
            }
        });

        jLabel102.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel102.setText("Password");

        jLabel103.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel103.setText(":");

        aksesPengguna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "kasir" }));

        jLabel69.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel69.setText("Alamat");

        jLabel104.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel104.setText(":");

        btnReset.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 123, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabKasirLayout = new javax.swing.GroupLayout(tabKasir);
        tabKasir.setLayout(tabKasirLayout);
        tabKasirLayout.setHorizontalGroup(
            tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabKasirLayout.createSequentialGroup()
                .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabKasirLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tabKasirLayout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(tabKasirLayout.createSequentialGroup()
                                .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel66)
                                    .addComponent(jLabel77)
                                    .addComponent(jLabel69)
                                    .addComponent(jLabel67))
                                .addGap(18, 18, 18)
                                .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabKasirLayout.createSequentialGroup()
                                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(usernamePengguna))
                                        .addGroup(tabKasirLayout.createSequentialGroup()
                                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(telpPengguna))
                                        .addGroup(tabKasirLayout.createSequentialGroup()
                                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(namaPengguna)))
                                    .addGroup(tabKasirLayout.createSequentialGroup()
                                        .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(tabKasirLayout.createSequentialGroup()
                                                .addComponent(btnUbahKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnHapusKasir, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                            .addComponent(btnTambahKasir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(aksesPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(tabKasirLayout.createSequentialGroup()
                                .addComponent(jLabel102)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(passwordPengguna)))
                        .addGap(34, 34, 34)
                        .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabKasirLayout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel61)))
                .addGap(0, 43, Short.MAX_VALUE))
        );
        tabKasirLayout.setVerticalGroup(
            tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabKasirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabKasirLayout.createSequentialGroup()
                        .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(jLabel70)
                            .addComponent(namaPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel71)
                                .addComponent(telpPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77)
                            .addComponent(jLabel81)
                            .addComponent(usernamePengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel102)
                                .addComponent(jLabel103))
                            .addGroup(tabKasirLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(passwordPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel68)
                                .addComponent(jLabel72))
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aksesPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69)
                            .addComponent(jLabel104))
                        .addGap(18, 18, 18)
                        .addComponent(btnTambahKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(tabKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUbahKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapusKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jLabel56)
                .addContainerGap())
        );

        tabPanelData.addTab("Pengguna", tabKasir);

        tabProduk.setBackground(new java.awt.Color(181, 234, 215));
        tabProduk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 206, 234), 10));
        tabProduk.setMaximumSize(new java.awt.Dimension(1080, 720));
        tabProduk.setMinimumSize(new java.awt.Dimension(1080, 720));

        jLabel83.setText("Copyright by CynKenDo");

        jLabel84.setFont(new java.awt.Font("Dialog", 1, 60)); // NOI18N
        jLabel84.setText("Data Produk");

        btnUbahProduk.setBackground(new java.awt.Color(199, 206, 234));
        btnUbahProduk.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnUbahProduk.setForeground(new java.awt.Color(0, 153, 255));
        btnUbahProduk.setText("Ubah");
        btnUbahProduk.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUbahProduk.setBorderPainted(false);
        btnUbahProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahProdukActionPerformed(evt);
            }
        });

        btnHapusProduk.setBackground(new java.awt.Color(199, 206, 234));
        btnHapusProduk.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnHapusProduk.setForeground(new java.awt.Color(0, 153, 255));
        btnHapusProduk.setText("Hapus");
        btnHapusProduk.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHapusProduk.setBorderPainted(false);
        btnHapusProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusProdukActionPerformed(evt);
            }
        });

        btnTambahProduk.setBackground(new java.awt.Color(199, 206, 234));
        btnTambahProduk.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnTambahProduk.setForeground(new java.awt.Color(0, 153, 255));
        btnTambahProduk.setText("Simpan");
        btnTambahProduk.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTambahProduk.setBorderPainted(false);
        btnTambahProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahProdukActionPerformed(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel85.setText("Kode");

        jLabel86.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel86.setText("Nama");

        jLabel87.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel87.setText("Stok");

        jLabel88.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel88.setText("Harga");

        jLabel89.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel89.setText(":");

        jLabel90.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel90.setText(":");

        jLabel91.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel91.setText(":");

        jLabel92.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel92.setText(":");

        namaProduk.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        stokProduk.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        stokProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokProdukActionPerformed(evt);
            }
        });

        kodeProduk.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

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
        jScrollPane16.setViewportView(tblProduk);

        hargaProduk.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        hargaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaProdukActionPerformed(evt);
            }
        });

        btnResetProduk.setBackground(new java.awt.Color(199, 206, 234));
        btnResetProduk.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnResetProduk.setForeground(new java.awt.Color(0, 153, 255));
        btnResetProduk.setText("Reset");
        btnResetProduk.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnResetProduk.setBorderPainted(false);
        btnResetProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetProdukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabProdukLayout = new javax.swing.GroupLayout(tabProduk);
        tabProduk.setLayout(tabProdukLayout);
        tabProdukLayout.setHorizontalGroup(
            tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProdukLayout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jLabel84)
                .addGap(0, 372, Short.MAX_VALUE))
            .addGroup(tabProdukLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabProdukLayout.createSequentialGroup()
                        .addGroup(tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel85)
                            .addComponent(jLabel88)
                            .addComponent(jLabel87)
                            .addComponent(jLabel86))
                        .addGap(30, 30, 30)
                        .addGroup(tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tabProdukLayout.createSequentialGroup()
                                .addComponent(jLabel90)
                                .addGap(18, 18, 18)
                                .addComponent(namaProduk))
                            .addGroup(tabProdukLayout.createSequentialGroup()
                                .addComponent(jLabel89)
                                .addGap(18, 18, 18)
                                .addComponent(kodeProduk))
                            .addGroup(tabProdukLayout.createSequentialGroup()
                                .addComponent(jLabel91)
                                .addGap(18, 18, 18)
                                .addComponent(stokProduk))
                            .addGroup(tabProdukLayout.createSequentialGroup()
                                .addComponent(jLabel92)
                                .addGap(18, 18, 18)
                                .addComponent(hargaProduk))
                            .addGroup(tabProdukLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnResetProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(tabProdukLayout.createSequentialGroup()
                                        .addComponent(btnUbahProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnHapusProduk, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))))
                    .addComponent(btnTambahProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(tabProdukLayout.createSequentialGroup()
                .addGap(429, 429, 429)
                .addComponent(jLabel83)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabProdukLayout.setVerticalGroup(
            tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabProdukLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel84)
                .addGap(44, 44, 44)
                .addGroup(tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabProdukLayout.createSequentialGroup()
                        .addGroup(tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel89)
                            .addComponent(jLabel85)
                            .addComponent(kodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel86)
                            .addComponent(jLabel90)
                            .addComponent(namaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(jLabel91)
                            .addComponent(stokProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel88)
                            .addComponent(jLabel92)
                            .addComponent(hargaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(btnTambahProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(tabProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUbahProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapusProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btnResetProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jLabel83)
                .addGap(104, 104, 104))
        );

        tabPanelData.addTab("Produk", tabProduk);

        tabLayanan.setBackground(new java.awt.Color(181, 234, 215));
        tabLayanan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 206, 234), 10));
        tabLayanan.setMaximumSize(new java.awt.Dimension(1080, 720));
        tabLayanan.setMinimumSize(new java.awt.Dimension(1080, 720));

        jLabel73.setText("Copyright by CynKenDo");

        jLabel74.setFont(new java.awt.Font("Dialog", 1, 60)); // NOI18N
        jLabel74.setText("Data Layanan");

        btnUbahLayanan.setBackground(new java.awt.Color(199, 206, 234));
        btnUbahLayanan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnUbahLayanan.setForeground(new java.awt.Color(0, 153, 255));
        btnUbahLayanan.setText("Ubah");
        btnUbahLayanan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUbahLayanan.setBorderPainted(false);
        btnUbahLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahLayananActionPerformed(evt);
            }
        });

        btnHapusLayanan.setBackground(new java.awt.Color(199, 206, 234));
        btnHapusLayanan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnHapusLayanan.setForeground(new java.awt.Color(0, 153, 255));
        btnHapusLayanan.setText("Hapus");
        btnHapusLayanan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHapusLayanan.setBorderPainted(false);
        btnHapusLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusLayananActionPerformed(evt);
            }
        });

        btnTambahLayanan.setBackground(new java.awt.Color(199, 206, 234));
        btnTambahLayanan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnTambahLayanan.setForeground(new java.awt.Color(0, 153, 255));
        btnTambahLayanan.setText("Simpan");
        btnTambahLayanan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTambahLayanan.setBorderPainted(false);
        btnTambahLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahLayananActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel75.setText("Kode");

        jLabel76.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel76.setText("Nama");

        jLabel78.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel78.setText("Harga");

        jLabel79.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel79.setText(":");

        jLabel80.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel80.setText(":");

        jLabel82.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel82.setText(":");

        namaLayanan.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        kodeLayanan.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

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
        jScrollPane14.setViewportView(tblLayanan);

        hargaLayanan.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        hargaLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaLayananActionPerformed(evt);
            }
        });

        btnResetLayanan.setBackground(new java.awt.Color(199, 206, 234));
        btnResetLayanan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnResetLayanan.setForeground(new java.awt.Color(0, 153, 255));
        btnResetLayanan.setText("Reset");
        btnResetLayanan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnResetLayanan.setBorderPainted(false);
        btnResetLayanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetLayananActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabLayananLayout = new javax.swing.GroupLayout(tabLayanan);
        tabLayanan.setLayout(tabLayananLayout);
        tabLayananLayout.setHorizontalGroup(
            tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabLayananLayout.createSequentialGroup()
                .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabLayananLayout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jLabel74))
                    .addGroup(tabLayananLayout.createSequentialGroup()
                        .addGap(442, 442, 442)
                        .addComponent(jLabel73)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(tabLayananLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabLayananLayout.createSequentialGroup()
                        .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75)
                            .addComponent(jLabel76))
                        .addGap(33, 33, 33)
                        .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tabLayananLayout.createSequentialGroup()
                                .addComponent(jLabel80)
                                .addGap(18, 18, 18)
                                .addComponent(namaLayanan, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                            .addGroup(tabLayananLayout.createSequentialGroup()
                                .addComponent(jLabel79)
                                .addGap(18, 18, 18)
                                .addComponent(kodeLayanan))))
                    .addGroup(tabLayananLayout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel82)
                        .addGap(18, 18, 18)
                        .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabLayananLayout.createSequentialGroup()
                                .addComponent(btnUbahLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapusLayanan, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                            .addComponent(btnTambahLayanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hargaLayanan)
                            .addComponent(btnResetLayanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        tabLayananLayout.setVerticalGroup(
            tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabLayananLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel74)
                .addGap(44, 44, 44)
                .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabLayananLayout.createSequentialGroup()
                        .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79)
                            .addComponent(jLabel75)
                            .addComponent(kodeLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(jLabel80)
                            .addComponent(namaLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel78)
                                .addComponent(jLabel82))
                            .addComponent(hargaLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(btnTambahLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabLayananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUbahLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapusLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnResetLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel73)
                .addContainerGap())
        );

        tabPanelData.addTab("Layanan", tabLayanan);

        tabCustomer.setBackground(new java.awt.Color(181, 234, 215));
        tabCustomer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 206, 234), 10));
        tabCustomer.setMaximumSize(new java.awt.Dimension(1080, 720));
        tabCustomer.setMinimumSize(new java.awt.Dimension(1080, 720));

        jLabel93.setText("Copyright by CynKenDo");

        jLabel94.setFont(new java.awt.Font("Dialog", 1, 60)); // NOI18N
        jLabel94.setText("Data Pelanggan");

        btnUbahPelanggan.setBackground(new java.awt.Color(199, 206, 234));
        btnUbahPelanggan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnUbahPelanggan.setForeground(new java.awt.Color(0, 153, 255));
        btnUbahPelanggan.setText("Ubah");
        btnUbahPelanggan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUbahPelanggan.setBorderPainted(false);
        btnUbahPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahPelangganActionPerformed(evt);
            }
        });

        btnHapusPelanggan.setBackground(new java.awt.Color(199, 206, 234));
        btnHapusPelanggan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnHapusPelanggan.setForeground(new java.awt.Color(0, 153, 255));
        btnHapusPelanggan.setText("Hapus");
        btnHapusPelanggan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHapusPelanggan.setBorderPainted(false);
        btnHapusPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPelangganActionPerformed(evt);
            }
        });

        btnTambahPelanggan.setBackground(new java.awt.Color(199, 206, 234));
        btnTambahPelanggan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnTambahPelanggan.setForeground(new java.awt.Color(0, 153, 255));
        btnTambahPelanggan.setText("Simpan");
        btnTambahPelanggan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTambahPelanggan.setBorderPainted(false);
        btnTambahPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahPelangganActionPerformed(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel95.setText("ID");

        jLabel96.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel96.setText("Nama");

        jLabel97.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel97.setText("No_Telp");

        jLabel99.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel99.setText(":");

        jLabel100.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel100.setText(":");

        jLabel101.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel101.setText(":");

        namaPelanggan.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        telpPelanggan.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        telpPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telpPelangganActionPerformed(evt);
            }
        });

        idPelanggan.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tblCustomer);

        btnResetPelanggan.setBackground(new java.awt.Color(199, 206, 234));
        btnResetPelanggan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnResetPelanggan.setForeground(new java.awt.Color(0, 153, 255));
        btnResetPelanggan.setText("Reset");
        btnResetPelanggan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnResetPelanggan.setBorderPainted(false);
        btnResetPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPelangganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabCustomerLayout = new javax.swing.GroupLayout(tabCustomer);
        tabCustomer.setLayout(tabCustomerLayout);
        tabCustomerLayout.setHorizontalGroup(
            tabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCustomerLayout.createSequentialGroup()
                .addGap(442, 442, 442)
                .addComponent(jLabel93)
                .addGap(0, 528, Short.MAX_VALUE))
            .addGroup(tabCustomerLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(tabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel95)
                    .addComponent(jLabel97)
                    .addComponent(jLabel96))
                .addGap(18, 18, 18)
                .addGroup(tabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabCustomerLayout.createSequentialGroup()
                        .addComponent(jLabel100)
                        .addGap(18, 18, 18)
                        .addComponent(namaPelanggan))
                    .addGroup(tabCustomerLayout.createSequentialGroup()
                        .addComponent(jLabel99)
                        .addGap(18, 18, 18)
                        .addComponent(idPelanggan))
                    .addGroup(tabCustomerLayout.createSequentialGroup()
                        .addComponent(jLabel101)
                        .addGap(18, 18, 18)
                        .addGroup(tabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTambahPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(tabCustomerLayout.createSequentialGroup()
                                .addComponent(btnUbahPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapusPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                            .addComponent(telpPelanggan)
                            .addComponent(btnResetPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabCustomerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel94)
                .addGap(318, 318, 318))
        );
        tabCustomerLayout.setVerticalGroup(
            tabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel94)
                .addGap(44, 44, 44)
                .addGroup(tabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabCustomerLayout.createSequentialGroup()
                        .addGroup(tabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(jLabel95)
                            .addComponent(idPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel96)
                            .addComponent(jLabel100)
                            .addComponent(namaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel97)
                            .addComponent(jLabel101)
                            .addComponent(telpPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btnTambahPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(tabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUbahPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapusPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnResetPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jLabel93)
                .addContainerGap())
        );

        tabPanelData.addTab("Pelanggan", tabCustomer);

        tabTransaksi.setBackground(new java.awt.Color(181, 234, 215));
        tabTransaksi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 206, 234), 10));

        jLabel98.setFont(new java.awt.Font("Dialog", 1, 60)); // NOI18N
        jLabel98.setText("Data Transaksi");

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTransaksi);

        javax.swing.GroupLayout tabTransaksiLayout = new javax.swing.GroupLayout(tabTransaksi);
        tabTransaksi.setLayout(tabTransaksiLayout);
        tabTransaksiLayout.setHorizontalGroup(
            tabTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTransaksiLayout.createSequentialGroup()
                .addGroup(tabTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransaksiLayout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel98))
                    .addGroup(tabTransaksiLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        tabTransaksiLayout.setVerticalGroup(
            tabTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTransaksiLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel98)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        tabPanelData.addTab("Transaksi", tabTransaksi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanelData)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanelData)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telpDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telpDokterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telpDokterActionPerformed

    private void stokProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokProdukActionPerformed

    private void hargaLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaLayananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaLayananActionPerformed

    private void hargaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaProdukActionPerformed

    private void telpPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telpPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telpPelangganActionPerformed

    private void btnTambahLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahLayananActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        String kodeLyn = kodeLayanan.getText();
        String namaLyn = namaLayanan.getText();
        String hargaLyn = hargaLayanan.getText();
        
        try {
            sql = "INSERT INTO layanan (kode, nama, harga) VALUES('"+kodeLyn+"', '"+namaLyn+"', '"+hargaLyn+"')";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Data Layanan Berhasil Di Tambah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }  
        TampilDataLayanan();
        AfterInsertLayanan();
    }//GEN-LAST:event_btnTambahLayananActionPerformed
    
    public void AfterInsertLayanan(){
        kodeLayanan.setText("");
        namaLayanan.setText("");
        hargaLayanan.setText("");
    }
    private void btnSimpanDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanDokterActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        String idDkt = idDokter.getText();
        String namaDkt = namaDokter.getText();
        String alamatDkt = alamatDokter.getText();
        String telpDkt = telpDokter.getText();
        try {
            sql = "INSERT INTO dokter(id, nama, alamat, telp) VALUES('"+idDkt+"','"+namaDkt+"','"+alamatDkt+"','"+telpDkt+"')";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataDokter();
        AfterTambahDokter();
    }//GEN-LAST:event_btnSimpanDokterActionPerformed

    private void tblDokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDokterMouseClicked
        // TODO add your handling code here:
        int baris = tblDokter.rowAtPoint(evt.getPoint());
        String id = tblDokter.getValueAt(baris, 0).toString();
        idDokter.setText(id);
        String nama = tblDokter.getValueAt(baris, 1).toString();
        namaDokter.setText(nama);
        String telp = tblDokter.getValueAt(baris, 3).toString();
        telpDokter.setText(telp);
        String alamat = tblDokter.getValueAt(baris, 2).toString();
        alamatDokter.setText(alamat);
        
    }//GEN-LAST:event_tblDokterMouseClicked

    private void btnUbahDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahDokterActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        String idDkt = idDokter.getText();
        String namaDkt = namaDokter.getText();
        String alamatDkt = alamatDokter.getText();
        String telpDkt = telpDokter.getText();
        try {
            sql = "UPDATE dokter SET id = '"+idDkt+"', nama = '"+namaDkt+"',alamat = '"+alamatDkt+"',telp = '"+telpDkt+"' WHERE id = '"+idDkt+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Update Berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataDokter();
        AfterTambahDokter();
               
    }//GEN-LAST:event_btnUbahDokterActionPerformed

    private void btnHapusDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusDokterActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        String idDkt = idDokter.getText();
        try {
            sql = "DELETE FROM dokter WHERE id = '"+idDkt+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Mengahapus Data Dokter");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataDokter();
        AfterTambahDokter();
    }//GEN-LAST:event_btnHapusDokterActionPerformed

    private void btnTambahKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahKasirActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        String namaKsr = namaPengguna.getText();
        String alamatKsr = alamatPengguna.getText();
        String telpKsr = telpPengguna.getText();
        String aksesKsr = (String)aksesPengguna.getSelectedItem();
        String passwordKsr = passwordPengguna.getText();
        String usernameKsr = usernamePengguna.getText();
        
        try {
            sql = "INSERT INTO pengguna (nama, alamat, telp, username, password, posisi) VALUES ('"+namaKsr+"', '"+alamatKsr+"', '"+telpKsr+"', '"+usernameKsr+"', '"+passwordKsr+"', '"+aksesKsr+"')";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Menambah Data Pengguna");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataKasir();
        AfterInsertKasir();
    }//GEN-LAST:event_btnTambahKasirActionPerformed

    private void tblKasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKasirMouseClicked
        // TODO add your handling code here:
        int baris = tblKasir.rowAtPoint(evt.getPoint());
        String id = tblKasir.getValueAt(baris, 0).toString();
        lblId.setText(id);
        String nama = tblKasir.getValueAt(baris, 1).toString();
        namaPengguna.setText(nama);
        String alamat = tblKasir.getValueAt(baris, 2).toString();
        alamatPengguna.setText(alamat);
        String telp = tblKasir.getValueAt(baris, 3).toString();
        telpPengguna.setText(telp);
        String username = tblKasir.getValueAt(baris, 4).toString();
        usernamePengguna.setText(username);
        passwordPengguna.setText("********");
        String akses = tblKasir.getValueAt(baris, 5).toString();
        aksesPengguna.setSelectedItem(akses);
        lblId.setVisible(false);
//        if(akses == "kasir"){
//            aksesPengguna.setSelectedItem("kasir");
//        }else{
//            aksesPengguna.setSelectedItem("admin");
//        }
    }//GEN-LAST:event_tblKasirMouseClicked

    private void btnUbahKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahKasirActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        String idKsr = lblId.getText();
        String namaKsr = namaPengguna.getText();
        String alamatKsr = alamatPengguna.getText();
        String telpKsr = telpPengguna.getText();
        String usernameKsr = usernamePengguna.getText();
        String aksesKsr = (String)aksesPengguna.getSelectedItem();
        
        try {
            sql = "UPDATE Pengguna SET id = '"+idKsr+"',nama = '"+namaKsr+"',alamat = '"+alamatKsr+"',telp = '"+telpKsr+"',username = '"+usernameKsr+"',posisi = '"+aksesKsr+"' WHERE id = '"+idKsr+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Update Data Pengguna Berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataKasir();
        AfterInsertKasir();
    }//GEN-LAST:event_btnUbahKasirActionPerformed

    private void btnHapusKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusKasirActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        String idKsr = lblId.getText();
        
        try {
            sql = "DELETE FROM pengguna WHERE id = '"+idKsr+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Data Pengguna Telah Terhapus");
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataKasir();
        AfterInsertKasir();
    }//GEN-LAST:event_btnHapusKasirActionPerformed

    private void btnTambahProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahProdukActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        String kodePrdk = kodeProduk.getText();
        String namaPrdk = namaProduk.getText();
        String stokPrdk = stokProduk.getText();
        String hargaPrdk = hargaProduk.getText();
        
        try {
            sql = "INSERT INTO produk(kode, nama, stok, harga) VALUES('"+kodePrdk+"', '"+namaPrdk+"', '"+stokPrdk+"', '"+hargaPrdk+"')";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Data Produk Berhasil Ditambahkan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataProduk();
        AfterInsertProduk();
    }//GEN-LAST:event_btnTambahProdukActionPerformed

    private void tblProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdukMouseClicked
        // TODO add your handling code here:
        int baris = tblProduk.rowAtPoint(evt.getPoint());
        String kode = tblProduk.getValueAt(baris, 0).toString();
        kodeProduk.setText(kode);
        String nama = tblProduk.getValueAt(baris, 1).toString();
        namaProduk.setText(nama);
        String harga = tblProduk.getValueAt(baris, 2).toString();
        hargaProduk.setText(harga);
        String stok = tblProduk.getValueAt(baris, 3).toString();
        stokProduk.setText(stok);
    }//GEN-LAST:event_tblProdukMouseClicked

    private void btnUbahProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahProdukActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        String kodePrdk = kodeProduk.getText();
        String namaPrdk = namaProduk.getText();
        String stokPrdk = stokProduk.getText();
        String hargaPrdk = hargaProduk.getText();
        
        try {
            sql = "UPDATE produk SET kode = '"+kodePrdk+"', nama = '"+namaPrdk+"', stok = '"+stokPrdk+"', harga = '"+hargaPrdk+"' WHERE kode = '"+kodePrdk+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Update Data Produk");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataProduk();
        AfterInsertProduk();
    }//GEN-LAST:event_btnUbahProdukActionPerformed

    private void btnHapusProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusProdukActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        String kodePrdk = kodeProduk.getText();
        
        try {
            sql = "DELETE FROM produk WHERE kode = '"+kodePrdk+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Data Produk Berhasil di Hapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        TampilDataProduk();
        AfterInsertProduk();
    }//GEN-LAST:event_btnHapusProdukActionPerformed

    private void tblLayananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLayananMouseClicked
        // TODO add your handling code here:
        int baris = tblLayanan.rowAtPoint(evt.getPoint());
        String kode = tblLayanan.getValueAt(baris, 0).toString();
        kodeLayanan.setText(kode);
        String nama = tblLayanan.getValueAt(baris, 1).toString();
        namaLayanan.setText(nama);
        String harga = tblLayanan.getValueAt(baris, 2).toString();
        hargaLayanan.setText(harga);
    }//GEN-LAST:event_tblLayananMouseClicked

    private void btnUbahLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahLayananActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        String kodeLyn = kodeLayanan.getText();
        String namaLyn = namaLayanan.getText();
        String hargaLyn = hargaLayanan.getText();
        
        try {
            sql = "UPDATE layanan set kode = '"+kodeLyn+"', nama = '"+namaLyn+"', harga = '"+hargaLyn+"' WHERE kode = '"+kodeLyn+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Data Layanan Berhasil Di Ubah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataLayanan();
        AfterInsertLayanan();
    }//GEN-LAST:event_btnUbahLayananActionPerformed

    private void btnHapusLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusLayananActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        String kodeLyn = kodeLayanan.getText();
        try {
            sql = "DELETE FROM layanan WHERE kode = '"+kodeLyn+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataLayanan();
        AfterInsertLayanan();
    }//GEN-LAST:event_btnHapusLayananActionPerformed

    private void btnTambahPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPelangganActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        String idPlgn = idPelanggan.getText();
        String namaPlgn = namaPelanggan.getText();
        String telpPlgn = telpPelanggan.getText();
        
        try {
            sql = "INSERT INTO customer(id, nama, telp) VALUES('"+idPlgn+"', '"+namaPlgn+"', '"+telpPlgn+"')";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Data Pelanggan Berhasil di Tambah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataCustomer();
        AfterInsertPelanggan();
    }//GEN-LAST:event_btnTambahPelangganActionPerformed

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        // TODO add your handling code here:
        int baris = tblCustomer.rowAtPoint(evt.getPoint());
        String id = tblCustomer.getValueAt(baris, 0).toString();
        idPelanggan.setText(id);
        String nama = tblCustomer.getValueAt(baris, 1).toString();
        namaPelanggan.setText(nama);
        String telp = tblCustomer.getValueAt(baris, 2).toString();
        telpPelanggan.setText(telp);
    }//GEN-LAST:event_tblCustomerMouseClicked

    private void btnUbahPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahPelangganActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        String idPlgn = idPelanggan.getText();
        String namaPlgn = namaPelanggan.getText();
        String telpPlgn = telpPelanggan.getText();
        
        try {
            sql = "UPDATE customer SET id = '"+idPlgn+"', nama = '"+namaPlgn+"', telp = '"+telpPlgn+"' WHERE id = '"+idPlgn+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Mengubah Data Pelanggan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataCustomer();
        AfterInsertPelanggan();
    }//GEN-LAST:event_btnUbahPelangganActionPerformed

    private void btnHapusPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusPelangganActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        String idPlgn = idPelanggan.getText();
        
        try {
            sql = "DELETE FROM customer WHERE id = '"+idPlgn+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Data Pelanggan Berhasil di Hapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataCustomer();
        AfterInsertPelanggan();
    }//GEN-LAST:event_btnHapusPelangganActionPerformed

    private void usernamePenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernamePenggunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernamePenggunaActionPerformed

    private void telpPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telpPenggunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telpPenggunaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        AfterInsertKasir();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnResetDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetDokterActionPerformed
        // TODO add your handling code here:
        AfterTambahDokter();
    }//GEN-LAST:event_btnResetDokterActionPerformed

    private void btnResetProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetProdukActionPerformed
        // TODO add your handling code here:
        AfterInsertProduk();
    }//GEN-LAST:event_btnResetProdukActionPerformed

    private void btnResetLayananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetLayananActionPerformed
        // TODO add your handling code here:
        AfterInsertLayanan();
    }//GEN-LAST:event_btnResetLayananActionPerformed

    private void btnResetPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPelangganActionPerformed
        // TODO add your handling code here:
        AfterInsertPelanggan();
    }//GEN-LAST:event_btnResetPelangganActionPerformed
    
    public void AfterInsertPelanggan(){
        idPelanggan.setText("");
        namaPelanggan.setText("");
        telpPelanggan.setText("");
    }
    
    public void AfterInsertProduk(){
        kodeProduk.setText("");
        namaProduk.setText("");
        stokProduk.setText("");
        hargaProduk.setText("");
    }
    
    public void AfterInsertKasir(){
        lblId.setText("");
        namaPengguna.setText("");
        alamatPengguna.setText("");
        telpPengguna.setText("");
        usernamePengguna.setText("");
        passwordPengguna.setText("");
    }
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
            java.util.logging.Logger.getLogger(GUI_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox aksesPengguna;
    private javax.swing.JTextArea alamatDokter;
    private javax.swing.JTextArea alamatPengguna;
    private javax.swing.JButton btnHapusDokter;
    private javax.swing.JButton btnHapusKasir;
    private javax.swing.JButton btnHapusLayanan;
    private javax.swing.JButton btnHapusPelanggan;
    private javax.swing.JButton btnHapusProduk;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnResetDokter;
    private javax.swing.JButton btnResetLayanan;
    private javax.swing.JButton btnResetPelanggan;
    private javax.swing.JButton btnResetProduk;
    private javax.swing.JButton btnSimpanDokter;
    private javax.swing.JButton btnTambahKasir;
    private javax.swing.JButton btnTambahLayanan;
    private javax.swing.JButton btnTambahPelanggan;
    private javax.swing.JButton btnTambahProduk;
    private javax.swing.JButton btnUbahDokter;
    private javax.swing.JButton btnUbahKasir;
    private javax.swing.JButton btnUbahLayanan;
    private javax.swing.JButton btnUbahPelanggan;
    private javax.swing.JButton btnUbahProduk;
    private javax.swing.JTextField hargaLayanan;
    private javax.swing.JTextField hargaProduk;
    private javax.swing.JTextField idDokter;
    private javax.swing.JTextField idPelanggan;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField kodeLayanan;
    private javax.swing.JTextField kodeProduk;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField namaDokter;
    private javax.swing.JTextField namaLayanan;
    private javax.swing.JTextField namaPelanggan;
    private javax.swing.JTextField namaPengguna;
    private javax.swing.JTextField namaProduk;
    private javax.swing.JPasswordField passwordPengguna;
    private javax.swing.JTextField stokProduk;
    private javax.swing.JPanel tabCustomer;
    private javax.swing.JPanel tabDokter;
    private javax.swing.JPanel tabKasir;
    private javax.swing.JPanel tabLayanan;
    private javax.swing.JTabbedPane tabPanelData;
    private javax.swing.JPanel tabProduk;
    private javax.swing.JPanel tabTransaksi;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTable tblDokter;
    private javax.swing.JTable tblKasir;
    private javax.swing.JTable tblLayanan;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField telpDokter;
    private javax.swing.JTextField telpPelanggan;
    private javax.swing.JTextField telpPengguna;
    private javax.swing.JTextField usernamePengguna;
    // End of variables declaration//GEN-END:variables
}
