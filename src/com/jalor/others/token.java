package com.jalor.others;

import java.util.UUID;

public class token {
    public static void main(String[] args) {
        String token = UUID.randomUUID().toString().substring(0,16);
        System.out.println("token的值: "+token);
    }
}
