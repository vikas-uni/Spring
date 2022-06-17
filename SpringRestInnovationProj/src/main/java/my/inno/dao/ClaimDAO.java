package my.inno.dao;

import java.util.List;

import my.inno.model.Claim;

public interface ClaimDAO 
{
   // public void addEmployee(EmployeeEntity employee);
    public List<Claim> getAllClaims();
    public Claim getClaimById(int id);
    //public void deleteEmployee(Integer employeeId);
	public Claim getClaimByQuery(String input);
}