package com.fun.exterrnalSorting;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedFilesCombinerTest {

    @ClassRule
    public static TemporaryFolder temporaryFolder = new TemporaryFolder();

    private List<File> filesList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        File file1 = new File("integerList1.txt");
        FileUtils.writeLines(file1, Arrays.asList(1,3,5,7));
        File file2 = new File("integerList2.txt");
        FileUtils.writeLines(file2, Arrays.asList(2,4,6,8));

        filesList= new ArrayList<>();
        filesList.add(file1);
        filesList.add(file2);
    }

    @Test
    public void shouldMergeSortedFileAndCreateANewSortedMergedFile() throws Exception {

        String sortedFileName = temporaryFolder.getRoot().getAbsolutePath() + File.separator + "sorted.bin";
        SortedFilesCombiner sortedFilesCombiner = new SortedFilesCombiner(filesList, sortedFileName);

        sortedFilesCombiner.mergeAndSave();

        File sortedFile = new File(sortedFileName);
        assertThat(sortedFile).isFile();

        List<String> strings = FileUtils.readLines(sortedFile);
        assertThat(strings).hasSize(8);
    }
}