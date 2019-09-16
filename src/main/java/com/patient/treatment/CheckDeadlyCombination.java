package com.patient.treatment;

import java.util.List;

/**
 * This class holds combinations of medicines that can be harmful to the patient
 */
public class CheckDeadlyCombination implements TreatmentChain {

    private TreatmentChain nextInChain;

    /**
     * In this method the patientState is immediately updated and the method returns true if matches
     * The chain execution will be dropped
     * @param medicine List<{@link Medicine>}
     * @param output {@link OutputParser}
     * @return boolean
     */
    private boolean checkForAspirinMixedWithParacetamol(List<Medicine> medicine, OutputParser output){
        if(medicine.contains(Medicine.ASPIRIN) && medicine.contains(Medicine.PARACETAMOL)){
            output.updatePatientState(PatientState.DEATH);
            return true;
        }
        return false;
    }

    public void checkForTreatment(PatientState patientState, List<Medicine> medicine, OutputParser output){

        // Patient died - there's no need to proceed in the chain
        if(checkForAspirinMixedWithParacetamol(medicine, output)){
            return;
        }
        nextInChain.checkForTreatment(patientState, medicine, output);
    }
    public void setNextChain(TreatmentChain nextChain){
        this.nextInChain = nextChain;
    }
}
