package com.jmorenor.service;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;
import com.jmorenor.dto.EventDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MustacheCreateTest {
    private MustacheCreate mustacheCreate;

    @Before
    public void init() {
        mustacheCreate = new MustacheCreateImpl();
    }

    @Test
    public void testWithTemplateSuccess() {
        Map<String, List<String>> mapExample = new HashMap<>();
        mapExample.put("indexes", List.of("example"));
        EventDto eventDto = new EventDto();
        eventDto.setIndexes(mapExample);
        Optional<String> result = mustacheCreate.generateTemplate("templates/index.mustache", eventDto);
        Assert.assertNotNull(result);
        Assert.assertEquals(true, result.get().contains("example"));

    }
}
