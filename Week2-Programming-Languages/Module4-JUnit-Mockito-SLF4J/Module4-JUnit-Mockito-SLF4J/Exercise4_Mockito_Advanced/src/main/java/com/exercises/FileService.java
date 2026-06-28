package com.exercises;
public class FileService {
    private final FileReader fileReader;
    private final FileWriter fileWriter;
    public FileService(FileReader r, FileWriter w) { fileReader = r; fileWriter = w; }
    public String processFile() { return "Processed " + fileReader.read(); }
}
