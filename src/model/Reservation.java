package model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Reservation {
	@Id
	private int IdReservation;
	private int Room;
	private int User;
	private LocalDateTime BeginTime;
	private LocalDateTime EndTime;

	/**
	 * @return
	 */
	public int getIdReservation() {
		return IdReservation;
	}

	/**
	 * @param idReservation
	 */
	public void setIdReservation(int idReservation) {
		IdReservation = idReservation;
	}

	/**
	 * @return
	 */
	public LocalDateTime getBeginTime() {
		return BeginTime;
	}

	/**
	 * @return
	 */
	public String getBeginTimeString() {
		return this.LDTtoString(BeginTime);
	}

	/**
	 * @param beginTime
	 */
	public void setBeginTime(LocalDateTime beginTime) {
		BeginTime = beginTime;
	}

	/**
	 * @param beginTime
	 */
	public void setBeginTimeString(String beginTime) {
		BeginTime = this.stringToLDT(beginTime);
	}

	/**
	 * @return
	 */
	public LocalDateTime getEndTime() {
		return EndTime;
	}

	/**
	 * @return
	 */
	public String getEndTimeString() {
		return this.LDTtoString(EndTime);
	}

	/**
	 * @param endTime
	 */
	public void setEndTime(LocalDateTime endTime) {
		EndTime = endTime;
	}

	/**
	 * @param endTime
	 */
	public void setEndTimeString(String endTime) {
		EndTime = this.stringToLDT(endTime);
	}

	/**
	 * @return
	 */
	public int getRoom() {
		return Room;
	}

	/**
	 * @param room
	 */
	public void setRoom(int room) {
		Room = room;
	}

	/**
	 * @return
	 */
	public int getUser() {
		return User;
	}

	/**
	 * @param user
	 */
	public void setUser(int user) {
		User = user;
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