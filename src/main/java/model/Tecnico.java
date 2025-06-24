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
@Table(name = "tbl_tecnicos")
@DiscriminatorValue("tipo_tecnico")
public class Tecnico extends Usuario {
    
    @Column(name = "codTec")
    private int codTec;

    public Tecnico(int codTec, int id, String nome, String login, String senha, String tipo) {
        super(id, nome, login, senha, tipo);
        this.codTec = codTec;
    }

    public int getCodTec() {
        return codTec;
    }

    public void setCodTec(int codTec) {
        this.codTec = codTec;
    }
}
