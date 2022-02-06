

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
 * Servlet implementation class ApplyAction
 */
@WebServlet("/ApplyAction")
public class ApplyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyAction() {
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
		
		HttpSession session=request.getSession();
		String e=(String)session.getAttribute("e-mail");
		String id = request.getParameter("jid");
		int idc = Integer.parseInt(id);
		//String id = (String)session.getAttribute("jid");
		//String p=(String)session.getAttribute("psswd");
		System.out.println("email:"+e);
		System.out.println("jid:"+id);
		//System.out.println("psswd:"+p);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema","root","dbms@123");
	
			PreparedStatement pm=con.prepareStatement("select s_id from student_t where s_email=?");
			pm.setString(1,e);
			ResultSet rm=pm.executeQuery();//we have student id here now, we need jid only anymore
			rm.next();//always if you want to go to first data entry place
			int sh = rm.getInt(1);
			
			System.out.println("s_id:"+rm.getString(1));
			
			
			//PreparedStatement pd=con.prepareStatement("select j_id from jobopen_t where j_id=?");
			//pd.setString(1,rm.getString(1));
			
			PreparedStatement fn = con.prepareStatement("insert into apply_t(j_id,s_id,s_email) values(?,?,?)");
			fn.setInt(1, idc);
			fn.setInt(2,sh);
			fn.setString(3,e);
			
			int i = fn.executeUpdate();
			
			if(i>0)
			{
				out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Applied for the Job Successfully</h4></div>");
				RequestDispatcher rd=request.getRequestDispatcher("student.jsp");
				rd.include(request, response);
			}
			else
			{
				out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Some error occured</h4></div>");
				RequestDispatcher rd=request.getRequestDispatcher("ShowJob");
				rd.include(request, response);
				
			}
		
	}catch (Exception e2) {e2.printStackTrace();}
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
