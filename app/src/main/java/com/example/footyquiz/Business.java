package com.example.footyquiz;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Business {
    private static ArrayList<String> terms = new ArrayList<>();
    private static ArrayList<String> definitions = new ArrayList<>();
    private static HashMap<Integer, String> relationships = new HashMap<>();

    public static void readFile(Context context){



        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.data);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            int i=1;
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(", ");
                terms.add(words[0]);
                definitions.add(words[1]);
                System.out.println(line);
                definitions.add(words[2]);
                definitions.add(words[3]);
                definitions.add(words[4]);
                relationships.put(i, words[5]);
                i++;
            }


            br.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
            Log.e("TESTING ERROR", e.getMessage());

        }


        for (String s: definitions) {
            Log.w("TESTING BUSINESS", s);

        }

    }

    public static boolean isCorrect(String answer, int qsNo){
        return relationships.get(qsNo).equals(answer);
    }



    public static ArrayList<String> getTerms() {
        return terms;
    }

    public static ArrayList<String> getDefinitions() {
        return definitions;
    }

    public static HashMap<Integer, String> getRelationships() {
        return relationships;
    }
}
