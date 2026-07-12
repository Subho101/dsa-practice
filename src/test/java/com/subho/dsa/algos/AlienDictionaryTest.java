package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.subho.dsa.graph.algos.AlienDictionnary;
import org.junit.jupiter.api.Test;

public class AlienDictionaryTest {

    @Test
    public void test1() {
        String[] dict = {
            "aaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaa",
            "a",
            "aaaaaaaa",
            "aaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaaa",
            "aaaa",
            "aaaaaaaaaaa",
            "aaaaa",
            "aaaaaaaaaaa",
            "aaa",
            "aaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaa",
            "aaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaa",
            "aaaaaaaaa",
            "aaaaa",
            "aaaaaaaaaaaaaaaaaaa"
        };
        String result = AlienDictionnary.findOrder(dict);
        assertEquals("", result);
    }

    @Test
    public void test2() {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        String result = AlienDictionnary.findOrder(dict);
        assertEquals("bdac", result);
    }

    @Test
    public void test3() {
        String[] dict = {"caa", "aaa", "aab"};
        String result = AlienDictionnary.findOrder(dict);
        assertEquals("cab", result);
    }

    @Test
    public void test4() {
        String[] dict = {"ab", "cd", "ef", "ad"};
        String result = AlienDictionnary.findOrder(dict);
        assertEquals("", result);
    }
}
