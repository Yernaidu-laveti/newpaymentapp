<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.example.SpringPaymentApp.entity.BankAccounts" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f6f8;
        }

        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            background-color: #2c3e50;
            box-shadow: 0 2px 4px rgba(0,0,0,0.2);
            z-index: 1000;
        }

        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 16px 20px;
            text-decoration: none;
            font-weight: bold;
            transition: 0.3s ease;
        }

        .navbar a:hover {
            background-color: #ecf0f1;
            color: #2c3e50;
        }

        .content {
            margin-top: 70px;
            padding: 30px;
        }

        h2 {
            color: #34495e;
        }

        .form-container {
            display: none;
            margin-top: 20px;
            border: 1px solid #ccc;
            padding: 25px;
            width: 400px;
            border-radius: 10px;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            position: absolute;
            left: 500px;
            top: 130px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 6px;
            color: #2c3e50;
        }

        .form-group input, .form-group select {
            width: 100%;
            padding: 8px 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            transition: border-color 0.3s;
        }

        .form-group input:focus, .form-group select:focus {
            border-color: #007bff;
            outline: none;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }

        .btn-container {
            margin-top: 20px;
        }

        .account {
            background-color: #ffffff;
            color: #2c3e50;
            display: inline-block;
            padding: 20px;
            margin: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            width: 300px;
            font-size: 15px;
            border: 1px solid #ccc;
        }

        .account table {
            width: 100%;
        }

        .account th {
            text-align: left;
            color: #34495e;
            padding-bottom: 6px;
        }

        .account td {
            padding: 4px 0;
        }
    </style>
</head>
<body>

<!-- Fixed Navbar -->
<div class="navbar">
    <a href="profile">Profile</a>
    <a href="sendmoneypage">Send Money</a>
    <a href="transactionpage">Transaction History</a>
    <a href="bankStatement">Bank Statement</a>
    <a href="addmoney">Add Money</a>
    <a href="logout">Logout</a>
</div>

<!-- Page Content -->
<div class="content">
    <h2>Welcome User</h2>

    <div class="btn-container">
        <button onclick="showForm()">➕ Add Account</button>
    </div>

    <%
        ArrayList<BankAccounts> accounts = (ArrayList<BankAccounts>) request.getAttribute("bankaccounts");
        if (accounts != null) {
            for (BankAccounts acc : accounts) {
    %>
        <div class="account">
            <table>
                <tr><th>Bank Name</th><td><%= acc.getBankName() %></td></tr>
                <tr><th>Account Number</th><td><%= acc.getAccountNumber() %></td></tr>
                <tr><th>Name</th><td><%= session.getAttribute("userName") %></td></tr>
            </table>
        </div>
    <%
            }
        } else {
    %>
        <p>No bank accounts found.</p>
    <%
        }
    %>

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

            <div class="form-group">
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
</div>

<!-- Show Alert Box from Backend Message -->
<script>
    <% 
        String msg = (String) request.getAttribute("msg");
        if (msg != null) { 
    %>
        alert("<%= msg.replace("\"", "\\\"") %>");
    <% 
        } 
    %>

    function showForm() {
        const form = document.getElementById('accountForm');
        form.style.display = form.style.display === 'block' ? 'none' : 'block';
    }
</script>

</body>
</html>
