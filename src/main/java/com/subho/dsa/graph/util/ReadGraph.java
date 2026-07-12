package com.subho.dsa.graph.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReadGraph {

    private static String fileName = "/01_input.txt";

    public List<List<Integer>> getGraph() {
        String filePath = getClass().getResource(fileName).getPath();

        List<List<Integer>> result = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(line -> {
                String[] nodes = line.split(" ");
                List<Integer> nodeList = Arrays.asList(Integer.parseInt(nodes[0]), Integer.parseInt(nodes[1]));
                result.add(nodeList);
            });
        } catch (IOException e) {
            System.out.println(e);
        }

        return result;
    }

    public static void main(String[] args) {
        ReadGraph rGraph = new ReadGraph();
        List<List<Integer>> grp = rGraph.getGraph();
        System.out.println(grp);
    }
}
