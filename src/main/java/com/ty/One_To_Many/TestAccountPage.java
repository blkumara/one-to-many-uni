package com.ty.One_To_Many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestAccountPage {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		UserAccount userAccount=new UserAccount();
		userAccount.setEmail("pava@gmail.com");
		userAccount.setPassword("pavan@7411");
		userAccount.setMobile(7411145659l);
		userAccount.setName("pavan K");
		
		Page page=new Page();
		page.setName("TrollsPage");
		page.setTittle("Bangalore Trolls");
		page.setDescription("Good Troll page");
		
		Page page1=new Page();
		page1.setName("VIP Pages");
		page1.setTittle("RaksithShetty");
		page1.setDescription(" page Is Nice");
		
		List<Page> list=new ArrayList<Page>();
		list.add(page);
		list.add(page1);
		
		userAccount.setPage(list);
		
		entityTransaction.begin();
		entityManager.persist(userAccount);
		entityManager.persist(page);
		entityManager.persist(page1);
		entityTransaction.commit();
		
		System.out.println("Saved");
		
			
	}

}
