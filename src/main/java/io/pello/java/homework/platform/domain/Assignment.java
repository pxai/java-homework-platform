package io.pello.java.homework.platform.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public  class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Lob
	private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date due;
	@ManyToOne
	private User user;
}
