package com.patient.treatment;

import java.util.*;

public class Main {

    private static void executeTreatment(List<PatientState> patientStates, List<Medicine> medicines){

        OutputParser output = new OutputParser();
        CheckDeadlyCombination c1 = new CheckDeadlyCombination();
        CheckMedicineCombination c2 = new CheckMedicineCombination();
        CheckIndividualMedicine c3 = new CheckIndividualMedicine();
        c1.setNextChain(c2);
        c2.setNextChain(c3);

        for(PatientState patientState : patientStates){
            c1.checkForTreatment(patientState, medicines, output);
        }

        System.out.println(output.toString());
    }

    public static void main(String[] args) {

        // @todo a more complex args verification with regex must be developed
        if (args.length == 0 || args.length == 1) {
            System.out.println("The patient states and medicines must be provided as arguments!");
            return;
        }

        InputParser inputArgs = new InputParser(args[0], args[1]);
        List<PatientState> patientStates = inputArgs.listOfPatientStates();
        List<Medicine> medicineProvided = inputArgs.listOfMedicineProvided();

        Main.executeTreatment(patientStates, medicineProvided);
    }
}

