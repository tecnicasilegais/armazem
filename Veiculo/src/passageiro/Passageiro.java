package passageiro;

import enums.FormaPgto;

public class Passageiro {
    private String cpf;
    private String nome;
    private FormaPgto formaPgto;
    private String nroCartao;
    private int qtdAvaliacoes;
    private long estrelas;

    public Passageiro (String cpf, String nome, FormaPgto formaPgto)
    {
        this.cpf = cpf;
        this.nome = nome;
        this.formaPgto = formaPgto;
        this.nroCartao = null;
        this.qtdAvaliacoes = 0;
        this.estrelas = 0;
    }

}