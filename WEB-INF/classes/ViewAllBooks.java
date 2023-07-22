import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;


public class ViewAllBooks extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
    
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Response</title></head>");
        out.println("<body bgcolor=\"#ffffff\">");


        try{
            HttpSession session=request.getSession(false);
            if(session!=null){
                String sessionKey=(String) session.getAttribute("sessionKey");
                String uname=(String) session.getAttribute("username");
                if(sessionKey.equals("User")){
                    // load driver
                    Class.forName("com.mysql.jdbc.Driver");
            
                    String url = "jdbc:mysql://localhost/employeesrecords";
            
                    Connection con=DriverManager.getConnection(url,"root","root");
            
                    Statement st=con.createStatement();
                    
                    String query="Select * from addbook where id=001";
                
                    ResultSet rs = st.executeQuery( query );
                
                    out.println("<html><head><title>Search Book Page</title><link rel='stylesheet' href='./css/style.css'><link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'></head>");
                    out.println("<body style='background-color: #f2f2f2;'>");
                    out.println("<ul>");
                    out.println("<li><a href='#'>View Profile</a></li>");
                    // out.println("<li><a href='searchBook.html'>Search Book</a></li>");
                    out.println("</ul>");
                    out.println("<table class='table table-striped table-hover'><thead style='background-color: #04AA6D; color:white;'><tr><th>Book Id</th><th>Book Title</th><th>Book Author</th><th>Book Isbn</th></tr></thead>");
        
                    if(rs.next()){
                    	String bkid = rs.getString("id");
                    	String bktitle = rs.getString("title");
                    	String bkauthor = rs.getString("author");
                        
                        out.println("<tbody><tr><td>"+bkid+"</td><td>"+bktitle+"</td><td>"+bkauthor+"</td></tr></tbody>");
	                }
        
                    out.println("</table>");
                    out.println("</body>");
                    out.println("</html>");
            
            
                    out.println("</body></html>");
                    st.close();
                    con.close();
                }
                else{
                    response.sendRedirect("login.html");
                }
            }
        }    
        catch(Exception e){

          out.println(e);
        }
    }

}
