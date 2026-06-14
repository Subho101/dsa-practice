package com.subho.dsa.algos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.subho.dsa.graph.algos.WordLadder;

public class WordLadderTest {

    @Test
    public void test1() {
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        String beginWord = "hit", endWord = "cog";
        int length = WordLadder.ladderLength(beginWord, endWord, wordList);
        assertEquals(5, length);
    }

    @Test
    public void test2() {
        List<String> wordList = Arrays.asList("des","der","dfr","dgt","dfs");
        String beginWord = "der", endWord= "dfs";
        int length = WordLadder.ladderLength(beginWord, endWord, wordList);
        assertEquals(3, length);
    }

    @Test
    public void test3() {
        List<String> wordList = Arrays.asList("geek", "gefk");
        String beginWord = "gedk", endWord= "geek";
        int length = WordLadder.ladderLength(beginWord, endWord, wordList);
        assertEquals(2, length);
    }

    @Test
    public void test4() {
        List<String> wordList = Arrays.asList("poon", "plee", "same", "poie","plea","plie","poin");
        String beginWord = "toon", endWord= "plea";
        int length = WordLadder.ladderLength(beginWord, endWord, wordList);
        assertEquals(7, length);
    }

    @Test
    public void test5() {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        String beginWord = "hit", endWord = "cog";
        int length = WordLadder.ladderLength(beginWord, endWord, wordList);
        assertEquals(0, length);
    }

    @Test
    public void test6() {
        List<String> wordList = Arrays.asList("hot","dog");
        String beginWord = "hot", endWord = "dog";
        int length = WordLadder.ladderLength(beginWord, endWord, wordList);
        assertEquals(0, length);
    }
}
