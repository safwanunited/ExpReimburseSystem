package com.revature.Project1.expReimbursement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/controller")
public class MyResource {
	static int curid;
	static String role;
	public int output;
	private Transaction tx;

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getHelloParam(String data) throws ClassNotFoundException, JsonProcessingException {

		System.out.println(data);
		Session session = null;
		Transaction transaction = null;
		ObjectMapper obj = new ObjectMapper();
		System.out.println(data);
		login u = obj.readValue(data, login.class);
		System.out.println(u);
		int uid = u.getUid();
		// state=uid;
		String pwd = u.getPwd();
		String des = u.getDes();
		Auth a = new Auth();
		if (des.equals("manager")) {

			try {
				session = HibernateUtils.getSessionFactory().openSession();
				transaction = session.beginTransaction();
				Manager m = (Manager) session.createQuery("FROM Manager M WHERE M.mid = :userId")
						.setParameter("userId", uid).uniqueResult();
				if (m != null && m.getPwd().equals(pwd)) {
					// l.setUid(uid);
					// l.setValue("true");
					// l.setDes(e.getD"es());
					curid = uid;
					role = "Manager";
					a.setStatus("true");
					System.out.println(a);
					
				}
				else {
	
				a.setStatus("false");
		
				}
				transaction.commit();
				return obj.writeValueAsString(a);
			} catch (Exception ex) {
				if (transaction != null) {
					transaction.rollback();
				}
				a.setStatus("false");
				System.out.println(a);
				return obj.writeValueAsString(a);

			}
		} else {
			try {
				session = HibernateUtils.getSessionFactory().openSession();
				transaction = session.beginTransaction();
				Employee e = (Employee) session.createQuery("FROM Employee E WHERE E.id = :userId")
						.setParameter("userId", uid).uniqueResult();
				if (e != null && e.getPwd().equals(pwd)) {
					// l.setUid(uid);
					// l.setValue("true");
					// l.setDes(e.getD"es());
					a.setStatus("true");
					curid = uid;
					role = "Employee";
					System.out.println(a);
					
				}
				else {
					
					a.setStatus("false");
			
					}
					transaction.commit();
					return obj.writeValueAsString(a);
			} catch (Exception ex) {
				if (transaction != null) {
					transaction.rollback();
				}
				a.setStatus("false");
				System.out.println(a);
				return obj.writeValueAsString(a);

			}
		}
	}

	@GET
	@Path("/profile")
	@Produces(MediaType.APPLICATION_JSON)

