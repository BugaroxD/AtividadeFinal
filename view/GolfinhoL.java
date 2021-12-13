package view;

import java.awt.*;
import javax.swing.*;

import model.Golfinho;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GolfinhoL extends JFrame {

  JTextArea listaGolfinho = new JTextArea(25, 40);
  JScrollPane scrollPane = new JScrollPane(listaGolfinho);

  JButton bttn1 = new JButton("Sair");

  public GolfinhoL() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 500);
    this.setVisible(true);

    Container pane = this.getContentPane();
    pane.setLayout(new FlowLayout(FlowLayout.CENTER));

    String golfinho = "";
    try {
      golfinho = Golfinho.SelectGolfinhoPS();
    } catch (Exception e) {
      golfinho = "Erro de busca: " + e.getMessage();
    }

    listaGolfinho.setLineWrap(true);
    listaGolfinho.setText(golfinho);

    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    pane.add(scrollPane);
    pane.add(bttn1);

    bttn1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        button1ActionPerformed(e);
      }
    });

  }

  private void button1ActionPerformed(ActionEvent e) {
    this.dispose();
  }
}
