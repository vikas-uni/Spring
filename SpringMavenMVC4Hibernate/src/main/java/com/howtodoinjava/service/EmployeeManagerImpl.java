package com.howtodoinjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.howtodoinjava.dao.EmployeeDAO;
import com.howtodoinjava.entity.EmployeeEntity;

@Service
public class EmployeeManagerImpl implements EmployeeManager {
	
	@Autowired
    private EmployeeDAO employeeDAO;

//	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.SUPPORTS)
	@Transactional
	public void addEmployee(EmployeeEntity employee) {
		employeeDAO.addEmployee(employee);
	}

	@Transactional
	public List<EmployeeEntity> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
 
}
/*
 * https://dzone.com/articles/spring-transaction-management
 * Let us now understand different @Transactional attributes.

@Transactional (isolation=Isolation.READ_COMMITTED)

The default is Isolation.DEFAULT
Most of the times, you will use default unless and until you have specific requirements.
Informs the transaction (tx) manager that the following isolation level should be used for the current tx. Should be set at the point from where the tx starts because we cannot change the isolation level after starting a tx.
DEFAULT

Use the default isolation level of the underlying database.

READ_COMMITTED

A constant indicating that dirty reads are prevented; non-repeatable reads and phantom reads can occur.

READ_UNCOMMITTED

This isolation level states that a transaction may read data that is still uncommitted by other transactions.

REPEATABLE_READ

A constant indicating that dirty reads and non-repeatable reads are prevented; phantom reads can occur.

SERIALIZABLE

A constant indicating that dirty reads, non-repeatable reads, and phantom reads are prevented.

What do these Jargons dirty reads, phantom reads, or repeatable reads mean?

Dirty Reads: Transaction 'A' writes a record. Meanwhile Transaction 'B' reads that same record before Transaction A commits. Later Transaction A decides to rollback and now we have changes in Transaction B that are inconsistent. This is a dirty read. Transaction B was running in READ_UNCOMMITTED isolation level so it was able to read Transaction A changes before a commit occurred.
Non-Repeatable Reads: Transaction 'A' reads some record. Then Transaction 'B' writes that same  record and commits. Later Transaction A reads that same record again and may get different values because Transaction B made changes to that record and committed. This is a non-repeatable read.
Phantom Reads: Transaction 'A' reads a range of records. Meanwhile Transaction 'B' inserts a new record in the same range that Transaction A initially fetched and commits. Later Transaction A reads the same range again and will also get the record that Transaction B just inserted. This is a phantom read: a transaction fetched a range of records multiple times from the database and obtained different result sets (containing phantom records).
@Transactional(timeout=60)

Defaults to the default timeout of the underlying transaction system.

Informs the tx manager about the time duration to wait for an idle tx before a decision is taken to rollback non-responsive transactions.

@Transactional(propagation=Propagation.REQUIRED)

If not specified, the default propagational behavior is REQUIRED. 

Other options are REQUIRES_NEW, MANDATORY, SUPPORTS, NOT_SUPPORTED, NEVER, and NESTED.

REQUIRED

Indicates that the target method can not run without an active tx. If a tx has already been started before the invocation of this method, then it will continue in the same tx or a new tx would begin soon as this method is called.    
REQUIRES_NEW

Indicates that a new tx has to start every time the target method is called. If already a tx is going on, it will be suspended before starting a new one.
MANDATORY

Indicates that the target method requires an active tx to be running. If a tx is not going on, it will fail by throwing an exception.
SUPPORTS

Indicates that the target method can execute irrespective of a tx. If a tx is running, it will participate in the same tx. If executed without a tx it will still execute if no errors.
Methods which fetch data are the best candidates for this option.
NOT_SUPPORTED

Indicates that the target method doesn’t require the transaction context to be propagated.
Mostly those methods which run in a transaction but perform in-memory operations are the best candidates for this option.
NEVER

Indicates that the target method will raise an exception if executed in a transactional process.
This option is mostly not used in projects.
@Transactional (rollbackFor=Exception.class)

Default is rollbackFor=RunTimeException.class
In Spring, all API classes throw RuntimeException, which means if any method fails, the container will always rollback the ongoing transaction.
The problem is only with checked exceptions. So this option can be used to declaratively rollback a transaction if Checked Exception occurs.
@Transactional (noRollbackFor=IllegalStateException.class)

Indicates that a rollback should not be issued if the target method raises this exception.*/
