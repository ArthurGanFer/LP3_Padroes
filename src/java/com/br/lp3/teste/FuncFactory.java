/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.teste;

/**
 *
 * @author 31338283
 */
public class FuncFactory {

    public static Funcionario getFuncionario(String tipo, String nome, double salario, int codigo) {
        tipo = tipo.toLowerCase();
        Funcionario f = null;
        switch (tipo) {
            case "gerente":
                f = new Gerente(nome, codigo, salario);
                break;
            case "secretaria":
                f = new Secretaria(nome, codigo, salario);
                break;
        }
        return f;

    }

}
