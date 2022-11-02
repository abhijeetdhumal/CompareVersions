package com.sojern.util;

public class VersionComparator {

    public int compare(String v1, String v2) throws Exception {
        if (v1 == null || v1.isEmpty() || v2 == null || v2.isEmpty())
            throw new Exception("Input is empty");

        if (v1.equals(v2))
            return 0;

        String [] v1Array = v1.split("\\.");
        String [] v2Array = v2.split("\\.");

        int v1Len = v1Array.length;
        int v2Len = v2Array.length;
        int i = 0;
        int j = 0;
        int v1Val = 0;
        int v2Val = 0;

        while(i < v1Len || j < v2Len) {
            // Compare if length exceeds in either v1 or v2 and assign 0 if it exceeds
            try {
                v1Val = i >= v1Len ? 0 : Integer.valueOf(v1Array[i]);
                v2Val = j >= v2Len ? 0 : Integer.valueOf(v2Array[j]);
            }catch(NumberFormatException e) {
                throw new NumberFormatException("Please enter a valid number");
            }
            if(v1Val < v2Val)
                return -1;
            else if(v1Val > v2Val)
                return 1;
            i++;
            j++;
        }

        return 0;
    }
}
