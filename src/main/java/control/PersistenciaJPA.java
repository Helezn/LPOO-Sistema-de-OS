/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author acer
 */
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import model.Funcionario;
import model.Tecnico;
import model.OrdemServico;
import model.Usuario;

public class PersistenciaJPA implements InterfaceBD {

    private EntityManager entity;
    private final EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("LPOO-ProjetoFinal-HelenZN");
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        return entity != null && entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        if (entity != null && entity.isOpen()) {
            entity.close();
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        return getEntityManager().find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            entity.persist(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao persistir: " + o.getClass().getSimpleName(), e);
            throw e;
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o);
            }
            entity.remove(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao remover: " + o.getClass().getSimpleName(), e);
            throw e;
        }
    }

    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    public List<Usuario> getUsuarios() {
        List<Usuario> lista = new ArrayList<>();

        List<Funcionario> funcionarios = getFuncionarios();
        if (funcionarios != null) {
            lista.addAll(funcionarios);
        }

        List<Tecnico> tecnicos = getTecnicos();
        if (tecnicos != null) {
            lista.addAll(tecnicos);
        }

        return lista;
    }

    public List<Tecnico> getTecnicos() {
        entity = getEntityManager();
        try {
            TypedQuery<Tecnico> query = entity.createQuery("SELECT t FROM Tecnico t", Tecnico.class);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao buscar técnicos", e);
            return null;
        }
    }

    public List<Funcionario> getFuncionarios() {
        entity = getEntityManager();
        try {
            TypedQuery<Funcionario> query = entity.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao buscar funcionários", e);
            return null;
        }
    }

    public List<OrdemServico> getOrdensServico() {
        entity = getEntityManager();
        try {
            TypedQuery<OrdemServico> query = entity.createQuery("SELECT o FROM OrdemServico o", OrdemServico.class);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao buscar ordens de serviço", e);
            return null;
        }
    }

}
