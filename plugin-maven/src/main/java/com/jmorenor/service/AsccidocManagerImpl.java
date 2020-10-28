package com.jmorenor.service;

import org.asciidoctor.Options;
import org.asciidoctor.SafeMode;

import java.io.File;
import java.util.Optional;

import static org.asciidoctor.Asciidoctor.Factory.create;

public class AsccidocManagerImpl implements AsccidocManager {

    @Override
    public Optional<String> convertToHTML(String file) {
        try {
            Options options = new Options();
            options.setInPlace(true);
            options.setBackend("html5");
            options.setSafe(SafeMode.SAFE);
            options.setToDir("src/test/resources/html5/");
            options.setMkDirs(true);
            options.setDocType("docbook");
            return Optional.of(create().convertFile(new File(file), options));
        } catch (Exception ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }
}
