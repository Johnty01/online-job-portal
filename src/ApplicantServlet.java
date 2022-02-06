

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
 * Servlet implementation class ApplicantServlet
 */
@WebServlet("/ApplicantServlet")
public class ApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantServlet() {
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
		System.out.println("IN THIS SERVLET ApplicantServlet");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema","root","dbms@123");
			HttpSession session =request.getSession();
			String em = (String)session.getAttribute("e-mail");
			if(em!=null && !em.isEmpty())
			{
				PreparedStatement ps = con.prepareStatement("select j_designation,j_profiletype,j_id from jobopen_t,company_t where jobopen_t.c_name = company_t.c_name and j_status=1 and company_t.c_email=?;");//if space btwn c_email and ? then wrong and in sql and is the right one not &
				ps.setString(1, em);
				ResultSet rs = ps.executeQuery();
				//rs.next();
				
				
				

				 out.print(
						 "<html>" +
						 "<head>" +
						 "<title>Jobs by the Company</title>");
				 out.print(
						 "<link rel='stylesheet' href='style.css' media='screen' type='text/css'>" +
						 "<link rel='stylesheet' href='tablejob.css' media='screen' type='text/css'"+
						"<style>"+
						//"input[type=submit]"+"{" +
						//	 "width: 100%;"+
						//	  "background-color: #4CAF50;"+
						//	  "color: white;"+
						//	  "padding: 14px 20px;"+
						//	  "margin: 8px 0;"+
						//	  "border: none;"+
						//	  "border-radius:4px;"+
						//	  "cursor: pointer;"+
						//"}"+
						
						"</style>"+
						 "</head>" +
						 "<body>" +

						 "<div class='header'>"+
							"<h1 class='heading-main' align='center'>Magnanimous Jobverse </h1>"+
						"</div>"+

						"<ul style='width:100%'>"+
						
					  		"<li style='float:right'><a href='jobadd.jsp'>Add a Job</a></li>"+
					  		"<li style='float:right'><a href='ApplicantServlet'>See Applicants</a></li>"+
					  		"<li style='float:right'><a href='homepage.jsp'>Logout</a></li>"+
					  		"<li style='float:right'><a href='HistoryServlet'>History</a></li>"+
						"</ul>"+
						"<hr>"+
						"<div class='portal'>"+
							"<p style='font-size=14' align='center'>Jobs</p>"+
						"</div>"+
						"<hr>");
				 
				 out.print("<table id='applicants' align='center'>"+
						 	"<tr> <th>S. No</th> <th> Job Designation</th> <th> Job Profile</td> <th>See Applicants</th>");
				 int count = 1;
				while(rs.next())
				{
					out.print("<tr>"+
								"<td>"+count+"."+"</td>"+
								"<td>"+rs.getString(1)+"</td>"+
								"<td>"+rs.getString(2)+"</td>"+
								"<td align='center'><form action='ApplicantForSelectedJob'><input type='hidden' name='jid' value='"+rs.getInt(3)+"'>"+"<input type='submit' style='width:100%;background-color:#4CAF50;color:white;padding-top:2px;padding-bottom:2px;font-size:20px;margin:8px 0;height:50px;display:inline-block' value='Click Here'></form></td>");
					count++;
				}
				 out.print("</table>");
				 
			}
		}catch(Exception e1) {
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
