<jsp:include page="/includes/header.html" />
<body>
<ul>
  <li><a href="index.jsp">Home</a></li>
  <li><a href="signUp.jsp">Sign up</a></li>
  <li><a href="login.jsp">Login</a></li>
</ul>
<div class="container">
<h2>User SignUp Here</h2>

<div class="outer">
  <form action="signup" method="post">

    <div class="inner" style="width: 100%;">
    <label>User Id</label>
    <input type="text" id="name" class="form-control" name="name" placeholder="Enter name" required>
    <small id="namevalid" class="form-text text-muted invalid-feedback">
      Your name must be 2-18 characters long and only includes alphabets
    </small>
    </div>
 
    <div class="inner" style="width: 100%;">
    <label>Email</label>
    <input type="text" id="email" class="form-control" name="email" placeholder="Enter email" required >
    <small id="emailvalid" class="form-text text-muted invalid-feedback">
      Your email must be a valid email
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
    <input type="submit" name="signup" value="Sign Up" id="submit-btn">
    </div>
  </form>
  <a href="login.jsp" class="account">Already have account <b class="bold">login here</b></a>
</div>
</div>

<jsp:include page="/includes/signupFooter.html" />


