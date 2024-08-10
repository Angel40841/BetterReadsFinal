package com.example.betterReads.book_module.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBookResponseDTO {
    private List<Volume> items;

    // Getters and Setters

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Volume {
        private String id;
        private VolumeInfo volumeInfo;

        // Getters and Setters

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class VolumeInfo {
            private String title;
            private List<String> authors;
            private String description;
            private String publisher;

            // Getters and Setters
        }
    }
}
