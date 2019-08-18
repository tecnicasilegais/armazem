import Enums.CategoriaVeiculo;

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
}