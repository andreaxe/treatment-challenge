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

    private void setPatientStateToOutput(){
        for (PatientState key :PatientState.patientStateHashMap().values()) {
            if(!outputPatientState.containsKey(key)){
                outputPatientState.put(key, 0);
            }
        }
    }

    @Override
    public String toString() {
        setPatientStateToOutput();
        return outputPatientState.keySet().stream()
                .map(key -> key.getValue() + ":" + outputPatientState.get(key))
                .collect(Collectors.joining(","));
    }
}
