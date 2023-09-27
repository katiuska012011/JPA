package com.latam.alura.tienda.prueba;

import com.latam.alura.tienda.Dao.CategoriaDao;
import com.latam.alura.tienda.Dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JAPUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroDeProducto {
    public static void main(String[] args) {
        registrar();
        EntityManager em = JAPUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        Producto producto =productoDao.consultaPorId(1l);
        System.out.println(producto.getNombre());
    }

    private static void registrar() {
        Categoria celulares = new Categoria("CELULARES");
        Producto celular = new Producto("Samsung", "telefono usado", new BigDecimal(1000), celulares);

        EntityManager em = JAPUtils.getEntityManager();

        ProductoDao productoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.guardar(celulares);
        productoDao.guardar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
