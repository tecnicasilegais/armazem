package motorista;

import enums.FormaPgto;
import veiculo.Veiculo;

public class Motorista {
    private String cpf;
    private FormaPgto[] formaPgto;
    private String nome;
    private int pontuacao;
    private Veiculo veiculo;

    public String getCpf() {
        return this.cpf;
    }

    public FormaPgto[] getFormaPgto() {
        return this.formaPgto;
    }

    public String getNome() {
        return this.nome;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

}