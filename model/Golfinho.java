package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Golfinho extends Animal implements Pesquisa<Golfinho> {

  private int treinos;
  private Jaula jaula;

  private ArrayList<Treinamento> treinamentos = new ArrayList<>();

  private final static String url = "jdbc:mysql://localhost:3306/atividadefinal?useTimezone=true&serverTimezone=UTC";
  private final static String user = "root";
  private final static String password = "";

  protected Golfinho(int id,
      String nome,
      int treinos) {
    super(id, nome);
    this.treinos = treinos;
  }

  public int getTreinos() {
    return treinos;
  }

  public ArrayList<Treinamento> getTreinamentos() {
    return this.treinamentos;
  }

  public Treinamento getUltimoTreinamento() {
    return treinamentos.get(treinamentos.size() - 1);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Golfinho)) {
      return false;
    }
    Golfinho golfinho = (Golfinho) o;
    return treinos == golfinho.treinos;
  }

  public Jaula getJaula() {
    return this.jaula;
  }

  public void setJaula(Jaula jaula) {
    this.jaula = jaula;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(treinos);
  }

  @Override
  public String toString() {
    return " \n" +
        " \nId:" + getIdAnimal() +
        " \nNome:" + getNome() +
        " \nTreinamento:" + getTreinamentos() +
        " \n";
  }

  /* INTRODUÇÃO DO BANCO DE DADOS */

  public static void printGolfinho(
      ArrayList<Golfinho> golfinhos) {
    try {
      for (Golfinho golfinho : golfinhos) {
        System.out.println(golfinho);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  // Case 1 SELECT COM PREPARE STATEMENT
  public static String SelectGolfinhoPS() throws Exception {
    try {
      Conexao conexao = new Conexao();
      Connection con = conexao.initConnect();
      Statement stm = con.createStatement();
      ResultSet rs = stm.executeQuery(
          "SELECT * FROM atividadefinal.golfinho;");

      String infos = "";
      while (rs.next()) {
        Golfinho golfinho = new Golfinho(
            rs.getInt(1),
            rs.getString(2),
            rs.getInt(3));

        infos = golfinho.toString() + "\n";
      }
      conexao.finalConnect();
      return infos;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  // Case 2 INSERT COM PREPARE STATEMENT

  public static Golfinho InsertGolfinhoPS(String nome, int treinamento, int idJaula) throws Exception {
    try {
      Conexao conexao = new Conexao();
      Connection conex = conexao.initConnect();
      PreparedStatement stm = conex.prepareStatement(
          "INSERT INTO atividadefinal.golfinho (nome, treinamento, jaula_id) VALUES (?, ?, ?);",
          PreparedStatement.RETURN_GENERATED_KEYS);

      stm.setString(1, nome);
      stm.setInt(2, treinamento);
      stm.setInt(3, idJaula);

      if (stm.executeUpdate() >= 0) {
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        Golfinho golfinho = new Golfinho(rs.getInt(1), nome, treinamento);

        conexao.finalConnect();

        return golfinho;
      }

      conexao.finalConnect();
      throw new Exception("Golfinho não incluso!");
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  // Case 3 UPDATE COM STATEMENT
  public static void updateGolfinhoS(Golfinho golfinho) {
    try {
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stm = con.createStatement();
      stm.execute("UPDATE golfinho SET "
          + " nome = '" + golfinho.getNome() + "'"
          + ", treinamento = '" + golfinho.getTreinamentos() + "'"
          + ", jaula = '" + golfinho.getJaula() + "'"
          + " WHERE id = " + golfinho.getIdAnimal());
      con.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  // Case 4 DELETE COM STATEMENT

  public static void deleteGolfinhoS(Golfinho golfinho) {
    try {
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stm = con.createStatement();
      stm.execute("DELETE FROM golfinho "
          + " WHERE id = " + golfinho.getIdAnimal());

      con.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void getPorId(String sql) {
    // TODO Auto-generated method stub

  }

}