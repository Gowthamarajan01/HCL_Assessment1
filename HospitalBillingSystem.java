import java.util.Scanner;

abstract class Doctor {
    protected double consultationCharge;

    Doctor(double consultationCharge) {
        this.consultationCharge = consultationCharge;
    }

    public abstract String getDoctorType();

    public double calculateTotalBill(double testCharges) {
        return consultationCharge;
    }

    public double getConsultationCharge() {
        return consultationCharge;
    }
}

class GeneralPhysician extends Doctor {
    GeneralPhysician() {
        super(500.0);
    }

    @Override
    public String getDoctorType() {
        return "General Physician";
    }
}

class Specialist extends Doctor {
    Specialist() {
        super(1000.0);
    }

    @Override
    public String getDoctorType() {
        return "Specialist";
    }
}

class EmergencyDoctor extends Doctor {
    EmergencyDoctor() {
        super(1500.0);
    }

    @Override
    public String getDoctorType() {
        return "Emergency Doctor";
    }

    @Override
    public double calculateTotalBill(double testCharges) {
        return consultationCharge + testCharges;
    }
}

public class HospitalBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int doctorType = sc.nextInt();
        double testCharges = sc.nextDouble();

        Doctor doctor;
        switch (doctorType) {
            case 1:
                doctor = new GeneralPhysician();
                break;
            case 2:
                doctor = new Specialist();
                break;
            default:
                doctor = new EmergencyDoctor();
        }

        System.out.println("Doctor Type: " + doctor.getDoctorType());
        System.out.printf("Consultation Charge: %.2f%n",
                doctor.getConsultationCharge());
        System.out.printf("Test Charges: %.2f%n", testCharges);
        System.out.printf("Total Bill: %.2f%n",
                doctor.calculateTotalBill(testCharges));

        sc.close();
    }
}
