package view;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GolfinhoA extends JFrame {

  JTextField tId = new JTextField(35);
  JTextField tNome = new JTextField(35);
  JTextField tTreino = new JTextField(35);
  JTextField tJaula = new JTextField(35);

  JLabel lId = new JLabel("ID: ");
  JLabel lNome = new JLabel("Nome: ");
  JLabel lTreino = new JLabel("Treinamento: ");
  JLabel lJaula = new JLabel("Id Jaula: ");

  JButton bttn1 = new JButton("Cadastrar");
  JButton bttn2 = new JButton("Cancelar");

  public GolfinhoA() {

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

    // Treino ADD
    pane.add(lTreino);
    pane.add(tTreino);

    // Jaula ADD
    pane.add(lJaula);
    pane.add(tJaula);

    // Botões ADD
    pane.add(bttn1);
    pane.add(bttn2);

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