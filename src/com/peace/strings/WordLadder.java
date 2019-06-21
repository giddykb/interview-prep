package com.peace.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/06/19
 * Time:    11:09 PM
 *
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {

  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return 0;

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    int result = 0;
    while (!queue.isEmpty()) {
      int k = queue.size();
      while (k > 0) {
        String word = queue.poll();
        if (word.equals(endWord)) return result+1;
        for (int i = 0; i <  word.length(); i++) {
          char [] newWord = word.toCharArray();
          for (char c = 'a'; c <= 'z' ; c++) {
            newWord[i] = c;
            String s  = new String(newWord);
            if (wordSet.contains(s) && !s.equals(word)) {
              queue.offer(s);
              wordSet.remove(s);
            }
          }
        }
        k--;
      }
      result++;
    }

    return 0;
  }

  public static int ladderLengthOptimal(String beginWord, String endWord, List<String> wordList) {

    int L = beginWord.length();

    HashMap<String,ArrayList<String>> allCombDict = new HashMap<>();

    wordList.forEach(
        word -> {
          for (int i = 0; i < L ; i++) {
            String newWord = word.substring(0,i)+ "*" + word.substring(i+1);
            ArrayList<String> transformations =
                allCombDict.getOrDefault(newWord, new ArrayList<>());
            transformations.add(word);
            allCombDict.put(newWord, transformations);
          }
        }
    );

    Queue<NodeLevel> queue = new LinkedList<>();
    HashMap<String,Boolean>  visited = new HashMap<>();
    queue.add(new NodeLevel(beginWord,1));
    visited.put(beginWord, true);

    while (!queue.isEmpty()) {
      NodeLevel nodeLevel =  queue.poll();
      String currWord = nodeLevel.word;
      int level = nodeLevel.level;

      for (int i = 0; i < L ; i++) {
        String newWord = currWord.substring(0,i)+ "*" + currWord.substring(i+1);
        ArrayList<String> transformations = allCombDict.getOrDefault(newWord,new ArrayList<>());
        for (String adjacentWord : transformations) {
          if (adjacentWord.equals(endWord)) return level+1;
          if (! visited.containsKey(adjacentWord)) {
            queue.offer(new NodeLevel(adjacentWord, level+1));
            visited.put(adjacentWord,true);
          }
        }
      }
    }

    return 0;
  }


  private static class NodeLevel {
    private String word;
    private int level;

    NodeLevel(String word, int level) {
      this.level = level;
      this.word = word;
    }

  }
  public static void main(String[] args) {
    String [] arr =  {"hot","dot","dog","lot","log","cog"};
    List<String> wordList = Arrays.asList(arr);

    String beginWord = "hit";
    String endWord = "cog";
    int result = ladderLengthOptimal(beginWord, endWord, wordList);
    System.out.println(result);
    System.out.println(ladderLength(beginWord, endWord, wordList));
  }
}
