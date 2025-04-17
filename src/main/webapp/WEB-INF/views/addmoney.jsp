<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.example.SpringPaymentApp.entity.BankAccounts" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Money to Wallet</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f1f4f9;
            min-height: 100vh;
        }

        .topbar {
            background-color: #2c3e50;
            padding: 15px 30px;
            display: flex;
            justify-content: flex-end;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
        }

        .topbar a {
            color: white;
            font-weight: bold;
            text-decoration: none;
            background-color: #3498db;
            padding: 10px 18px;
            border-radius: 6px;
            transition: background-color 0.3s ease;
        }

        .topbar a:hover {
            background-color: #1e70bf;
        }

        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding-top: 40px;
        }

        h1 {
            font-size: 24px;
            color: #2c3e50;
            margin-bottom: 30px;
        }

        .wallet-form {
            background-color: #ffffff;
            padding: 28px 32px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 400px;
        }

        .form-group {
            margin-bottom: 18px;
        }

        label {
            font-weight: 600;
            display: block;
            margin-bottom: 6px;
            color: #333;
        }

        select,
        input[type="number"] {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
        }

        button {
            width: 100%;
            padding: 11px;
            background-color: #28a745;
            color: white;
            font-size: 15px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }

        button:hover {
            background-color: #218838;
        }

        .note {
            font-size: 13px;
            color: #666;
            margin-top: 12px;
            text-align: center;
        }
    </style>
</head>
<body>

    <!-- Topbar with Home link at top right -->
    <div class="topbar">
        <a href="indexpage">Home</a>
    </div>

    <div class="container">
        <h1>Add Money to Wallet</h1>

        <form class="wallet-form" action="addMoneyServlet" method="post">
            <div class="form-group">
                <label for="accountNumber">Account Number</label>
                <select id="accountNumber" name="accountNumber" required>
                    <%
                        ArrayList<BankAccounts> accounts = (ArrayList<BankAccounts>) request.getAttribute("bankaccounts");
                        if (accounts != null) {
                            for (BankAccounts account : accounts) {
                    %>
                        <option value="<%= account.getAccountNumber() %>"><%= account.getAccountNumber() %></option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>

            <div class="form-group">
                <label for="amount">Amount to Add</label>
                <input type="number" id="amount" name="amount" required placeholder="₹ Enter amount">
            </div>

            <button type="submit">Add Money</button>

            <div class="note">Secure transaction. Funds will reflect instantly.</div>
        </form>
    </div>

    <script>
        <% 
            String msg = (String) request.getAttribute("msg");
            if (msg != null) { 
        %>
            alert("<%= msg.replace("\"", "\\\"") %>");
        <% 
            } 
        %>
    </script>

</body>
</html>
