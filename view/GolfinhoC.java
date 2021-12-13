package view;

import java.awt.*;
import javax.swing.*;

import model.Golfinho;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GolfinhoC extends JFrame {

  // Botões.
  JButton bttn1 = new JButton("Cadastrar");
  JButton bttn2 = new JButton("Cancelar");

  // Inserção de texto.
  JTextField tNome = new JTextField(35);
  JTextField tTreino = new JTextField(35);
  JTextField tJaula = new JTextField(35);

  // Texto impresso em tela.
  JLabel lNome = new JLabel("Nome: ");
  JLabel lTreino = new JLabel("Treinamento: ");
  JLabel lJaula = new JLabel("Id Jaula: ");

  public GolfinhoC() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 500);
    this.setVisible(true);

    Container pane = this.getContentPane();
    pane.setLayout(new GridLayout(4, 2));

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

      String nome = tNome.getText();

      int treino = Integer.parseInt(tTreino.getText());

      int idJaula = Integer.parseInt(tJaula.getText());

      Golfinho golfinho = Golfinho.InsertGolfinhoPS(nome, treino, idJaula);

      JOptionPane.showMessageDialog(
          this,
          "Golfinho cadastrado. \n" + golfinho,
          "Confirmação de Cadastro",
          JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception err) {
      System.err.println("Não cadastrou");
      System.err.println(err.getMessage());
    }
  }

  private void button2ActionPerformed(ActionEvent e) {
    this.dispose();
  }

}