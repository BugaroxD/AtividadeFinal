package model;

import java.util.ArrayList;
import java.util.Objects;

public class Jaula {

  private int idJaula;
  private String descricao;

  public Jaula(int idJaula, String descricao) {
    this.idJaula = idJaula;
    this.descricao = descricao;
  }

  public int getId() {
    return this.idJaula;
  }

  public void setId(int idJaula) {
    this.idJaula = idJaula;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Jaula)) {
      return false;
    }
    Jaula jaula = (Jaula) o;
    return idJaula == jaula.idJaula && Objects.equals(descricao, jaula.descricao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idJaula, descricao);
  }

  @Override
  public String toString() {
    return " \n" +
        " \nId:" + getId() +
        " \nDescrição:" + getDescricao() +
        " \n";
  }
}
