package com.br.lp3.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 31338283
 */
public class SingObj {

    private static SingObj instance = null;
    private String cor;

    private SingObj() {
        cor = "#FFF";
    }

    public static SingObj getInstance() {
        if (instance == null) {
            instance = new SingObj();
        }
        return instance;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}
