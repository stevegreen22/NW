package com.nakedwines.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by SteveGreen on 15/10/15.
 */
@Entity
@Table(name="appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int appId;

//    @NotNull leaving validation to be done by the validator instead
    private String title;
    private String description;

    @DateTimeFormat(pattern = "dd/MM/yyyy")// with this we can't convert the date
    private Date theDate;

    @DateTimeFormat(pattern = "HH:mm")
    private Date startTime;

    @DateTimeFormat(pattern = "HH:mm")
    private Date endTime;


    @Transient
    private int duration;


    private AppointmentType appointmentType;

    public Date getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Appointment(){}

    //time and duration not inclusive as may be empty.
    public Appointment(String title, String description, Date theDate, AppointmentType appointmentType) {
        this.title = title;
        this.description = description;
        this.theDate = theDate;
        this.appointmentType = appointmentType;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    public Date getTheDate() {
        return theDate;
    }

    public void setTheDate(Date theDate) {
        this.theDate = theDate;
    }

    public int getAppId() {
        return appId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





}