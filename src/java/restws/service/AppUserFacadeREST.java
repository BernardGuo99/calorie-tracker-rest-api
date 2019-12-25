/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restws.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import restws.AppUser;

/**
 *
 * @author Ning
 */
@Stateless
@Path("restws.appuser")
public class AppUserFacadeREST extends AbstractFacade<AppUser> {

    @PersistenceContext(unitName = "CalorieTracker-webservicePU")
    private EntityManager em;

    public AppUserFacadeREST() {
        super(AppUser.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(AppUser entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, AppUser entity) {
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
    public AppUser find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Path("findByFirstname/{firstname}")
    @Produces({"application/json"})
    public List<AppUser> findByFirstname(@PathParam("firstname") String firstname) {
        Query query = em.createNamedQuery("AppUser.findByFirstname");
        query.setParameter("firstname", firstname);
        return query.getResultList();
    }

    @GET
    @Path("findBySurname/{surname}")
    @Produces({"application/json"})
    public List<AppUser> findBySurname(@PathParam("surname") String surname) {
        Query query = em.createNamedQuery("AppUser.findBySurname");
        query.setParameter("surname", surname);
        return query.getResultList();
    }

    @GET
    @Path("findByEmail/{email}")
    @Produces({"application/json"})
    public List<AppUser> findByEmail(@PathParam("email") String email) {
        Query query = em.createNamedQuery("AppUser.findByEmail");
        query.setParameter("email", email);
        return query.getResultList();
    }

    @GET
    @Path("findByDateOfBirth/{dateOfBirth}")
    @Produces({"application/json"})
    public List<AppUser> findByDateOfBirth(@PathParam("dateOfBirth") String dateOfBirth) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Query query = em.createNamedQuery("AppUser.findByDateOfBirth");
        List<AppUser> list = new ArrayList<>();
        try {
            query.setParameter("dateOfBirth", sdf.parse(dateOfBirth));
            list = query.getResultList();
        } catch (ParseException ex) {
            Logger.getLogger(AppUserFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @GET
    @Path("findByHeight/{height}")
    @Produces({"application/json"})
    public List<AppUser> findByHeight(@PathParam("height") String height) {
        Query query = em.createNamedQuery("AppUser.findByHeight");
        List<AppUser> list = new ArrayList<>();
        try {
            query.setParameter("height", Double.parseDouble(height));
            list = query.getResultList();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    @GET
    @Path("findByWeight/{weight}")
    @Produces({"application/json"})
    public List<AppUser> findByWeight(@PathParam("weight") String weight) {
        Query query = em.createNamedQuery("AppUser.findByWeight");
        List<AppUser> list = new ArrayList<>();
        try {
            query.setParameter("weight", Double.parseDouble(weight));
            list = query.getResultList();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    @GET
    @Path("findByGender/{gender}")
    @Produces({"application/json"})
    public List<AppUser> findByGender(@PathParam("gender") String gender) {
        Query query = em.createNamedQuery("AppUser.findByGender");
        query.setParameter("gender", gender);
        return query.getResultList();
    }

    @GET
    @Path("findByAddress/{address}")
    @Produces({"application/json"})
    public List<AppUser> findByAddress(@PathParam("address") String address) {
        Query query = em.createNamedQuery("AppUser.findByAddress");
        query.setParameter("address", address);
        return query.getResultList();
    }

    @GET
    @Path("findByPostcode/{postcode}")
    @Produces({"application/json"})
    public List<AppUser> findByPostcode(@PathParam("postcode") String postcode) {
        Query query = em.createNamedQuery("AppUser.findByPostcode");
        query.setParameter("postcode", postcode);
        return query.getResultList();
    }

    @GET
    @Path("findByLevelOfActivity/{levelOfActivity}")
    @Produces({"application/json"})
    public List<AppUser> findByLevelOfActivity(@PathParam("levelOfActivity") String levelOfActivity) {
        Query query = em.createNamedQuery("AppUser.findByLevelOfActivity");
        List<AppUser> list = new ArrayList<>();
        try {
            query.setParameter("levelOfActivity", Integer.parseInt(levelOfActivity));
            list = query.getResultList();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    @GET
    @Path("findByStepsPerMile/{stepsPerMile}")
    @Produces({"application/json"})
    public List<AppUser> findByStepsPerMile(@PathParam("stepsPerMile") String stepsPerMile) {
        Query query = em.createNamedQuery("AppUser.findByStepsPerMile");
        List<AppUser> list = new ArrayList<>();
        try {
            query.setParameter("stepsPerMile", Integer.parseInt(stepsPerMile));
            list = query.getResultList();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    @GET
    @Path("findByFullName/{firstname}/{surname}")
    @Produces({"application/json"})
    public List<AppUser> findByFullName(@PathParam("firstname") String firstname, @PathParam("surname") String surname) {
        TypedQuery<AppUser> query = em.createQuery(
                "SELECT a FROM AppUser a WHERE a.firstname = :firstname and a.surname = :surname", AppUser.class);
        query.setParameter("firstname", firstname);
        query.setParameter("surname", surname);
        return query.getResultList();
    }

    @GET
    @Path("caloriesBurnedPerStepByUser/{userId}/")
    @Produces({"application/json"})
    public String caloriesBurnedPerStepByUser(@PathParam("userId") String userId) {
        Query query = em.createNamedQuery("AppUser.findByUserId");
        query.setParameter("userId", userId);
        List<AppUser> list = query.getResultList();
        AppUser user = list.get(0);
        Integer stepsPerMile = user.getStepsPerMile();
        System.out.println(stepsPerMile);
        double caloriesBurnedPerMile = user.getWeight() * 2.2046 * 0.49;
        double caloriesBurnedPerStep = caloriesBurnedPerMile / stepsPerMile;
        return String.format("%.4f", caloriesBurnedPerStep);
    }

    @GET
    @Path("calculateBMR/{userId}/")
    @Produces({"application/json"})
    public String calculateBMR(@PathParam("userId") String userId) {
        Query query = em.createNamedQuery("AppUser.findByUserId");
        query.setParameter("userId", userId);
        AppUser user = (AppUser) query.getSingleResult();
        double weight = user.getWeight();
        double height = user.getHeight();
        String gender = user.getGender();
        Date dOB = user.getDateOfBirth();
        Calendar c = Calendar.getInstance();
        c.setTime(dOB);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
        LocalDate ld = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        Period diff = Period.between(ld, now);
        int age = diff.getYears();
        double amount = 0;
        if (gender.equals("M")) {
            amount = (13.75 * weight) + (5.003 * height) - (6.755 * age) + 66.5;
        } else {
            amount = (9.563 * weight) + (1.85 * height) - (4.676 * age) + 655.1;
        }
        return Double.toString(amount);
    }

    @GET
    @Path("totalCaloriesBurnedAtRest/{userId}/")
    @Produces({"application/json"})
    public String totalCaloriesBurnedAtRest(@PathParam("userId") String userId) {
        Query query = em.createNamedQuery("AppUser.findByUserId");
        query.setParameter("userId", userId);
        AppUser user = (AppUser) query.getSingleResult();
        Integer levelOfActivity = user.getLevelOfActivity();
        String BMRPlain = calculateBMR(userId);
        double BMR = Double.parseDouble(BMRPlain);
        double totalCalories = 0;
        switch (levelOfActivity) {
            case 1:
                totalCalories = BMR * 1.2;
                break;
            case 2:
                totalCalories = BMR * 1.375;
                break;
            case 3:
                totalCalories = BMR * 1.55;
                break;
            case 4:
                totalCalories = BMR * 1.725;
                break;
            case 5:
                totalCalories = BMR * 1.9;
                break;
            default:
                break;
        }
        return Double.toString(totalCalories);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AppUser> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AppUser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
