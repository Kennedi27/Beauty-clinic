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
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author RIDO
 */
public class GUI_Transaksi extends javax.swing.JFrame {
    private DefaultTableModel model;
    public String DapatNamaPelanggan; 
    public String DapatNamaLayanan;
    public String DapatHargaLayanan;
    public String DapatNamaProduk;
    public String DapatHargaProduk;
    public String DapatNamaDokter;
    public String terlogin;
    Connection con;
    Statement stat;
    ResultSet  rs;
    String sql;
    /**
     * Creates new form GUI_Transaksi
     */
    public GUI_Transaksi(String terlogin) {
        initComponents();
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        vardong.setText(terlogin);
        vardong.hide();
        ambilNamaKasir();
        TampilPelanggan(); 
        SetTanggalSekarang();
        TampilDataTransaksi();
        noTransaksiOtomatis();
        
        lblIdTrans.setVisible(false);
        
    }
    
    public String GetNamaPelanganKami(){
        return DapatNamaPelanggan;
    }
    public String GetNamaProduk(){
        return DapatNamaProduk;
    }
    public String GetHargaProduk(){
        return DapatHargaProduk;
    }
    public String GetNamaLayananKami(){
        return DapatNamaLayanan;
    }
    public String GetHargaLayananKami(){
        return DapatHargaLayanan;
    }
    public String GetNamaDokter(){
        return DapatNamaDokter;
    }
    public void SetTanggalSekarang(){
        Date tanggal = new Date();
        SimpleDateFormat formatTanggal = new SimpleDateFormat("dd-MM-yyyy");
        txtTanggalTransaksi.setText(formatTanggal.format(tanggal));
        txtTanggalTransaksi.setEditable(false);
        txtNamaPelangganTransaksi.setEditable(false);
        txtNamaProdukTransaksi.setEditable(false);
        txtNamaLayananTransaksi.setEditable(false);
        txtNamaDokterTransaksi.setEditable(false);
        txtTotalPembayaran.setEditable(false);
        btnSimpanPenjualan.setEnabled(false);
        txtNoTransaksi.setEditable(false);
        Barlang.hide();
        btnUbahPenjualan.setEnabled(false);
    }
    
