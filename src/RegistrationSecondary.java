

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationSecondary
 */
@WebServlet("/RegistrationSecondary")
public class RegistrationSecondary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationSecondary() {
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
		String name = request.getParameter("fname");
		String email = request.getParameter("email");
		String ten = request.getParameter("s_mark");
		String twelve = request.getParameter("ss_mark");
		String graduation = request.getParameter("g_mark");
		String branch = request.getParameter("strm");
		String field = request.getParameter("field");
		String course = request.getParameter("crs"); //btech, bsc, bca
		String pass = request.getParameter("psswrd");
		
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema", "root", "dbms@123");
			 PreparedStatement pd=conn.prepareStatement("insert into student_t(s_name,s_email,s_pass,s_smarks,s_ssmarks,s_gmarks,s_course,s_stream,s_field) values (?,?,?,?,?,?,?,?,?)");
			 pd.setString(1,name);
			 pd.setString(2,email);
			 pd.setString(3,pass);
			 pd.setString(4,ten);
			 pd.setString(5,twelve);
			 pd.setString(6,graduation);
			 pd.setString(7,course);
			 pd.setString(8,branch);
			 pd.setString(9,field);
			 
			 
			 int i = pd.executeUpdate();
			 if(i>0){
				 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
							"You are Registered as a Student Now</h4></div>");
				 RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
				 
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
