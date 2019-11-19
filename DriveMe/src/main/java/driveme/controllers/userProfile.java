package driveme.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import driveme.model.User;
import driveme.service.rideServiceImpl;

@Controller
public class userProfile {

	@Autowired
	private rideServiceImpl rideService;

	@RequestMapping("/user_profile")
	public String greeting(ModelMap map, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) {

		User usr = (User) session.getAttribute("User");
		Map<String, Object> mapObject = rideService.userProfile(usr);
		map.addAttribute("User", usr);
		map.addAttribute("offerRideList", mapObject.get("offerRideList"));
		map.addAttribute("rideRequestMapping", mapObject.get("rideRequestMapping"));
		map.addAttribute("paymentList", mapObject.get("paymentList"));
		map.addAttribute("reviewList", mapObject.get("reviewList"));
		return "user_profile";
	}

}
