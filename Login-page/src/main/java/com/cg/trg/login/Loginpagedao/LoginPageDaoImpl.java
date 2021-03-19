package com.cg.trg.login.Loginpagedao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.trg.login.Loginpage.User;

import com.cg.trg.login.exceptions.InvalidLoginCredentialsException;
import com.cg.trg.login.exceptions.PhoneNumberExistsException;
import com.cg.trg.login.exceptions.UserNameAlreadyExistsException;



public class LoginPageDaoImpl implements LoginPageDao {
	
	static int user_idd = 1;

	@Autowired
	EntityManager entityManager;
	@Override
	public User addAccount(User us) {
		
		//count of the existing accounts  to assign account number
		String command = "SELECT count(us.user_id) from User us";
		TypedQuery<Long> query1 = entityManager.createQuery(command, Long.class);
		Long count = query1.getSingleResult();

		//if count is  greater than zero increment by 1 to the maximum of account numbers
		if(count > 0) {
		String command2 = "select max(us.user_id) from User us";
		TypedQuery <Integer> query2 = entityManager.createQuery(command2,Integer.class);
		int USERID = query2.getSingleResult();
		us.setUser_id(USERID +1);
		System.out.println(USERID);
		}
		else
		{
			us.setUser_id(user_idd);
			
		}
		//persisting the data into database
		
		entityManager.persist(us);
		System.out.println();
		return us;
	}
    
	//checks if the user is valid 
		@Override
		public boolean checkUser(String userName, String password) throws  InvalidLoginCredentialsException{
				try{
					//command for selecting user name and password from the data
					String cmd = "select user_details from User user_details where user_details.user_name=:user and user_details.password=:pwd";
					TypedQuery<User> query = entityManager.createQuery(cmd,User.class);

					//setting the parameters in the command with given user name and password
					query.setParameter ("user",userName);
					query.setParameter ("pwd", password);
					query.getSingleResult();
					return true;
				}

				//if login details are wrong
				catch(Exception ex) 
				{throw new InvalidLoginCredentialsException("Invalid Login Credentials");}
			}

	@Override
	public boolean userNameExists(String userName) throws UserNameAlreadyExistsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean phNoExists(String phoneNo) throws PhoneNumberExistsException {
		// TODO Auto-generated method stub
		return false;
	}
	
        
}
