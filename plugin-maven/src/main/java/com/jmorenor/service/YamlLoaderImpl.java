package com.jmorenor.service;

import com.jmorenor.dto.EventDto;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;

import java.util.NoSuchElementException;
import java.util.Optional;

public class YamlLoaderImpl implements YamlLoader {

    private Yaml yaml;

    public YamlLoaderImpl(Yaml yaml) {
        this.yaml = yaml;
    }

    @Override
    public Optional<EventDto> readYaml(String nameFile) {
        try {
            return Optional.of(yaml.load(this.getClass()
                    .getClassLoader()
                    .getResourceAsStream(nameFile)));
        } catch (YAMLException ex) {
            return Optional.empty();
        }

    }
}
