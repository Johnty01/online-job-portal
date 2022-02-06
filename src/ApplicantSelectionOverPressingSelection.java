

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
 * Servlet implementation class ApplicantSelectionOverPressingSelection
 */
@WebServlet("/ApplicantSelectionOverPressingSelection")
public class ApplicantSelectionOverPressingSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantSelectionOverPressingSelection() {
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
		System.out.println("IN THIS SERVICE ApplicantSelectionOverPressingSelection");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			HttpSession session =request.getSession();
			String em = (String)session.getAttribute("e-mail");
			String jsd = (String)session.getAttribute("jobthru");
			int jfd = Integer.parseInt(jsd);
			String sid = request.getParameter("smail");
			if(em!=null && !em.isEmpty())
			{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema","root","dbms@123");
				PreparedStatement ps = con.prepareStatement("update apply_t set status='Selected',check_status=1 where s_email=? and j_id=?;");
				ps.setString(1, sid);
				ps.setInt(2,jfd);
				int j=ps.executeUpdate();
				if(j==1)
				{
					out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
							"Student is successfully selected!</h4></div>");
					RequestDispatcher rd=request.getRequestDispatcher("ApplicantForSelectedJob");
					rd.include(request, response);
				}
				
			}
			else
			{
				out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Please Login First!</h4></div>");
				//out.print("Sorry username or password error!");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
				
			}	
			
		}catch(Exception e1) {
			e1.printStackTrace();}
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
