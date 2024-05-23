package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	private DoctorEntity doctor; // wiele wizyt moze byc przypisanych dla jednego doktora

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private PatientEntity patient; // wiele wizyt moze byc przypisanych do jednego pacjenta

	@OneToMany(mappedBy = "visit", cascade = CascadeType.ALL)
	private List<MedicalTreatmentEntity> treatments = new ArrayList<>(); // jedna wizyta moze miec wiele lekarstw v zabiegow

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}
