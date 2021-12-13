
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* 

+ Curso: Análise e Desenvolvimento de Sistemas (ADS)
+ Aluno: Jefferson Luiz Martins Clemente
+ Professor: Jackson Machado
+ Matéria: Programação Orientada a Objeto
+ Atividade Avaliativa Final

*/

import view.LeaoL;
import view.LeaoC;
import view.GolfinhoL;
import view.LeaoA;
import view.GolfinhoA;
import view.GolfinhoC;

public class Zoologico extends JFrame {

  JButton bttn1 = new JButton("CadastrarGolfinho");
  JButton bttn2 = new JButton("Cadastrar Leao");
  JButton bttn3 = new JButton("Listar Golfinho.");
  JButton bttn4 = new JButton("Listar Leão.");
  JButton bttn5 = new JButton("Alterar Golfinho.");
  JButton bttn6 = new JButton("Alterar Leão.");
  JButton bttn7 = new JButton("Deletar Golfinho.");
  JButton bttn8 = new JButton("Deletar Leão.");

  public Zoologico() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(300, 600);
    this.setVisible(true);

    Container pane = this.getContentPane();
    pane.setLayout(new GridLayout(7, 3));

    pane.add(bttn1);
    pane.add(bttn2);
    pane.add(bttn3);
    pane.add(bttn4);
    pane.add(bttn5);
    pane.add(bttn6);
    pane.add(bttn7);
    pane.add(bttn8);

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

    bttn3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        button3ActionPerformed(e);
      }
    });

    bttn4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        button4ActionPerformed(e);
      }
    });

    bttn5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        button4ActionPerformed(e);
      }
    });

    bttn6.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        button4ActionPerformed(e);
      }
    });

    bttn7.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        button4ActionPerformed(e);
      }
    });

    bttn8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        button4ActionPerformed(e);
      }
    });

  }

  // Botão 1
  private void button1ActionPerformed(ActionEvent e) {
    try {

      GolfinhoC golfinhoC = new GolfinhoC();
    } catch (Exception err) {
      System.err.println("Não cadastrou.");
      System.err.println(err.getMessage());
    }

  }

  // Botão 2
  private void button2ActionPerformed(ActionEvent e) {
    try {

      LeaoC leaoC = new LeaoC();
    } catch (Exception err) {
      System.err.println("Não cadastrou.");
      System.err.println(err.getMessage());
    }

  }

  // Botão 3
  private void button3ActionPerformed(ActionEvent e) {
    try {

      GolfinhoL golfinhoL = new GolfinhoL();
    } catch (Exception err) {
      System.err.println("Não listou.");
      System.err.println(err.getMessage());
    }

  }

  // Botão 4
  private void button4ActionPerformed(ActionEvent e) {
    try {

      LeaoL leaoL = new LeaoL();
    } catch (Exception err) {
      System.err.println("Não listou.");
      System.err.println(err.getMessage());
    }

  }

  // Botão 5
  private void button5ActionPerformed(ActionEvent e) {
    try {

      LeaoA leaoA = new LeaoA();
    } catch (Exception err) {
      System.err.println("Não alterou.");
      System.err.println(err.getMessage());
    }

  }

  // Botão 6
  private void button6ActionPerformed(ActionEvent e) {
    try {

      GolfinhoA golfinhoA = new GolfinhoA();
    } catch (Exception err) {
      System.err.println("Não alterou.");
      System.err.println(err.getMessage());
    }

  }

  public static void main(String[] args) {

    // Menu do Sistema.
    Zoologico zoologico = new Zoologico();
  }
}