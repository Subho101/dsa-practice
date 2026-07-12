package com.subho.dsa.two_pointer;

public class CrawlerLogFolder {
    public static int minOperations(String[] logs) {
        int count = 0;

        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) {
                if (count > 0) count--;
            } else if (logs[i].equals("./")) {
                continue;
            } else {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // String[] logs = {"d1/","d2/","../","d21/","./"};
        // String[] logs = {"d1/","d2/","./","d3/","../","d31/"};
        String[] logs = {"d1/", "../", "../", "../"};
        System.out.println(minOperations(logs));
    }
}
