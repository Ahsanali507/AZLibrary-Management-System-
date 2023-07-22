import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;


public class DeleteBook extends HttpServlet {

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
            
            String query="delete from addbook where id='"+bookid+"' ";
            int rs = st.executeUpdate( query );
            out.println("Book deleted successfully");
       
            // if(rs.next()){
	        //     //out.println("<h1>Record found</h1>");
            // 	String bkId = rs.getString("id");
            //     if(bookid.equals(bkId)){
            //         String query2="DELETE * from addbook where id='"+bookid+"' ";
            //         int rs2=st.executeUpdate( query2 );
            //         out.println("Book deleted successfully");
            //     }
            //     else{
            //         out.println("Invalid BookId");
            //     }
    
	        // }
            // else{
            // 	//out.println("<h1>No record found</h1>");
            //     out.println("<h3>Invaid BookId</h3>");
            // }
    
    
            out.println("</body></html>");
                st.close();
                con.close();
        }catch(Exception e){

          out.println(e);
        }
    }

}
