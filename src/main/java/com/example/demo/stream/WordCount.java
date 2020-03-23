package com.example.demo.stream;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class WordCount {

    public void run(String dirPath) throws ExecutionException, InterruptedException {
        File path = new File(dirPath);
        File[] files = path.listFiles();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Map<String, Integer>>> allWordsF = new ArrayList<>();

        for (File file : files) {
            ReadThread readThread = new ReadThread(file);
            Future<Map<String, Integer>> fileWords = executorService.submit(readThread); //若文件太多，则每个线程将结果写到同一个目录的多个文件中，最后遍历文件到内存
            allWordsF.add(fileWords);
        }


        Map<String, Integer> allWords = new HashMap<>();
        for (Future<Map<String, Integer>> future : allWordsF) {
            Map<String, Integer> wordmap = future.get();
            for (Map.Entry<String, Integer> entry : wordmap.entrySet()) {
                String key = entry.getKey();
                if (allWords.containsKey(key)) {
                    allWords.put(key, allWords.get(key) + entry.getValue());
                } else {
                    allWords.put(key, entry.getValue());
                }
            }

        }

        allWords.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).forEach(System.out::println);

        executorService.shutdown();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String path = "D:\\sample";
        new WordCount().run(path);

    }

}

class ReadThread implements Callable<Map<String, Integer>> {
    File file;

    public ReadThread(File file) {
        this.file = file;
    }

    @Override
    public Map<String, Integer> call() {
        long startTime = System.currentTimeMillis();
        Map<String, Integer> words = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " [],.!?\"'"); //用于切分字符串
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    if (words.containsKey(word)) {
                        words.put(word, words.get(word) + 1);
                    } else {
                        words.put(word, new Integer(1));
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println(Thread.currentThread() + "- it takes " + (endTime - startTime) + "ms to process file: " + file.getName());
        System.out.println("words: " + words.size());
        return words;
    }
}
