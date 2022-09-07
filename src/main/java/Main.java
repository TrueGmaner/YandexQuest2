import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //читаем инфу о местах
        int seatrowsAmount = scanner.nextInt();
        String[] seatsShema = new String[seatrowsAmount];
        for (int i=0;i<seatsShema.length;i++){
            seatsShema[i] =scanner.next();
        }
        //читаем инфу о пассажирах
        int groupsAmount = scanner.nextInt();
        String[] passengersArray = new String[groupsAmount+1];
        for (int i=0;i<=groupsAmount;i++){
            passengersArray[i]= scanner.nextLine();
        }

        for (int i=1;i<=groupsAmount;i++){
            seatsShema= func1(passengersArray[i], seatsShema);
        }
    }

    public static void printSeats(String[] seatsScheme){
        for (int i = 0; i < seatsScheme.length; i++) {
            System.out.println(seatsScheme[i]);
        }
    }

    public static String[] func1(String passengerInfo, String[] seatsScheme){
        String noSeatsMessage = "Cannot fulfill passengers requirements";
        if (passengerInfo.charAt(0)=='3'){
            String[] words = passengerInfo.split(" ");
            switch (words[1]){
                case "right":
                    for (int j=0;j<seatsScheme.length;j++) {
                        if (seatsScheme[j].substring(4, 7).equals("...")) {
                            System.out.printf("Passengers can take seats: %dD %dE %dF", j+1, j+1, j+1);
                            System.out.println();
                            seatsScheme[j]= seatsScheme[j].substring(0,4) + "XXX";
                            printSeats(seatsScheme);
                            seatsScheme[j]= seatsScheme[j].substring(0,4) + "###";
                            break;
                        }
                        if (j == seatsScheme.length-1) System.out.println(noSeatsMessage);
                    }
                    return seatsScheme;
                case "left":
                    for (int j=0;j<seatsScheme.length;j++) {
                        if (seatsScheme[j].substring(0, 3).equals("...")) {
                            System.out.printf("Passengers can take seats: %dA %dB %dC", j+1, j+1, j+1);
                            System.out.println();
                            seatsScheme[j]= "XXX" + seatsScheme[j].substring(3,7);
                            printSeats(seatsScheme);
                            seatsScheme[j]= "###" + seatsScheme[j].substring(3,7);
                            break;
                        }
                        if (j == seatsScheme.length-1) System.out.println(noSeatsMessage);
                    }
                    return seatsScheme;
                default: return seatsScheme;
            }
        }
        // если группа пасажиров не из 3 человек
        else
        switch (passengerInfo) {
            case "2 right window":
                for (int j=0;j<seatsScheme.length;j++) {
                    if (seatsScheme[j].substring(5, 7).equals("..")) {
                        System.out.printf("Passengers can take seats: %dE %dF", j+1, j+1);
                        System.out.println();
                        seatsScheme[j]= seatsScheme[j].substring(0,5) + "XX";
                        printSeats(seatsScheme);
                        seatsScheme[j]= seatsScheme[j].substring(0,5) + "##";
                        break;
                    }
                    if (j == seatsScheme.length-1) System.out.println(noSeatsMessage);
                }
                return seatsScheme;
            case "2 left window":
                for (int j=0;j<seatsScheme.length;j++) {
                    if (seatsScheme[j].substring(0, 2).equals("..")) {
                        System.out.printf("Passengers can take seats: %dA %dB", j+1, j+1);
                        System.out.println();
                        seatsScheme[j]= "XX" + seatsScheme[j].substring(2,7);
                        printSeats(seatsScheme);
                        seatsScheme[j]= "##" + seatsScheme[j].substring(2,7);
                        break;
                    }
                    if (j == seatsScheme.length-1) System.out.println(noSeatsMessage);
                }
                return seatsScheme;
            case "2 right aisle":
                for (int j=0;j<seatsScheme.length;j++) {
                    if (seatsScheme[j].substring(4, 6).equals("..")) {
                        System.out.printf("Passengers can take seats: %dD %dE", j+1, j+1);
                        System.out.println();
                        seatsScheme[j]= seatsScheme[j].substring(0,4) + "XX" + seatsScheme[j].substring(6,7);
                        printSeats(seatsScheme);
                        seatsScheme[j]= seatsScheme[j].substring(0,4) + "##" + seatsScheme[j].substring(6,7);
                        break;
                    }
                    if (j == seatsScheme.length-1) System.out.println(noSeatsMessage);
                }
                return seatsScheme;
            case "2 left aisle":
                for (int j=0;j<seatsScheme.length;j++) {
                    if (seatsScheme[j].substring(1, 3).equals("..")) {
                        System.out.printf("Passengers can take seats: %dB %dC", j+1, j+1);
                        System.out.println();
                        seatsScheme[j]= seatsScheme[j].substring(0,1) + "XX" + seatsScheme[j].substring(3,7);
                        printSeats(seatsScheme);
                        seatsScheme[j]= seatsScheme[j].substring(0,1) + "##" + seatsScheme[j].substring(3,7);
                        break;
                    }
                    if (j == seatsScheme.length-1) System.out.println(noSeatsMessage);
                }
                return seatsScheme;
            case "1 right window":
                for (int j=0;j<seatsScheme.length;j++) {
                    if (seatsScheme[j].charAt(6)=='.') {
                        System.out.printf("Passengers can take seats: %dF", j+1);
                        System.out.println();
                        seatsScheme[j]= seatsScheme[j].substring(0,6) + "X";
                        printSeats(seatsScheme);
                        seatsScheme[j]= seatsScheme[j].substring(0,6) + "#";
                        break;
                    }
                    if (j == seatsScheme.length-1) System.out.println(noSeatsMessage);
                }
                return seatsScheme;
            case "1 left window":
                for (int j=0;j<seatsScheme.length;j++) {
                    if (seatsScheme[j].charAt(0)=='.') {
                        System.out.printf("Passengers can take seats: %dA", j+1);
                        System.out.println();
                        seatsScheme[j]= "X" + seatsScheme[j].substring(1,7);
                        printSeats(seatsScheme);
                        seatsScheme[j]= "#" + seatsScheme[j].substring(1,7);
                        break;
                    }
                    if (j == seatsScheme.length-1) System.out.println(noSeatsMessage);
                }
                return seatsScheme;
            case "1 right aisle":
                for (int j=0;j<seatsScheme.length;j++) {
                    if (seatsScheme[j].charAt(4)=='.') {
                        System.out.printf("Passengers can take seats: %dD", j+1);
                        System.out.println();
                        seatsScheme[j]= seatsScheme[j].substring(0,4) + "X" + seatsScheme[j].substring(5,7);
                        printSeats(seatsScheme);
                        seatsScheme[j]= seatsScheme[j].substring(0,4) + "#" + seatsScheme[j].substring(5,7);
                        break;
                    }
                    if (j == seatsScheme.length-1) System.out.println(noSeatsMessage);
                }
                return seatsScheme;
            case "1 left aisle":
                for (int j=0;j<seatsScheme.length;j++) {
                    if (seatsScheme[j].charAt(2)=='.') {
                        System.out.printf("Passengers can take seats: %dC", j+1);
                        System.out.println();
                        seatsScheme[j]= seatsScheme[j].substring(0,2) + "X" + seatsScheme[j].substring(3,7);
                        printSeats(seatsScheme);
                        seatsScheme[j]= seatsScheme[j].substring(0,2) + "#" + seatsScheme[j].substring(3,7);
                        break;
                    }
                    if (j == seatsScheme.length-1) System.out.println(noSeatsMessage);
                }
                return seatsScheme;
            default: return seatsScheme;
        }
    }
}