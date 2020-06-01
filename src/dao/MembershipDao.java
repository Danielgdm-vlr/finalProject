package dao;

import model.Membership;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MembershipDao extends GenericDao<Membership> {
        private EntityManagerFactory factory;

        public MembershipDao(EntityManagerFactory factory){
            super(Membership.class);
            this.factory = factory;
        }

        public EntityManager getEntityManager(){
            try{
                return factory.createEntityManager();
            }catch (Exception e){
                System.out.println("The entity cannot be created!");
                return null;
            }
        }
}
