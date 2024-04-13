<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registration_login.css">
    <link rel="stylesheet" href="alert/dist/sweetalert.css">
    <title>sign-up</title>
</head>

<body>
	<input type= "hidden" id="status" value ="<%= request.getAttribute("status") %>">
    <div class="cont">
        <form class="form sign-in" method="post" action = "login">
            <h2>Welcome back,</h2>
            <label>
                <span>Email</span>
                <input type="email" name = "email_login"/>
            </label>
            <label>
                <span>Password</span>
                <input type="password" name = "password_login"/>
            </label>
            <p class="forgot-pass">Forgot password?</p>
            <input type="submit" class="style-btn submit" value="Sign in"></input>
            <!-- <button type="button" class="fb-btn">Connect with <span>facebook</span></button> -->
        </form>
        <div class="sub-cont">
            <div class="img">
                <div class="img__text m--up">
                    <h2>New here?</h2>
                    <p>Sign up and discover great amount of new opportunities!</p>
                </div>
                <div class="img__text m--in">
                    <h2>One of us?</h2>
                    <p>If you already has an account, just sign in. We've missed you!</p>
                </div>
                <div class="img__btn">
                    <span class="m--up">Sign Up</span>
                    <span class="m--in">Sign In</span>
                </div>
            </div>
            <form class="form sign-up" method="post" action = "register">
                <h2>Time to feel like home,</h2>
                <label>
                    <span>Họ và tên</span>
                    <input type="text" name="fullname_signup"/>
                </label>
                <label>
                    <span>Email</span>
                    <input type="email" name = "email_signup"/>
                </label>
                
                <label>
                    <span>Địa chỉ</span>
                    <input type="text" name = "address_signup"/>
                </label>
                 <label>
                    <span>Số điện thoại</span>
                    <input type="text" name = "contact_signup"/>
                </label>
                <label>
                    <span>Password</span>
                    <input type="password" name = "password_signup"/>
                </label>
                <input type="submit" class="style-btn submit" value = "signup"></input>
                <!-- <button type="button" class="fb-btn">Join with <span>facebook</span></button> -->
            </form>
        </div>
    </div>

    <script src="./js/registration_login.js"></script> 
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	
    <script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "failed") {
			swal("Sorry","Wrong Username or Password", "error");
		}
		if (status == "success") {
			swal("Congrats","Account Create Successfull", "success")
		}
	</script>
</body>

</html>