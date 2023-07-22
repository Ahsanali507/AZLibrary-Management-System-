import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;


public class SearchBook extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
    
        PrintWriter out = response.getWriter();

        String bookid=request.getParameter("name");
        
        out.println("<html>");
        out.println("<head><title>Response</title></head>");
        out.println("<body bgcolor=\"#ffffff\">");


        try{
            // load driver
            Class.forName("com.mysql.jdbc.Driver");
    
            String url = "jdbc:mysql://localhost/employeesrecords";
    
            Connection con=DriverManager.getConnection(url,"root","root");
    
            Statement st=con.createStatement();
            
            String query="Select * from addbook where id='"+bookid+"' ";
       
            ResultSet rs = st.executeQuery( query );
       
            if(rs.next()){
	            //out.println("<h1>Record found</h1>");
            	String bkid = rs.getString("id");
            	String bktitle = rs.getString("title");
            	String bkauthor = rs.getString("author");
            	String bkisbn = rs.getString("isbn");
                out.println("<html><head><title>Search Book Page</title><link rel='stylesheet' href='./css/style.css'><link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'></head>");
                out.println("<body style='background-color: #f2f2f2;'>");
                out.println("<ul>");
                out.println("<li><a href='#'>View All Books</a></li>");
                out.println("<li><a href='searchBook.html'>Search Book</a></li>");
                out.println("</ul>");
                out.println("<table class='table table-striped table-hover'><thead style='background-color: #04AA6D; color:white;'><tr><th>Book Id</th><th>Book Title</th><th>Book Author</th><th>Book Isbn</th></tr></thead>");
                out.println("<tbody><tr><td>"+bkid+"</td><td>"+bktitle+"</td><td>"+bkauthor+"</td><td>"+bkisbn+"</td></tr></tbody>");
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
    
	         }
            else{
            	//out.println("<h1>No record found</h1>");
                response.sendRedirect("searchBook.html");
            }
    
    
            out.println("</body></html>");
                st.close();
                con.close();
        }catch(Exception e){

          out.println(e);
        }
    }

}
