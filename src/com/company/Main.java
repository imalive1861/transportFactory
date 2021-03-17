package com.company;

import com.company.transport.Transport;

import java.util.List;
import java.util.Scanner;

import static com.company.Utils.*;

public class Main {

    public static void main(String[] args) {
        String[] inputValues = consoleInput();
        List<Transport> transportList = createTransportList(inputValues);
        sortTransportList(transportList);
        outputTransportList(transportList);
    }

    public static String[] consoleInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of wheels: ");
        String input = in.nextLine();
        String[] inputValues = input.split(" ");
        in.close();
        return inputValues;
    }

    public static void sortTransportList(List<Transport> transportList) {
        System.out.println("Sorting...");
        transportList.sort(new Utils.TransportComparator());
    }

    public static void outputTransportList(List<Transport> transportList) {
        transportList.forEach(transport -> System.out.println("Wheels: " + transport.getNumberOfWheels() + "; " +
                "Name: " + transport.getTransportName() + "; " +
                "Max Path: " + calculateMaxPath(transport)));
    }
}