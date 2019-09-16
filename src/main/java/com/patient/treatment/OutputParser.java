package com.patient.treatment;

import java.util.HashMap;
import java.util.stream.Collectors;


public class OutputParser {

    private HashMap<PatientState, Integer> outputPatientState = new HashMap<>();

    void updatePatientState(PatientState newState){
        outputPatientState.put(newState, getHashMapKeyCount(newState) + 1);
    }

    private Integer getHashMapKeyCount(PatientState patientState){
        return outputPatientState.getOrDefault(patientState, 0);
    }

    private void setMissingStatesToOutput(){
        for (PatientState patientState : PatientState.patientStateHashMap().values()) {
            if(!outputPatientState.containsKey(patientState)){
                outputPatientState.put(patientState, 0);
            }
        }
    }

    @Override
    public String toString() {
        setMissingStatesToOutput();
        return outputPatientState.keySet().stream()
                .map(key -> key.getValue() + ":" + outputPatientState.get(key))
                .collect(Collectors.joining(","));
    }
}
