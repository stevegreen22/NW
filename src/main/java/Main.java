import com.nakedwines.dao.AppointmentDaoImpl;
import com.nakedwines.model.Appointment;

import java.util.List;

/**
 * Created by SteveGreen on 15/10/15.
 */
public class Main {

    public static void main(String[] args) {

        Appointment appointment = new Appointment();
        appointment.setDescription("Pankaj");

        AppointmentDaoImpl personDao = new AppointmentDaoImpl();

        personDao.persistAppointment(appointment);

        System.out.println("Person::"+ appointment);

        List<Appointment> list = personDao.getAppointmentlist();

        for(Appointment p : list){
            System.out.println("Person List::"+p);
        }

    }
}
