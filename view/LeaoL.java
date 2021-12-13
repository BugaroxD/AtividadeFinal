package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Leao;

public class LeaoL extends JFrame {

  JTextArea listaLeao = new JTextArea(25, 40);
  JScrollPane scrollPane = new JScrollPane(listaLeao);

  JButton bttn1 = new JButton("Sair");

  public LeaoL() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 500);
    this.setVisible(true);

    Container pane = this.getContentPane();
    pane.setLayout(new FlowLayout(FlowLayout.CENTER));

    String leao = "";
    try {
      leao = Leao.SelectLeaoPS();
    } catch (Exception e) {
      leao = "Erro ao buscar Leões: " + e.getMessage();
    }

    listaLeao.setLineWrap(true);
    listaLeao.setText(leao);

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