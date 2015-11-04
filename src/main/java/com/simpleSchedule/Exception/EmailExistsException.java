package com.simpleSchedule.Exception;

/**
 * Created by SteveGreen on 10/10/15.
 */
@SuppressWarnings("serial")
public class EmailExistsException extends Throwable{

    public EmailExistsException(final String message){
        super(message);
    }
}
