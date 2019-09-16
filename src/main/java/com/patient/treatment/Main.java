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

        String patientStatus = "F,H,D,T,D,D,T,F,D,X,X,T,F,F,H,T,F,F,T";
        String medicine = "As,P";

        InputParser inputArgs = new InputParser(patientStatus, medicine);
        List<PatientState> patientStates = inputArgs.listOfPatientStates();
        List<Medicine> medicineProvided = inputArgs.listOfMedicineProvided();

        Main.executeTreatment(patientStates, medicineProvided);
    }
}

