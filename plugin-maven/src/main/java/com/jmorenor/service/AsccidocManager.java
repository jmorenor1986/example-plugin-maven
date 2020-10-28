package com.jmorenor.service;

import java.util.Optional;

public interface AsccidocManager {
    Optional<String> convertToHTML(String file);
}
