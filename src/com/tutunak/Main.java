package com.tutunak;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Helpers methods for working with array
 */
class Helper {
    /**
     * @param size size of new array
     * @return array integer numbers
     */
    static int[] generateArray(int size) {
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static void swap(int[] array, int i, int change) {
        int helper = array[i];
        array[i] = array[change];
        array[change] = helper;
    }

    private static void shuffleArray(int[] array) {
        int n = array.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n -i);
            swap(array, i, change);
        }
    }

    static int askInteger(String question) {
        System.out.println(question);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}

class Algorithms {
    static void binarySearch() {
        int size = Helper.askInteger("How big array do you want?");
        int[] array = Helper.generateArray(size);
        System.out.println(Arrays.toString(array));
        int element = Helper.askInteger("Which number do you want find?");
        System.out.println(element);
    }
}

public class Main {
    public static void main(String[] args) {
        final String[] choices = {
                "binary_search"};
        ArgumentParser parser = ArgumentParsers.newFor("Algorithms").build()
                .description("Algorithms");
        parser.addArgument("algorithm").choices(choices);
        Namespace namespace = null;
        try {
            namespace = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            System.exit(1);
        }
        switch (namespace.getString("algorithm")) {
            case "binary_search":
                Algorithms.binarySearch();
                break;
        }

    }
}
