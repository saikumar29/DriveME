package driveme.controllers;

import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import driveme.model.Payment;
import driveme.model.User;
import driveme.model.UserRvw;
import driveme.service.rideServiceImpl;

@Controller
@Scope("request")
public class userOperations {

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private rideServiceImpl rideService;

	@Autowired
	private User user;

	@RequestMapping("/createUser")
	public String createUser() {
		return "createUser";
	}

	@RequestMapping("/payment")
	public String payment() {
		return "payment";
	}

	@RequestMapping("/loginPage")
	public String loginPage() {
		return "login";
	}

	private String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@PostMapping("/saveUser")
	public String saveUser(User usr, Model model, HttpSession session) {
		System.out.println("inside save User Controller");
		try {

			usr.setUsr_password(hashPassword(usr.getUsr_password()));
			boolean saveSuccess = rideService.saveUserHibernate(usr);
			if (saveSuccess) {
				System.out.println("Successfully saved the user");
				System.out.println("now sending email");
				MimeMessage message = sender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message);
				helper.setTo(usr.getEmail());
				helper.setText("Greeting from DriveMe, You have been successfully registered with us."); // check email
				helper.setSubject("DriveMe Registration Successful");
				sender.send(message);
				model.addAttribute("userSaved", "userSaved");
				model.addAttribute("userName", usr.getUsr_name());
				return "login";

			}

			else
				System.out.println("Error while saving the user");

		} catch (Exception e) {
			System.out.println("Error while saving user Controller");
			e.printStackTrace();
		}

		return "createUser";
	}

	@PostMapping("/editUser")
	public String editUser(User usr, Model model, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {
		System.out.println("inside edit User Controller");
		try {
			System.out.println(usr);
			boolean saveSuccess = rideService.updateUser(usr);
			if (saveSuccess) {
				System.out.println("Successfully edited the user");

				model.addAttribute("User", usr);

				return "user_profile"; // remove your password I want to see the app.properties file
			} else
				System.out.println("Error while editing the user");

		} catch (Exception e) {
			System.out.println("Error while editing user Controller");
			e.printStackTrace();
		}

		return "authenticateUserLogin";
	}

	@PostMapping("/authenticateUserLogin")
	public String authenticateUserLogin(User usr, ModelMap map, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {
		System.out.println("inside save User Controller");
		try {

			User loginUsr = rideService.checkUser(usr.getUsr_name(), usr.getUsr_password());
			if (loginUsr == null) {
				System.out.println("Invalid User name / password");
				map.addAttribute("error", "Invalid User name / password");
				return "login";
			} else {
				Map<String, Object> mapObject = rideService.userProfile(loginUsr);

				session.setAttribute("User", loginUsr);
				map.addAttribute("User", loginUsr);
				map.addAttribute("offerRideList", mapObject.get("offerRideList"));
				map.addAttribute("rideRequestMapping", mapObject.get("rideRequestMapping"));
				map.addAttribute("paymentList", mapObject.get("paymentList"));
				map.addAttribute("reviewList", mapObject.get("reviewList"));

				return "user_profile";
			}

		} catch (Exception e) {
			System.out.println("Error while saving user Controller");
			e.printStackTrace();
		}

		return "user_profile";
	}

	@PostMapping("/savePayment")
	public String savePayment(Payment payment, Model model) {
		System.out.println("inside save User Controller");
		try {

			System.out.println(payment);
			model.addAttribute("payment", payment);
			rideService.savePaymentInformation(payment);
			return "payment";
		} catch (Exception e) {
			System.out.println("Error while saving user Controller");
			e.printStackTrace();
		}

		return "createUser";
	}

	@PostMapping("/saveReview")
	public String saveReview(UserRvw review, User usr, ModelMap map, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {
		map.addAttribute("review", review);

		System.out.println(review.getRvw_star());
		rideService.saveReviewInformation(review);

		User user = (User) session.getAttribute("User");
		Map<String, Object> mapObject = rideService.userProfile(user);
		user = (User) session.getAttribute("User");
		session.setAttribute("User", user);
		map.addAttribute("User", user);
		map.addAttribute("offerRideList", mapObject.get("offerRideList"));
		map.addAttribute("rideRequestMapping", mapObject.get("rideRequestMapping"));
		map.addAttribute("paymentList", mapObject.get("paymentList"));
		map.addAttribute("reviewList", mapObject.get("reviewList"));

		return "user_profile";

	}

	@RequestMapping("/logout")
	public String logout(User usr, Model model, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {

		System.out.println("Inside logout");
		session.removeAttribute("User");
		return "login";

	}

	@RequestMapping("/about")
	public String about() {

		return "about";

	}

	@RequestMapping(value = "/payRide", method = RequestMethod.GET)
	public String ReviewRate(@RequestParam("req_id") Long req_id, Model model, HttpServletRequest request,
			HttpSession session, HttpServletResponse response) {

		model.addAttribute("Requester_Id", req_id);
		return "payment";

	}

}
