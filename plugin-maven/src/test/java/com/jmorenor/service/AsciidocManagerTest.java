package com.jmorenor.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class AsciidocManagerTest {

    private AsccidocManager asccidocManager;

    @Before
    public void setUp() {
        asccidocManager = new AsccidocManagerImpl();
    }

    @Test
    public void testAsciidocSuccess() {
        Optional<String> result = asccidocManager.convertToHTML("src/test/resources/adoc/test.adoc");
        Assert.assertNotNull(result);
    }


}
