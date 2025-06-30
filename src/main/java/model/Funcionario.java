/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "tbl_funcionarios")
@DiscriminatorValue("tipo_funcionario")
public class Funcionario extends Usuario {
    
    @Column(name = "codFun")
    private int codFun;

    public Funcionario(int codFun, String nome, String login, String senha, String tipo) {
        super(nome, login, senha, tipo);
        this.codFun = codFun;
    }

    public int getCodFun() {
        return codFun;
    }

    public void setCodFun(int codFun) {
        this.codFun = codFun;
    }
}
