import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class SignupUser extends HttpServlet {
  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	    response.setContentType("text/html");
    
	    // get PrintWriter object
	    PrintWriter out = response.getWriter();

        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String password=request.getParameter("password");

        out.println("<html>");
        out.println("<head><title>Response</title></head>");
        out.println("<body bgcolor=\"#ffffff\">");


        try{
            // load driver
            Class.forName("com.mysql.jdbc.Driver");
        
            String url = "jdbc:mysql://localhost/employeesrecords";
        
            Connection con=DriverManager.getConnection(url, "root", "root");
        
            Statement st=con.createStatement();
        
            String firstQuery="Select * from employees where empEmail='"+email+"' ";
        
            ResultSet rs = st.executeQuery( firstQuery );
        
            if(rs.next()){
                //email found from db
            	String u_email = rs.getString("empEmail");
                out.println("<h3>User with email already exists please try another account</h3>");
	        }
            else{
                //no email found from db
                if(name!=""&&email!=""&&password!=""){
                    String secondQuery = "INSERT INTO employees(empName,empEmail,empPassword)VALUES('"+ name + "','"+ email + "','"+ password + "') ";
                    int rws = st.executeUpdate( secondQuery );

                    if(rws==1){
                        out.println("<h3>Account created successfully</h3>");
                    }
	                else{	
                        out.println("<h3>Account could not successfully</h3>"); 		
                    }
                }
                else{
                    out.println("<h3>Please enter all values</h3>");
                }
            }
        
            out.println("</body></html>");
        
                st.close();
                con.close();
        
        }catch(Exception e){

            out.println(e);
        }

    }

}
