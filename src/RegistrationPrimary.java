

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationPrimary
 */
@WebServlet("/RegistrationPrimary")
public class RegistrationPrimary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationPrimary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				System.out.println("IN THIS SERVICE===");
				response.setContentType("text/html");
				 PrintWriter out = response.getWriter();
				 String e = request.getParameter("email");
				 System.out.println("email:"+e);
				 
				 
				 try{
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema", "root", "dbms@123");
					 
					 PreparedStatement pa=conn.prepareStatement("select a_email from admin_t where a_email=?");
					 pa.setString(1,e);
					 
					 ResultSet ra = pa.executeQuery();
					 
					 PreparedStatement pc=conn.prepareStatement("select c_email from company_t where c_email=?");
					 pc.setString(1,e);
					 
					 ResultSet rc = pc.executeQuery();
					 
					 PreparedStatement ps=conn.prepareStatement("select s_email from student_t where s_email=?");
					 ps.setString(1,e);
					 
					 ResultSet rs = ps.executeQuery();
					 
					 			 
					 if(ra.next()){
						 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Sorry Email ID exist!</h4></div>");
				//out.print("Sorry emailid exist!");
				RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
				rd.include(request, response);
							
							
						}
					 else if(rc.next()){
						 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Sorry Email Id exist!</h4></div>");
				//out.print("Sorry emailid exist!");
				RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
				rd.include(request, response);
							
							
						}
					 else if(rs.next()){
						 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Sorry Email Id exist!</h4></div>");
				//out.print("Sorry emailid exist!");
				RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
				rd.include(request, response);
							
							
						}
					 
					 else{
						 out.print(
								 "<html>" +
								 "<head>" +
								 "<link rel='stylesheet' href='style.css' media='screen' type='text/css'>" +
								 "<title>Student Registration on Jobverse</title>" +

							 "</head>" +
								 "<body>" +

								 "<div class='header'>"+
									"<h1 class='heading-main' align='center'>Magnanimous Jobverse </h1>"+
								"</div>"+

								"<ul style='width:100%'>"+
								"<li><a href='homepage.jsp'>Home</a></li>"+
							  		"<li style='float:right'><a href='registration.jsp'>Registration</a></li>"+
							  		"<li style='float:right'><a href='login.jsp'>Login</a></li>"+
								"</ul>"+
								"<hr>"+
								"<div class='portal'>"+
									"<p style='font-size=14' align='center'>Proceed further to register at Magnanimous Jobverse</p>"+
								"</div>"+
								"<hr>");

						out.print("<div class='bigbox' align='center'>"+
								"<h2 align='center'>REGISTRATION</h2>"+
								"<form name='loginform' action='RegistrationSecondary'>"+
									"<table align='center'>"+
										"<br/>"+
										"<br/>"+
										"<tr>"+
										"<td>Name</td>"+
										"<td>"+
											"<input type='text' name='fname' maxlength='20' size='30'"+
										"</td>"+
									"</tr>"+
									"<tr>"+
									"<td>E-Mail</td>"+
									"<td>"+
										"<input type='email' name='email' title='Enter a valid Email Address' maxlength='80' size='30'"+
									"</td>"+
								"</tr>"+
										"<tr>"+
											"<td>10th Marks</td>"+
											"<td>"+
												"<input type='text' name='s_mark' maxlength='20' size='10'"+
											"</td>"+
										"</tr>"+
										"<tr>"+
											"<td>12th Marks</td>"+
											"<td>"+
												"<input type='text' name='ss_mark' maxlength='20' size='10'>"+
											"</td>"+
										"</tr>"+
										"<tr>"+
											"<td>Graduation Marks(till current sem)</td>"+
											"<td>"+
												"<input type='text' name='g_mark' maxlength='80' size='10'>"+
											"</td>"+
										"</tr>"+
										"<tr>"+
										"<td>Course</td>"+
										"<td>"+
											"<input type='text' name='crs' maxlength='80' size='30'>"+
										"</td>"+
									"</tr>"+
									"<tr>"+
									"<td>Stream</td>"+
									"<td>"+
										"<input type='text' name='strm' maxlength='80' size='30'>"+
									"</td>"+
								"</tr>"+
								"</tr>"+
								"<tr>"+
								"<td>Training Field</td>"+
								"<td>"+
									"<input type='text' name='field' maxlength='80' size='30'>"+
								"</td>"+
							"</tr>"+
							"<tr>"+
							"<td>Password</td>"+
							"<td>"+
								"<input type='password' name='psswrd' pattern='(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}' title='Must contain atleast one number and one uppercase and lowercase letter, and atleast 8 or more characters'required maxlength='20' size='10'"+
							"</td>"+
						"</tr>"+
										"<tr>"+"<td>"+"</td>"+"<td>"+"</td>"+"</tr>"+
										"<tr>"+
											"<td>"+
											"</td>"+
											"<td>"+
											"<input type='submit' value='Submit' name='sbmt' id='submit'>"+
												"<input type='reset' value='Reset' name='rst' id='submit'>"+
											"</td>"+
											"</tr>"+
									"</table>"+
								"</form>"+
							"</div>"+
						"</body>"+
						"</html>"

							 	
							 ); 
					
						 
					 }			 
					 
					 
				 }catch(Exception e1 ){
					 
					 e1.printStackTrace();
				 }

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
