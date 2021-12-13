package model;

import java.sql.Date;
import java.util.Objects;

public class Treinamento {

  private int id;
  private Date dataTreino;
  private String detalhes;
  Golfinho golfinho;

  public Treinamento(int id, Date dataTreino, String detalhes, Golfinho golfinho) {
    this.id = id;
    this.dataTreino = dataTreino;
    this.detalhes = detalhes;
    this.golfinho = golfinho;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDataTreino() {
    return this.dataTreino;
  }

  public void setDataTreino(Date dataTreino) {
    this.dataTreino = dataTreino;
  }

  public String getDetalhes() {
    return this.detalhes;
  }

  public void setDetalhes(String detalhes) {
    this.detalhes = detalhes;
  }

  public Golfinho getGolfinho() {
    return this.golfinho;
  }

  public void setGolfinho(Golfinho golfinho) {
    this.golfinho = golfinho;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Treinamento)) {
      return false;
    }
    Treinamento treinamento = (Treinamento) o;
    return id == treinamento.id && Objects.equals(dataTreino, treinamento.dataTreino)
        && Objects.equals(detalhes, treinamento.detalhes) && Objects.equals(golfinho, treinamento.golfinho);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dataTreino, detalhes, golfinho);
  }

  @Override
  public String toString() {
    return " \n" +
        " \nId;" + getId() +
        " \nData Treino;" + getDataTreino() +
        " \nDetalhes:" + getDetalhes() +
        " \nGolfinho:" + getGolfinho() +
        " \n";
  }
}