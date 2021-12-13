package model;

public interface Pesquisa<T extends Animal> {

  public void getPorId(String sql);

}