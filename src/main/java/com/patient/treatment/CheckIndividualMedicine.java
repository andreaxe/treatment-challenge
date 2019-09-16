package com.patient.treatment;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds the results for the medicine that is single administered to a given patient
 * @todo in a scenario where multiple if's are required for each treatment change to a switch structure
 * NOTE: this is the last element of the chain.
 */
public class CheckIndividualMedicine implements TreatmentChain{

    private TreatmentChain nextChain;
    private static final double CHANCES_SPAGHETTI_MONSTER = 1.0/1000000;

    private boolean checkForSpaghettiMonster(PatientState patientState,OutputParser output){

        if(patientState.equals(PatientState.DEATH)){
             if(Math.random() <= CHANCES_SPAGHETTI_MONSTER){
                 output.updatePatientState(PatientState.HEALTH);
                 return true;
             }
        }
        return false;
    }
    private boolean checkForAspirin(PatientState patientState, List<Medicine> medicine, OutputParser output){

        if(patientState.equals(PatientState.FEVER) && medicine.contains(Medicine.ASPIRIN)){
            output.updatePatientState(PatientState.HEALTH);
            return true;
        }
        return false;
    }

    private boolean checkForParacetamol(PatientState patientState, List<Medicine> medicine, OutputParser output){

        if(patientState.equals(PatientState.FEVER) && medicine.contains(Medicine.PARACETAMOL)){
            output.updatePatientState(PatientState.HEALTH);
            return true;
        }
        return false;
    }

    private boolean checkForAntibiotic(PatientState patientState, List<Medicine> medicine, OutputParser output){

        if(patientState.equals(PatientState.TUBERCULOSIS) && medicine.contains(Medicine.ANTIBIOTIC)){
            output.updatePatientState(PatientState.HEALTH);
            return true;
        }
        return false;
    }

    private boolean checkForInsulin(PatientState patientState, List<Medicine> medicine, OutputParser output)
    {
        if(patientState.equals(PatientState.DIABETES)){
            if(medicine.contains(Medicine.INSULIN)){
                output.updatePatientState(PatientState.DIABETES);
                return true;
            } else {
                // without insulin the patient dies
                output.updatePatientState(PatientState.DEATH);
                return true;
            }
        }
        return false;
    }

    public void checkForTreatment(PatientState patientState, List<Medicine> medicine, OutputParser output){

        List<Boolean> treatments = new ArrayList<>();
        treatments.add(checkForAspirin(patientState, medicine, output));
        treatments.add(checkForInsulin(patientState, medicine, output));
        treatments.add(checkForParacetamol(patientState, medicine, output));
        treatments.add(checkForAntibiotic(patientState, medicine, output));
        treatments.add(checkForSpaghettiMonster(patientState, output));

        for (Boolean treatmentAdministered : treatments) {
            if(treatmentAdministered){
                return;
            }
        }

        // If no treatment was administered update the initial patient state
        output.updatePatientState(patientState);

        // in case you add other class to the chain that will be processed after this one
        if(nextChain != null){
            nextChain.checkForTreatment(patientState, medicine, output);
        }

    }
    public void setNextChain(TreatmentChain nextChain){
        this.nextChain = nextChain;
    }
}
