package my.inno.service;

import java.util.List;

import my.inno.model.Claim;

public interface IClaimManager {

	public List<Claim> getAllClaims();
	public Claim getClaimByQuery(String input);
}
