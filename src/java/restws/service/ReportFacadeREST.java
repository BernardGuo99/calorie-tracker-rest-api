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
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
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
import restws.Report;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Ning
 */
@Stateless
@Path("restws.report")
public class ReportFacadeREST extends AbstractFacade<Report> {

    @PersistenceContext(unitName = "CalorieTracker-webservicePU")
    private EntityManager em;

    public ReportFacadeREST() {
        super(Report.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Report entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Report entity) {
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
    public Report find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Path("findByReportDate/{reportDate}")
    @Produces({"application/json"})
    public List<Report> findByReportDate(@PathParam("reportDate") String reportDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Query query = em.createNamedQuery("Report.findByReportDate");
        List<Report> list = new ArrayList<>();
        try {
            query.setParameter("reportDate", sdf.parse(reportDate));
            list = query.getResultList();
        } catch (ParseException ex) {
            Logger.getLogger(ReportFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @GET
    @Path("findByCaloriesConsumed/{caloriesConsumed}")
    @Produces({"application/json"})
    public List<Report> findByCaloriesConsumed(@PathParam("caloriesConsumed") String caloriesConsumed) {
        Query query = em.createNamedQuery("Report.findByCaloriesConsumed");
        List<Report> list = new ArrayList<>();
        try {
            query.setParameter("caloriesConsumed", Double.parseDouble(caloriesConsumed));
            System.out.println("123");
            list = query.getResultList();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    @GET
    @Path("findByCaloriesBurned/{caloriesBurned}")
    @Produces({"application/json"})
    public List<Report> findByCaloriesBurned(@PathParam("caloriesBurned") String caloriesBurned) {
        Query query = em.createNamedQuery("Report.findByCaloriesBurned");
        List<Report> list = new ArrayList<>();
        try {
            query.setParameter("caloriesBurned", Double.parseDouble(caloriesBurned));
            list = query.getResultList();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    @GET
    @Path("findByStepsTaken/{stepsTaken}")
    @Produces({"application/json"})
    public List<Report> findByStepsTaken(@PathParam("stepsTaken") String stepsTaken) {
        Query query = em.createNamedQuery("Report.findByStepsTaken");
        List<Report> list = new ArrayList<>();
        try {
            query.setParameter("stepsTaken", Integer.parseInt(stepsTaken));
            list = query.getResultList();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    @GET
    @Path("findByCalorieGoal/{calorieGoal}")
    @Produces({"application/json"})
    public List<Report> findByCalorieGoal(@PathParam("calorieGoal") String calorieGoal) {
        Query query = em.createNamedQuery("Report.findByCalorieGoal");
        List<Report> list = new ArrayList<>();
        try {
            query.setParameter("calorieGoal", Double.parseDouble(calorieGoal));
            list = query.getResultList();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    @GET
    @Path("findByUserId/{userId}")
    @Produces({"application/json"})
    public List<Report> findByUserId(@PathParam("userId") String userId) {
        Query query = em.createNamedQuery("Report.findByUserId");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @GET
    @Path("findByEmailAndDate/{email}/{reportDate}")
    @Produces({"application/json"})
    public List<Report> findByEmailAndDate(@PathParam("email") String email, @PathParam("reportDate") String reportDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Query query = em.createNamedQuery("Report.findByEmailAndDate");
        query.setParameter("email", email);
        query.setParameter("reportDate", sdf.parse(reportDate));
        return query.getResultList();
    }
    
    @GET
    @Path("findByUserIdAndDate/{userId}/{reportDate}")
    @Produces({"application/json"})
    public List<Report> findByUserIdAndDate(@PathParam("userId") String userId, @PathParam("reportDate") String reportDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Query query = em.createNamedQuery("Report.findByUserIdAndDate");
        query.setParameter("userId", userId);
        query.setParameter("reportDate", sdf.parse(reportDate));
        return query.getResultList();
    }
    
    @GET
    @Path("findUserReportDateRange/{userId}/{startDate}/{endDate}")
    @Produces({"application/json"})
    public List<Report> findUserReportDateRange(@PathParam("userId") String userId, @PathParam("startDate") String startDate, @PathParam("endDate") String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        List<Report> result = new ArrayList<>();
        try{
            Date temp = sdf.parse(startDate);
            Date last = sdf.parse(endDate);
            while(temp.before(last) || temp.equals(last)){
                List<Report> currentList = findByUserIdAndDate(userId,sdf.format(temp));
                if(currentList.size()!=0){
                    result.add(currentList.get(0));
                }else{
                    result.add(new Report());
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(temp);
                cal.add(Calendar.DATE, 1);
                temp = cal.getTime();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
//        result.add(findByUserIdAndDate(userId,startDate).get(0));
//        result.add(findByUserIdAndDate(userId,endDate).get(0));
        
        
        
        
        return result;
    }
    
    

    @GET
    @Path("queryCaloriesInOneDay/{userId}/{date}")
    @Produces({"application/json"})
    public Object queryCaloriesInOneDay(@PathParam("userId") String userId, @PathParam("date") String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Query query = em.createQuery("SELECT r.caloriesConsumed, r.caloriesBurned, r.calorieGoal "
                + "FROM Report As r WHERE r.userId.userId = :userId AND r.reportDate = :date", Object[].class);
        query.setParameter("userId", userId);
        query.setParameter("date", sdf.parse(date));
        Object[] result = (Object[]) query.getResultList().get(0);
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        double caloriesConsumed = (double) result[0];
        double caloriesBurned = (double) result[1];
        double calorieGoal = (double) result[2];
        double remainingCalorie = caloriesConsumed - caloriesBurned - calorieGoal;
        JsonObject reportObject = Json.createObjectBuilder().
                add("caloriesConsumed", Double.toString(caloriesConsumed))
                .add("caloriesBurned", Double.toString(caloriesBurned))
                .add("remainingCalorie", Double.toString(remainingCalorie)).build();
        arrayBuilder.add(reportObject);
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }

    @GET
    @Path("queryCaloriesInTimePeriod/{userId}/{startDate}/{endDate}")
    @Produces({"application/json"})
    public Object queryCaloriesInTimePeriod(@PathParam("userId") String userId, @PathParam("startDate") String startDate, @PathParam("endDate") String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Query query = em.createQuery("SELECT r.caloriesConsumed, r.caloriesBurned, r.stepsTaken "
                + "FROM Report r WHERE r.userId.userId = :userId AND r.reportDate BETWEEN :startDate AND :endDate", Object[].class);
        query.setParameter("userId", userId);
        query.setParameter("startDate", sdf.parse(startDate));
        query.setParameter("endDate", sdf.parse(endDate));
        double caloriesConsumedTotal = 0;
        double caloriesBurnedTotal = 0;
        int stepsTakenTotal = 0;
        List<Object[]> queryList = query.getResultList();
        for (Object[] row : queryList) {
            caloriesConsumedTotal += (double) row[0];
            caloriesBurnedTotal += (double) row[1];
            stepsTakenTotal += (int) row[2];
        }
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        JsonObject reportObject = Json.createObjectBuilder().
                add("caloriesConsumedTotal", Double.toString(caloriesConsumedTotal))
                .add("caloriesBurnedTotal", Double.toString(caloriesBurnedTotal))
                .add("stepsTakenTotal", Integer.toString(stepsTakenTotal)).build();
        arrayBuilder.add(reportObject);
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
