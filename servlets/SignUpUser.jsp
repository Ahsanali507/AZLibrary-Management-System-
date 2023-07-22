<html>
<head>
<title>User SignUp</title></head>
<%@ page language = "java" import = "javax.servlet.*,javax.servlet.http.*,java.io.*,java.sql.*,javax.swing.*" %>
<body>

<%
    try{
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String address=request.getParameter("address");


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
                out.println("User with this account already exists try with another account..")
	        }
            else{
                //no email found from db
                if(name!=""&&email!=""&&password!=""&&address!=""){
                    String secondQuery = "INSERT INTO employees(empName,empEmail,empPassword,empAddress)VALUES('"+ name + "','"+ email + "','"+ password + "','" + address+ "') ";
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
            st.close();
            con.close();
        
    }catch(Exception e){

        out.println(e);
    }
%>
