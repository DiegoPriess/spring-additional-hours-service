package com.hexa22.flutterprojectservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="certificates")
public class Certificate {

    private static final long serialVersionUID = 1L;

    public static synchronized Certificate create() {
        return new Certificate();
    }

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
    @Temporal(value = TemporalType.DATE)
    private Calendar dateCreation;

    public Certificate withUserCreator(User userCreator) {
        this.userCreator = userCreator;
        return this;
    }

    public Certificate withUserJudge(User userJudge) {
        this.userJudge = userJudge;
        return this;
    }

    public Certificate withAmountHours(LocalTime amountHours) {
        this.amountHours = amountHours;
        return this;
    }

    public Certificate withDocument(String document) {
        this.document = document;
        return this;
    }

    public Certificate withDescription(String description) {
        this.description = description;
        return this;
    }

    public Certificate withStatus(char status) {
        this.status = status;
        return this;
    }

    public Certificate withDateCreation(Calendar dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }
}
