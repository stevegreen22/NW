package com.nakedwines.model;

//Inner enum class, doesn't need to be exposed anywhere else.
    //Would be nice to use an enum in postgres but...much heartache.
    public enum AppointmentType {

        //values stored in properties, does require updating both if
        //changes are made but useful for mutliple languages.
        MEETING("AppointmentType.Meeting"),
        HOME("AppointmentType.Home"),
        DENTIST("AppointmentType.Dentist"),
        XYZ("AppointmentType.XYZ"),
        ABC("AppointmentType.ABC");

        private final String displayName;

        AppointmentType(String displayName){
            this.displayName = displayName;
        }

        public String getDisplayName(){
            return displayName;
        }
    }