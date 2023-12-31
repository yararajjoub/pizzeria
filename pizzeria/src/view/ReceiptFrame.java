package view;

import javax.swing.*;
import java.awt.*;

public class ReceiptFrame extends JFrame {
    JTextArea txtAreaInfo; // TODO: 2021-07-24
    BorderLayout layout;

    // TODO: 2021-07-24
    public ReceiptFrame() {
        JFrame receiptFrame = new JFrame();
        JPanel pnlProductInfo = new JPanel();
        receiptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        receiptFrame.setTitle("The receipt");
        receiptFrame.setSize(320,290);
        txtAreaInfo = new JTextArea();
        txtAreaInfo.setBorder(BorderFactory.createLoweredBevelBorder());
        txtAreaInfo.setSize(new Dimension(305, 230));
        Font font = new Font("Courier New", Font.ITALIC, 12);
        txtAreaInfo.setFont(font);
        txtAreaInfo.setPreferredSize(new Dimension(280, 240));
        txtAreaInfo.setEditable(false);
        txtAreaInfo.setBackground(new Color(192, 192, 192));
        pnlProductInfo.add(txtAreaInfo);

        add(pnlProductInfo, BorderLayout.CENTER);
        receiptFrame.setContentPane(pnlProductInfo);
        receiptFrame.setResizable(false);
        receiptFrame.setVisible(true);
    }

    public void setTxtAreaInfo(String text) {
        txtAreaInfo.setText(text);
    }


}
