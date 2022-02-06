
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
 * Servlet implementation class StudentRemove
 */
@WebServlet("/StudentRemove")
public class StudentRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRemove() {
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
		String e = request.getParameter("email");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema", "root", "dbms@123");
			PreparedStatement ps=conn.prepareStatement("delete from student_t where s_email=?");
			//ResultSet rs = ps.executeQuery();
			ps.setString(1,e);
			 int i = ps.executeUpdate();
			 if(i>0){
				 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Student is removed </h4></div>");
				 RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
					rd.forward(request, response);
			 }
			 else{
				 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Sorry this Student does not exist</h4></div>");

				 		RequestDispatcher rd=request.getRequestDispatcher("studentremove.jsp");
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
