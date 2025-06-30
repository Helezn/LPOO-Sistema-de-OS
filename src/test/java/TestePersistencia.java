/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import control.PersistenciaJPA;
import java.util.ArrayList;
import java.util.Date;
import model.OrdemServico;
import model.StatusOS;
import model.SetorOS;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acer
 */
public class TestePersistencia {

    public TestePersistencia() {
    }

    private PersistenciaJPA jpa;

    @Before
    public void setUp() {
        jpa = new PersistenciaJPA();
        System.out.println("Iniciando teste de conexão...");
    }

    @After
    public void tearDown() {
        if (jpa != null && jpa.conexaoAberta()) {
            jpa.fecharConexao();
            System.out.println("Conexão fechada com sucesso.");
        }
    }

    @Test
    public void cadastroOrdensServico() {
        try {
            OrdemServico os = new OrdemServico(
                    "Problema no computador",
                    StatusOS.ABERTO,
                    SetorOS.FATURAMENTO,
                    123, 
                    456,
                    new Date()
            );
            jpa.persist(os);
        } catch (Exception ex) {
            System.err.println("Erro ao persistir OrdemServico: " + ex);
        }

        ArrayList<OrdemServico> listaOrdens = (ArrayList<OrdemServico>) jpa.getOrdensServico();

        if (listaOrdens.isEmpty()) {
            System.out.println("Não há ordens de serviço cadastradas");
        }

        for (OrdemServico os : listaOrdens) {
            System.out.println("OS #" + os.getIdOS()
                    + " - Problema: " + os.getDescricaoProblema()
                    + " - Conserto: " + os.getDescricaoConserto()
                    + " - Status: " + os.getStatus()
                    + " - Setor: " + os.getSetor()
                    + " - CodFun: " + os.getCodFun()
                    + " - CodTec: " + os.getCodTec()
                    + " - Abertura: " + os.getAbertura()
                    + " - Fechamento: " + os.getFechamento());
        }
    }

}
