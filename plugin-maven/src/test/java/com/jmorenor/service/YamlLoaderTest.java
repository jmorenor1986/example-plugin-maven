package com.jmorenor.service;

import com.jmorenor.dto.EventDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

import java.util.Optional;

public class YamlLoaderTest {
    private YamlLoader yamlLoader;

    @Before
    public void setUp() {
        Representer representer = new Representer();
        representer.getPropertyUtils().setSkipMissingProperties(true);
        yamlLoader = new YamlLoaderImpl(new Yaml(new Constructor(EventDto.class), representer));
    }

    @Test
    public void testReadYamlSuccess() {
        Optional<EventDto> result = yamlLoader.readYaml("yaml/yaml-test.yaml");
        Assert.assertEquals(1, result.get().getFields().size());
    }

    @Test
    public void testReadYamlWithOutFile() {
        Optional<EventDto> result = yamlLoader.readYaml("yaml/yaml-test-not-exist.yaml");
        Assert.assertEquals(Optional.empty(), result);
    }

    @Test
    public void testReadYamlWithOutParameter() {
        Optional<EventDto> result = yamlLoader.readYaml("yaml/yaml-test-without-parameter.yaml");
        Assert.assertEquals(1, result.get().getIndexes().size());
    }

    @Test
    public void testReadYamlParamTypeDiferent(){
        Optional<EventDto> result = yamlLoader.readYaml("yaml/yaml-test-parameter-type.yaml");
        Assert.assertEquals(Optional.empty(), result);
    }
}
