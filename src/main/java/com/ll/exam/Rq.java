package com.ll.exam;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String url;
    private String path;
    private Map<String,String> queryStrings;
    Rq(String url) {
        this.url = url;
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];
        queryStrings = new HashMap<>();
        if (urlBits.length == 2) {
            String[] params = urlBits[1].split("&");
            for (String param : params) {
                String[] paramNameAndValue = param.split("=", 2);
                if (paramNameAndValue.length == 1) {
                    continue;
                }
                String paramName = paramNameAndValue[0].trim();
                String paramValue = paramNameAndValue[1].trim();
                queryStrings.put(paramName, paramValue);
            }
        }
    }
    int getIntValue(String paramName,int defaultValue) {

        //Map의 없는 값을 요구할시
        if(!queryStrings.containsKey(paramName)){
            return defaultValue;
        }

        //Map의 Value의 길이가 0일때
        if(queryStrings.get(paramName).length()==0){
            return defaultValue;
        }
        return Integer.parseInt(queryStrings.get(paramName));
    }
    String getPath(){
        return path;
    }
}

