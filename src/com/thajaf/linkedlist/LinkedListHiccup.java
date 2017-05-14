package com.thajaf.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by afsalthaj on 14/05/2017.
 */
public class LinkedListHiccup {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInorder(placesToVisit, "Sydney");
        addInorder(placesToVisit, "Melbourne");
        addInorder(placesToVisit, "Adelaide");

        visit(placesToVisit);
    }


    private static boolean addInorder(LinkedList<String> linkedList, String value) {
        ListIterator<String> listIterator = linkedList.listIterator();

        while(listIterator.hasNext()){
            int comparison = listIterator.next().compareTo(value);
            if(comparison == 0) {
                System.out.println("can't be added");
                return false;
            }

            else if (comparison > 0) {
                listIterator.previous();
                listIterator.add(value);
                return true;
            }
            else if (comparison < 0) {
                // nothing to do
            }
        }

        linkedList.add(value);
        return true;
    }

    private static void visit(LinkedList<String> cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();
        if(cities.isEmpty()){
            System.out.println("No cities in the itenary");
            return;
        } else {
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("vacation over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward){
                        if(listIterator.hasNext())
                            listIterator.next();
                    }
                    goingForward = true;
                    if(listIterator.hasNext())
                        System.out.println("now visiting " +listIterator.next());
                    else {
                        System.out.println("reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious())
                        listIterator.previous();
                    }
                    goingForward = false;
                    if(listIterator.hasPrevious())
                        System.out.println("now visiting "+ listIterator.previous());
                    else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                default:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("===================choose 0 to exit, 1 to next city and 2 to previous city=====================");
    }
}
