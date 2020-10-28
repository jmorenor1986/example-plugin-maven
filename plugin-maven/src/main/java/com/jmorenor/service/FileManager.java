package com.jmorenor.service;

import java.util.Optional;

public interface FileManager {
    Optional<Boolean> writeFile(String text, String name, String folder);
}
