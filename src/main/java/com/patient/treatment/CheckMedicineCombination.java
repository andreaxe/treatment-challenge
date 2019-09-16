package com.patient.treatment;

import java.util.List;

public class CheckMedicineCombination implements TreatmentChain{

    private TreatmentChain nextChain;

    public void setNextChain(TreatmentChain nextChain){
        this.nextChain = nextChain;
    }

    private boolean CheckForInsulinMixedWithAntibiotic(PatientState patientState,
                                                    List<Medicine> medicines,
                                                    OutputParser output)
    {
        if(patientState.equals(PatientState.HEALTH)){
            if(medicines.contains(Medicine.INSULIN) && medicines.contains(Medicine.ANTIBIOTIC)) {
                output.updatePatientState(PatientState.FEVER);
                return true;
            }
        }
        return false;
    }
    public void checkForTreatment(PatientState patientState, List<Medicine> medicines, OutputParser output){

        if(CheckForInsulinMixedWithAntibiotic(patientState, medicines, output)){
            return;
        }
        this.nextChain.checkForTreatment(patientState, medicines, output);
    }
}
