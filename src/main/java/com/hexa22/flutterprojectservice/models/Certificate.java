package com.hexa22.flutterprojectservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="certificates")
public class Certificate {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_creator_id", referencedColumnName = "id")
    private User userCreator;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_judge_id", referencedColumnName = "id")
    private User userJudge;

    @NotNull
    @Column(name="amount_hours")
    private LocalTime amountHours;

    @NotNull
    @Column(name="document")
    private String document;

    @NotNull
    @Column(name="description")
    private String description;

    @NotNull
    @Column(name="status")
    private char status;

    @Column(name="date_creation")
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDate dateCreation;
}
