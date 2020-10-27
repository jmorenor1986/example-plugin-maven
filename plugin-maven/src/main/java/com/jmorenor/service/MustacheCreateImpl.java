package com.jmorenor.service;

import com.github.mustachejava.Mustache;
import com.jmorenor.dto.EventDto;
import com.jmorenor.util.MustacheUtil;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MustacheCreateImpl implements MustacheCreate {

    @Override
    public Optional<String> generateTemplate(String nameTemplate, EventDto eventDto) {
        Mustache m = MustacheUtil.getMustacheFactory().compile(nameTemplate);
        Map<String, Object> context = new HashMap<>();
        context.put("event", eventDto);
        return executeTemplate(m, context);
    }

    private Optional<String> executeTemplate(Mustache m, Map<String, Object> context) {
        try {
            StringWriter writer = new StringWriter();
            m.execute(writer, context).flush();
            return Optional.of(writer.toString());
        } catch (IOException exc) {
            return Optional.empty();
        }

    }
}
