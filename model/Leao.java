package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class Leao extends Animal implements Pesquisa<Leao> {

  private int alimentacao;
  private int visitantes;
  Jaula jaula;

  private ArrayList<Alimentacao> refeicao = new ArrayList<>();

  private final static String url = "jdbc:mysql://localhost:3306/atividadefinal?useTimezone=true&serverTimezone=UTC";
  private final static String user = "root";
  private final static String password = "";

  protected Leao(int id, String nome, int alimentacao, int visitantes) {
    super(id, nome);
    this.alimentacao = alimentacao;
    this.visitantes = visitantes;

  }

  public int getAlimentacao() {
    return this.alimentacao;
  }

  public void setAlimentacao(int alimentacao) {
    this.alimentacao = alimentacao;
  }

  public int getVisitantes() {
    return this.visitantes;
  }

  public void setVisitantes(int visitantes) {
    this.visitantes = visitantes;
  }

  public ArrayList<Alimentacao> getRefeicao() {
    return this.refeicao;
  }

  public void setRefeicao(Alimentacao refeicao) {
    this.refeicao.add(refeicao);
  }

  public void setJaula(Jaula jaula) {
    this.jaula = jaula;
  }

  public Jaula getJaula() {
    return jaula;
  }

  public Alimentacao getUltimaRefeicao() {
    return refeicao.get(refeicao.size() - 1);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Leao)) {
      return false;
    }
    Leao leao = (Leao) o;
    return id == leao.id && visitantes == leao.visitantes;
  }

  @Override
  public int hashCode() {
    return Objects.hash(alimentacao, visitantes);
  }

  @Override
  public String toString() {
    String infosLeao = "\n" +
        " \nId:" + getIdAnimal() +
        " \nNome:" + getNome() +
        " \nAlimentação:'" + getAlimentacao() + "'" +
        " \nVisitantes:'" + getVisitantes() + "'" +
        " \n";

    return infosLeao;
  }

  /* INTRODUÇÃO DO BANCO DE DADOS */

  public static void printLeao(
      ArrayList<Leao> leoes) {
    try {
      for (Leao leao : leoes) {
        System.out.println(leao);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  // Case 1 SELECT COM PREPARE STATEMENT

  public static String SelectLeaoPS() throws Exception {
    try {
      Conexao conexao = new Conexao();
      Connection con = conexao.initConnect();
      Statement stm = con.createStatement();
      ResultSet rs = stm.executeQuery(
          "SELECT * FROM atividadefinal.leao;");

      String infos = "";
      while (rs.next()) {
        Leao leao = new Leao(
            rs.getInt(1),
            rs.getString(2),
            rs.getInt(3),
            rs.getInt(4));

        infos = leao.toString() + "\n";
      }
      conexao.finalConnect();
      return infos;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  // Case 2 INSERT COM PREPARE STATEMENT

  public static Leao InsertLeaoPS(String nome, int alimentacao, int visitantes, int idJaula) throws Exception {
    try {
      Conexao conexao = new Conexao();
      Connection conex = conexao.initConnect();
      PreparedStatement stm = conex.prepareStatement(
          "INSERT INTO atividadefinal.leao (nome, alimentacao, visitantes, jaula_id) VALUES (?, ?, ?, ?);",
          PreparedStatement.RETURN_GENERATED_KEYS);

      stm.setString(1, nome);
      stm.setInt(2, alimentacao);
      stm.setInt(3, visitantes);
      stm.setInt(4, idJaula);

      if (stm.executeUpdate() >= 0) {
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        Leao leao = new Leao(rs.getInt(1), nome, alimentacao, visitantes);

        conexao.finalConnect();

        return leao;
      }

      conexao.finalConnect();
      throw new Exception("Leao não incluso!");
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  // Case 3 UPDATE COM PREPARE STATEMENT

  public static void updateLeaoS(Leao leao) {
    try {
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stm = con.createStatement();
      stm.execute("UPDATE leao SET "
          + " nome = '" + leao.getNome() + "'"
          + ", alimentacao = '" + leao.getAlimentacao() + "'"
          + ", visitantes = '" + leao.getVisitantes() + "'"
          + ", jaula_id = '" + leao.getJaula() + "'"
          + " WHERE id = " + leao.getIdAnimal());
      con.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  // Case 4 DELETE COM STATEMENT

  public static void deleteLeaoPS(Leao leao) {
    try {
      System.out.println("Conectando ao banco de dados");
      Connection con = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/atividadefinal?useTimezone=true&serverTimezone=UTC", "root", "");
      System.out.println("Banco de Dados conectado");
      System.out.println("Deletando Dados do banco");
      PreparedStatement prepLeao = con.prepareStatement("DELETE FROM leao WHERE id = ?");
      prepLeao.setInt(1, leao.getIdAnimal());
      System.out.println("Dados deletado com sucesso");
      if (prepLeao.executeUpdate() <= 0) {
        System.out.println("Falha na execução.");
      }
      con.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void getPorId(String sql) {

  }

}