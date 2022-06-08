package com.ty.One_To_Many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetMobileAndSim {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Mobile mobile = entityManager.find(Mobile.class, 4);
		if (mobile != null) {
			System.out.println("Mobile Name Is:" + mobile.getName());
			System.out.println("Mobile Cost Is:" + mobile.getCost());

			List<Sim> list = mobile.getSims();
			if(list.size()>0) {
			for (Sim sim : list) {
				System.out.println("Sim Id Is:" + sim.getId());
				System.out.println("Sim Provider:" + sim.getProvider());
				System.out.println("Sim type:" + sim.getType());
				System.out.println("*******************");
			}
			}
			else {
				System.out.println("No sim");
			}

		} else {
			System.out.println("Mobile Is Not Found");
		}
	}
}
