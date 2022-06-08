package com.ty.One_To_Many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetUserAccountPage {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		UserAccount userAccount = entityManager.find(UserAccount.class, 1);
		if (userAccount != null) {
			System.out.println("UserAccount Id Is:"+userAccount.getId());
			System.out.println("UserAccount Mail Is:"+userAccount.getEmail());
			

			List<Page> list = userAccount.getPage();
			if(list.size()>0) {
			for (Page sim : list) {
				System.out.println("Page Id Is:" + sim.getId());
				System.out.println("page Name Is:" + sim.getName());
				System.out.println("page Tittle Is:" + sim.getTittle());
				System.out.println("page description Is:" + sim.getDescription());
				System.out.println("*******************");
			}
			}
			else {
				System.out.println("No Page");
			}

		} else {
			System.out.println("Account Is Not Found");
		}
	}
}
