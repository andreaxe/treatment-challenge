package com.patient.treatment;

import java.util.List;

public interface TreatmentChain {

    void setNextChain(TreatmentChain nextChain);
    void checkForTreatment(PatientState patientState, List<Medicine> medicine, OutputParser output);
}
