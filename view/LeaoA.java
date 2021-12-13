package view;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaoA extends JFrame {

  JLabel lId = new JLabel("ID: ");
  JLabel lNome = new JLabel("Nome: ");
  JLabel lAlimentacao = new JLabel("Alimentação: ");
  JLabel lVisitantes = new JLabel("Visitantes: ");
  JLabel lJaula = new JLabel("ID Jaula: ");

  JButton bttn1 = new JButton("Cadastrar");
  JButton bttn2 = new JButton("Cancelar");

  JTextField tId = new JTextField(35);
  JTextField tNome = new JTextField(35);
  JTextField tAlimentacao = new JTextField(35);
  JTextField tVisitantes = new JTextField(35);
  JTextField tJaula = new JTextField(35);

  public LeaoA() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 500);
    this.setVisible(true);

    Container pane = this.getContentPane();
    pane.setLayout(new GridLayout(5, 3));

    // Id ADD
    pane.add(lId);
    pane.add(tId);

    // Nome ADD
    pane.add(lNome);
    pane.add(tNome);

    // Alimentação ADD
    pane.add(lAlimentacao);
    pane.add(tAlimentacao);

    // Visitantes ADD
    pane.add(lVisitantes);
    pane.add(tVisitantes);

    // Jaula ADD
    pane.add(lJaula);
    pane.add(tJaula);

    // Botões ADD
    pane.add(bttn1);
    pane.add(bttn2);

    bttn1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        actionPerformed(e);
      }
    });

    bttn2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        actionPerformed(e);
      }
    });

  }

}