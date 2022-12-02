import java.io.*;
import java.util.*;

public class Part2 {
    public static void main(String[] args) throws Exception {
        File file = new File("Day2.txt");
      	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
	    String line;
        int score = 0;
		while ((line = br.readLine()) != null) {
            String[] a = line.split(" ");
            a[1] = calculateResponse(a[0], a[1]);
            switch(a[1]) {
                case "X": //Rock
                    score += 1;
                    break;
                case "Y": //Paper
                    score += 2;
                    break;
                case "Z": //scissor
                    score += 3;
                    break;
            }
            score += decider(a[0], a[1]);
        }
        System.out.println(score);
    }

    public static int decider(String x, String y) {
        switch (x) { //Rock
            case "A":
                switch(y){
                    case "X": //Rock
                        return 3;
                    case "Y": //Paper
                        return 6;
                    case "Z": //scissor
                        return 0;
                }
            case "B": //Paper
                switch(y){
                    case "X": //Rock
                        return 0;
                    case "Y": //Paper
                        return 3;
                    case "Z": //scissor
                        return 6;
                }
            case "C": //scissor
                switch(y){
                    case "X": //Rock
                        return 6;
                    case "Y": //Paper
                        return 0;
                    case "Z": //scissor
                        return 3;
                }
        }
        return 0;
    }

    public static String calculateResponse(String x, String y) {
        switch (y) { 
            case "X": //Perder
                switch(x){
                    case "A": //Rock
                        return "Z"; //Scissor
                    case "B": //Paper
                        return "X"; //Rock
                    case "C": //scissor
                        return "Y"; //Paper
                }
            case "Y": //Empatar
                switch(x){
                    case "A": //Rock
                        return "X";
                    case "B": //Paper
                        return "Y";
                    case "C": //scissor
                        return "Z";
                }
            case "Z": //Ganhar
                switch(x){
                    case "A": //Rock
                        return "Y";
                    case "B": //Paper
                        return "Z";
                    case "C": //scissor
                        return "X";
                }
        }
        return "A";
    }
}