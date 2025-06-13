package model;

public class FornecedorItem {
    private int id;
    private String nome;

    public FornecedorItem(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nome;
    }
}
