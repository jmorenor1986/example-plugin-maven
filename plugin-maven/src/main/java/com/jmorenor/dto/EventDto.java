package com.jmorenor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class EventDto {
    private Map<String, List<String>> indexes;
    private Map<String, List<String>> fields;
}
