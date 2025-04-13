package com.example.SpringPaymentApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User,Integer>
{
	boolean existsByUserNameAndPassword(String userName,String password);

	boolean existsByUserId(int userId);
	
	User findByUserId(int userId);
	
	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.userName = :userName, u.firstName = :firstName, u.lastName = :lastName, " +
	       "u.email = :email, u.phoneNum = :phoneNum, u.dob = :dob, u.address = :address " +
	       "WHERE u.userId = :userId")
	int updateByUserId(@Param("userId") int userId,
	                   @Param("userName") String userName,
	                   @Param("firstName") String firstName,
	                   @Param("lastName") String lastName,
	                   @Param("email") String email,
	                   @Param("phoneNum") int phoneNum,  // changed to String (see note below)
	                   @Param("dob") String dob,
	                   @Param("address") String address);

	
	User findByUserNameAndPassword(String userName,String password);
	
	@Modifying
	@Transactional
	int deleteByUserId(int userId); //built in


}
