/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Compress_Decompress.Compressor;
import Compress_Decompress.Decompressor;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author kali
 */
public class AppFrame extends JFrame implements ActionListener{
    JLabel background;
    JButton compress;
    JButton decompress;
    AppFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        pack();
        this.setBounds(150 , 100 , 1150 , 600);

        this.setLayout(null);
        background = new JLabel();
        background.setBounds(0 , 0 , 1150 , 600);
        ImageIcon image = new ImageIcon("/home/kali/NetBeansProjects/Compressor_Decompressor/src/main/java/GUI/Compress.jpg");
        background.setIcon(image);
        this.add(background);
        
        
//        Compressor

        compress = new JButton("Compress" , new ImageIcon("/home/kali/NetBeansProjects/Compressor_Decompressor/src/main/java/GUI/zip.png"));
        compress.setBounds(400 , 360 , 150 , 150);
        compress.setBorder(null);
        compress.setBorderPainted(false);
        compress.setFocusPainted(false);
        compress.setContentAreaFilled(false);
        compress.addActionListener(this);
        background.add(compress);

        
        
//        Decompressor

        decompress = new JButton("Decompress" , new ImageIcon("/home/kali/NetBeansProjects/Compressor_Decompressor/src/main/java/GUI/Data-Extraction.png"));
        decompress.setBounds(630 , 360 , 150 , 150);
        decompress.setBorder(null);
        decompress.setBorderPainted(false);
        decompress.setFocusPainted(false);
        decompress.setContentAreaFilled(false);
        decompress.addActionListener(this);
        background.add(decompress);
        
        
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == compress)
        {
            JFileChooser filechooser = new JFileChooser();
            filechooser.setDialogTitle("Compress File");
            int response = filechooser.showSaveDialog(compress);
            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                try
                {
                    Compressor.method(file);
                }
                catch(Exception exception)
                {
                    JOptionPane.showMessageDialog(null , exception.toString());
                }
            }
        }
        if(e.getSource() == decompress)
        {
            JFileChooser filechooser = new JFileChooser();
            filechooser.setDialogTitle("DeCompress File");
            int response = filechooser.showSaveDialog(decompress);
            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                try
                {
                    Decompressor.method(file);
                }
                catch(Exception exception)
                {
                    JOptionPane.showMessageDialog(filechooser , exception.toString());
                }
            }
        }
    }
}