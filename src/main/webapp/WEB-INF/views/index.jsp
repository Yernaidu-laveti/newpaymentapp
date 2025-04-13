
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <style>
        /* Fixed Navbar Styling */
		.form-container {
		   display: none;
		   margin-top: 20px;
		   border: 1px solid #ccc;
		   padding: 20px;
		   width: 300px;
		   border-radius: 10px;
		   background-color: #f9f9f9;
		 }
		 .form-group {
		   margin-bottom: 12px;
		 }
		 .form-group label {
		   display: block;
		   font-weight: bold;
		   margin-bottom: 5px;
		 }
		 .form-group input, .form-group select {
		   width: 100%;
		   padding: 6px;
		   border: 1px solid #ccc;
		   border-radius: 5px;
		 }
		 button {
		   padding: 8px 16px;
		   background-color: #007bff;
		   color: white;
		   border: none;
		   border-radius: 5px;
		   cursor: pointer;
		 }
		 button:hover {
		   background-color: #0056b3;
		 }
        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            background-color: #333;
            overflow: hidden;
        }
        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .content {
            margin-top: 50px; /* Space below navbar */
            padding: 20px;
        }
    </style>
</head>
<body>

<!-- Fixed Navbar -->
<div class="navbar">
    <a href="profile">Profile</a>
	<a href="sendmoneypage">send Money</a>
    <a href="transactionpage">Transactions History</a>
    <a href="bankStatement">Bank Statement</a>
    <a href="logout">Logout</a>
</div>

<!-- Page Content -->
<div class="content">
    <h2>Welcome User</h2>
    <p>This is your home page.</p>
</div>

<div id="accparent">
	
	
</div>

<button onclick="showForm()">Add Account</button>

  <div id="accountForm" class="form-container">
    <form action="addBankAccount">
      <div class="form-group">
        <label for="accountNumber">Account Number</label>
        <input type="text" id="accountNumber" name="accountNumber" required>
      </div>

      <div class="form-group">
        <label for="ifsc">IFSC Code</label>
        <input type="text" id="ifsc" name="ifsc" required>
      </div>

      <div class="form-group">
        <label for="bankName">Bank Name</label>
        <input type="text" id="bankName" name="bankName" required>
      </div>

      <div class="form-group"
        <label for="branch">Branch Location</label>
        <input type="text" id="branch" name="branch" required>
      </div>

      <div class="form-group">
        <label for="isActive">Is Active</label>
        <select id="isActive" name="isActive" required>
          <option value="">Select</option>
          <option value="true">Yes</option>
          <option value="false">No</option>
        </select>
      </div>

      <button type="submit">Submit</button>
    </form>
  </div>
<script>
	
	    function showForm() {
	      document.getElementById('accountForm').style.display = 'block';
	    }
</script>
 
</body>
</html>
