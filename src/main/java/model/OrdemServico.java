/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "tbl_ordens_servicos")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOS")
    private int idOS;

    @Column(name = "descricaoProblema")
    private String descricaoProblema;

    @Column(name = "descricaoConserto")
    private String descricaoConserto;

    @Enumerated(EnumType.STRING)
    private StatusOS status;

    @Enumerated(EnumType.STRING)
    private SetorOS setor;

    @Column(name = "codFun")
    private int codFun;

    @Column(name = "codTec")
    private int codTec;

    @Column(name = "abertura")
    private Date abertura;

    @Column(name = "fechamento")
    private Date fechamento;

    public OrdemServico(String descricaoProblema, StatusOS status, SetorOS setor, int codFun, int codTec, Date abertura) {
        this.descricaoProblema = descricaoProblema;
        this.descricaoConserto = descricaoConserto;
        this.status = status;
        this.setor = setor;
        this.codFun = codFun;
        this.codTec = codTec;
        this.abertura = abertura;
    }

    public int getIdOS() {
        return idOS;
    }

    public void setIdOS(int idOS) {
        this.idOS = idOS;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getDescricaoConserto() {
        return descricaoConserto;
    }

    public void setDescricaoConserto(String descricaoConserto) {
        this.descricaoConserto = descricaoConserto;
    }

    public StatusOS getStatus() {
        return status;
    }

    public void setStatus(StatusOS status) {
        this.status = status;
    }

    public SetorOS getSetor() {
        return setor;
    }

    public void setSetor(SetorOS setor) {
        this.setor = setor;
    }

    public int getCodFun() {
        return codFun;
    }

    public void setCodFun(int codFun) {
        this.codFun = codFun;
    }

    public int getCodTec() {
        return codTec;
    }

    public void setCodTec(int codTec) {
        this.codTec = codTec;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public Date getFechamento() {
        return fechamento;
    }

    public void setFechamento(Date fechamento) {
        this.fechamento = fechamento;
    }

    @Override
    public String toString() {
        return "OS: " + idOS + " | Status: " + status + " | Setor: " +  setor;
    }
}
