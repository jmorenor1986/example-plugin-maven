package com.jmorenor.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class FileManagerImpl implements FileManager {
    @Override
    public Optional<Boolean> writeFile(String text, String name, String folder) {
        try {
            Files.write(Paths.get(folder.concat(File.separator).concat(name)), text.getBytes());
            return Optional.of(Boolean.TRUE);
        } catch (IOException e) {
            return Optional.of(Boolean.FALSE);
        }
    }
}
