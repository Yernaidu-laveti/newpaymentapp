<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.example.SpringPaymentApp.entity.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Statement Request Page</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f6f9;
            padding: 0;
            margin: 0;
        }

        .topbar {
            background-color: #34495e;
            padding: 15px 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
        }

        .topbar h1 {
            color: white;
            font-size: 20px;
            margin: 0;
        }

        .topbar a {
            color: white;
            font-weight: 500;
            text-decoration: none;
            background-color: #2ecc71;
            padding: 10px 18px;
            border-radius: 6px;
            transition: background-color 0.3s ease;
        }

        .topbar a:hover {
            background-color: #27ae60;
        }

        .container {
            max-width: 600px;
            margin: 40px auto;
            background: white;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
        }

        label {
            font-weight: bold;
            display: block;
            margin: 15px 0 5px;
        }

        input[type="date"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 6px;
            border: 1px solid #ccc;
        }

        .checkbox-group {
            display: flex;
            flex-wrap: wrap;
            margin-top: 15px;
        }

        .checkbox-group label {
            width: 50%;
            margin-bottom: 10px;
            font-weight: normal;
        }

        .checkbox-group input {
            margin-right: 8px;
        }

        .generate-btn {
            width: 100%;
            padding: 12px;
            margin-top: 20px;
            background-color: #007bff;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
        }

        .generate-btn:hover {
            background-color: #0056b3;
        }

        .transaction-container {
            margin-top: 40px;
            padding: 20px;
            border-radius: 10px;
            background-color: #eef1f5;
            min-height: 100px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            text-align: left;
            padding: 12px;
            border-bottom: 1px solid #ccc;
        }

        th {
            background-color: #f0f0f0;
            color: #333;
        }

        .no-data {
            text-align: center;
            color: #888;
            padding: 20px;
        }
    </style>
</head>
<body>

<div class="topbar">
   
    <a href="indexpage">Home</a>
</div>

<div class="container">
    <h2>Statement Request Page</h2>

    <form action="generateStatement" method="post">
        <label for="startDate">Start Date</label>
        <input type="date" id="startDate" name="startDate" required>

        <label for="endDate">End Date</label>
        <input type="date" id="endDate" name="endDate" required>

        <div class="checkbox-group">
            <label><input type="checkbox" name="filters" value="all"> All</label>
            <label><input type="checkbox" name="filters" value="credit"> Credit Transactions</label>
            <label><input type="checkbox" name="filters" value="debit"> Debit Transactions</label>
            <label><input type="checkbox" name="filters" value="wallet"> Wallet</label>
            <label><input type="checkbox" name="filters" value="bank"> Bank</label>
        </div>

        <button type="submit" class="generate-btn">Generate</button>
    </form>

    <div class="transaction-container">
        <table>
            <tr>
                <th>Transaction Id</th>
                <th>Transaction Date</th>
                <th>Source Id</th>
                <th>Target Id</th>
                <th>Source Type</th>
                <th>Target Type</th>
                <th>Transaction Amount</th>
            </tr>
            <%
                List<Transactions> transactions = (List<Transactions>) request.getAttribute("tentransaction");
                if (transactions != null && !transactions.isEmpty()) {
                    for (Transactions trans : transactions) {
            %>
                        <tr>
                            <td><%= trans.getTransactionId() %></td>
                            <td><%= trans.getTransactionDate() %></td>
                            <td><%= trans.getSourceId() %></td>
                            <td><%= trans.getTargetId() %></td>
                            <td><%= trans.getSourceType() %></td>
                            <td><%= trans.getTargetType() %></td>
                            <td><%= trans.getTransactionAmount() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="7" class="no-data">No transactions yet. After clicking "Generate", results will appear here.</td>
                    </tr>
            <%
                }
            %>
        </table>
    </div>

</div>
</body>
</html>
