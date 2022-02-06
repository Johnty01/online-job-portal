

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
 * Servlet implementation class CompanyAdd
 */
@WebServlet("/CompanyAdd")
public class CompanyAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyAdd() {
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
		String cn = request.getParameter("compname");
		String e = request.getParameter("email");
		String p = request.getParameter("psw");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema", "root", "dbms@123");
			
			PreparedStatement pd=conn.prepareStatement("insert into company_t(c_name,c_email,c_pass) values (?,?,?)");
			 pd.setString(1,cn);
			 pd.setString(2,e);
			 pd.setString(3,p);			
			 
			 int i = pd.executeUpdate();
			 if(i>0){
				 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Company Added Successfully</h4></div>");
				 RequestDispatcher rd=request.getRequestDispatcher("companyadd.jsp");
					rd.include(request, response);
				 
			 }	
			 else
			 {
					 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
							  "Sorry this Company already exists!</h4></div>");

					 		RequestDispatcher rd=request.getRequestDispatcher("companyadd.jsp");
			rd.include(request, response);
			 }
		}catch(Exception e1)
	 	{
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
