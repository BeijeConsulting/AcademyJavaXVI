package it.beije.neumann.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;


public class OrderDTO {

	private Integer id;
	
	@JsonProperty(value = "user_id")
	private Integer userId;
	
	private LocalDateTime datetime;
	
	//@JsonIgnore
	private Double amount;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	@JsonGetter(value = "datetime")
	public String getDatetimeAsString() {
		return datetime.toString();
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	@JsonSetter(value = "datetime")
	public void setDatetime(String datetime) {
		//this.datetime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).parse(datetime);
	}

	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", userId: ").append(userId)
				.append(", datetime: ").append(datetime)
				.append(", amount: ").append(amount)
				.append("}");

		return builder.toString();
	}

}
