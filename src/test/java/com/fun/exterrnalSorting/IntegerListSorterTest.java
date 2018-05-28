package com.fun.exterrnalSorting;

import org.apache.commons.io.FileUtils;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class IntegerListSorterTest {

    @ClassRule
    public static TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void shouldSortAndSaveListOfIntegersIntoAfile() throws Exception {

        //Arrange
        List<Integer> integers = Arrays.asList(10, 2, 3, 4, 8, 6);
        List<Integer> expectedSortedIntegers = Arrays.asList(10, 2, 3, 4, 8, 6);

        Collections.sort(expectedSortedIntegers);
        String sortedFileName = temporaryFolder.getRoot().getAbsolutePath() + File.separator + "sorted.bin";

        //Act
        IntegerListSorter integerListSorter = new IntegerListSorter(integers, sortedFileName);
        integerListSorter.sortAndSave();

        //Assert
        checkWhetherFileContentIsSorted(expectedSortedIntegers, sortedFileName);

    }

    private void checkWhetherFileContentIsSorted(List<Integer> expectedSortedIntegers, String sortedFileName) throws IOException {
        File sortedListFile = new File(sortedFileName);
        assertThat(sortedListFile).isFile();

        List<String> lines = FileUtils.readLines(new File(sortedFileName), "utf-8");

        assertThat(lines).hasSize(6);

        List<Integer> actualSortedLines = getIntegersFromListOfStrings(lines);

        assertThat(actualSortedLines).isEqualTo(expectedSortedIntegers);
    }

    private List<Integer> getIntegersFromListOfStrings(List<String> lines) {
        return lines.stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}