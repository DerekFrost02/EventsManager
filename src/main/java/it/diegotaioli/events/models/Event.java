package it.diegotaioli.events.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name="events")
public class Event {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "name required")
	@Size(min = 3, message = "name too short")
	private String name;
	
	@JoinColumn(name = "place_id")
	@ManyToOne
	@JsonIdentityInfo(
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id"
	)
	private Place place;
	
	private String description;
	
	@NotNull(message = "date required")
	private LocalDateTime date;
	
	@NotNull(message = "guests required")
	private int guests;
	
	@ManyToMany
	@JoinTable(
			name = "event_member",
			joinColumns = @JoinColumn(name = "event_id"),
			inverseJoinColumns = @JoinColumn(name = "member_id")
	)
	private List<Member> members;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private LocalDateTime updatedAt;
	
}
