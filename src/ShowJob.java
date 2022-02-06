

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
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ShowJob
 */
@WebServlet("/ShowJob")
public class ShowJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowJob() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema","root","dbms@123");
				
				HttpSession session = request.getSession();
				String StudentEmail = (String)session.getAttribute("e-mail");
				System.out.println("mail"+StudentEmail);
				
				//PreparedStatement ps = conn.prepareStatement("select * from jobopen_t");
				PreparedStatement ps = conn.prepareStatement("select j_id,c_name,j_designation,j_ctc,j_profiletype,j_venue from jobopen_t where j_status=1"
						+ " and j_id not in "
						+ "(select jobopen_t.j_id from jobopen_t,apply_t where jobopen_t.j_id=apply_t.j_id and s_email=?);");
				ps.setString(1,StudentEmail);
				 
				 ResultSet rs = ps.executeQuery();
				
				 out.print(
						 "<html>" +
						 "<head>" +
						 "<title>Show Jobs For Students</title>");
				 out.print(
						 "<link rel='stylesheet' href='style.css' media='screen' type='text/css'>" +
						 "<link rel='stylesheet' href='tablejob.css' media='screen' type='text/css'"+
						"<style>"+
						 
						
						
						
						"</style>"+
						 "</head>" +
						 "<body>" +

						 "<div class='header'>"+
							"<h1 class='heading-main' align='center'>Magnanimous Jobverse </h1>"+
						"</div>"+

						"<ul style='width:100%'>"+
						
					  		"<li style=\"float:right\"><a href=\"homepage.jsp\">Logout</a></li>"+
					  		"<li style=\"float:right\"><a href='ResultForStudents' action='ResultForStudents'>Results</a></li>"+
					  		"<li style=\"float:right\"><a href='ShowJob' action='ShowJob'>Jobs</a></li>"+
					  		"<li style=\"float:right\"><a href='AppliedListForStudents' action='AppliedListForStudents'>Applied</a></li>"+
						"</ul>"+
						"<hr>"+
						"<div class='portal'>"+
							"<p style='font-size=14' align='center'>Available Jobs</p>"+
						"</div>"+
						"<hr>");
				 
				 while(rs.next())
				 {
					 out.print("<div style='border:3px solid black;width=100%;height='300px''>" + 
					 		"<table >"+
						"<tr>"+
							"<td><h1 style='color:#6C223D'>"+rs.getString(2)+"</h1></td>"+
							"</tr>"+
						"<tr>"+
							"<td>CTC</td>"+
							"<td>"+rs.getInt(4)+" lakhs"+"</td>"+
						"</tr>"+
						"<tr>"+
						"<td>Designation</td>"+
						"<td>"+rs.getString(3)+"</td>"+
						"</tr>"+
						
						"<tr>"+
							"<td>Apply Now</td>"+
							"<td><form action='ApplyAction'><input type='hidden' name='jid' value='"+rs.getInt(1)+"' >"+"<input type='submit' style='width:125px;background-color:#4CAF50;color:white;padding-top:2px;padding-bottom:2px;font-size:20px;margin:8px 0;height:50px;display:inline-block' class='button1' value='Apply'></form></td>"+
						"</tr>"+
					"</table>"+
					"</div>"+"<br/>"+"<br/>");
				 } 
				 
			}catch (Exception e1) {e1.printStackTrace();}
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
