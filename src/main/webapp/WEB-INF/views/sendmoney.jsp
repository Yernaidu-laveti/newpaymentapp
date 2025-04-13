<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Send Money</title>
  <style>
    body {
      font-family: 'Segoe UI', sans-serif;
      background-color: #f7f9fc;
      display: flex;
      flex-direction: column;
      align-items: center;
      padding: 50px;
    }

    .header-btn {
      margin-bottom: 20px;
    }

    .header-btn button {
      background-color: #007bff;
      color: white;
      border: none;
      border-radius: 8px;
      padding: 10px 20px;
      font-size: 16px;
      cursor: pointer;
    }

    .container {
      background: #ffffff;
      padding: 30px 40px;
      border-radius: 12px;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
      width: 400px;
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
      width: calc(100% - 20px);
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

  <!-- Select Account Button Outside the Form -->
  <div class="header-btn">
    <button type="button">Select Account</button>
  </div>

  <div class="container">
    <h2>Send Money</h2>
    <form action="sendmoney">
      <!-- Amount to Send -->
      <fieldset>
        <label for="amount">Amount to Send</label>
        <input type="number" id="amount" placeholder="Enter amount" name="transactionAmount"required>
      </fieldset>
      
      <!-- From Account Input -->
      <fieldset>
        <label for="fromAccount">From Account</label>
        <input type="text" id="fromAccount" placeholder="Enter account number" name="sourceId" required>
      </fieldset>
      
      <!-- To Account Input -->
      <fieldset>
        <label for="toAccount">To Account</label>
        <input type="text" id="toAccount" placeholder="Enter recipient account" name="targetId" required>
      </fieldset>
      
      <!-- Source Type Dropdown -->
      <fieldset>
        <label for="sourceType">Source Type</label>
        <select id="sourceType" name="sourceType" required>
          <option value="" disabled selected>Select Source Type</option>
          <option value="bank">Bank Account</option>
          <option value="wallet">Wallet</option>
        </select>
      </fieldset>
      
      <!-- Target Type Dropdown -->
      <fieldset>
        <label for="targetType">Target Type</label>
        <select id="targetType" name="targetType" required>
          <option value="" disabled selected>Select Target Type</option>
          <option value="bank">Bank Account</option>
          <option value="wallet">Wallet</option>
        </select>
      </fieldset>
      
      <!-- Send Button -->
      <button type="submit" class="submit-btn">Send</button>
    </form>
  </div>

</body>
</html>
