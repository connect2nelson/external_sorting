package com.fun.exterrnalSorting;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class IntegerListSorter {


    private List<Integer> integers;
    private String sortedFileName;

    public IntegerListSorter(List<Integer> integers, String sortedFileName) {

        this.integers = integers;
        this.sortedFileName = sortedFileName;
    }

    public void sortAndSave() throws IOException {

        Collections.sort(integers);

        FileUtils.writeLines(new File(sortedFileName), "UTF-8", integers);
    }
}
