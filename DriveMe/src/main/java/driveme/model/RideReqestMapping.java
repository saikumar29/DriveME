package driveme.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@Entity
@Table(name = "ride_request_mapping")
public class RideReqestMapping {
	@Id
	@GeneratedValue
	@Column(name = "req_id")
	private Long req_id; // PK

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rr_map_or")
	private OfferRide rr_map_or; // foreign key, PK of OfferRide

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rr_user_id")
	private User rr_user_id; // foreign Key, PK user, requester user id

	@Transient
	private boolean paymentFlag;
	@Transient
	private boolean reviewFlag;
	/*
	 * @Transient private String rideDate;
	 * 
	 * @Transient private String rideStartPoint;
	 * 
	 * @Transient private String endPoint;
	 */
	@Transient
	private String status;

	/*
	 * @Transient private Long offererUserId; // foreign key, PK user
	 * 
	 * public Long getOffererUserId() { return offererUserId; }
	 * 
	 * public void setOffererUserId(Long offererUserId) { this.offererUserId =
	 * offererUserId; }
	 */
	public Long getReq_id() {
		return req_id;
	}

	public void setReq_id(Long req_id) {
		this.req_id = req_id;
	}

	/*
	 * public String getRideDate() { return rideDate; }
	 * 
	 * public void setRideDate(String rideDate) { this.rideDate = rideDate; }
	 * 
	 * public String getRideStartPoint() { return rideStartPoint; }
	 * 
	 * public void setRideStartPoint(String rideStartPoint) { this.rideStartPoint =
	 * rideStartPoint; }
	 * 
	 * public String getEndPoint() { return endPoint; }
	 * 
	 * public void setEndPoint(String endPoint) { this.endPoint = endPoint; }
	 */

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getRr_user_id() {
		return rr_user_id;
	}

	public void setRr_user_id(User rr_user_id) {
		this.rr_user_id = rr_user_id;
	}

	public boolean isPaymentFlag() {
		return paymentFlag;
	}

	public void setPaymentFlag(boolean paymentFlag) {
		this.paymentFlag = paymentFlag;
	}

	public boolean isReviewFlag() {
		return reviewFlag;
	}

	public void setReviewFlag(boolean reviewFlag) {
		this.reviewFlag = reviewFlag;
	}

	public OfferRide getRr_map_or() {
		return rr_map_or;
	}

	public void setRr_map_or(OfferRide rr_map_or) {
		this.rr_map_or = rr_map_or;
	}

	@Override
	public String toString() {
		return "RideReqestMapping [req_id=" + req_id + ", rr_map_or=" + rr_map_or + ", rr_user_id=" + rr_user_id
				+ ", paymentFlag=" + paymentFlag + ", reviewFlag=" + reviewFlag + ", status=" + status + "]";
	}

	/*
	 * @Override public String toString() { return "RideReqestMapping [req_id=" +
	 * req_id + ", rr_map_or=" + rr_map_or + ", rr_user_id=" + rr_user_id +
	 * ", paymentFlag=" + paymentFlag + ", reviewFlag=" + reviewFlag + ", status=" +
	 * status + ", offererUserId=" + offererUserId + "]"; }
	 */

}
