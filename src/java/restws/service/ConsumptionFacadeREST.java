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
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restws.Consumption;
import restws.Food;

/**
 *
 * @author Ning
 */
@Stateless
@Path("restws.consumption")
public class ConsumptionFacadeREST extends AbstractFacade<Consumption> {

    @PersistenceContext(unitName = "CalorieTracker-webservicePU")
    private EntityManager em;

    public ConsumptionFacadeREST() {
        super(Consumption.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Consumption entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Consumption entity) {
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
    public Consumption find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findAll() {
        return super.findAll();
    }

    @GET
    @Path("findByConsumptionDate/{consumptionDate}")
    @Produces({"application/json"})
    public List<Consumption> findByConsumptionDate(@PathParam("consumptionDate") String consumptionDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Query query = em.createNamedQuery("Consumption.findByConsumptionDate");
        List<Consumption> list = new ArrayList<>();
        try {
            query.setParameter("consumptionDate", sdf.parse(consumptionDate));
            list = query.getResultList();
        } catch (ParseException ex) {
            Logger.getLogger(ConsumptionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @GET
    @Path("findByQuantity/{quantity}")
    @Produces({"application/json"})
    public List<Consumption> findByQuantity(@PathParam("quantity") String quantity) {
        Query query = em.createNamedQuery("Consumption.findByQuantity");
        List<Consumption> list = new ArrayList<>();
        try {
            query.setParameter("quantity", Integer.parseInt(quantity));
            list = query.getResultList();
        } catch (NumberFormatException e) {
            Logger.getLogger(ConsumptionFacadeREST.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    @GET
    @Path("findByUserId/{userId}")
    @Produces({"application/json"})
    public List<Consumption> findByUserId(@PathParam("userId") String userId) {
        Query query = em.createNamedQuery("Consumption.findByUserId");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @GET
    @Path("findByFoodId/{foodId}")
    @Produces({"application/json"})
    public List<Consumption> findByFoodId(@PathParam("foodId") String foodId) {
        Query query = em.createNamedQuery("Consumption.findByFoodId");
        query.setParameter("foodId", foodId);
        return query.getResultList();
    }

    @GET
    @Path("findByFoodAndQuantity/{foodName}/{quantity}")
    @Produces({"application/json"})
    public List<Consumption> findByFoodAndQuantity(@PathParam("foodName") String foodName, @PathParam("quantity") String quantity) {
        TypedQuery<Consumption> query = em.createQuery(
                "SELECT c FROM Consumption c WHERE c.foodId.foodName = :foodName and c.quantity = :quantity", Consumption.class);
        List<Consumption> list = new ArrayList<>();
        query.setParameter("foodName", foodName);
        try {
            query.setParameter("quantity", Integer.parseInt(quantity));
            list = query.getResultList();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    @GET
    @Path("dailyCaloriesConsumed/{userId}/{date}")
    @Produces({"application/json"})
    public String dailyCaloriesConsumed(@PathParam("userId") String userId, @PathParam("date") String date) throws ParseException {
        TypedQuery<Consumption> query = em.createQuery(
                "SELECT c FROM Consumption c WHERE c.userId.userId = :userId and c.consumptionDate = :date", Consumption.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        query.setParameter("userId", userId);
        query.setParameter("date", sdf.parse(date));
        List<Consumption> list = query.getResultList();
        double caloriesConsumed = 0;
        for (Consumption consumption : list) {
            double caloriesAmount = consumption.getFoodId().getCalorieAmount();
            Integer quantity = consumption.getQuantity();
            caloriesConsumed += (caloriesAmount * quantity);
        }
        return Double.toString(caloriesConsumed);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
