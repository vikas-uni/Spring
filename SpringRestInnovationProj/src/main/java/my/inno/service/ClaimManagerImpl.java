package my.inno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.inno.dao.ClaimDAO;
import my.inno.model.Claim;


@Service
public class ClaimManagerImpl implements IClaimManager{
	@Autowired
    private ClaimDAO claimDAO;
	
	public ClaimDAO getClaimDAO() {
		return claimDAO;
	}

	public void setClaimDAO(ClaimDAO claimDAO) {
		this.claimDAO = claimDAO;
	}

	@Override
	@Transactional
	public List<Claim> getAllClaims() {
		// TODO Auto-generated method stub
		return claimDAO.getAllClaims();
	}

	@Override
	@Transactional
	public Claim getClaimByQuery(String input) {
		// TODO Auto-generated method stub
		return claimDAO.getClaimByQuery(input);
	}

}
