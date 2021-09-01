package org.med.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class AlarmsJSON {

    public static void writer(String fileName, List<Alarm> alarms) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(BufferedWriter bufferedReader = new BufferedWriter(new FileWriter(fileName))) {

            gson.toJson(alarms, bufferedReader);
            bufferedReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Alarm> reader(String fileName) {

        Gson gson = new Gson();
        List<Alarm> alarms = null;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            alarms = gson.fromJson(bufferedReader, new TypeToken<LinkedList<Alarm>>(){}.getType());
            bufferedReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return alarms;
    }
}
