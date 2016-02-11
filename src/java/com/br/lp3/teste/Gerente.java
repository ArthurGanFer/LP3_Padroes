/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.teste;

import java.io.Serializable;

/**
 *
 * @author 31338283
 */
public class Gerente implements Funcionario , Serializable{

    private String nome;
    private int codigo;
    private double salario;

    public Gerente(String nome, int codigo, double salario) {
        this.nome = nome;
        this.codigo = codigo;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Gerente{" + "nome=" + nome + ", Codigo=" + codigo + ", salario=" + salario + '}';
    }

    @Override
    public String getNome() {
        return "Gerente " + this.nome;
    }

    @Override
    public double getSalario() {
        return this.salario;
    }

    @Override
    public int getCodigo() {
        return this.codigo;
    }

}