	public String getprofile() throws ClassNotFoundException, JsonProcessingException {
		System.out.println(curid);
		ObjectMapper o = new ObjectMapper();
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		if (role.equals("Employee")) {
			Employee usr = session.get(Employee.class, curid);
			// List<Employee> list=new ArrayList<Employee>();
			// list.add(usr);
			return o.writeValueAsString(usr);
		} else {

			Manager usr = session.get(Manager.class, curid);
			// List<Manager> list=new ArrayList<Manager>();
			// list.add(usr);
			return o.writeValueAsString(usr);

		}

	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@PUT
	@Path("/eupdateprofile")
	@Produces(MediaType.APPLICATION_JSON)

	public String updateeprofile(String data) throws ClassNotFoundException, JsonProcessingException {
		Auth au = new Auth();
		System.out.println(curid);
		ObjectMapper o = new ObjectMapper();
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("done");
		output = 0;
		if (role.equals("Employee")) {
			Employee e1 = session.get(Employee.class, curid);
			Employee e = o.readValue(data, Employee.class);
			System.out.println(e);
			System.out.println(e1);
			try {
				if (!e.getEmail().equals("")) {
					e1.setEmail(e.getEmail());
				}
				if (!e.getPhno().equals("")) {
					e1.setPhno(e.getPhno());
				}
				if (!e.getAdd().equals("")) {
					e1.setAdd(e.getAdd());
				}
				if (!e.getState().equals("")) {
					e1.setState(e.getState());
				}
				if (!e.getCountry().equals("")) {
					e1.setCountry(e.getCountry());
				}
				if (!e.getPin().equals("")) {
					e1.setPin(e.getPin());
				}
				if (!e.getCity().equals("")) {
					e1.setCity(e.getCity());
				}
				Query q = session.createQuery(
						"update Employee set email=:emailid,phno=:phno,add=:add,city=:city,state=:state,country=:country,pin=:pin  where id=:id");
				q.setParameter("emailid", e1.getEmail());
				q.setParameter("phno", e1.getPhno());

				q.setParameter("add", e1.getAdd());
				q.setParameter("city", e1.getCity());
				q.setParameter("state", e1.getState());
				q.setParameter("country", e1.getCountry());
				q.setParameter("pin", e1.getPin());
				// q.setParameter("contactno",e.getContactno());

				q.setParameter("id", curid);
				System.out.println(e1);
				int result = q.executeUpdate();

				if (result > 0) {

					au.setStatus("true");
				} else {
					au.setStatus("false");
				}

			} catch (Exception ex) {
				ex.getMessage();
			}
			tx.commit();
			return o.writeValueAsString(au);
		} else {
			Manager e1 = session.get(Manager.class, curid);
			Manager e = o.readValue(data, Manager.class);
			try {
				if (!e.getEmail().equals("")) {
					e1.setEmail(e.getEmail());
				}
				if (!e.getPhno().equals("")) {
					e1.setPhno(e.getPhno());
				}
				if (!e.getAdd().equals("")) {
					e1.setAdd(e.getAdd());
				}
				if (!e.getState().equals("")) {
					e1.setState(e.getState());
				}
				if (!e.getCountry().equals("")) {
					e1.setCountry(e.getCountry());
				}
				if (!e.getPin().equals("")) {
					e1.setPin(e.getPin());
				}
				if (!e.getCity().equals("")) {
					e1.setCity(e.getCity());
				}
				System.out.println(e);
				System.out.println(e1);
				Query q = session.createQuery(
						"update Manager set email=:emailid,phno=:phno,add=:add,city=:city,state=:state,country=:country,pin=:pin  where mid=:id");
				q.setParameter("emailid", e1.getEmail());
				q.setParameter("phno", e1.getPhno());

				q.setParameter("add", e1.getAdd());
				q.setParameter("city", e1.getCity());
				q.setParameter("state", e1.getState());
				q.setParameter("country", e1.getCountry());
				q.setParameter("state", e1.getState());
				q.setParameter("pin", e1.getPin());
				// q.setParameter("contactno",e.getContactno());

				q.setParameter("id", curid);
				int result = q.executeUpdate();

				if (result > 0) {
					au.setStatus("true");
				} else {
					au.setStatus("false");
				}

			} catch (Exception ex) {
				ex.getMessage();
			}
			tx.commit();
			return o.writeValueAsString(au);
		}

	}

	@POST
	@Path("/insert")

	public String insertvalue(String data) throws JsonMappingException, JsonProcessingException {

		Auth au = new Auth();
		System.out.println(curid);
		ObjectMapper o = new ObjectMapper();
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("done");

		Employee e = o.readValue(data, Employee.class);
		session.save(e);
		tx.commit();

		au.setStatus("true");

		return o.writeValueAsString(au);

	}

	@POST
	@Path("/insertreq")

	public String insertrequest(String data) throws JsonMappingException, JsonProcessingException {

		Auth au = new Auth();
		System.out.println(curid);
		ObjectMapper o = new ObjectMapper();
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Date d = new Date();

		System.out.println("done");
		Employee eid = session.get(Employee.class, curid);
		EreimburseReq e = o.readValue(data, EreimburseReq.class);
		e.setEmp(eid);
		e.setDateofreq(d);
		e.setStatus("pending");
		session.save(e);
		tx.commit();

		au.setStatus("true");

		return o.writeValueAsString(au);

	}

	@GET
	@Path("/viewempreq")
	@Produces(MediaType.APPLICATION_JSON)

	public String viewEmpReq() throws ClassNotFoundException, JsonProcessingException {
		System.out.println(role);
		System.out.println("employeeid"+curid);
		ObjectMapper o = new ObjectMapper();
		Session session = HibernateUtils.getSessionFactory().openSession();
		tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<EreimburseReq> req = session.createQuery("from EreimburseReq where emp.id=:id").setParameter("id", curid).list();
		System.out.println(req);
		List<ErUtils> pend=new ArrayList<ErUtils>();
        for(EreimburseReq e:req) {
        	ErUtils p=new ErUtils(e.getReqNo(),e.getDateofreq(),e.getRname(),e.getAmt(), e.getDescription(),e.getStatus(),e.getEmp().getId());
             pend.add(p);
             System.out.println(p);
      }
		// EreimburseReq usr = session.get(EreimburseReq.class, curid);
		return o.writeValueAsString(pend);

	}
	
	@GET
	@Path("/viewpend")
	@Produces(MediaType.APPLICATION_JSON)

	public String viewPend() throws ClassNotFoundException, JsonProcessingException {
		System.out.println(role);
		System.out.println("employeeid"+curid);
		ObjectMapper o = new ObjectMapper();
		Session session = HibernateUtils.getSessionFactory().openSession();
		tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<EreimburseReq> req = session.createQuery("from EreimburseReq where status='pending' and emp.id=:id").setParameter("id", curid).list();
		System.out.println(req);
		List<ErUtils> pend=new ArrayList<ErUtils>();
        for(EreimburseReq e:req) {
        	ErUtils p=new ErUtils(e.getReqNo(),e.getDateofreq(),e.getRname(),e.getAmt(), e.getDescription(),e.getStatus(),e.getEmp().getId());
             pend.add(p);
             System.out.println(p);
      }
		// EreimburseReq usr = session.get(EreimburseReq.class, curid);
		return o.writeValueAsString(pend);

	}
	
	
	
	
	
	
	@GET
	@Path("/viewresolved")
	@Produces(MediaType.APPLICATION_JSON)

	public String viewResolved() throws ClassNotFoundException, JsonProcessingException {
		System.out.println(role);
		System.out.println("employeeid"+curid);
		ObjectMapper o = new ObjectMapper();
		Session session = HibernateUtils.getSessionFactory().openSession();
		tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<EreimburseReq> req = session.createQuery("from EreimburseReq where status='resolved' and emp.id=:id").setParameter("id", curid).list();
		System.out.println(req);
		List<ErUtils> pend=new ArrayList<ErUtils>();
        for(EreimburseReq e:req) {
        	ErUtils p=new ErUtils(e.getReqNo(),e.getDateofreq(),e.getRname(),e.getAmt(), e.getDescription(),e.getStatus(),e.getEmp().getId());
             pend.add(p);
             System.out.println(p);
      }
		// EreimburseReq usr = session.get(EreimburseReq.class, curid);
		return o.writeValueAsString(pend);

	}

	
	@GET
	@Path("/viewmanagerreq")
	@Produces(MediaType.APPLICATION_JSON)

	public String viewManagerReq() throws ClassNotFoundException, JsonProcessingException {
		System.out.println(role);
		System.out.println("employeeid"+curid);
		ObjectMapper o = new ObjectMapper();
		Session session = HibernateUtils.getSessionFactory().openSession();
		tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<EreimburseReq> req=session.createQuery("from EreimburseReq where status='pending' ").list();
		System.out.println(req);
		List<ErUtils> pend=new ArrayList<ErUtils>();
        for(EreimburseReq e:req) {
        	ErUtils p=new ErUtils(e.getReqNo(),e.getDateofreq(),e.getRname(),e.getAmt(), e.getDescription(),e.getStatus(),e.getEmp().getId());
             pend.add(p);
             System.out.println(p);
      }
		// EreimburseReq usr = session.get(EreimburseReq.class, curid);
		return o.writeValueAsString(pend);

	}
	
	
	@PUT
	@Path("/updaterequest")
	@Produces(MediaType.APPLICATION_JSON)

	public String updateReq(String data) throws ClassNotFoundException, JsonProcessingException {
		
		System.out.println(role);
		System.out.println("employeeid"+curid);
		ObjectMapper o = new ObjectMapper();
		Session session = HibernateUtils.getSessionFactory().openSession();
		ErUtils r=o.readValue(data,ErUtils.class);
		tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query q=session.createQuery("update EreimburseReq set status=:s  where reqNo=:id");  
	    q.setParameter("s","resolved");  
	    q.setParameter("id",r.getReqNo());  
	    int result=q.executeUpdate();     
		tx.commit();
		Auth u=new Auth();
		if(result==1)
		{
			u.setStatus("true");
		}
		else
		{
			u.setStatus("false");
			
		}
	
	
		
		return o.writeValueAsString(u);

	}
		
	
	@PUT
	@Path("/rejected")
	@Produces(MediaType.APPLICATION_JSON)

	public String Rejected(String data) throws ClassNotFoundException, JsonProcessingException {
		
		System.out.println(role);
		System.out.println("employeeid"+curid);
		ObjectMapper o = new ObjectMapper();
		Session session = HibernateUtils.getSessionFactory().openSession();
		ErUtils r=o.readValue(data,ErUtils.class);
		tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query q=session.createQuery("update EreimburseReq set status=:s  where reqNo=:id");  
	    q.setParameter("s","rejected");  
	    q.setParameter("id",r.getReqNo());  
	    int result=q.executeUpdate();     
		tx.commit();
		Auth u=new Auth();
		if(result==1)
		{
			u.setStatus("true");
		}
		else
		{
			u.setStatus("false");
			
		}
	
	
		
		return o.writeValueAsString(u);

	}
	
	@GET
	@Path("/viewallreq")
	@Produces(MediaType.APPLICATION_JSON)

	public String viewallreq() throws ClassNotFoundException, JsonProcessingException {
		System.out.println(role);
		System.out.println("employeeid"+curid);
		ObjectMapper o = new ObjectMapper();
		Session session = HibernateUtils.getSessionFactory().openSession();
		tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<EreimburseReq> req=session.createQuery("from EreimburseReq ").list();
		System.out.println(req);
		List<ErUtils> pend=new ArrayList<ErUtils>();
        for(EreimburseReq e:req) {
        	ErUtils p=new ErUtils(e.getReqNo(),e.getDateofreq(),e.getRname(),e.getAmt(), e.getDescription(),e.getStatus(),e.getEmp().getId());
             pend.add(p);
             System.out.println(p);
      }
		// EreimburseReq usr = session.get(EreimburseReq.class, curid);
		return o.writeValueAsString(pend);

	}
	
	
	
	@GET
	@Path("/viewallresolved")
	@Produces(MediaType.APPLICATION_JSON)

	public String viewallResolved() throws ClassNotFoundException, JsonProcessingException {
		System.out.println(role);
		System.out.println("employeeid"+curid);
		ObjectMapper o = new ObjectMapper();
		Session session = HibernateUtils.getSessionFactory().openSession();
		tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<EreimburseReq> req = session.createQuery("from EreimburseReq where status='resolved' ").list();
		System.out.println(req);
		List<ErUtils> pend=new ArrayList<ErUtils>();
        for(EreimburseReq e:req) {
        	ErUtils p=new ErUtils(e.getReqNo(),e.getDateofreq(),e.getRname(),e.getAmt(), e.getDescription(),e.getStatus(),e.getEmp().getId());
             pend.add(p);
             System.out.println(p);
      }
		// EreimburseReq usr = session.get(EreimburseReq.class, curid);
		return o.writeValueAsString(pend);

	}

	
	
	
	
		
	
	/*  @GET
	  
	  @Path("/insert") public String insertvalue(){
	  
	 
	 Session session = HibernateUtils.getSessionFactory().openSession();
	  Transaction tx=session.beginTransaction(); 
	  Manager s=new Manager("Rihab","M","rihab123","rihab@email.com","96555",
	  "er","coimbatore","tn","in","872"); session.save(s); tx.commit(); session.close();
	  return null; }*/
	 

	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	




