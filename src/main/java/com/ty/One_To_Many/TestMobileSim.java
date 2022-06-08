package com.ty.One_To_Many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMobileSim {
	public static void main(String[] args) {




		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Mobile mobile=new Mobile();
		mobile.setName("Vivo");
		mobile.setCost(25000);
		
		Sim sim=new Sim();
		sim.setProvider("BSNL");
		sim.setType("4G");
		
		Sim sim2=new Sim();
		sim2.setProvider("Airtel");
		sim2.setType("VodaPhone");
		
		List<Sim> list= new ArrayList<Sim>();
		list.add(sim);
		list.add(sim2);
		
		mobile.setSims(list);
		
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim);
		entityManager.persist(sim2);
		entityTransaction.commit();
		
		
		
		System.out.println("***DONE***");
		


	}
}
