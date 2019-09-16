package com.patient.treatment;

import java.util.*;
import java.util.stream.Stream;

enum Medicine {

    ASPIRIN("As"),
    PARACETAMOL("P"),
    ANTIBIOTIC("An"),
    INSULIN("I");

    private String value;

    Medicine(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }

    static Stream<Medicine> stream() {
        return Stream.of(Medicine.values());
    }

    static List<Medicine> getListOfMedicine(){
        return Arrays.asList(Medicine.values());
    }

    static Map<String, Medicine> medicineHashMap(){

        Map<String, Medicine> medicineHashMap = new HashMap<String, Medicine>();
        for (Medicine medicine : Medicine.values()) {
            medicineHashMap.put(medicine.getValue(), medicine);
        }
        return medicineHashMap;
    }

    public static boolean valueOfLabelExists(String label) {
        for (Medicine e : values()) {
            if (e.value.equals(label)) {
                return true;
            }
        }
        return false;
    }
}
