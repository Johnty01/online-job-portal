

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
 * Servlet implementation class ResultForStudents
 */
@WebServlet("/ResultForStudents")
public class ResultForStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultForStudents() {
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

		HttpSession session = request.getSession();
		String StudentEmail = (String)session.getAttribute("e-mail");
		System.out.println("mail:"+StudentEmail);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			if(StudentEmail!=null && !StudentEmail.isEmpty())
			{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema","root","dbms@123");
			PreparedStatement ps = conn.prepareStatement("select c_name,j_designation,j_ctc,j_profiletype,j_venue,status,event_venue from apply_t,jobopen_t where apply_t.j_id=jobopen_t.j_id and j_status=0 and check_status=1 and s_email=?;");
					
			ps.setString(1,StudentEmail);
			 
			 ResultSet rs = ps.executeQuery();
			
			 out.print(
					 "<html>" +
					 "<head>" +
					 "<title>Results for Students</title>");
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
					"<li><a href='homepage.jsp'>Home</a></li>"+
				  		
				  		"<li style=\"float:right\"><a href='ResultForStudents' action='ResultForStudents'>Results</a></li>"+
				  		"<li style=\"float:right\"><a href='ShowJob' action='ShowJob'>Jobs</a></li>"+
				  		"<li style=\"float:right\"><a href='AppliedListForStudents' action='AppliedListForStudents'>Applied</a></li>"+
					"</ul>"+
					"<hr>"+
					"<div class='portal'>"+
						"<p style='font-size=14' align='center'>Applications in Companies</p>"+
					"</div>"+
					"<hr>");
			 out.print("<table id='applicants' align='center'>"+
				 		"<tr> 	<th>S. No</th> 		<th>Company Name</th>			<th>Job Designation</th>		<th>CTC</th>		<th>Job Profile</th> 		<th>Joining Venue</th>	<th>Decision</th> <th>Event Place</th>	 </tr>");
			 int count=1;
			 while(rs.next())
			 {
				 out.print("<tr>"+
							"<td>"+count+"."+"</td>"+
							"<td>"+rs.getString(1)+"</td>"+
							"<td>"+rs.getString(2)+"</td>"+
							"<td>"+rs.getDouble(3)+"</td>"+
							"<td>"+rs.getString(4)+"</td>"+
							"<td>"+rs.getString(5)+"</td>"+
							"<td>"+rs.getString(6)+"</td>"+
							"<td>"+rs.getString(7)+"</td>"
							
						 );	 
				 count++;
			 }
			 out.print("</table>");
			}
			else
			{
				out.print("<div id=header style=background-color:cadetblue;color:white;> <h4 style=margin-left:550;>" +
						" Please Log-in first !</h4></div>");
					 	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					 	rd.include(request, response);
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
