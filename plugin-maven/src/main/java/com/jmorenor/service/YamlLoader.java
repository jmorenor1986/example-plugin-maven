package com.jmorenor.service;

import java.util.Optional;

public interface YamlLoader {
    Optional<Object> readYaml(String s);
}
