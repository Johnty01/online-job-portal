

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
 * Servlet implementation class JobAdd
 */
@WebServlet("/JobAdd")
public class JobAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobAdd() {
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
		String j = request.getParameter("jname");
		String jd = request.getParameter("jdesignation");
		String jpt = request.getParameter("jprofiletype");
		String jc = request.getParameter("jctc");
		Double jcc = Double.parseDouble(jc);
		System.out.println("CTC:"+jc);
		String jv = request.getParameter("jvenue");
		String ev = request.getParameter("evenue");
		//String cn = request.getParameter("cname");
		HttpSession session=request.getSession();
		String cn=(String)session.getAttribute("e-mail");
		System.out.println(cn);
		
		try {
			System.out.println("Checkpoint 1");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Checkpoint 2");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinejobportalschema","root","dbms@123");
			//PreparedStatement ps=conn.prepareStatement("select c_name from company_t where c_email=e-mail");
			//ps.setString(1,);
			//ResultSet rs = ps.executeQuery();
			//String eg = rs.toString();
			//System.out.println(eg);
			//out.println(eg);
			System.out.println("Checkpoint 3");
			PreparedStatement xs = conn.prepareStatement("select c_name from company_t where c_email=?;");
			System.out.println("Checkpoint 4");
			xs.setString(1,cn);
			System.out.println("Checkpoint 5");
			ResultSet rs = xs.executeQuery();
			System.out.println("Checkpoint 6");
			String ccname=null;
			while(rs.next())
			{ 
				ccname = (String)rs.getString(1);
			}
			session.setAttribute("cname",ccname);
			
			System.out.println("Checkpoint 7");
			System.out.println("cname:"+ccname);
			String cend=(String)session.getAttribute("cname");
			
			PreparedStatement pd=conn.prepareStatement("insert into jobopen_t(c_email,j_designation,j_ctc,j_profiletype,j_venue,c_name,event_venue) values (?,?,?,?,?,?,?)");
			 pd.setString(1,cn);
			 pd.setString(2,jd);
			 pd.setDouble(3,jcc);
			 pd.setString(4,jpt);
			 pd.setString(5,jv);
			 pd.setString(6,cend);
			 pd.setString(7,ev);
			 
			 int i = pd.executeUpdate();
			 if(i>0){
				 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Job is Successfully Added!</h4></div>");
				 RequestDispatcher rd=request.getRequestDispatcher("companyportal.jsp");
					rd.include(request, response);
				 
			 }	
			 else
			 {
				 out.print("<div id=header style=background-color:#17A589;> <h4 align='center'; style='margin-bottom:1px'>" +
						  "Some Error occured!</h4></div>");
				 RequestDispatcher rd=request.getRequestDispatcher("companyportal.jsp");
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
