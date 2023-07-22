import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;


public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
    
        PrintWriter out = response.getWriter();

        String email=request.getParameter("email");
        String password=request.getParameter("password");
        
        out.println("<html>");
        out.println("<head><title>Response</title></head>");
        out.println("<body bgcolor=\"#ffffff\">");


        try{
            // load driver
            Class.forName("com.mysql.jdbc.Driver");
    
            String url = "jdbc:mysql://localhost/employeesrecords";
    
            Connection con=DriverManager.getConnection(url,"root","root");
    
            Statement st=con.createStatement();
            
            String query="Select * from employees where empEmail='"+email+"' ";
       
            ResultSet rs = st.executeQuery( query );
       
            if(rs.next()){
	            //out.println("<h1>Record found</h1>");
            	String u_email = rs.getString("empEmail");
            	String u_password = rs.getString("empPassword");
            	String u_type = rs.getString("empType");
            	String u_name = rs.getString("empName");
                if(email.equals(u_email)&&password.equals(u_password)){
                    HttpSession session;
                    if(u_type.equals("Admin")){
                        session = request.getSession(true);
                        
                        response.sendRedirect("AdminHomePage");
                    }
                    else{
                        session=request.getSession(true);
                        // session.setAttribute("sessionKey",u_type);
                        // session.setAttribute("username",u_name);
                        response.sendRedirect("UserHomePage");
                    }
                    session.setAttribute("sessionKey",u_type);
                    session.setAttribute("username",u_name);
                }
                else{
                out.println("<h3>Invalid email or password</h3>");
                }
    
	         }
            else{
            	//out.println("<h1>No record found</h1>");
                out.println("<h3>Invalid email or password</h3>");
            }
    
    
            out.println("</body></html>");
                st.close();
                con.close();
        }catch(Exception e){

          out.println(e);
        }
    }

}
