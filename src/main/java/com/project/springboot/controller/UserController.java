package com.project.springboot.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.springboot.beans.Transaction;
import com.project.springboot.beans.UserInfo;
import com.project.springboot.service.BankService;
import com.project.springboot.service.CustomerService;


@Controller
public class UserController {

	private CustomerService customerService;
	private BankService bankService;
	
	public UserController(CustomerService customerService,BankService bankService) {
		this.customerService=customerService;
		this.bankService=bankService;
	}
	@RequestMapping("")
	public ModelAndView getLoginPage() {
		return new ModelAndView("Login");
	}
	
	@RequestMapping("/customerhome")
	public ModelAndView getUserCredentials(@RequestParam("email") String email,@RequestParam("password") String password) {
		ModelAndView modelAndView;
		
		UserInfo user=customerService.checkCustomerCredentials(email, password);
		if(user!=null) {
			modelAndView=new ModelAndView("CustomerHome");
			modelAndView.addObject("user",user);
		}
		else {
			modelAndView=new ModelAndView("IncorrectCredentials");
		}
		
		return modelAndView;
		
	}
	@RequestMapping("/bankhome")
	public ModelAndView getBankCredentials(@RequestParam("bic") String bic,@RequestParam("password")String password) {
		ModelAndView modelAndView;
		boolean result=bankService.checkBankCredentials(bic, password);
		if(result) {
			
			modelAndView=new ModelAndView("BankHome");
		}
		else {
			modelAndView=new ModelAndView("IncorrectCredentials");
		}
		return modelAndView;
	}
	
	@RequestMapping("/pay")
	public ModelAndView doPayment(@RequestParam("senderUserId") String senderUserId,@RequestParam("senderAccountNumber") 
			String senderAccountNumber,@RequestParam("senderName") String senderName, 
			@RequestParam("beneficiaryUserId") String beneficiaryUserId, @RequestParam("senderBankCode") String senderBankCode,
			@RequestParam("beneficiaryName") String beneficiaryName,@RequestParam("receiverMobileNumber") 
			String receiverMobileNumber, @RequestParam("bic") String bic,@RequestParam("beneficiaryAccountNumber")
			String beneficiaryAccountNumber,@RequestParam("amount") String amount) {
		
		String orderingCustomer=senderName+","+senderAccountNumber+senderUserId;
		String beneficiaryCustomer=beneficiaryName+","+beneficiaryAccountNumber+","+beneficiaryUserId;
		
		Transaction transaction=new Transaction();
		transaction.setOrderingCustomer(orderingCustomer);
		transaction.setBeneficiaryCustomer(beneficiaryCustomer);
		transaction.setSendingInstitution(senderBankCode);
		transaction.setAccountWithInstitution(bic);
		transaction.setAmount(Double.valueOf(amount));
		transaction.setStatus("PENDING");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		transaction.setDate((dtf.format(now)));  
		
		customerService.saveTransaction(transaction);
		
		ModelAndView modelAndView=new ModelAndView("PaymentConfirmation");
		modelAndView.addObject("transaction",transaction);
		return modelAndView;
	}
}

