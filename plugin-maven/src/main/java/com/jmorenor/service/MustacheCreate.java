package com.jmorenor.service;

import com.jmorenor.dto.EventDto;

import java.util.Optional;

public interface MustacheCreate {
    Optional<String> generateTemplate(String nameTemplate, EventDto eventDto);
}
