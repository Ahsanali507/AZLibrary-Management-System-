import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class AddBook extends HttpServlet {
  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	    response.setContentType("text/html");
    
	    // get PrintWriter object
	    PrintWriter out = response.getWriter();

        String bookid=request.getParameter("name");
        String booktitle=request.getParameter("email");
        String bookauthor=request.getParameter("password");
        String bookisbn=request.getParameter("address");

        out.println("<html>");
        out.println("<head><title>Response</title></head>");
        out.println("<body bgcolor=\"#ffffff\">");


        try{
            // load driver
            Class.forName("com.mysql.jdbc.Driver");
        
            String url = "jdbc:mysql://localhost/employeesrecords";
        
            Connection con=DriverManager.getConnection(url, "root", "root");
        
            Statement st=con.createStatement();
        
            String firstQuery="Select * from addbook where id='"+bookid+"' ";
        
            ResultSet rs = st.executeQuery( firstQuery );
        
            if(rs.next()){
                //email found from db
            	String bkId = rs.getString("id");
                out.println("<h3>Book with this id already exists please try again</h3>");
	        }
            else{
                //no email found from db
                if(bookid!=""&&booktitle!=""&&bookauthor!=""&&bookisbn!=""){
                    String secondQuery = "INSERT INTO addbook(id,title,author,isbn)VALUES('"+ bookid + "','"+ booktitle + "','"+ bookauthor + "','" + bookisbn+ "') ";
                    int rws = st.executeUpdate( secondQuery );

                    if(rws==1){
                        out.println("<h3>Book info inserted successfully</h3>");
                    }
	                else{	
                        out.println("<h3>Book info could not inserted successfully</h3>"); 		
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
