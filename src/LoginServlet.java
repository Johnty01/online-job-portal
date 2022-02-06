

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
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	
	{
		// TODO Auto-generated method stub
		
		System.out.println("IN THIS SERVICE===");// console m print krega
		response.setContentType("text/html");//content type for dynamic webpage content
		 PrintWriter out = response.getWriter();//
		 String n = request.getParameter("email");
		 String p = request.getParameter("psw");
		 System.out.println("user:"+n);
		 System.out.println("pass:"+p);
		 
		 HttpSession session=request.getSession();
			session.setAttribute("e-mail",n);//this email is the attrib of session instance
			session.setAttribute("pssw",p);
		
		 
		 try
		 
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema", "root", "dbms@123");
			 PreparedStatement ps=conn.prepareStatement("select * from student_t where s_email=? and s_pass=?");
			 ps.setString(1,n); //1 is for first question mark and ? represents value is variable and will be achieved
			 ps.setString(2,p);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 PreparedStatement pc=conn.prepareStatement("select * from company_t where c_email=? and c_pass=?");
			 pc.setString(1,n);
			 pc.setString(2,p);
			 
			 ResultSet rc = pc.executeQuery();
			 
			 PreparedStatement pa=conn.prepareStatement("select * from admin_t where a_email=? and a_pass=?");
			 pa.setString(1,n);
			 pa.setString(2,p);
			 
			 ResultSet ra = pa.executeQuery();
			 if(rs.next()){ //student wali cond true hoti h to 1 vlue so cond true
				 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Student is successfully logged in!</h4></div>");
				 //if(rs.getInt(4)==1){ //table->attribute(number)
					 RequestDispatcher rd=request.getRequestDispatcher("student.jsp");//on which page u want to send the user
						rd.include(request, response);
				 }
				/* else{
					 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
					  "Sorry you are not verified!</h4></div>");
			//out.print("Sorry username or password error!");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);//include the error msg on the same page
					 
				 }*/
			 
			 else if(rc.next()){
				 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Company is successfully logged in!</h4></div>");
				 RequestDispatcher rd=request.getRequestDispatcher("companyportal.jsp");
					rd.include(request, response);
				 
			 }
			 
			 else if(ra.next()){
				 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Admin is successfully logged in!</h4></div>");
				 RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
					rd.include(request, response);
					
					
				}
				else{
					out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
							  "Sorry username or password error!</h4></div>");
					//out.print("Sorry username or password error!");
					RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
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
