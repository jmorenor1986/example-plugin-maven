package com.jmorenor.service;

import com.jmorenor.dto.EventDto;

import java.util.Optional;

public interface YamlLoader {
    Optional<EventDto> readYaml(String s);
}
