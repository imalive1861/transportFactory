package com.company;

import com.company.transport.Transport;

import java.util.*;

public class Utils {
    private static String[] transportNames = {"zero", "one", "two", "three", "four", "six", "seven", "eight", "nine"};

    public static String getTransportName(int number) {
        return transportNames[number];
    }

    public static String generateTransportName() {
        Random rand = new Random();
        int number = rand.nextInt(9);
        return Utils.getTransportName(number);
    }

    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static List<Transport> createTransportList(String[] inputValues) {
        System.out.println("Creating new transport objects...");
        TransportFactory tf = new TransportFactory();
        List<Transport> transportList = new ArrayList<>();
        Arrays.stream(inputValues).forEach(value -> {
            int numberOfWheels;
            try {
                numberOfWheels = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input!");
                return;
            }
            Transport transport = tf.getTransport(numberOfWheels);
            transportList.add(transport);
            System.out.println("Your input: " + value + "; " +
                    "Wheels: " + transport.getNumberOfWheels() + "; " +
                    "Name: " + transport.getTransportName() + "; " +
                    "Fuel Tank Volume: " + transport.getFuelTankVolume() + "; " +
                    "Fuel Consumption Per 100 Km: " + transport.getFuelConsumptionPer100Km());
        });
        return transportList;
    }

    public static boolean isDefault(Transport t) {
        return "Default".equalsIgnoreCase(t.getClass().getSimpleName());
    }

    public static int calculateMaxPath(Transport t) {
        return t.getFuelTankVolume() / t.getFuelConsumptionPer100Km() * 100;
    }

    public static class TransportComparator implements Comparator<Transport> {
        @Override
        public int compare(Transport t1, Transport t2) {
            int result = isDefault(t1) && !isDefault(t2) ? 1 : !isDefault(t1) && isDefault(t2) ? -1 : 0;
            result = ifZeroCompareAgain(result, Integer.compare(t2.getNumberOfWheels(), t1.getNumberOfWheels()));
            result = ifZeroCompareAgain(result, compareByMaxPath(t1, t2));
            result = ifZeroCompareAgain(result, t1.getTransportName().compareToIgnoreCase(t2.getTransportName()));
            return result;
        }
    }

    public static int ifZeroCompareAgain(int result, int newResult) {
        return result == 0 ? newResult : result;
    }

    public static int compareByMaxPath(Transport t1, Transport t2) {
        return Double.compare(calculateMaxPath(t2), calculateMaxPath(t1));
    }
}
