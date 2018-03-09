package ru.frechman.department;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SortDepartment {

    private Set<String> sort(String[] unsortedDepartment) {
        Set<String> result = new TreeSet<>();
        String[] bufferSplit;
        for (String strike : unsortedDepartment) {
            bufferSplit = strike.split("\\\\");
            StringBuilder sb = new StringBuilder();
            for (String aBufferSplit : bufferSplit) {
                sb.append(aBufferSplit);
                result.add(sb.toString());
                sb.append("\\");
            }
        }
        return result;
    }

    public String[] sortInAscendingOrder(String[] unsortedDepartment) {
        Set<String> result = new TreeSet<>(sort(unsortedDepartment));

        return result.toArray(new String[0]);
    }

    public String[] sortInDescendingOrder(String[] unsortedDepartment) {
        Comparator<String> de = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] deps1 = o1.split("\\\\");
                String[] deps2 = o2.split("\\\\");
                // Minimum department length.
                int dlm = Math.min(deps1.length, deps2.length);
                int res = 0;
                for (int i = 0; i < dlm; i++) {
                    // 1. Сравниваем департаменты, находящиеся на одном уровне.
                    // 1. Comparing of departments that are on the same level.
                    if (!deps1[i].equals(deps2[i])) {
                        if (i > 0) {
                            res = deps1[i].compareTo(deps2[i]);
                        } else {
                            res = deps2[i].compareTo(deps1[i]);
                        }
                        break;
                    } else {
                        // 2. Сравниваем по длине массивы: с меньшей длиной - выше.
                        // 2. If all departments are matched on all leves then
                        // its comparing by length.
                        res = deps1.length - deps2.length;
                    }
                }

                return res;
            }
        };

        Comparator<String> descOrder = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;

                int length = o1.length() - o2.length();

                if (!o1.startsWith(o2)) {

                }

                return 0;
            }
        };
        Set<String> result = new TreeSet<>(de);

        result.addAll(sort(unsortedDepartment));

        System.out.println(result);

        return result.toArray(new String[0]);
    }
}
