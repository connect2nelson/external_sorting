package com.fun.exterrnalSorting;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class SortedFilesCombiner {


    private List<File> filesList;
    private String sortedFileName;

    public SortedFilesCombiner(List<File> filesList, String sortedFileName) {

        this.filesList = filesList;
        this.sortedFileName = sortedFileName;
    }

    public void mergeAndSave() {

        File sortedFile = new File(sortedFileName);

        filesList.forEach(file -> {
            try {
                List<String> strings = FileUtils.readLines(file);

                strings.forEach(s -> {
                            try {
                                FileUtils.writeStringToFile(sortedFile, s + "\r\n", StandardCharsets.UTF_8, true);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        );
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }


}
