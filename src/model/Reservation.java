package model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Reservation")
public class Reservation {
	@Id
	private int IdReservation;

	@ManyToOne
	private Room room;
	@ManyToOne
	private User user;
	private LocalDateTime BeginTime;
	private LocalDateTime EndTime;

	public int getIdReservation() {
		return IdReservation;
	}

	public void setIdReservation(int idReservation) {
		IdReservation = idReservation;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getBeginTime() {
		return BeginTime;
	}

	public void setBeginTime(LocalDateTime beginTime) {
		BeginTime = beginTime;
	}

	public LocalDateTime getEndTime() {
		return EndTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		EndTime = endTime;
	}

	/**
	 * @param datetime
	 * @return LDT
	 */
	public LocalDateTime stringToLDT(String datetime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime LDT = LocalDateTime.parse(datetime, formatter);
		return LDT;
	}

	/**
	 * @param ldt
	 * @return formattedDateTime
	 */
	public String LDTtoString(LocalDateTime ldt) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = ldt.format(formatter);
		return formattedDateTime;
	}

	@Override
	public String toString() {
		return "Reservation{" + "IdReservation=" + IdReservation + ", BeginTime=" + BeginTime + ", EndTime=" + EndTime
				+ '}';
	}
}