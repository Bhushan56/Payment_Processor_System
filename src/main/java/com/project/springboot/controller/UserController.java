package com.project.springboot.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.springboot.beans.BankInfo;
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
		List<Transaction>approvedTransaction=new ArrayList<>();
		List<Transaction>rejectedTransaction=new ArrayList<>();
		UserInfo user=customerService.checkCustomerCredentials(email, password);
		if(user!=null) {
			approvedTransaction=customerService.getTransaction(user.getUserId(), "Successful");
			rejectedTransaction=customerService.getTransaction(user.getUserId(), "Rejected");
			
			modelAndView=new ModelAndView("CustomerHome");
			modelAndView.addObject("user",user);
			modelAndView.addObject("approvedTransaction",approvedTransaction);
			modelAndView.addObject("rejectedTransaction", rejectedTransaction);
		}
		else {
			modelAndView=new ModelAndView("IncorrectCredentials");
		}
		
		return modelAndView;
		
	}
	@PostMapping("/bankhome")
	public ModelAndView getBankCredentials(@RequestParam("bic") String bic,@RequestParam("password")String password) {
		List<Transaction>pendingTransaction=new ArrayList<>();
		List<Transaction>approvedTransaction=new ArrayList<>();
		List<Transaction>rejectedTransaction=new ArrayList<>();
		ModelAndView modelAndView;
		 BankInfo bank=bankService.checkBankCredentials(bic, password);
		if(bank!=null) {
			pendingTransaction=bankService.getPendingTransaction(bic, "PENDING");
			approvedTransaction=bankService.getApprovedTransaction(bic, "Successful");
			rejectedTransaction=bankService.getRejectedTransaction(bic, "Rejected");
			modelAndView=new ModelAndView("BankHome");
			modelAndView.addObject("bank", bank);
			modelAndView.addObject("pendingTransaction",pendingTransaction);
			modelAndView.addObject("approvedTransaction",approvedTransaction);
			modelAndView.addObject("rejectedTransaction", rejectedTransaction);
		}
		else {
			modelAndView=new ModelAndView("IncorrectCredentials");
		}
		return modelAndView;
	}
	 
	
	@RequestMapping("/pay")
	public ModelAndView doPayment(@RequestParam("senderAccountBalance") String AvailableBalance,@RequestParam("senderUserId") String senderUserId,@RequestParam("senderAccountNumber") 
			String senderAccountNumber,@RequestParam("senderName") String senderName, 
			@RequestParam("beneficiaryUserId")  int beneficiaryUserId, @RequestParam("senderBankCode") String senderBankCode,
			@RequestParam("beneficiaryName") String beneficiaryName,@RequestParam("receiverMobileNumber") 
			String receiverMobileNumber, @RequestParam("bic") String bic,@RequestParam("beneficiaryAccountNumber")
			String beneficiaryAccountNumber,@RequestParam("amount") String amount) {
 		        
		         ModelAndView modelAndView;
		    if(customerService.validateBenificiary(beneficiaryUserId, beneficiaryName, receiverMobileNumber, bic, beneficiaryAccountNumber)) {     
				if(Double.valueOf(AvailableBalance)<Double.valueOf(amount)) {
					modelAndView=new ModelAndView("WrongData");
		         }
				else {
	
					String orderingCustomer=senderName+","+senderAccountNumber+","+senderUserId;
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
					
					modelAndView=new ModelAndView("PaymentConfirmation");
					modelAndView.addObject("transaction",transaction);
				}
		    }
		    else {
		    	modelAndView=new ModelAndView("NotFound");
		    }
		 
		return modelAndView;
		
	}	

	 
	  @RequestMapping("/success") 
	  public String payment(@RequestParam("S_bic") String S_bic,@RequestParam("availableBalance")double availableBalance,@RequestParam("R_bic") String R_bic,@RequestParam("bankName") String bankName,@RequestParam("amount") double
	  amount) {
		  System.out.print(S_bic + R_bic)
;		  bankService.payment(S_bic,availableBalance,R_bic,bankName,amount); 
		  return "Success";
	  }
	 
		/*
		 * @GetMapping("/bankhome") public ModelAndView redirect() {
		 * 
		 * return new ModelAndView("BankHome"); }
		 */
	@RequestMapping("/approve")
	public String approvePayment(@RequestParam("t_id")  String ref_id) {
		 
		 int ref=Integer.parseInt(ref_id.split("/")[0]);
		 bankService.approveTransaction(ref);
		 return "Success";
	}
	@RequestMapping("/reject")
	public String rejectPayment(@RequestParam("t_id")  String ref_id) {
		 
		 int ref=Integer.parseInt(ref_id.split("/")[0]);
		 bankService.rejectTransaction(ref);
		 
		 
		 return "Success";
	}
	/*
	 * @RequestMapping(value="/register",method = RequestMethod.GET) public
	 * ModelAndView reg() { return new ModelAndView("register"); }
	 */
	/*
	 * @RequestMapping(value="/register",method = RequestMethod.POST) public
	 * ModelAndView register(@RequestParam("name") String
	 * name,@RequestParam("email") String email,@RequestParam("phoneNumber") String
	 * phoneNumber,
	 * 
	 * @RequestParam("address") String address,@RequestParam("bic") String
	 * bic,@RequestParam("accountNo") String accountNo,@RequestParam("amount")
	 * double amount,@RequestParam("password") String password) {
	 * 
	 * UserInfo userInfo = new UserInfo(); userInfo.setName(name);
	 * userInfo.setEmail(email); userInfo.setMobieNumber(phoneNumber);
	 * userInfo.setAddress(address); userInfo.setBic(bic);
	 * userInfo.setAccountNumber(accountNo); userInfo.setAmount(amount);
	 * userInfo.setPassword(password); bankService.register(userInfo); return new
	 * ModelAndView("Login"); }
	 */
	 
}