    public void NamaLayananTerpilih(){
        GUI_Pencarian_Data layananku = new GUI_Pencarian_Data();
        layananku.AmbilNamaPelanggan = this;
        txtNamaLayananTransaksi.setText(DapatNamaLayanan);
        lblHargaLayananTransaksi.setText(DapatHargaLayanan);
    }
    public void NamaDokterTerpilih(){
        GUI_Pencarian_Data dokterku = new GUI_Pencarian_Data();
        dokterku.AmbilNamaPelanggan = this;
        txtNamaDokterTransaksi.setText(DapatNamaDokter);
    }
    public void NamaProdukTerpilih(){
        GUI_Pencarian_Data produkku = new GUI_Pencarian_Data();
        produkku.AmbilNamaPelanggan = this;
        txtNamaProdukTransaksi.setText(DapatNamaProduk);
        lblHargaProdukTransaksi.setText(DapatHargaProduk);
        
    }
    public void PerkalianProduk(){
        String HasilPerkalianProduk;
        int Qty, harga, operasi;
        txtQtyProdukTransaksi.setText("1");
        Qty = Integer.parseInt(txtQtyProdukTransaksi.getText());
        harga = Integer.parseInt(lblHargaProdukTransaksi.getText());
        operasi = Qty * harga;
        HasilPerkalianProduk = Integer.toString(operasi);
        lblTotalHargaProdukTransaksi.setText(HasilPerkalianProduk);
    }
    public void NamaPelangganTerpilih(){
        GUI_Pencarian_Data pelangganku = new GUI_Pencarian_Data();
        pelangganku.AmbilNamaPelanggan = this;
        txtNamaPelangganTransaksi.setText(DapatNamaPelanggan);
    }
    public void TampilPelanggan(){
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
    
    public void ambilNamaKasir(){
        try {
            sql = "SELECT * FROM pengguna WHERE username = '"+vardong.getText()+"'";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String ckck;
                ckck = rs.getString("nama");
                lblNamaKasirTrans.setText(ckck);
            }
        }catch(Exception e){
        
        }
    }
    public void tabTransk(){
        tabKasirku.setSelectedIndex(0);
        pack();
        setVisible(true);
    }
    public void tabMember(){
        tabKasirku.setSelectedIndex(1);
        pack();
        setVisible(true);
    }
    public void HapusDataTransaksi(){
        try {
            sql = "DELETE FROM detail_transaksi WHERE no_transaksi = '"+txtNoTransaksi.getText()+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilDataTransaksi();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        tabKasirku = new javax.swing.JTabbedPane();
        tabTransaksi = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        txtNamaPelangganTransaksi = new javax.swing.JTextField();
        txtNamaLayananTransaksi = new javax.swing.JTextField();
        txtNoTransaksi = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        txtNamaProdukTransaksi = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDataTransaksi = new javax.swing.JTable();
        txtTotalPembayaran = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        txtNamaDokterTransaksi = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        txtTanggalTransaksi = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        btnSimpanPenjualan = new javax.swing.JButton();
        btnUbahPenjualan = new javax.swing.JButton();
        btnHapusPenjualan = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        lblHargaLayananTransaksi = new javax.swing.JLabel();
        lblTotalHargaProdukTransaksi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        txtQtyProdukTransaksi = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        lblHargaProdukTransaksi = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnTambahPenjualan = new javax.swing.JButton();
        btnResetPenjualan = new javax.swing.JButton();
        lblNamaKasirTrans = new javax.swing.JLabel();
        resetProduk = new javax.swing.JLabel();
        resetLayanan = new javax.swing.JLabel();
        Barlang = new javax.swing.JScrollPane();
        tblDetailTransaksi = new javax.swing.JTable();
        lblIdTrans = new javax.swing.JLabel();
        vardong = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tabMember = new javax.swing.JPanel();
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
        tblPelanggan = new javax.swing.JTable();
        btnResetMemberBaru = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tabTransaksi.setBackground(new java.awt.Color(181, 234, 215));
        tabTransaksi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 206, 234), 10));
        tabTransaksi.setMaximumSize(new java.awt.Dimension(1080, 720));
        tabTransaksi.setMinimumSize(new java.awt.Dimension(1080, 720));
        tabTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabTransaksiMouseEntered(evt);
            }
        });
        tabTransaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel102.setText("Transaksi");
        tabTransaksi.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 32, -1, -1));

        jLabel103.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel103.setText("No. Transaksi");
        tabTransaksi.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 102, -1, -1));

        jLabel104.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel104.setText("Customer");
        tabTransaksi.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 142, -1, -1));

        jLabel105.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel105.setText("Layanan");
        tabTransaksi.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 185, -1, -1));

        jLabel106.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel106.setText(":");
        tabTransaksi.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 102, -1, -1));

        jLabel107.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel107.setText(":");
        tabTransaksi.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 142, -1, -1));

        jLabel108.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel108.setText(":");
        tabTransaksi.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 185, -1, -1));

        txtNamaPelangganTransaksi.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtNamaPelangganTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNamaPelangganTransaksiMouseClicked(evt);
            }
        });
        txtNamaPelangganTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPelangganTransaksiActionPerformed(evt);
            }
        });
        tabTransaksi.add(txtNamaPelangganTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 140, 266, -1));

        txtNamaLayananTransaksi.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtNamaLayananTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaLayananTransaksiActionPerformed(evt);
            }
        });
        tabTransaksi.add(txtNamaLayananTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 183, 227, -1));

        txtNoTransaksi.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tabTransaksi.add(txtNoTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 100, 266, -1));

        jLabel109.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        tabTransaksi.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 232, -1, -1));

        jLabel110.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel110.setText(":");
        tabTransaksi.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 217, -1, -1));

        jLabel111.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel111.setText("Harga");
        tabTransaksi.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 217, -1, -1));

        jLabel112.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel112.setText("Produk");
        tabTransaksi.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 259, -1, -1));

        jLabel113.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel113.setText(":");
        tabTransaksi.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 259, -1, -1));

        txtNamaProdukTransaksi.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtNamaProdukTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaProdukTransaksiActionPerformed(evt);
            }
        });
        tabTransaksi.add(txtNamaProdukTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 257, 224, -1));

        jLabel114.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel114.setText("Total Harga");
        tabTransaksi.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 362, -1, -1));

        jLabel115.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel115.setText(":");
        tabTransaksi.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 362, -1, -1));

        tblDataTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDataTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDataTransaksi);

        tabTransaksi.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 600, 968, 90));

        txtTotalPembayaran.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        txtTotalPembayaran.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalPembayaran.setText("0");
        txtTotalPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPembayaranActionPerformed(evt);
            }
        });
        tabTransaksi.add(txtTotalPembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 133, 557, 124));

        jLabel116.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel116.setText("Total :");
        tabTransaksi.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 93, -1, -1));

        jLabel119.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel119.setText("Dokter");
        tabTransaksi.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 392, -1, -1));

        jLabel120.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel120.setText(":");
        tabTransaksi.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 392, -1, -1));

        txtNamaDokterTransaksi.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtNamaDokterTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaDokterTransaksiActionPerformed(evt);
            }
        });
        tabTransaksi.add(txtNamaDokterTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 392, 266, -1));

        jLabel121.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel121.setText("Tanggal");
        tabTransaksi.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 442, -1, -1));

        jLabel122.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel122.setText(":");
        tabTransaksi.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 435, -1, -1));

        txtTanggalTransaksi.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtTanggalTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalTransaksiActionPerformed(evt);
            }
        });
        tabTransaksi.add(txtTanggalTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 440, 266, -1));

        jLabel117.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel117.setText("Data Transaksi");
        tabTransaksi.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 563, -1, -1));

        btnSimpanPenjualan.setBackground(new java.awt.Color(199, 206, 234));
        btnSimpanPenjualan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSimpanPenjualan.setForeground(new java.awt.Color(0, 153, 255));
        btnSimpanPenjualan.setText("Simpan");
        btnSimpanPenjualan.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btnSimpanPenjualan.setBorderPainted(false);
        btnSimpanPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPenjualanActionPerformed(evt);
            }
        });
        tabTransaksi.add(btnSimpanPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 506, 183, 39));

        btnUbahPenjualan.setBackground(new java.awt.Color(199, 206, 234));
        btnUbahPenjualan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnUbahPenjualan.setForeground(new java.awt.Color(0, 153, 255));
        btnUbahPenjualan.setText("Ubah");
        btnUbahPenjualan.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btnUbahPenjualan.setBorderPainted(false);
        btnUbahPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUbahPenjualanMouseEntered(evt);
            }
        });
        btnUbahPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahPenjualanActionPerformed(evt);
            }
        });
        tabTransaksi.add(btnUbahPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 392, 183, 39));

        btnHapusPenjualan.setBackground(new java.awt.Color(199, 206, 234));
        btnHapusPenjualan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnHapusPenjualan.setForeground(new java.awt.Color(0, 153, 255));
        btnHapusPenjualan.setText("Hapus");
        btnHapusPenjualan.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btnHapusPenjualan.setBorderPainted(false);
        btnHapusPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPenjualanActionPerformed(evt);
            }
        });
        tabTransaksi.add(btnHapusPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 449, 183, 39));

        btnCari.setBackground(new java.awt.Color(199, 206, 234));
        btnCari.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCari.setForeground(new java.awt.Color(0, 153, 255));
        btnCari.setText("Ambil Data");
        btnCari.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btnCari.setBorderPainted(false);
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        tabTransaksi.add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 275, 183, 39));

        lblHargaLayananTransaksi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHargaLayananTransaksi.setText("0");
        tabTransaksi.add(lblHargaLayananTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 218, 239, 20));

        lblTotalHargaProdukTransaksi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotalHargaProdukTransaksi.setText("0");
        tabTransaksi.add(lblTotalHargaProdukTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 361, 237, 25));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel1.setText("Qty");
        tabTransaksi.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 302, -1, -1));

        jLabel118.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel118.setText(":");
        tabTransaksi.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 302, -1, -1));

        txtQtyProdukTransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQtyProdukTransaksiKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyProdukTransaksiKeyReleased(evt);
            }
        });
        tabTransaksi.add(txtQtyProdukTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 304, 76, -1));

        jLabel123.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel123.setText("Harga Satuan");
        tabTransaksi.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 331, -1, -1));

        jLabel124.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel124.setText(":");
        tabTransaksi.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 331, -1, -1));

        lblHargaProdukTransaksi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHargaProdukTransaksi.setText("0");
        tabTransaksi.add(lblHargaProdukTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 330, 226, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Rp.");
        tabTransaksi.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 216, -1, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Rp.");
        tabTransaksi.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 361, -1, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Rp.");
        tabTransaksi.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 330, -1, 25));

        btnTambahPenjualan.setBackground(new java.awt.Color(199, 206, 234));
        btnTambahPenjualan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnTambahPenjualan.setForeground(new java.awt.Color(0, 153, 255));
        btnTambahPenjualan.setText("Tambahkan");
        btnTambahPenjualan.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btnTambahPenjualan.setBorderPainted(false);
        btnTambahPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahPenjualanActionPerformed(evt);
            }
        });
        tabTransaksi.add(btnTambahPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 506, 266, 39));

        btnResetPenjualan.setBackground(new java.awt.Color(199, 206, 234));
        btnResetPenjualan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnResetPenjualan.setForeground(new java.awt.Color(0, 153, 255));
        btnResetPenjualan.setText("Reset");
        btnResetPenjualan.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btnResetPenjualan.setBorderPainted(false);
        btnResetPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPenjualanActionPerformed(evt);
            }
        });
        tabTransaksi.add(btnResetPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 332, 183, 41));

        lblNamaKasirTrans.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNamaKasirTrans.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tabTransaksi.add(lblNamaKasirTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 61, 130, 26));

        resetProduk.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        resetProduk.setText("Reset");
        resetProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetProdukMouseClicked(evt);
            }
        });
        tabTransaksi.add(resetProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 259, 36, 25));

        resetLayanan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        resetLayanan.setText("Reset");
        resetLayanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetLayananMouseClicked(evt);
            }
        });
        tabTransaksi.add(resetLayanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 185, 40, 25));

        Barlang.setBackground(new java.awt.Color(181, 234, 215));

        tblDetailTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDetailTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetailTransaksiMouseClicked(evt);
            }
        });
        Barlang.setViewportView(tblDetailTransaksi);

        tabTransaksi.add(Barlang, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 275, 364, 270));
        tabTransaksi.add(lblIdTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 54, 30, 30));
        tabTransaksi.add(vardong, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 34, 60, 20));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Copyright by Kelompok 1");
        tabTransaksi.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 810, 1110, 20));

        tabKasirku.addTab("Transaksi", tabTransaksi);

        tabMember.setBackground(new java.awt.Color(181, 234, 215));
        tabMember.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 206, 234), 10));
        tabMember.setMaximumSize(new java.awt.Dimension(1080, 720));
        tabMember.setMinimumSize(new java.awt.Dimension(1080, 720));

        jLabel94.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel94.setText("Input Member Baru");

        btnUbahPelanggan.setBackground(new java.awt.Color(199, 206, 234));
        btnUbahPelanggan.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnUbahPelanggan.setForeground(new java.awt.Color(0, 153, 255));
        btnUbahPelanggan.setText("Ubah");
        btnUbahPelanggan.setBorder(new javax.swing.border.SoftBevelBorder(0));
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
        btnHapusPelanggan.setBorder(new javax.swing.border.SoftBevelBorder(0));
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
        btnTambahPelanggan.setBorder(new javax.swing.border.SoftBevelBorder(0));
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
        idPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPelangganActionPerformed(evt);
            }
        });

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
        jScrollPane15.setViewportView(tblPelanggan);

        btnResetMemberBaru.setBackground(new java.awt.Color(199, 206, 234));
        btnResetMemberBaru.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnResetMemberBaru.setForeground(new java.awt.Color(0, 153, 255));
        btnResetMemberBaru.setText("Reset");
        btnResetMemberBaru.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btnResetMemberBaru.setBorderPainted(false);
        btnResetMemberBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetMemberBaruActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Copyright by Kelompok 1");

        javax.swing.GroupLayout tabMemberLayout = new javax.swing.GroupLayout(tabMember);
        tabMember.setLayout(tabMemberLayout);
        tabMemberLayout.setHorizontalGroup(
            tabMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabMemberLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(tabMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel95)
                    .addComponent(jLabel97)
                    .addComponent(jLabel96))
                .addGap(18, 18, 18)
                .addGroup(tabMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabMemberLayout.createSequentialGroup()
                        .addComponent(jLabel100)
                        .addGap(18, 18, 18)
                        .addComponent(namaPelanggan))
                    .addGroup(tabMemberLayout.createSequentialGroup()
                        .addComponent(jLabel99)
                        .addGap(18, 18, 18)
                        .addComponent(idPelanggan))
                    .addGroup(tabMemberLayout.createSequentialGroup()
                        .addComponent(jLabel101)
                        .addGap(18, 18, 18)
                        .addGroup(tabMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tabMemberLayout.createSequentialGroup()
                                .addComponent(btnUbahPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapusPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                            .addComponent(btnTambahPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(telpPelanggan)
                            .addComponent(btnResetMemberBaru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(tabMemberLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel94)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabMemberLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tabMemberLayout.setVerticalGroup(
            tabMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabMemberLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel94)
                .addGap(18, 18, 18)
                .addGroup(tabMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabMemberLayout.createSequentialGroup()
                        .addGroup(tabMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(jLabel95)
                            .addComponent(idPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel96)
                            .addComponent(jLabel100)
                            .addComponent(namaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel97)
                            .addComponent(jLabel101)
                            .addComponent(telpPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btnTambahPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUbahPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapusPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnResetMemberBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabKasirku.addTab("Member Baru", tabMember);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabKasirku)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabKasirku)
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telpPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telpPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telpPelangganActionPerformed

    private void txtTanggalTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalTransaksiActionPerformed

    private void txtNamaDokterTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaDokterTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaDokterTransaksiActionPerformed

    private void txtTotalPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPembayaranActionPerformed

    private void txtNamaProdukTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaProdukTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaProdukTransaksiActionPerformed

    private void txtNamaLayananTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaLayananTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaLayananTransaksiActionPerformed

    private void idPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPelangganActionPerformed

    private void btnTambahPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPelangganActionPerformed
        // TODO add your handling code here:
        String idPlgn = idPelanggan.getText();
        String namaPlgn = namaPelanggan.getText();
        String telpPlgn = telpPelanggan.getText();
        try {
            sql = "INSERT INTO customer (id, nama, telp) VALUES('"+idPlgn+"', '"+namaPlgn+"', '"+telpPlgn+"')";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilPelanggan();
        AfterInsertPelanggan();
    }//GEN-LAST:event_btnTambahPelangganActionPerformed

    private void btnUbahPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahPelangganActionPerformed
        // TODO add your handling code here:
        String idPlgn = idPelanggan.getText();
        String namaPlgn = namaPelanggan.getText();
        String telpPlgn = telpPelanggan.getText();
        
        try {
            sql = "UPDATE customer SET id = '"+idPlgn+"', nama = '"+namaPlgn+"', telp = '"+telpPlgn+"' WHERE id = '"+idPlgn+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Update Data");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilPelanggan();
        AfterInsertPelanggan();
    }//GEN-LAST:event_btnUbahPelangganActionPerformed

    private void btnHapusPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusPelangganActionPerformed
        // TODO add your handling code here:
        String idPlgn = idPelanggan.getText();
      
        try {
            sql = "DELETE FROM customer WHERE id = '"+idPlgn+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Menghapus Data Dokter");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        TampilPelanggan();
        AfterInsertPelanggan();
        
    }//GEN-LAST:event_btnHapusPelangganActionPerformed

    private void tblPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPelangganMouseClicked
        // TODO add your handling code here:
        int baris = tblPelanggan.rowAtPoint(evt.getPoint());
        String id = tblPelanggan.getValueAt(baris, 0).toString();
        idPelanggan.setText(id);
        String nama = tblPelanggan.getValueAt(baris, 1).toString();
        namaPelanggan.setText(nama);
        String telp = tblPelanggan.getValueAt(baris, 2).toString();
        telpPelanggan.setText(telp);
    }//GEN-LAST:event_tblPelangganMouseClicked

    private void btnResetMemberBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetMemberBaruActionPerformed
        // TODO add your handling code here:
        AfterInsertPelanggan();
    }//GEN-LAST:event_btnResetMemberBaruActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        GUI_Pencarian_Data abc = new GUI_Pencarian_Data();
        abc.AmbilNamaPelanggan = this;
        abc.setVisible(true);
    }//GEN-LAST:event_btnCariActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
           
    }//GEN-LAST:event_formWindowActivated

    private void btnUbahPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahPenjualanActionPerformed
        // TODO add your handling code here:
        UpdateDataTransaksi();
        TotalPembayaran();
        TampilDataTransaksi();
        DetailDataTransaksi();
    }//GEN-LAST:event_btnUbahPenjualanActionPerformed

    private void btnTambahPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPenjualanActionPerformed
        // TODO add your handling code here:
        TambahDataTransaksi();
        TotalPembayaran();
        btnSimpanPenjualan.setEnabled(true);
    }//GEN-LAST:event_btnTambahPenjualanActionPerformed

    private void btnSimpanPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPenjualanActionPerformed
        // TODO add your handling code here:
        SimpanDataTransaksi();
        TampilDataTransaksi();
        btnSimpanPenjualan.setEnabled(false);
    }//GEN-LAST:event_btnSimpanPenjualanActionPerformed

    private void txtQtyProdukTransaksiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyProdukTransaksiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyProdukTransaksiKeyPressed

    private void txtQtyProdukTransaksiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyProdukTransaksiKeyReleased
        // TODO add your handling code here:
        getTotalHargaProduk();
    }//GEN-LAST:event_txtQtyProdukTransaksiKeyReleased

    private void btnResetPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPenjualanActionPerformed
        // TODO add your handling code here:
        AfterSimpanTransaksi();
        SetTanggalSekarang();
        btnTambahPenjualan.setEnabled(true);
        
    }//GEN-LAST:event_btnResetPenjualanActionPerformed

    private void tblDataTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataTransaksiMouseClicked
        // TODO add your handling code here:
        int baris = tblDataTransaksi.getSelectedRow();
        String notransaksi = tblDataTransaksi.getValueAt(baris, 1).toString();
        txtNoTransaksi.setText(notransaksi);
        String namaPelanggan = tblDataTransaksi.getValueAt(baris, 2).toString();
        txtNamaPelangganTransaksi.setText(namaPelanggan);
        String namaDokter = tblDataTransaksi.getValueAt(baris, 3).toString();
        txtNamaDokterTransaksi.setText(namaDokter);
        String namaKasir = tblDataTransaksi.getValueAt(baris, 4).toString();
        lblNamaKasirTrans.setText(namaKasir);
        String tanggalTransaksi = tblDataTransaksi.getValueAt(baris, 0).toString();
        txtTanggalTransaksi.setText(tanggalTransaksi);
        TotalPembayaran();
        DetailDataTransaksi();
        btnUbahPenjualan.setEnabled(true);
    }//GEN-LAST:event_tblDataTransaksiMouseClicked

    private void btnHapusPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusPenjualanActionPerformed
        // TODO add your handling code here:
        HapusDataTransaksi();
        AfterSimpanTransaksi();
        Barlang.hide();
    }//GEN-LAST:event_btnHapusPenjualanActionPerformed

    private void resetProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetProdukMouseClicked
        // TODO add your handling code here:
        txtNamaProdukTransaksi.setText("");
        txtQtyProdukTransaksi.setText("0");
        lblTotalHargaProdukTransaksi.setText("0");
        lblHargaProdukTransaksi.setText("0");
    }//GEN-LAST:event_resetProdukMouseClicked

    private void resetLayananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetLayananMouseClicked
        // TODO add your handling code here:
        txtNamaLayananTransaksi.setText("");
        lblHargaLayananTransaksi.setText("0");
    }//GEN-LAST:event_resetLayananMouseClicked

    private void tblDetailTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetailTransaksiMouseClicked
        // TODO add your handling code here:
        int baris = tblDetailTransaksi.getSelectedRow();
        String idtrans = tblDetailTransaksi.getValueAt(baris, 0).toString();
        lblIdTrans.setText(idtrans);
        String layanan = tblDetailTransaksi.getValueAt(baris, 1).toString();
        txtNamaLayananTransaksi.setText(layanan);
        String produk = tblDetailTransaksi.getValueAt(baris, 2).toString();
        txtNamaProdukTransaksi.setText(produk);
        String jumlahProduk = tblDetailTransaksi.getValueAt(baris, 3).toString();
        txtQtyProdukTransaksi.setText(jumlahProduk);
        String TotalhargaProduk = tblDetailTransaksi.getValueAt(baris, 4).toString();
        lblTotalHargaProdukTransaksi.setText(TotalhargaProduk);
        DataLayanan();
        DataProduk();
    }//GEN-LAST:event_tblDetailTransaksiMouseClicked

    public void getTotalDong(){
        TotalPembayaran();
        Date tanggal = new Date();
        SimpleDateFormat formatTanggal = new SimpleDateFormat("dd-MM-yyyy");
        String hariIni = formatTanggal.format(tanggal);

        String no_trans = txtNoTransaksi.getText();
        String nmPelanggan = txtNamaPelangganTransaksi.getText();
        String layananTrans = txtNamaLayananTransaksi.getText();
        String hargalyn = lblHargaLayananTransaksi.getText();
        String produkTrans = txtNamaProdukTransaksi.getText();
        String qtyTrans = txtQtyProdukTransaksi.getText();
        String hrgSatuanProduk = lblHargaProdukTransaksi.getText();
        String totalHargaDariProduk = lblTotalHargaProdukTransaksi.getText();
        String nmDokter = txtNamaDokterTransaksi.getText();
        String tanggalTrans = txtTanggalTransaksi.getText();
        String nmKasir = lblNamaKasirTrans.getText();
        String ttl_bayaran = txtTotalPembayaran.getText();
        String idTrans = lblIdTrans.getText();

        try {
            sql = "UPDATE transaksi, detail_transaksi SET transaksi.layanan = '"+layananTrans+"', transaksi.harga_layanan = '"+hargalyn+"', transaksi.produk = '"+produkTrans+"', transaksi.qty = '"+qtyTrans+"', transaksi.tanggal = '"+hariIni+"', transaksi.totalHargaProduk = '"+totalHargaDariProduk+"', detail_transaksi.pelanggan ='"+nmPelanggan+"', detail_transaksi.dokter ='"+nmDokter+"', detail_transaksi.tanggal ='"+hariIni+"', detail_transaksi.total_harga_bayar ='"+ttl_bayaran+"', detail_transaksi.kasir ='"+nmKasir+"' WHERE transaksi.no_transaksi = '"+no_trans+"' AND transaksi.id = '"+idTrans+"' AND detail_transaksi.no_transaksi = '"+no_trans+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private void btnUbahPenjualanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahPenjualanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbahPenjualanMouseEntered

    private void tabTransaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTransaksiMouseEntered
        // TODO add your handling code here:
        if(lblIdTrans.getText() != ""){
                getTotalDong();
        }
    }//GEN-LAST:event_tabTransaksiMouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void txtNamaPelangganTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPelangganTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPelangganTransaksiActionPerformed

    private void txtNamaPelangganTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNamaPelangganTransaksiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPelangganTransaksiMouseClicked
    
    public void TampilDataTransaksi(){
        model = new DefaultTableModel();
        tblDataTransaksi.setModel(model);
        model.addColumn("Tanggal");
        model.addColumn("No Transaksi");
        model.addColumn("Pelanggan");
        model.addColumn("Dokter");
        model.addColumn("Kasir");
        model.addColumn("Total Pembayaran");
        
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            sql = "SELECT * FROM detail_transaksi";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                Object[] obj = new Object[6];
                obj[0] = rs.getString("tanggal");
                obj[1] = rs.getString("no_transaksi");
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
    public void TotalPembayaran(){
        String hasilTerakhir;
        String noTransaksi = txtNoTransaksi.getText();
        String hasil;
        try {
            sql = "SELECT SUM(totalHargaProduk) AS total_harga_produk, SUM(harga_layanan) as hargalyn FROM transaksi WHERE no_transaksi = '"+noTransaksi+"'";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                hasil = rs.getString("total_harga_produk");
                String dapat = rs.getString("hargalyn");
                int penjumlahan = Integer.parseInt(hasil) + Integer.parseInt(dapat);
                hasilTerakhir = Integer.toString(penjumlahan);
                txtTotalPembayaran.setText(hasilTerakhir);
            }
            
        }catch(Exception e){
            txtTotalPembayaran.setText("0");
//            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void getTotalHargaProduk(){
        int Qty, harga, operasi;
        Qty = Integer.parseInt(txtQtyProdukTransaksi.getText());
        harga = Integer.parseInt(lblHargaProdukTransaksi.getText());
        operasi = Qty * harga;
        String HasilPerkalianProduk = Integer.toString(operasi);
        lblTotalHargaProdukTransaksi.setText(HasilPerkalianProduk);
    }
    public void TambahDataTransaksi(){
        String no_trans = txtNoTransaksi.getText();
        String layananTrans = txtNamaLayananTransaksi.getText();
        String produkTrans = txtNamaProdukTransaksi.getText();
        String tanggalTrans = txtTanggalTransaksi.getText();
        String qtyTrans = txtQtyProdukTransaksi.getText();
        String totalHargaDariProduk = lblTotalHargaProdukTransaksi.getText();
        String hargalyn = lblHargaLayananTransaksi.getText();
        try {
            sql = "INSERT INTO transaksi (no_transaksi, layanan, harga_layanan, produk, tanggal, qty, totalHargaProduk) VALUES('"+no_trans+"', '"+layananTrans+"','"+hargalyn+"', '"+produkTrans+"', '"+tanggalTrans+"', '"+qtyTrans+"', '"+totalHargaDariProduk+"')";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Menambah Data Transaksi");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void SimpanDataTransaksi(){
        String no_trans = txtNoTransaksi.getText();
        String pelangganTrans = txtNamaPelangganTransaksi.getText();
        String dokterTrans = txtNamaDokterTransaksi.getText();
        String tanggalTrans = txtTanggalTransaksi.getText();
        String AmbilKasirTrans = lblNamaKasirTrans.getText();
        String totalPembayaranTrans = txtTotalPembayaran.getText();
        try {
            sql = "INSERT INTO detail_transaksi (no_transaksi, pelanggan, dokter, tanggal, total_harga_bayar, kasir) VALUES('"+no_trans+"', '"+pelangganTrans+"', '"+dokterTrans+"', '"+tanggalTrans+"', '"+totalPembayaranTrans+"', '"+AmbilKasirTrans+"')";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Minyimpan Data Transaksi");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        AfterSimpanTransaksi();
    }
    public void DetailDataTransaksi(){
        model = new DefaultTableModel();
        tblDetailTransaksi.setModel(model);
        model.addColumn("ID");
        model.addColumn("Layanan");
        model.addColumn("Produk");
        model.addColumn("Qty");
        model.addColumn("Total Harga");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String nomorTransk = txtNoTransaksi.getText();
        String tanggalTransk = txtTanggalTransaksi.getText();
        try {
            sql = "SELECT * FROM transaksi WHERE no_transaksi = '"+nomorTransk+"' AND tanggal = '"+tanggalTransk+"'";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                Object[] obj = new Object[5];
                obj[0] = rs.getString("id");
                obj[1] = rs.getString("layanan");
                obj[2] = rs.getString("produk");
                obj[3] = rs.getString("qty");
                obj[4] = rs.getString("totalHargaProduk");
                
                model.addRow(obj);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        Barlang.setVisible(true);
    }
    public void AfterSimpanTransaksi(){
        txtNamaLayananTransaksi.setText("");
        txtNamaProdukTransaksi.setText("");
        txtQtyProdukTransaksi.setText("0");
        lblTotalHargaProdukTransaksi.setText("0");
        lblHargaLayananTransaksi.setText("0");
        lblHargaProdukTransaksi.setText("0");
        txtNamaPelangganTransaksi.setText("");
        txtNamaDokterTransaksi.setText("");
        txtTotalPembayaran.setText("0");
        noTransaksiOtomatis();
    }
    public void AfterInsertPelanggan(){
        idPelanggan.setText("");
        namaPelanggan.setText("");
        telpPelanggan.setText("");
    }
    public void UpdateDataTransaksi(){
        Date tanggal = new Date();
        SimpleDateFormat formatTanggal = new SimpleDateFormat("dd-MM-yyyy");
        String hariIni = formatTanggal.format(tanggal);
        
        String no_trans = txtNoTransaksi.getText();
        String nmPelanggan = txtNamaPelangganTransaksi.getText();
        String layananTrans = txtNamaLayananTransaksi.getText();
        String hargalyn = lblHargaLayananTransaksi.getText();
        String produkTrans = txtNamaProdukTransaksi.getText();
        String qtyTrans = txtQtyProdukTransaksi.getText();
        String hrgSatuanProduk = lblHargaProdukTransaksi.getText();
        String totalHargaDariProduk = lblTotalHargaProdukTransaksi.getText();
        String nmDokter = txtNamaDokterTransaksi.getText();
        String tanggalTrans = txtTanggalTransaksi.getText();
        String nmKasir = lblNamaKasirTrans.getText();
        String ttl_bayaran = txtTotalPembayaran.getText();
        String idTrans = lblIdTrans.getText();
        
        try {
            sql = "UPDATE transaksi, detail_transaksi SET transaksi.layanan = '"+layananTrans+"', transaksi.harga_layanan = '"+hargalyn+"', transaksi.produk = '"+produkTrans+"', transaksi.qty = '"+qtyTrans+"', transaksi.tanggal = '"+hariIni+"', transaksi.totalHargaProduk = '"+totalHargaDariProduk+"', detail_transaksi.pelanggan ='"+nmPelanggan+"', detail_transaksi.dokter ='"+nmDokter+"', detail_transaksi.tanggal ='"+hariIni+"', detail_transaksi.total_harga_bayar ='"+ttl_bayaran+"', detail_transaksi.kasir ='"+nmKasir+"' WHERE transaksi.no_transaksi = '"+no_trans+"' AND transaksi.id = '"+idTrans+"' AND detail_transaksi.no_transaksi = '"+no_trans+"'";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.execute();
            JOptionPane.showMessageDialog(null, "Data Transaksi Berhasil di Ubah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void DataLayanan(){
        try {
            sql = "SELECT * FROM layanan WHERE nama = '"+txtNamaLayananTransaksi.getText()+"'";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                String hargaLayanannya = rs.getString("harga");
                lblHargaLayananTransaksi.setText(hargaLayanannya);
            }
        }catch(Exception e){}
    }
    public void DataProduk(){
        try {
            sql = "SELECT * FROM produk WHERE nama = '"+txtNamaProdukTransaksi.getText()+"'";
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                String hargaProduknya = rs.getString("harga");
                lblHargaProdukTransaksi.setText(hargaProduknya);
            }
        }catch(Exception e){}
    }
    public void noTransaksiOtomatis(){
        try {
            sql = "SELECT max(right(no_transaksi, 5)) as notrens FROM detail_transaksi";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                if(rs.first() == false){
                    txtNoTransaksi.setText("TR00001");
                }else{
                    rs.last();
                    int no_nya = rs.getInt(1) + 1;
                    String nomor = String.valueOf(no_nya);
                    int PanjangNo = nomor.length();
                    
                    for(int a = 0; a < 5-PanjangNo; a++){
                        nomor = "0" + nomor;
                    }
                    txtNoTransaksi.setText("TR"+nomor);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Barlang;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapusPelanggan;
    private javax.swing.JButton btnHapusPenjualan;
    private javax.swing.JButton btnResetMemberBaru;
    private javax.swing.JButton btnResetPenjualan;
    private javax.swing.JButton btnSimpanPenjualan;
    private javax.swing.JButton btnTambahPelanggan;
    private javax.swing.JButton btnTambahPenjualan;
    private javax.swing.JButton btnUbahPelanggan;
    private javax.swing.JButton btnUbahPenjualan;
    private javax.swing.JTextField idPelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHargaLayananTransaksi;
    private javax.swing.JLabel lblHargaProdukTransaksi;
    private javax.swing.JLabel lblIdTrans;
    private javax.swing.JLabel lblNamaKasirTrans;
    private javax.swing.JLabel lblTotalHargaProdukTransaksi;
    private javax.swing.JTextField namaPelanggan;
    private javax.swing.JLabel resetLayanan;
    private javax.swing.JLabel resetProduk;
    private javax.swing.JTabbedPane tabKasirku;
    private javax.swing.JPanel tabMember;
    private javax.swing.JPanel tabTransaksi;
    private javax.swing.JTable tblDataTransaksi;
    private javax.swing.JTable tblDetailTransaksi;
    private javax.swing.JTable tblPelanggan;
    private javax.swing.JTextField telpPelanggan;
    private javax.swing.JTextField txtNamaDokterTransaksi;
    private javax.swing.JTextField txtNamaLayananTransaksi;
    private javax.swing.JTextField txtNamaPelangganTransaksi;
    private javax.swing.JTextField txtNamaProdukTransaksi;
    private javax.swing.JTextField txtNoTransaksi;
    private javax.swing.JTextField txtQtyProdukTransaksi;
    private javax.swing.JTextField txtTanggalTransaksi;
    private javax.swing.JTextField txtTotalPembayaran;
    private javax.swing.JLabel vardong;
    // End of variables declaration//GEN-END:variables
}
