package com.Assignment1.UTHAssignment;

import com.Assignment1.Models.Transaction;
import com.Assignment1.Models.UserWallet;
import com.Assignment1.Repositories.PaginationRepository;
import com.Assignment1.Repositories.TransactionRepository;
import com.Assignment1.Repositories.UserWalletRepository;
import com.sun.istack.NotNull;
import org.junit.Assert;
import com.Assignment1.Models.User;
import com.Assignment1.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import com.Assignment1.Service.service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
/*@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)*/

class UthAssignmentApplicationTests {

/*@Autowired
	service service;
	@Autowired
	private UserRepository userRepository;

	@Test
	public void createUserTest()
	{
		User user = new User("alex123","alex","dutch","9898989898","alex@usa.com","XYZ","PQR");
	//	userRepository.save(user);
		assertNotEquals(null);
	}*/


	@Autowired
	service service;
	@MockBean
	UserRepository userRepository;
	@MockBean
	UserWalletRepository userWalletRepository;
	@MockBean
	TransactionRepository transactionRepository;
	@MockBean
	PaginationRepository paginationRepository;

	@Test
	public void createUserTest()
	{
		User user = new User("alex123","alex","dutch","9898989898","alex@usa.com","XYZ","PQR");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user,service.createUser(user));
	}
	@Test
	public void findUserTest()
	{
		User user = new User("alex123","alex","dutch","9898989898","alex@usa.com","XYZ","PQR");
		when(userRepository.findByUserID((long)1)).thenReturn(user);
		assertEquals(user,service.findUser((long)1));
	}
	@Test
	public void updateUserTest()
	{
		User user = new User("alex1234","alex","dutch","9898989898","alex@usa.com","XYZ","PQR");
		when(userRepository.save(user)).thenReturn(user);
		when(userRepository.findByUserID((long)1)).thenReturn(user);
		assertEquals("User updated successfully.",service.updateUser(1L,user));

	}
	@Test
	public void deleteUserTest()
	{
		User user = new User("alex123","alex","dutch","9898989898","alex@usa.com","XYZ","PQR");

		assertEquals("User does not exist.",service.updateUser(1L,user));

	}

	@Test
	public void createWalletTest()
	{
		User user = new User("alex123","alex","dutch","9898989898","alex@usa.com","XYZ","PQR");
		String mobileNumber = "9898989898";
		UserWallet userWallet = new UserWallet(mobileNumber);

		when(userWalletRepository.findByID(mobileNumber)).thenReturn(null);
		when(userRepository.findByMobileNumber(mobileNumber)).thenReturn(user);
		when(userWalletRepository.save(userWallet)).thenReturn(userWallet);

		assertEquals(userWallet,service.createWallet(mobileNumber));

	}

	@Test
	public void doTransactionTest()
	{
		User user = new User("alex123","alex","dutch","9898989898","alex@usa.com","XYZ","PQR");
		String mobileNumber1 = "9898989898";
		String mobileNumber2 = "9999999999";
		Double amount =100D;
		UserWallet userWallet1 = new UserWallet(mobileNumber1);
		UserWallet userWallet2 = new UserWallet(mobileNumber2);
		Transaction transaction =  new Transaction(mobileNumber1, mobileNumber2, amount, "Success");

		when(userWalletRepository.findByID(mobileNumber1)).thenReturn(userWallet1);
		when(userWalletRepository.findByID(mobileNumber2)).thenReturn(userWallet2);
		when(userWalletRepository.save(userWallet1)).thenReturn(userWallet1);
		when(userWalletRepository.save(userWallet2)).thenReturn(userWallet2);
		when(transactionRepository.save(transaction)).thenReturn(transaction);

		assertEquals(transaction,service.doTransaction(mobileNumber1,mobileNumber2,amount));

	}

	@Test
	public void getTransactionSummaryTest()
	{

		User user = new User("alex123","alex","dutch","9898989898","alex@usa.com","XYZ","PQR");
		String mobileNumber1 = "9898989898";
		String mobileNumber2 = "9999999999";
		Double amount =100D;
		UserWallet userWallet1 = new UserWallet(mobileNumber1);
		UserWallet userWallet2 = new UserWallet(mobileNumber2);
		Transaction transaction =  new Transaction(mobileNumber1, mobileNumber2, amount, "Success");
		Pageable firstPageWithOneElement = PageRequest.of(0, 15, Sort.by("Date").descending());
		Page<Transaction> tasks = Mockito.mock(Page.class);

		when(userRepository.findByUserID(user.getUserID())).thenReturn(user);
		when(userWalletRepository.findByID(user.getMobileNumber())).thenReturn(userWallet1);
		when(paginationRepository.findByUserID(firstPageWithOneElement,user.getMobileNumber())).thenReturn(tasks);

		assertEquals(tasks,service.getTransactionSummary(user.getUserID()));

	}

	@Test
	public void getTransactionStatusTest()
	{

		String mobileNumber1 = "9898989898";
		String mobileNumber2 = "9999999999";
		Double amount =100D;
UserWallet userWallet1 = new UserWallet(mobileNumber1);
		UserWallet userWallet2 = new UserWallet(mobileNumber2);

		Transaction transaction =  new Transaction(mobileNumber1, mobileNumber2, amount, "Success");
		when(transactionRepository.findByID(transaction.getTransactionID())).thenReturn(transaction);

	}



/*	public void findUserTest1()
			throws Exception {

		User alex = new User("alex123","alex","dutch","9898989898","alex@usa.com","XYZ","ABC");


		given(service.findUser((long)1)).willReturn(alex);

		mvc.perform(get("/user")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", is(alex.getUserName())));
	}*/


}
