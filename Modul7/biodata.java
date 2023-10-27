/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul7;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Yusup
 */
public class biodata extends JFrame {
    
    private DefaultTableModel tableModel;
    
    public biodata() {
        // Pengaturan jendela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Komponen input
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 30, 100, 30);
        
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);
        
        JLabel labelNomorHP = new JLabel("Nomor HP:");
        labelNomorHP.setBounds(15, 100, 350, 10);
        
        JTextField textFieldNomorHP = new JTextField();
        textFieldNomorHP.setBounds(15, 120, 350, 30);
        
        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
        labelJenisKelamin.setBounds(15, 155, 350, 10);
        
        // RadioButton untuk Jenis Kelamin
        JRadioButton radioButtonLakiLaki = new JRadioButton("Laki-Laki", true);
        radioButtonLakiLaki.setBounds(15, 165, 350, 30);
        
        JRadioButton radioButtonPerempuan = new JRadioButton("Perempuan");
        radioButtonPerempuan.setBounds(15, 190, 350, 30);
        
        // Label Alamat
        JLabel labelinput1 = new JLabel("Alamat:");
        labelinput1.setBounds(15, 220, 350, 30);
        
        // TextArea untuk Alamat
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 250, 350, 100);
        
        // Grup RadioButton
        ButtonGroup bgJenisKelamin = new ButtonGroup();
        bgJenisKelamin.add(radioButtonLakiLaki);
        bgJenisKelamin.add(radioButtonPerempuan);
        
        // Tombol Simpan
        JButton button = new JButton("Simpan");
        button.setBounds(15, 350, 100, 30);
        
        // Tombol Edit
        JButton button1 = new JButton("Edit");
        button1.setBounds(120, 350, 100, 30);
        
        // Tombol Hapus
        JButton button2 = new JButton("Hapus");
        button2.setBounds(225, 350, 100, 30);
        
        // Tombol Simpan ke File
        JButton button3 = new JButton("Simpan ke file");
        button3.setBounds(335, 350, 100, 30);
        
        // Tabel dan Model Tabel
        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 395, 350, 200);
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nama");
        tableModel.addColumn("Nomor HP");
        tableModel.addColumn("Jenis Kelamin");
        tableModel.addColumn("alamat");
        table.setModel(tableModel);

        
        // ActionListener untuk Tombol Simpan
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String nomorHP = textFieldNomorHP.getText();
                String jenisKelamin = radioButtonLakiLaki.isSelected() ? "Laki-Laki" : "Perempuan";
                String alamat = txtOutput.getText();
                
                if (!nama.isEmpty()) {
                    int result = JOptionPane.showConfirmDialog(biodata.this, "Apakah Anda yakin ingin menyimpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                    tableModel.addRow(new Object[] { nama, nomorHP, jenisKelamin, alamat });
                    textFieldNama.setText("");
                    textFieldNomorHP.setText("");
                    bgJenisKelamin.clearSelection();
                    txtOutput.setText("");
                } else {
                    JOptionPane.showMessageDialog(HelloTable.this, "Nama, Nomor HP, dan Alamat harus diisi.");
                }
            }
            }
        });
        
        // ActionListener untuk Tombol Hapus
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int result = JOptionPane.showConfirmDialog(biodata.this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                    }
                } else {
                    JOptionPane.showMessageDialog(biodata.this, "Pilih baris yang ingin dihapus.");
                }
            }
        });
        
        // ActionListener untuk Tombol Edit
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String nama = textFieldNama.getText();
                    String nomorHP = textFieldNomorHP.getText();
                    String jenisKelamin = radioButtonLakiLaki.isSelected() ? "Laki-Laki" : "Perempuan";
                    String alamat = txtOutput.getText();

                    if (!nama.isEmpty()) {
                        int result = JOptionPane.showConfirmDialog(biodata.this, "Apakah Anda yakin ingin mengedit data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            tableModel.setValueAt(nama, selectedRow, 0);
                            tableModel.setValueAt(nomorHP, selectedRow, 1);
                            tableModel.setValueAt(jenisKelamin, selectedRow, 2);
                            tableModel.setValueAt(alamat, selectedRow, 3);
                            textFieldNama.setText("");
                            textFieldNomorHP.setText("");
                            bgJenisKelamin.clearSelection();
                            txtOutput.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(biodata.this, "Nama, Nomor HP, dan Alamat harus diisi.");
                    }
                } else {
                    JOptionPane.showMessageDialog(biodata.this, "Pilih baris yang ingin diubah.");
                }
            }
        });
        
        // untuk penutup jendela
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(biodata.this, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    dispose(); // Tutup jendela
                }
            }
        });

        // Mengatur tata letak komponen
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(button);
        this.add(textFieldNama);
        this.add(labelNama);
        this.add(textFieldNomorHP);
        this.add(labelNomorHP);
        this.add(labelinput1);
        this.add(labelJenisKelamin);
        this.add(radioButtonLakiLaki);
        this.add(radioButtonPerempuan);
        this.add(txtOutput);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(scrollableTable);

        this.setSize(400, 600);
        this.setLayout(null);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                biodata h = new biodata();
                h.setVisible(true);
            }
        });
    }
}