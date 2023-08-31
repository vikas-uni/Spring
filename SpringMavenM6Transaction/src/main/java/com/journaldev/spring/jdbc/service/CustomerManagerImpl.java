package com.journaldev.spring.jdbc.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.jdbc.dao.CustomerDAO;
import com.journaldev.spring.jdbc.model.Customer;

public class CustomerManagerImpl implements CustomerManager {

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
	public void createCustomer(Customer cust) {
		customerDAO.create(cust);
	}

}

/*
 * @Transactional(propagation=Propagation.REQUIRED)

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

Indicates that the target method doesn�t require the transaction context to be propagated.
Mostly those methods which run in a transaction but perform in-memory operations are the best candidates for this option.
NEVER

Indicates that the target method will raise an exception if executed in a transactional process.
This option is mostly not used in projects.
@Transactional (rollbackFor=Exception.class)

Default is rollbackFor=RunTimeException.class
In Spring, all API classes throw RuntimeException, which means if any method fails, the container will always rollback the ongoing transaction.
The problem is only with checked exceptions. So this option can be used to declaratively rollback a transaction if Checked Exception occurs.
@Transactional (noRollbackFor=IllegalStateException.class)

Indicates that a rollback should not be issued if the target method raises this exception.
Now the last but most important step in transaction management is the placement of @Transactional annotation. Most of the times, there is a confusion where should the annotation be placed: at Service layer or DAO layer?

@Transactional: Service or DAO Layer?

The Service is the best place for putting @Transactional, service layer should hold the detail-level use case behavior for a user interaction that would logically go in a transaction.
There are a lot of CRUD applications that don't have any significant business logic for them having a service layer that just passes data through between the controllers and data access objects is not useful. In these cases we can put transaction annotation on Dao.
So in practice you can put them in either place, it's up to you.
Also if you put @Transactional in DAO layer and if your DAO layer is getting resused by different services then it will be difficult to put it on DAO layer as different services may have different requirements.
If your service layer is retrieving objects using Hibernate and let's say you have lazy initializations in your domain object definition then you need to have a transaction open in service layer else you will face LazyInitializationException thrown by the ORM.
Consider another example where your Service layer may call two different DAO methods to perform DB operations. If your first DAO operation failed  then other two may be still passed and you will end up inconsistent DB state. Annotating Service layer can save you from such situations.
 
 
 The following are the types of Transaction Isolation Levels-
SERIALIZABLE
If two transactions are executing concurrently then it is as if the transactions get executed serially i.e the first transaction 
gets committed only then the second transaction gets executed. This is total isolation. So a running transaction is never affected 
by other transactions. However this may cause issues as performance will be low and deadlock might occur.

REPEATABLE_READ
If two transactions are executing concurrently - till the first transaction is committed the existing records cannot be changed 
by second transaction but new records can be added. After the second transaction is committed, the new added records get reflected 
in first transaction which is still not committed. For MySQL the default isolation level is REPEATABLE_READ.
However the REPEATABLE READ isolation level behaves differently when using mysql. When using MYSQL we are not able to see the newly 
added records that are committed by the second transaction.

READ_COMMITTED
If two transactions are executing concurrently - before the first transaction is committed the existing records can be changed as 
well as new records can be changed by second transaction. After the second transaction is committed, the newly added and also 
updated records get reflected in first transaction which is still not committed.

READ_UNCOMMITTED
If two transactions are executing concurrently - before the first transaction is committed the existing records can be changed 
as well as new records can be changed by second transaction. Even if the second transaction is not committed the newly added 
and also updated records get reflected in first transaction which is still not committed.

Summary
Dirty Reads - Suppose two transactions - Transaction A and Transaction B are running concurrently. If Transaction A modifies a 
record but not commits it. Transaction B reads this record but then Transaction A again rollbacks the changes for the record 
and commits it. So Transaction B has a wrong value.

Non-Repeatable Reads - Suppose two transactions - Transaction A and Transaction B are running concurrently. 
If Transaction A reads some records. Transaction B modifies these records before transaction A has been committed. 
So if Transaction A again reads these records they will be different. So same select statements result in different existing records.

Phantom Reads - Suppose two transactions - Transaction A and Transaction B are running concurrently. If Transaction A reads some 
records. Transaction B adds more such records before transaction A has been committed. So if Transaction A again reads there 
will be more records than the previous select statement. So same select statements result in different number records to be 
displayed as new records also get added.
 * */

 