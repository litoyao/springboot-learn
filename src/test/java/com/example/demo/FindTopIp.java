package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 从巨大的数据量当中查找出现次数在Top 10的IP
 */
public class FindTopIp {

    public List<String> readFromFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        Map<String,Long> idMap = new HashMap<>();
        String line;
        while ((line = br.readLine()) != null) {

            String[] it=line.split("\\.",2);
            if(idMap.containsKey(it[0])){
                idMap.put(it[0],idMap.get(it[0])+1);
            }else{
                idMap.put(it[0],1L);
            }
        }

        List<String> top10= idMap.entrySet().stream()
                .sorted((a, b)->(int)(b.getValue()-a.getValue()))
                .limit(10)
                .map(f->f.getKey())
                .collect(Collectors.toList());

        return top10;

    }

    public void run(String file) throws IOException {
        List<String> top10 = readFromFile(file);


    }

    public static void main(String[] args) throws IOException {
        FindTopIp findTopIp = new FindTopIp();
        findTopIp.run("D:\\workspace\\SpringBoot-learn\\src\\main\\resources\\ip.txt");
    }

}
