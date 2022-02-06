

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
 * Servlet implementation class ApplicantForSelectedJob
 */
@WebServlet("/ApplicantForSelectedJob")
public class ApplicantForSelectedJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantForSelectedJob() {
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
			
			HttpSession session =request.getSession();
			String em = (String)session.getAttribute("e-mail");
			String jsd = request.getParameter("jid");
			if(jsd==null)
			{
				jsd = (String)session.getAttribute("jobthru");
			}
			session.setAttribute("jobthru",jsd);
			int fmd = Integer.parseInt(jsd);
			System.out.println(em);
			if(em!=null && !em.isEmpty())
			{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema","root","dbms@123");
					System.out.println("checkpoint before query");
					PreparedStatement ps = con.prepareStatement("select s_name,student_t.s_email,s_course,s_stream,s_field,s_gmarks,s_smarks,s_ssmarks from apply_t,student_t where apply_t.s_id = student_t.s_id and apply_t.s_email=student_t.s_email and status='Applied' and check_status=0 and j_id=?;");//if space btwn c_email and ? then wrong and in sql and is the right one not &
					ps.setInt(1,fmd);
					ResultSet rs = ps.executeQuery();
					//rs.next();
					out.print(
							"<html>" +
									"<head>" +
							"<title>Applicants by the Company Job</title>");
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
									//"border: none;"+
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
								"<p style='font-size=14' align='center'>Applicants</p>"+
								"</div>"+
							"<hr>");
				 
					out.print("<table id='applicants' align='center'>"+
						 		"<tr> 	<th>S. No</th> 		<th>Name</th> 		<th>Email</th>		 <th>Graduation Course</th>			<th>Stream</th>			<th>Work Field</th>			<th>Graduation avg Marks</th>			<th>10th Marks</th>			<th>12th Marks</th> <th>Decision</th> </tr>");
					int count = 1;
					while(rs.next())
					{
						out.print("<tr>"+
									"<td>"+count+"."+"</td>"+
									"<td>"+rs.getString(1)+"</td>"+
									"<td>"+rs.getString(2)+"</td>"+
									"<td>"+rs.getString(3)+"</td>"+
									"<td>"+rs.getString(4)+"</td>"+
									"<td>"+rs.getString(5)+"</td>"+
									"<td>"+rs.getDouble(6)+"</td>"+
									"<td>"+rs.getDouble(7)+"</td>"+
									"<td>"+rs.getDouble(8)+"</td>"+
									"<td align='center'><form action='ApplicantSelectionOverPressingSelection'><input type='hidden' name='smail' value='"+rs.getString(2)+"'>"+"<input type='submit' style='width:100%;background-color:#4CAF50;color:white;padding-top:2px;padding-bottom:2px;font-size:20px;margin:8px 0;height:50px;display:inline-block' value='Select Student'></form></td>");
								//action dena h isme
						count++;
					}
					out.print("</table>");
				
					out.print("<div align='center'><form action='SubmitTheSelectedApplicant' align='center''><input type='submit' style='width:200px;background-color:#4CAF50;color:white;padding-top:2px;padding-bottom:2px;font-size:20px;margin:8px 0;height:50px;display:inline-block' value='Submit'></form></div>");
				 
				}
			
				else
				{
					out.print("<div id=header style=background-color:cadetblue;color:white;> <h4 style=margin-left:550;>" +
							" Please Log-in first !</h4></div>");
						 	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
						 	rd.include(request, response);
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
