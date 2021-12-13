package model;

import java.util.Objects;

public abstract class Animal {
  protected int id;
  protected String nome;

  protected Animal(int id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public int getIdAnimal() {
    return this.id;
  }

  public void setIdAnimal(int id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Animal)) {
      return false;
    }
    Animal animal = (Animal) o;
    return id == animal.id && Objects.equals(nome, animal.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome);
  }

  @Override
  public String toString() {
    return " \n" +
        " \nId:" + getIdAnimal() +
        " \nNome:" + getNome() +
        " \n";
  }
}