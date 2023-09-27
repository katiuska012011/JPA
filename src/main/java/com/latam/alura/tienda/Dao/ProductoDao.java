package com.latam.alura.tienda.Dao;

import com.latam.alura.tienda.modelo.Producto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductoDao {

    private EntityManager em;

    public ProductoDao(EntityManager em){
        this.em = em;
    }

    public void guardar(Producto producto){
        this.em.persist(producto);
    }

    public Producto consultaPorId(Long id){
        return em.find(Producto.class, id);
    }

    public List<Producto> consultarTodos(){
        String query = "SELECT P FROM Producto as P ";
        return em.createQuery(query, Producto.class).getResultList();
    }
}
