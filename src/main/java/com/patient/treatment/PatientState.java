package com.patient.treatment;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

enum PatientState {

    FEVER("F"),
    HEALTH("H"),
    DIABETES("D"),
    TUBERCULOSIS("T"),
    DEATH("X");

    private String value;

    PatientState(String value){
        this.value = value;
    }
    static String getLabel(){
        return  "PatientState";
    }

    public String getValue(){
        return value;
    }

    static Stream<PatientState> stream() {
        return Stream.of(PatientState.values());
    }

    static Map<String, PatientState> patientStateHashMap(){

        Map<String, PatientState> patientStateHashMap = new HashMap<String, PatientState>();
        for (PatientState condition : PatientState.values()) {
            patientStateHashMap.put(condition.getValue(), condition);
        }
        return patientStateHashMap;
    }
}
