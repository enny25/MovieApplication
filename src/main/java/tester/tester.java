/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import DatabaseMappers.MovieMapper;
import entity.Movie;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lenovo
 */
public class tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
        EntityManager em = emf.createEntityManager();
        Movie movie= MovieMapper.movieGetter("tt0265086");
        
        try {
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();    
        } catch (Exception e) {
        }finally{
            em.close();
        }
        
        
        
        
    }
    
}
