package com.distinctwordsort;


import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class DistinctWordSortApp {

    private static final String dir = "src/com/distinctwordsort/tmp/";
    private static final String suffix = ".splitPart";
    private static final String inputFileName = "src/com/distinctwordsort/input/bigfile.txt";
    private static final String outputFileName = "src/com/distinctwordsort/output/distinctwords.txt";

    private static final long bytesPerSplit = 30;
    private static final int maxReadBufferSize = 8 * 1024; //8KB

    public static void main(String[] args) {
        File input = new File(inputFileName);
        File output = new File(outputFileName);

        //using a hashset so that only distinct words are recorded
        HashSet<String> distinctWords = new HashSet<>();

        try{
            //using a BufferedReader object so that only a portion of the input file is added to memory at a time
            BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));
            String currentLine = "";

            //read input file line by line
            while((currentLine = br.readLine()) != null){

                //regex matches words made up of the english alphabet
                String[] words = currentLine.split("\\W+");

                //add each word to the
                for(String word : words){
                    if(word.length() != 0) {
                        word = word.toLowerCase(Locale.ENGLISH);
                        distinctWords.add(word);
                    }
                }
            }

            //Copying the distinctWord HashSet to an ArrayList so that it can be sorted
            List<String> distinctWordsList = new ArrayList<>(distinctWords);
            Collections.sort(distinctWordsList);

            //writing each word to an output file in order
            for(String word : distinctWordsList) {
                bw.write(String.format("%s\n", word));
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
