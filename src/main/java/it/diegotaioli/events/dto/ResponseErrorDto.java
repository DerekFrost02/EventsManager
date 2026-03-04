package it.diegotaioli.events.dto;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class ResponseErrorDto<T> {
	
	private T message;
	private HttpStatus status;
	private LocalDate errorTime;
	
	public ResponseErrorDto(T message, HttpStatus status) {
		this.message = message;
		this.status = status;
		this.errorTime = LocalDate.now();
	}

}
