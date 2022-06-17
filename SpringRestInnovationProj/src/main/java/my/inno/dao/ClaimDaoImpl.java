package my.inno.dao;

import java.util.List;

import my.inno.model.Claim;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ClaimDaoImpl implements ClaimDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Claim> getAllClaims() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from Claim").list();
	}
	
	public Claim getClaimById(int id) {
		// TODO Auto-generated method stub
		return (Claim) this.sessionFactory.getCurrentSession().load(Claim.class, id);
	}

	@Override
	public Claim getClaimByQuery(String input) {
		//use this for MySQL - CALL SP_getClaimStatus(:text)
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery(
				"EXEC SP_getClaimStatus :text")
				.addEntity(Claim.class)
				.setParameter("text", input);
						
			Claim result = (Claim) query.uniqueResult();//list();
			/*for(int i=0; i<result.size(); i++){
				Claim stock = (Claim)result.get(i);
				//System.out.println(stock.getStockCode());
			}*/
		return result;
	}

}
