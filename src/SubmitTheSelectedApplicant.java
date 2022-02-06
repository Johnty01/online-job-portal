

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
 * Servlet implementation class SubmitTheSelectedApplicant
 */
@WebServlet("/SubmitTheSelectedApplicant")
public class SubmitTheSelectedApplicant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitTheSelectedApplicant() {
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
		
		System.out.println("IN THIS SERVICE SubmitTheSelectedApplicant");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			HttpSession session =request.getSession();
			String em = (String)session.getAttribute("e-mail");
			String jsd = (String)session.getAttribute("jobthru");
			int fmd = Integer.parseInt(jsd);
			if(em!=null && !em.isEmpty())
			{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema","root","dbms@123");
				PreparedStatement ps = con.prepareStatement("update apply_t SET status='Not Selected', check_status=1 where check_status=0 and status='Applied' and j_id=?;");
				ps.setInt(1,fmd);
				int i = ps.executeUpdate();//settled the remaining students
				
				PreparedStatement pd = con.prepareStatement("update jobopen_t SET j_status=0 where j_id=?;");
				pd.setInt(1, fmd);
				int j = pd.executeUpdate();//settled that job which we have seen currently
				System.out.println("\n"+i+" "+j);
				if(i>0 && j>0)
				{
					out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
							"Applicants have been successfully seen and selected!</h4></div>");
					//out.print("Sorry username or password error!");
					RequestDispatcher rd=request.getRequestDispatcher("companyportal.jsp");
					rd.include(request, response);
				}
				else
				{
					out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
							"Some Error occured!</h4></div>");
					//out.print("Sorry username or password error!");
					RequestDispatcher rd=request.getRequestDispatcher("companyportal.jsp");
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
