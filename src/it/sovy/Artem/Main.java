package it.sovy.Artem;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sk.itsovy.data.DataIP;
import sk.itsovy.data.Date;
import sk.itsovy.data.MacAddress;
import sk.itsovy.data.PersonalID;

public class Main {

    private static final String IPADDRESS_PATTERN = "((2[0-5][0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(2[0-5][0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])[$0-9]";
    private static final String PERSONALCODE_PATTERN = "^[0-9]{2}[0156][0-9]{3}\\/?[0-9]{3,4}$";
    private static final String MACADDRESS_PATTERN = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
    private static final String DATE_PATTERN = "^((([1-9]|([1-2][0-9]|31|30))\\.(1|3|5|7|9|11))|(([1-9]|([1-2][0-9]))\\.(2|4|6|8|10|12)))\\.((19|20)([0-9]{2}))$";

    public static void main(String[] args) {
        System.out.println("IP Address:");
        DataIP data = new DataIP();
        System.out.println(data.get());
        getIPAddress(data.get());

        System.out.println("---------------------");

        System.out.println("Date:");
        Date date = new Date();
        System.out.println(date.get());
        getDate(date.get());

        System.out.println("----------------------");

        System.out.println("Personal identification code:");
        PersonalID perID = new PersonalID();
        System.out.println(perID.get());
        getIdentificationCode(perID.get());

        System.out.println("---------------------");

        System.out.println("Mac Address:");
        MacAddress mac = new MacAddress();
        System.out.println(mac.get());
        getMacAddress(mac.get());

    }

    public static void getIPAddress(List<String> list) {
        String line = list.toString();

        Pattern r = Pattern.compile(IPADDRESS_PATTERN);
        Matcher mt = r.matcher(line);

        int count = 0;
        if (!mt.find())
            System.out.println("Didn't find any match!");
        else {
            do {
                //System.out.println("Found a match!");
                System.out.println(mt.group(0));
                count++;
            } while (mt.find());
        }
        System.out.println("Matches found: " + count);
    }

    public static void getDate(List<String> list) {
        Pattern r = Pattern.compile(DATE_PATTERN);
        int count = 0;

        for (int i = 0; i < list.size(); i++){
            if (list.get(i) != null){
                Matcher mt = r.matcher(list.get(i));
                if (mt.find()) {
                    System.out.println(mt.group(0));
                    count++;
                }
            }
        }
        System.out.println("Matches found: " + count);
    }

    public static void getIdentificationCode(List<String> list) {
        Pattern r = Pattern.compile(PERSONALCODE_PATTERN);
        int count = 0;

        for (int i = 0; i < list.size(); i++){
            if (list.get(i) != null) {
                Matcher mt = r.matcher(list.get(i));
                if (mt.find()){
                    System.out.println(mt.group(0));
                    count++;
                }

            }
        }
        System.out.println("Matches found: " + count);
    }

    public static void getMacAddress(List<String> list) {
        Pattern r = Pattern.compile(MACADDRESS_PATTERN);
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                Matcher mt = r.matcher(list.get(i));
                if (mt.find()) {
                    System.out.println(mt.group(0));
                    count++;
                }
            }
        }
        System.out.println("Matches found: " + count);
    }
}
