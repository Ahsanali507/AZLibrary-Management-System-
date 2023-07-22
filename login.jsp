<jsp:include page="/includes/header.html"/>
<body>
<ul>
  <li><a href="index.jsp">Home</a></li>
  <li><a href="signUp.jsp">Sign up</a></li>
  <li><a href="login.jsp">Login</a></li>
</ul>
<div class="container">
<h2>User Or Admin Login Here</h2>

<div class="outer">
  <form action="login" method="post">
 
    <div class="inner" style="width: 100%;">
      <label>User Id</label>
      <input type="text" id="email" class="form-control" name="email" placeholder="Enter email" required >
      <small id="emailvalid" class="form-text text-muted invalid-feedback">
        Your id must be a valid id
      </small>
    </div>
  
    <div class="inner" style="width: 100%;">
      <label>Password</label>
      <input type="password" id="password" class="form-control" name="password" placeholder="Enter password" required>
      <small id="passwordvalid" class="form-text text-muted invalid-feedback">
        Password must be 8-15 characters include at least one lowercase letter, one uppercase letter, one <br> numeric digit, and one special character
      </small>
    </div>
    
    <div style="width: 100%;">
      <input type="submit" name="login" value="Login" id="submit-btn">
    </div>
  </form>
  <a href="signUp.jsp" class="account">Don't have account <b class="bold">signup here</b></a>
</div>
</div>

<jsp:include page="/includes/loginFooter.html" />
