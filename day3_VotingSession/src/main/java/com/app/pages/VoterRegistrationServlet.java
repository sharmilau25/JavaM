package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class VoterRegistrationServlet
 */
//@WebServlet("/registration")
public class VoterRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init of...");
		try {
			userDao = new UserDaoImpl();

		} catch (Exception e) {
			// centralized exc handling in Servlet
			/*
			 * In case of err in init --To inform the WC throw ServletException --WC will
			 * abort the life cycle Ctor of javax.servlet.ServletException(String mesg,
			 * Throwable rootCause)
			 */
			throw new ServletException("err in init - " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			// WC invokes it once @ end of the life cycle
			// clean up Dao
			userDao.cleanUp();
		} catch (Exception e) {
			System.out.println("err in destroy - " + getClass());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			// first name , last name , email , password , dob from user.
			HttpSession session=request.getSession();
			String first_name=request.getParameter("fn");
			String last_name=request.getParameter("ln");
			String email=request.getParameter("em");
			String password=request.getParameter("pass");
			LocalDate dob=LocalDate.parse(request.getParameter("dob"));
			
			Period period=Period.between(dob, LocalDate.now());
			System.out.println("local date......"+period.getYears());
			
			if(period.getYears()>21)
			{
				User newVoter=new User(first_name,last_name,email,password,Date.valueOf(dob));
				//String user=userDao.voterRegistration(first_name,last_name,email,password,dob);
				//invoke user daos method for inserting
				
				System.out.println("user inserted..."+newVoter);
				pw.print("<a href='login.html'>Login</a>");
			}
			else {
				System.out.println("age below 21.....");
				pw.print("<h3>Age below 21.. cannot vote..</h3><a href='voter_registration.html'>Back</a>");
			}
			
		
			
		}
		catch (Exception e) {
			System.out.println("in voter registration servlet");
		}
		
		
		
	}

}
