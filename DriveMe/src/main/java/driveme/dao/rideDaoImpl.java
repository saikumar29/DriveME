package driveme.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import driveme.model.OfferRide;
import driveme.model.Payment;
import driveme.model.RideReqestMapping;
import driveme.model.User;
import driveme.model.UserRvw;

@Repository
public class rideDaoImpl {

	private static final SessionFactory sf = new Configuration().configure("hiberncate.cfg.xml").buildSessionFactory();
	private Session session = null;

	private Session getSession() {
		if (session == null || !session.isOpen()) {
			session = sf.openSession();
		}
		return session;
	}

	private void beginTransaction() {
		getSession().beginTransaction();
	}

	private void commit() {
		getSession().getTransaction().commit();
		;
	}

	private void close() {
		if (session != null) {
			getSession().close();
		}
	}

	private void rollbackTransaction() {
		getSession().getTransaction().rollback();
	}

	public boolean saveUserHibernate(User usr) {
		try {
			System.out.println("Inside saveUserHibernate");
			beginTransaction();
			getSession().save(usr);
			commit();
			return true;
		} catch (Exception e) {
			System.out.println("=============Error Inside saveUserHibernate");
			e.printStackTrace();
		}
		return false;
	}

	public User checkUser(String userName, String password) {
		try {

			User userList = null;
			Criteria checkUserCriteria = getSession().createCriteria(User.class);
			checkUserCriteria.add(Restrictions.eq("usr_name", userName));
			if (checkUserCriteria.list().size() > 0) {
				userList = (User) checkUserCriteria.list().get(0);
				if (BCrypt.checkpw(password, userList.getUsr_password()))
					return userList;
			} else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return null;

	}

	public boolean saveOfferRide(OfferRide offerRide) {

		try {

			offerRide.setSeats_available(offerRide.getSeats_offer());
			beginTransaction();
			getSession().save(offerRide);
			commit();
			return true;
		} catch (Exception e) {
			System.out.println("Error inside saveOfferRide");
			e.printStackTrace();
			return false;
		}
	}

	public List<OfferRide> searchRide(String ride_start_point, String ride_end_point, String ride_start_date) {

		Criteria critofferride = getSession().createCriteria(OfferRide.class);
		critofferride.add(Restrictions.eq("ride_start_point", ride_start_point));
		critofferride.add(Restrictions.eq("ride_end_point", ride_end_point));
		critofferride.add(Restrictions.eq("ride_start_date", ride_start_date));
		critofferride.add(Restrictions.gt("seats_available", 0L));
		@SuppressWarnings("unchecked")
		List<OfferRide> offerRideList = critofferride.list();

		return offerRideList;

	}

	public boolean saveRideRequest(Long rr_map_or, User rr_user_id) {
		try {

			beginTransaction();

			Criteria critsaveridereq = getSession().createCriteria(OfferRide.class);
			critsaveridereq.add(Restrictions.eq("or_id", rr_map_or));
			OfferRide offerRide = (OfferRide) critsaveridereq.list().get(0);
			offerRide.setSeats_available(offerRide.getSeats_available() - 1);

			RideReqestMapping rr = new RideReqestMapping();
			getSession().save(rr);
			rr.setRr_map_or(offerRide);
			rr.setRr_user_id(rr_user_id);
			getSession().update(offerRide);
			commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Map<String, Object> userProfile(User usr) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			Criteria s1 = getSession().createCriteria(OfferRide.class);
			s1.add(Restrictions.eq("or_user_id", usr));
			List<OfferRide> offerRideList = s1.list();

			Criteria s2 = getSession().createCriteria(RideReqestMapping.class);
			s2.add(Restrictions.eq("rr_user_id", usr));
			List<RideReqestMapping> rideRequestMapping = s2.list();

			List<Long> reqId = new ArrayList<Long>();
			List<Long> rr_map_or_id_List = new ArrayList<Long>();
			for (RideReqestMapping rideReqMap : rideRequestMapping) {
				reqId.add(rideReqMap.getReq_id());
				rr_map_or_id_List.add(rideReqMap.getRr_map_or().getOr_id());
			}

			if (reqId.size() == 0) {
				reqId.add(0L);
				rr_map_or_id_List.add(0L);
			}

			Criteria s3 = getSession().createCriteria(Payment.class);
			s1.add(Restrictions.in("payment_map_rr", reqId));
			List<Payment> paymentlist = s3.list();

			Criteria s4 = getSession().createCriteria(UserRvw.class);
			s1.add(Restrictions.in("rvw_map_rr", reqId));
			List<UserRvw> reviewlist = s4.list();

			Criteria s5 = getSession().createCriteria(OfferRide.class);
			s5.add(Restrictions.in("or_id", rr_map_or_id_List));
			List<OfferRide> rr_map_or_List = s5.list();

			for (RideReqestMapping rideReqMap : rideRequestMapping) {

				for (Payment payment : paymentlist) {
					if (rideReqMap.getReq_id().intValue() == payment.getPayment_map_rr()) {
						rideReqMap.setPaymentFlag(true);
					}
				}
				for (UserRvw review : reviewlist) {
					if (rideReqMap.getReq_id().intValue() == review.getRvw_map_rr()) {
						rideReqMap.setReviewFlag(true);
					}
				}
			}
			map.put("offerRideList", offerRideList);
			map.put("rideRequestMapping", rideRequestMapping);
			map.put("paymentList", paymentlist);
			map.put("reviewList", reviewlist);
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return map;

	}

	public boolean savePaymentInformation(Payment payment) {
		try {

			beginTransaction();
			getSession().save(payment);
			commit();

			System.out.println("Here n save payment");
			System.out.println(payment.getAmount_paid());
			System.out.println(payment.getPayment_id());
			return true;
		} catch (Exception e) {
			System.out.println("Error inside saveOfferRide");
			e.printStackTrace();
			return false;
		}
	}

	public boolean saveReviewInformation(UserRvw review) {
		try {

			beginTransaction();
			getSession().save(review);
			commit();
			System.out.println("Here n save review dao");

			return true;
		} catch (Exception e) {
			System.out.println("Error inside saveReview");
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(User usr) {
		// TODO Auto-generated method stub
		try {

			beginTransaction();
			getSession().update(usr);
			commit();
			return true;
		} catch (Exception e) {
			System.out.println("Exception in editUser");
			e.printStackTrace();

		}
		return false;

	}

}
