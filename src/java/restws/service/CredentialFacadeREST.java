/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restws.Credential;

/**
 *
 * @author Ning
 */
@Stateless
@Path("restws.credential")
public class CredentialFacadeREST extends AbstractFacade<Credential> {

    @PersistenceContext(unitName = "CalorieTracker-webservicePU")
    private EntityManager em;

    public CredentialFacadeREST() {
        super(Credential.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Credential entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Credential entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Credential find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Path("findByUserName/{userName}")
    @Produces({"application/json"})
    public List<Credential> findByUserName(@PathParam("userName") String userName) {
        Query query = em.createNamedQuery("Credential.findByUserName");
        query.setParameter("userName", userName);
        return query.getResultList();
    }

    @GET
    @Path("findByPasswordHash/{passwordHash}")
    @Produces({"application/json"})
    public List<Credential> findByPasswordHash(@PathParam("passwordHash") String passwordHash) {
        Query query = em.createNamedQuery("Credential.findByPasswordHash");
        query.setParameter("passwordHash", passwordHash);
        return query.getResultList();
    }

    @GET
    @Path("findBySignUpDate/{signUpDate}")
    @Produces({"application/json"})
    public List<Credential> findBySignUpDate(@PathParam("signUpDate") String signUpDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Query query = em.createNamedQuery("Credential.findBySignUpDate");
        List<Credential> list = new ArrayList<>();
        try {
            query.setParameter("signUpDate", sdf.parse(signUpDate));
            list = query.getResultList();
        } catch (ParseException ex) {
            Logger.getLogger(CredentialFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @GET
    @Path("findByUserId/{userId}")
    @Produces({"application/json"})
    public List<Credential> findByUserId(@PathParam("userId") String userId) {
        Query query = em.createNamedQuery("Credential.findByUserId");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credential> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credential> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
