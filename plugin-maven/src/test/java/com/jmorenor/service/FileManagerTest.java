package com.jmorenor.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class FileManagerTest {
    private FileManager fileManager;

    @Before
    public void setUp() {
        fileManager = new FileManagerImpl();
    }

    @Test
    public void testWriteFileSuccess() {
        Optional<Boolean> result = fileManager.writeFile("== Included Section\n" +
                "\n" +
                "Look, I came from out of the [blue]#blue#!\n" +
                "\n" +
                "--\n" +
                "I'm keepin' it open.\n" +
                "\n" +
                "An 'open block', like this one, can contain other blocks.\n" +
                "\n" +
                "It can also act as any other block. (TODO)\n" +
                "--", "test.adoc", "src/test/resources/adoc");
        Assert.assertEquals(Boolean.TRUE, result.get());
    }

    @Test
    public void testWriteFileErrorFolder(){
        Optional<Boolean> result = fileManager.writeFile("", "test.adoc", "src/test/resources/no-adoc");
        Assert.assertEquals(Boolean.FALSE,result.get());
    }

}
