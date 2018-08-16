package ru.frechman.department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepartmentSort {


    private List<String> departments = new ArrayList<>();

    public String[] sortAscOrder(String[] unsorted) {
        this.departments.addAll(Arrays.asList(unsorted));
        this.departments.sort(Comparator.naturalOrder());


        return this.departments.toArray(new String[0]);
    }

    public String[] sortDescOrder(String[] unsorted) {


        return null;
    }


    Comparator<String> sortAsc = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            int res = 0;
            if (s1.length() > s2.length()) {
                //res =
            }
            return 0;
        }
    };


}
