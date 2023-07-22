import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class AdminHomePage extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        PrintWriter out=response.getWriter();

        HttpSession session=request.getSession(false);
        if(session!=null){
            String sessionKey=(String) session.getAttribute("sessionKey");
            String uname=(String) session.getAttribute("username");
            if(sessionKey.equals("Admin")){
                out.println("<html><head><title>Admin page</title><link rel='stylesheet' href='./css/style.css'></head>");
                out.println("<body style='background-color: #f2f2f2;'>");
                out.println("<ul>");
                out.println("<li><a href='addBook.html'>Add Employee</a></li>");
                out.println("<li><a href='deleteBook.html'>Delete Employee</a></li>");
                out.println("</ul>");
                out.println("<div class='homeheading'>");
                out.println("<h1>Wellcome "+uname+"</h1>");
                out.println("</body>");
                out.println("</html>");
            }
            else{
                response.sendRedirect("login.html");
            }
        }
        else{
            response.sendRedirect("login.html");
        }
    }
}