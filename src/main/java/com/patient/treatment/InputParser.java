package com.patient.treatment;

import java.util.*;

class InputParser {

    private String patientStatesArg;
    private String medicinesArg;

    InputParser(String patientStatesArg, String medicinesArg){
        this.patientStatesArg = patientStatesArg;
        this.medicinesArg = medicinesArg;
    }

    List<PatientState> listOfPatientStates(){
        List<String> input = convertToArr(patientStatesArg);
        List<PatientState> patientStates = new ArrayList<>();

        Map<String, PatientState> patientStateHashMap = PatientState.patientStateHashMap();
        for(String condition: input)
        {
            if(patientStateHashMap.containsKey(condition)){
                patientStates.add(patientStateHashMap.get(condition));
            }
        }
        return patientStates;
    }

    List<Medicine> listOfMedicineProvided(){

        List<String> input = convertToArr(medicinesArg);
        List<Medicine> medicineProvided = new ArrayList<>();

        Map<String, Medicine> medicineHashMap = Medicine.medicineHashMap();
        for(String medicine: input)
        {
            if(medicineHashMap.containsKey(medicine)){
                medicineProvided.add(medicineHashMap.get(medicine));
            }
        }
        return medicineProvided;
    }

    private String capitalizeFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private List<String> convertToArr(String input){
        List<String> items = Arrays.asList(input.split("\\s*,\\s*"));
        for (int i = 0; i < items.size(); i++) {
            items.set(i, capitalizeFirstLetter(items.get(i)));
        }
        return items;
    }
}
