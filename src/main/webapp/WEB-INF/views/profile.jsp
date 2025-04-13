
	
	<!DOCTYPE html>
	<html lang="en">
	<head>
	  <meta charset="UTF-8">
	  <title>User Profile</title>
	  <style>
	    body {
	      font-family: 'Segoe UI', sans-serif;
	      background-color: #f0f2f5;
	      display: flex;
	      justify-content: center;
	      padding: 40px;
	    }

	    .profile-card {
	      background: #fff;
	      padding: 25px 35px;
	      border-radius: 15px;
	      box-shadow: 0 5px 20px rgba(0,0,0,0.1);
	      width: 400px;
	      position: relative;
	    }

	    .profile-card h2 {
	      margin-bottom: 20px;
	      color: #333;
	      text-align: center;
	    }

	    .profile-info p {
	      margin: 10px 0;
	      font-size: 16px;
	      color: #555;
	    }

	    .profile-info span {
	      font-weight: bold;
	      color: #222;
	    }

	    .profile-actions {
	      display: flex;
	      justify-content: space-between;
	    }

	    .profile-actions button {
	      padding: 10px 20px;
	      border: none;
	      border-radius: 8px;
	      font-weight: bold;
	      cursor: pointer;
	      transition: 0.3s;
	    }

	    .update-btn {
	      background-color: #007bff;
	      color: white;
	    }

	    .update-btn:hover {
	      background-color: #0056b3;
	    }

	    .delete-btn {
	      background-color: #dc3545;
	      color: white;
	    }

	    .delete-btn:hover {
	      background-color: #a71d2a;
	    }

	    .update-form {
	      display: none;
	      margin-top: 20px;
	    }

	    .update-form input, .update-form textarea {
	      width: 100%;
	      padding: 10px;
	      margin: 8px 0;
	      border: 1px solid #ccc;
	      border-radius: 6px;
	    }

	    .update-form button {
	      margin-top: 10px;
	      width: 100%;
	      background-color: #28a745;
	      color: white;
	      padding: 10px;
	      border: none;
	      border-radius: 8px;
	      font-weight: bold;
	      cursor: pointer;
	    }

	    .update-form button:hover {
	      background-color: #1e7e34;
	    }

	    /* Delete confirmation popup */
	    .modal {
	      display: none;
	      position: fixed;
	      z-index: 10;
	      left: 0;
	      top: 0;
	      width: 100%;
	      height: 100%;
	      overflow: auto;
	      background-color: rgba(0,0,0,0.5);
	    }

	    .modal-content {
	      background-color: #fff;
	      margin: 15% auto;
	      padding: 20px;
	      border-radius: 10px;
	      width: 300px;
	      text-align: center;
	    }

	    .modal-content button {
	      padding: 8px 16px;
	      margin: 10px;
	      border: none;
	      border-radius: 6px;
	      cursor: pointer;
	    }

	    .yes-btn {
	      background-color: #dc3545;
	      color: white;
	    }

	    .no-btn {
	      background-color: #6c757d;
	      color: white;
	    }
	  </style>
	</head>
	<body>
	<p>${output}</p>
	  <div class="profile-card">
	    <h2>User Profile</h2>

	    <div class="profile-info" id="profileInfo">
			<p><span>Username:</span> <span id="username">${userName}</span></p>
				      <p><span>First Name:</span> <span id="firstName"> ${firstName} </span></span></p>
				      <p><span>Last Name:</span> <span id="lastName">${lastName} </span></p>
				      <p><span>Email:</span> <span id="email"> ${email} </span></p>
				      <p><span>Phone:</span><span id="phone"> ${phoneNum} </span></p>
				      <p><span>Date of Birth:</span><span id="dob">  ${dob} </span></p>
				      <p><span>Address:</span><span id="address"> ${address} </span></p>
			
	    </div>

	    <div class="profile-actions">
	      <button class="update-btn" onclick="showUpdateForm()">Update</button>
	     <form action="profiledelete"> <button class="delete-btn">Delete</button></form>
	    </div>

	    <div class="update-form" id="updateForm">
		<form action="updatedata">
	      <input type="text" id="u_username" placeholder="Username" name="Username">
	      <input type="text" id="u_firstName" placeholder="First Name" name="firstname">
	      <input type="text" id="u_lastName" placeholder="Last Name" name="lastname">
	      <input type="email" id="u_email" placeholder="Email" name="email">
	      <input type="text" id="u_phone" placeholder="Phone Number" name="phno">
	      <input type="text" id="u_dob" name="dob">
	      <textarea id="u_address" rows="2" placeholder="Address" name="address"></textarea>
	      <input type="submit" value="submit">
		  </form>
	    </div>
	  </div>

	  <!-- Delete Confirmation Modal -->
	  <div id="deleteModal" class="modal">
	    <div class="modal-content">
	      <p>Are you sure you want to delete this profile?</p>
	      <button class="yes-btn" onclick="confirmDelete()">Yes</button>
	      <button class="no-btn" onclick="closeModal()">No</button>
	    </div>
	  </div>

	  <script>
	    function showUpdateForm() {
	      // Fill form with current values
		  document.getElementById("u_username").value = document.getElementById("username").innerText;
		        document.getElementById("u_firstName").value = document.getElementById("firstName").innerText;
		        document.getElementById("u_lastName").value = document.getElementById("lastName").innerText;
		        document.getElementById("u_email").value = document.getElementById("email").innerText;
		        document.getElementById("u_phone").value = document.getElementById("phone").innerText;
		        document.getElementById("u_dob").value = document.getElementById("dob").innerText;
		        document.getElementById("u_address").value = document.getElementById("address").innerText;

	     
	      document.getElementById("updateForm").style.display = "block";
	    }

	    function submitUpdate() {
	      // Update values on profile
	     

	      alert("Profile updated successfully!");
	      document.getElementById("updateForm").style.display = "none";
	    }

	    function openModal() {
	      document.getElementById("deleteModal").style.display = "block";
	    }

	    function closeModal() {
	      document.getElementById("deleteModal").style.display = "none";
	    }

	    function confirmDelete() {
	      alert("Profile deleted!");
	      closeModal();
	      // Optional: clear profile details or redirect
	    }
	  </script>

	</body>
	</html>

