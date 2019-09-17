package com.patient.treatment;

import java.util.List;

public interface TreatmentChain {

    void setNextInChain(TreatmentChain nextInChain);
    void checkForTreatment(PatientState patientState, List<Medicine> medicine, OutputParser output);
}
