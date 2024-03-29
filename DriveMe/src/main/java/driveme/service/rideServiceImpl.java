package driveme.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import driveme.dao.rideDaoImpl;
import driveme.model.OfferRide;
import driveme.model.Payment;
import driveme.model.User;
import driveme.model.UserRvw;

@Service
public class rideServiceImpl {

	@Autowired
	private rideDaoImpl rideDao;

	public User checkUser(String usrName, String password) {
		return rideDao.checkUser(usrName, password);
	}

	public boolean saveOfferRide(OfferRide offerRide) {
		return rideDao.saveOfferRide(offerRide);
	}

	public List<OfferRide> searchRide(String ride_start_point, String ride_end_point, String ride_start_date) {
		return rideDao.searchRide(ride_start_point, ride_end_point, ride_start_date);
	}

	public boolean saveRideRequest(Long rr_map_or, User rr_user_id) {
		return rideDao.saveRideRequest(rr_map_or, rr_user_id);
	}

	public Map<String, Object> userProfile(User usr) {
		return rideDao.userProfile(usr);
	}

	public boolean savePaymentInformation(Payment payment) {
		return rideDao.savePaymentInformation(payment);

	}

	public boolean saveReviewInformation(UserRvw review) {
		return rideDao.saveReviewInformation(review);

	}

	public boolean updateUser(User usr) {
		// TODO Auto-generated method stub
		return rideDao.updateUser(usr);
	}

	@Transactional
	public boolean saveUserHibernate(User usr) {
		return rideDao.saveUserHibernate(usr);
	}
}
