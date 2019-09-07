package com.tecnicasilegais.urbe.passageiro;

import com.tecnicasilegais.urbe.enums.FormaPgto;

public class Passageiro {
    private String cpf;
    private String nome;
    private FormaPgto formaPgto;
    private String nroCartao;
    private int qtdAvaliacoes;
    private long estrelas;

    public Passageiro(String cpf, String nome, FormaPgto formaPgto) {
        this.cpf = cpf;
        this.nome = nome;
        this.formaPgto = formaPgto;
        this.nroCartao = null;
        this.qtdAvaliacoes = 0;
        this.estrelas = 0;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public FormaPgto getFormaPgto() {
        return this.formaPgto;
    }

    public String getNroCartao() {
        return this.nroCartao;
    }

    public int getPontuacaoMedia(){
        return this.calculaPontuacaoMedia();
    }

    public int getQtdAvaliacoes(){
        return this.qtdAvaliacoes;
    }

    public long getEstrelas(){
        return this.estrelas;
    }

    public void infoPontuacao(int pontuacao){
        this.qtdAvaliacoes ++;
        this.estrelas += pontuacao;
    }

    private int calculaPontuacaoMedia(){
        return (int)this.estrelas/this.qtdAvaliacoes;
    }
}