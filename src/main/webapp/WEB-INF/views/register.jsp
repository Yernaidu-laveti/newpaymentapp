<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Register</title></head>
<body>
    <h2>Register</h2>
    <form action="register" method="post">
        <label>Username:</label>
        <input type="text" name="userName" required><br>
        <label>Password:</label>
        <input type="password" name="password" required><br>
        <label>Confirm Password:</label>
        <input type="password" name="confirmPassword" required><br>
        <label>First Name:</label>
        <input type="text" name="firstName" required><br>
        <label>Last Name:</label>
        <input type="text" name="lastName" required><br>
        <label>Email:</label>
        <input type="email" name="email" required><br>
        <label>Phone:</label>
        <input type="text" name="phoneNum" required><br>
        <label>Date of Birth:</label>
        <input type="date" name="dob" required><br>
        <label>Address:</label>
        <textarea name="address" required></textarea><br>
        <input type="submit" value="Register">
    </form>
    <p>Already registered? <a href="login">Login here</a></p>
</body>
</html>