package veiculo;

import enums.CategoriaVeiculo;

public class Veiculo {
    private String cor;
    private String marca;
    private String placa;
    private CategoriaVeiculo categoria;

    public Veiculo(String cor, String marca, String placa, CategoriaVeiculo categoria) {
        this.cor = cor;
        this.marca = marca;
        this.placa = placa;
        this.categoria = categoria;
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public String getPlaca() {
        return placa;
    }

    public CategoriaVeiculo getCategoria() {
        return categoria;
    }

    public Boolean compareDados(Veiculo v2) {
        if (!compareCategoria(v2))
            return false;
        if (!compareCor(v2))
            return false;
        if (!compareMarca(v2))
            return false;
        return true;
    }

    public Boolean compareCategoria(Veiculo v2) {
        return (this.categoria.equals(v2.categoria));
    }

    public Boolean comparePlaca(Veiculo v2) {
        return (this.placa.equals(v2.placa));
    }

    public Boolean compareCor(Veiculo v2) {
        return (this.cor.equals(v2.cor));
    }

    public Boolean compareMarca(Veiculo v2) {
        return (this.marca.equals(v2.marca));
    }
}