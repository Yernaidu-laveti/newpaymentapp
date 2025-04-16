<%@ page import="java.util.*" %>
<%@ page import="com.example.SpringPaymentApp.entity.BankAccounts" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Send Money</title>
  <style>
    body {
      font-family: 'Segoe UI', sans-serif;
      background-color: #f7f9fc;
      margin: 0;
      padding: 0;
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
      margin: 50px auto;
      background: #ffffff;
      padding: 30px 40px;
      border-radius: 12px;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
      width: 420px;
    }

    h2 {
      text-align: center;
      color: #333;
      margin-bottom: 25px;
    }

    label {
      display: block;
      margin-bottom: 6px;
      font-weight: bold;
      color: #555;
    }

    input[type="text"],
    input[type="number"],
    select {
      width: 100%;
      padding: 10px;
      margin-bottom: 20px;
      border: 1px solid #ccc;
      border-radius: 8px;
      font-size: 16px;
    }

    .submit-btn {
      width: 100%;
      background-color: #28a745;
      color: white;
      padding: 12px;
      font-size: 16px;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      margin-top: 10px;
    }

    .submit-btn:hover {
      background-color: #1e7e34;
    }

    fieldset {
      border: none;
      margin: 0;
      padding: 0;
    }
  </style>
</head>
<body>

  <!-- Topbar with Home link -->
  <div class="topbar">
    <a href="indexpage"> Home</a>
  </div>

  <!-- Send Money Form -->
  <div class="container">
    <h2>Send Money</h2>
    <form action="sendmoney">
      
      <fieldset>
        <label for="amount">Amount to Send</label>
        <input type="number" id="amount" placeholder="Enter amount" name="transactionAmount" required>
      </fieldset>
      
      <fieldset>
        <label for="fromAccount">From Account</label>
        <select id="fromAccount" name="sourceId" required>
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
      </fieldset>
      
      <fieldset>
        <label for="toAccount">To Account</label>
        <input type="text" id="toAccount" placeholder="Enter recipient account" name="targetId" required>
      </fieldset>
      
      <fieldset>
        <label for="sourceType">Source Type</label>
        <select id="sourceType" name="sourceType" required>
          <option value="" disabled selected>Select Source Type</option>
          <option value="bank">Bank Account</option>
          <option value="wallet">Wallet</option>
        </select>
      </fieldset>
      
      <fieldset>
        <label for="targetType">Target Type</label>
        <select id="targetType" name="targetType" required>
          <option value="" disabled selected>Select Target Type</option>
          <option value="bank">Bank Account</option>
          <option value="wallet">Wallet</option>
        </select>
      </fieldset>
      
      <button type="submit" class="submit-btn">Send</button>
    </form>
  </div>

  <!-- Alert Message -->
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
