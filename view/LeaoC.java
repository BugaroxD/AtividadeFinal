package view;

import java.awt.*;
import javax.swing.*;

import model.Leao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaoC extends JFrame {

  // Texto impresso em tela.
  JLabel lNome = new JLabel("Nome: ");
  JLabel lAlimentacao = new JLabel("Alimentação: ");
  JLabel lVisitantes = new JLabel("Visitantes: ");
  JLabel lJaula = new JLabel("ID Jaula: ");

  // Botões.
  JButton bttn1 = new JButton("Cadastrar");
  JButton bttn2 = new JButton("Cancelar");

  // Inserção de texto.
  JTextField tNome = new JTextField(35);
  JTextField tAlimentacao = new JTextField(35);
  JTextField tVisitantes = new JTextField(35);
  JTextField tJaula = new JTextField(35);

  public LeaoC() {

    // Janela
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 500);
    this.setVisible(true);

    // Container de Layout
    Container pane = this.getContentPane();
    pane.setLayout(new GridLayout(6, 4));

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
        button1ActionPerformed(e);
      }
    });

    bttn2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        button2ActionPerformed(e);
      }
    });

  }

  private void button1ActionPerformed(ActionEvent e) {
    try {
      // Convertendo Nome Leão em forma de String
      String nome = tNome.getText();

      int alimentacao = Integer.parseInt(tAlimentacao.getText());

      int visitantes = Integer.parseInt(tVisitantes.getText());

      int idJaula = Integer.parseInt(tJaula.getText());

      Leao leao = Leao.InsertLeaoPS(nome, alimentacao, visitantes, idJaula);

      JOptionPane.showMessageDialog(
          this,
          "Leão cadastrado. \n" + leao,
          "Confirmação de Cadastro",
          JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception err) {
      System.err.println("Não cadastrou.");
      System.err.println(err.getMessage());
    }
  }

  private void button2ActionPerformed(ActionEvent e) {
    this.dispose();
  }
}