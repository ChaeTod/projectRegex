package it.sovy.Artem;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sk.itsovy.data.DataIP;

public class Main {

    private static final String IPADDRESS_PATTERN = "((2[0-5][0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(2[0-5][0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])[$0-9]";

    public static void main(String[] args){

        DataIP data = new DataIP();
        System.out.println(data.get());
        getIPAddress(data.get());




    }

    public static void getIPAddress(List list){
        String line = list.toString();

        Pattern r = Pattern.compile(IPADDRESS_PATTERN);
        Matcher mt = r.matcher(line);

        int count = 0;
        if (!mt.find())
            System.out.println("Didn't find any match!");
        else {
            do {
                System.out.println("Found a match!");
                System.out.println(mt.group(0));
                count++;
            } while (mt.find());
        }

        System.out.println("Matches found: " +count);
    }
/*
    public static void getIndetificationCode(List list){
        String pattern = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        String line = list.toString();

        Pattern r = Pattern.compile(pattern);
        Matcher mt = r.matcher(line);

        /*do {
            if (mt.find()) {
                System.out.println("Fount a match!");
                System.out.println(mt.group(0));
                //i++;
            } else {
                System.out.println("Didn't find any matches!");
            }
        } while (mt.find());


    }


 */
}
