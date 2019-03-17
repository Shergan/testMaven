package com.divashchenko;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        XmlMapper xmlMapper = new XmlMapper();
        try {
            String fileString = new String(Files.readAllBytes(Paths.get("Group.xml")), StandardCharsets.UTF_8);
            Group group = xmlMapper.readValue(fileString, Group.class);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(group);
            writeToFile(json, "Group.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String string, String fileName) {
        try {
            FileUtils.writeStringToFile(new File(fileName), string, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
