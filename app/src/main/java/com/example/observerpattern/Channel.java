package com.example.observerpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class Channel {

    String channelName;
    String [] subs;

    public Channel(String channelName, String[] subs) {
        this.channelName = channelName;
        this.subs = subs;
    }

    public  void update(String message){

        for (int i = 0; i < subs.length ; i++) {

            System.out.println("A Message From " + channelName + " For " + subs[i] + " " + message);
        }
    }

    public void deleteSubs(int i){

        subs[i] = "";
    }
}
