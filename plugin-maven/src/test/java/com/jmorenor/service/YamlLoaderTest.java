package com.jmorenor.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class YamlLoaderTest {
    private YamlLoader yamlLoader;

    @Before
    public void setUp() {
        yamlLoader = new YamlLoaderImpl();
    }

    @Test
    public void testReadYamlSuccess() {
        Optional<Object> result = yamlLoader.readYaml("yaml/yaml-test.yaml");
        Assert.assertNotNull(result);
    }
}
