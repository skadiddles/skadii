package main;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        terminal();
    }
    
    private static int transfer;
    private static int ride;
    private static int finale;
    private static int terminal;
    private static Scanner scanner;
    private static int initial;
    private static int card;
    private static int status;
    private static double payment;
 
    public static void terminal() {
        payment = 0;
        initial = 0;
        finale = 0;
        ride = 0;
        transfer = 0;
        scanner = new Scanner(System.in);
        System.out.println("Welcome to LRT/MRT Stations");
 
        System.out.print("\nTerminal Station (1-LRT 1 | 2-LRT 2 | 3-MRT 3) : ");
        terminal = scanner.nextInt();
 
        System.out.print("Terminal Station (1- Regular Card | 2-Beep Card) : ");
        card = scanner.nextInt();
 
        status = 0;
        if(card == 2) {
            System.out.print("Terminal Station (1-Regular Passenger (10%) | 2-Student (15%) | 3-PWD (20%)) : ");
            status = scanner.nextInt();
        }
 
        if (terminal == 1) {  
            lrt1(scanner, payment, terminal, initial, finale, card, status, ride, transfer);
        } else if (terminal == 2) {
            lrt2(scanner, payment, terminal, initial, finale, card, status, ride, transfer);
        } else if (terminal == 3) {
            lrt3(scanner, payment, terminal, initial, finale, card, status, ride, transfer);
        } else {
            System.out.println("Invalid selection");
        }
 
        scanner.close(); // Closing the scanner object to prevent resource leak
    }
 
    public static void lrt1(Scanner scanner, double payment, int terminal, int initial, int finale, int card, int status, int ride, int transfer) {
        String lolo;  String codexx = "LRT 1";
        finale = initial;
        int platf;
 
        String[] platters = {"Baclaran", "EDSA (Connecting MRT 3)", "Libertad", "Gil Puyat", "Vito Cruz", "Quirino", "Pedro Gil",
            "UN Ave.", "Central", "Carriedo", "Doroteo Jose  (Connecting LRT 2)", "Bambang", "Tayuman", "Blumentritt",
            "Abad Santos", "R. Papa", "5th Avenue", "Monumento", "Balintawak", "Roosevelt"};
 
        int codex = 0;
        if(ride == 0) {
            System.out.println("\nWelcome to LRT 1 Terminal (List of Stations)\n-----------------------------------------------------------------");
 
            for(platf = 0; platf < platters.length; platf++) {
                if(platf == 6 || platf == 11 || platf == 17) { System.out.print("\n"+codex + "-" + platters[codex]+" |"); }
                else { System.out.print(codex + "-" + platters[codex]+" | "); }
                codex = codex + 1;
            }
        }
 
 
        if(transfer == 1)
        {
            lolo = platters[initial];
            System.out.print("\n-----------------------------------------------------------------\n"+codexx+" : From "+lolo+" To : ");
            finale = scanner.nextInt();  
        }
        else
        {
            if(finale != 0)
            {
                lolo = platters[initial];
                System.out.print("\n-----------------------------------------------------------------\n"+codexx+" : From "+lolo+" To : ");
            }
            else
            {
                System.out.print("\n-----------------------------------------------------------------\n"+codexx+" : From: ");
            }
 
 
            if(finale != 0) {  finale = scanner.nextInt(); }
            else { initial = scanner.nextInt(); }
 
            if(finale == 0)
            {
                lolo = platters[initial];
                System.out.print(codexx+" : From "+lolo+" To : ");
                finale = scanner.nextInt();
            }
        }
 
 
        int[][] LRT1Fares = {
        {0, 20, 20, 20, 25, 25, 25, 25, 25, 25, 30, 30, 30, 30, 30, 35, 35, 35, 35, 35}, //fpj
            {20, 0, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 30, 30, 30, 30, 30, 35, 35, 35}, // Balintawak
            {20, 20, 0, 15, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 30, 30, 30, 30, 30}, // Monumento
            {20, 20, 15, 0, 15, 15, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 30, 30, 30, 30}, // 5th Ave
            {25, 20, 20, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 35, 35, 35}, // R. Papa
            {25, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 30, 30}, // Abad Santos
            {25, 25, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 30}, // Blumentritt
            {25, 25, 25, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25}, // Tayuman
            {25, 25, 20, 20, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25}, // Bambang
            {25, 25, 20, 20, 20, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 20, 25, 25, 25, 25}, // D. Jose
            {30, 25, 25, 20, 20, 20, 20, 20, 15, 15, 0, 15, 20, 20, 20, 20, 20, 25, 25, 25}, // Carriedo
            {30, 25, 25, 20, 20, 20, 20, 20, 20, 15, 15, 0, 15, 20, 20, 20, 20, 20, 25, 25}, // Central
            {30, 30, 25, 25, 25, 20, 20, 20, 20, 20, 20, 15, 0, 15, 15, 20, 20, 20, 20, 20}, // UN Avenue
            {30, 30, 25, 25, 25, 25, 20, 20, 20, 20, 20, 20, 15, 0, 15, 15, 20, 20, 20, 20}, // Pedro Gil
            {30, 30, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 15, 0, 15, 20, 20, 20, 20}, // Quirino
            {35, 30, 30, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 15, 0, 15, 15, 20, 20}, // Vito Cruz
            {35, 30, 30, 30, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 0, 15, 15, 20}, // Gil Puyat
            {33, 35, 30, 30, 30, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 15, 15, 0, 15, 15}, // Libertad
            {35, 35, 30, 30, 30, 30, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 15, 15, 0, 15}, // EDSA
            {35, 35, 30, 30, 30, 30, 30, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 15, 0} // Baclaran
        };
 
        String textko = "";
        double pricy;
        if(initial == finale) { payment += 0; pricy = 0; transfer = 0; }
        else {
            pricy = LRT1Fares[initial][finale];
 
            if(status == 1 && card == 2) { pricy = pricy - (pricy *.10); pricy = pricy - (pricy *.10); textko = "Discounted"; }
            if(status == 2 && card == 2) { pricy = pricy - (pricy *.15); pricy = pricy - (pricy *.15); textko = "Discounted"; }
            if(status == 3 && card == 2) { pricy = pricy - (pricy *.20);  pricy = pricy - (pricy *.20);  textko = "Discounted"; }
 
            payment += pricy;
            transfer = 0;
         }
 
        String dep = platters[initial]; String dep1 = platters[finale];
        System.out.print("-----------------------------------------------------------------\nTerminal "+terminal + " | From  " + dep + " To  " + dep1 + " | Ride Fee: Php " + pricy + " " + textko);
 
        int sta = 0;
        System.out.print("\n(1- Ride Again ");
        if(terminal == 1 && (finale == 1 || finale == 10))
        {
            System.out.print(" | 2- Change Station");
            sta = 1;
        }
        System.out.print(" | any key to Get Off) : ");
        int soample = scanner.nextInt();
 
        if(soample == 1) {
            initial = finale;
            ride = 1;
            lrt1(scanner, payment,terminal,initial,finale,card,status,ride,transfer);
 
        } else if(soample == 2 && sta == 1) {
            ride = 0;
            //terminal101(scanner, payment,card,status,ride);
            transfer = 1;
            if(finale == 1)
            {
                ride = 1;
                finale = 12;
                terminal = 3;
                lrt3(scanner,payment,terminal,initial,finale,card,status,ride,transfer);   
            }
 
            if(finale == 10)
            {
                ride = 1;
                terminal = 2;
                finale = 0;
                lrt2(scanner,payment,terminal,initial,finale,card,status,ride,transfer);   
            }
 
        }
        else { System.out.println("-----------------------------------------------------------------\nTotal Payment " + payment); }
    }
 
    public static void lrt2(Scanner scanner, double payment, int terminal,int initial,int finale,int card, int status, int ride, int transfer) {
        String lolo; String codexx = "LRT 2";
        if(transfer == 0) { finale = initial; } else { initial = finale; }
 
        int platf;
 
        String[] platters = {"Recto (Connecting LRT 1)", "Legarda", "Pureza", "V. Mapa", "J. Ruiz", "Gilmore", "Betty Go-Belmonte",
            "Araneta - Cubao (Connecting MRT 3)", "Anonas", "Katipunan", "Santolan"};
 
        int codex = 0;
        if(ride == 0 || transfer == 1)
        {
             System.out.println("\nWelcome to LRT 2 Terminal (List of Stations)\n-----------------------------------------------------------------");
 
            for(platf = 0; platf < platters.length; platf++) {
                if(platf == 6 || platf == 11 || platf == 17) { System.out.print("\n"+codex + "-" + platters[codex]+" |"); }
                else { System.out.print(codex + "-" + platters[codex]+" | "); }
                codex = codex + 1;
            }
        }
 
        if(transfer == 1)
        {
            lolo = platters[initial];
            System.out.print("\n-----------------------------------------------------------------\n"+codexx+" : From "+lolo+" To : ");
            finale = scanner.nextInt();  
        }
        else
        {
            if(finale != 0)
            {
                lolo = platters[initial];
                System.out.print("\n-----------------------------------------------------------------\n"+codexx+" : From "+lolo+" To : ");
            }
            else
            {
                System.out.print("\n-----------------------------------------------------------------\n"+codexx+" : From: ");
            }
 
 
            if(finale != 0) {  finale = scanner.nextInt(); }
            else { initial = scanner.nextInt(); }
 
            if(finale == 0)
            {
                lolo = platters[initial];
                System.out.print(codexx+" : From "+lolo+" To : ");
                finale = scanner.nextInt();
            }
        }
 
        int[][] LRT1Fares = {
        	{0, 15, 20, 20, 20, 25, 25, 25, 25, 30, 30, 35, 35}, //Recto
            {15, 0, 15, 20, 20, 20, 25, 25, 25, 25, 30, 30, 35}, // Legarda
            {20, 15, 0, 15, 20, 20, 20, 20, 25, 25, 30, 30, 30}, // Pureza
            {20, 20, 15, 0, 15, 20, 20, 20, 20, 25, 25, 30, 30}, // V. Mapa
            {20, 20, 20, 15, 0, 15, 20, 20, 20, 20, 25, 25, 30}, // J. Ruiz
            {25, 20, 20, 20, 15, 0, 15, 20, 20, 20, 25, 25, 30}, // Gilmore
            {25, 25, 20, 20, 30, 15, 0, 15, 20, 20, 20, 25, 25}, // Betty Go
            {25, 25, 20, 20, 20, 20, 15, 0, 15, 20, 20, 25, 25}, // Araneta
            {25, 25, 25, 20, 20, 20, 20, 15, 0, 15, 20, 20, 25}, // Anonas
            {30, 25, 25, 25, 20, 20, 20, 20, 15, 0, 20, 20, 25}, // Katipuan
            {30, 30, 30, 25, 25, 25, 20, 20, 20, 20, 0, 15, 20}, // Santolan
            {35, 30, 30, 30, 25, 25, 25, 25, 20, 20, 15, 0, 20}, // Marikina
            {35, 35, 30, 30, 30, 30, 25, 25, 25, 25, 20, 20, 0}, // Antipolo
        };
 
        String textko = "";
        double pricy;
        if(initial == finale) { payment += 0; pricy = 0; transfer = 0; }
        else {
            pricy = LRT1Fares[initial][finale];
 
            if(status == 1 && card == 2) { pricy = pricy - (pricy *.10); pricy = pricy - (pricy *.10); textko = "Discounted"; }
            if(status == 2 && card == 2) { pricy = pricy - (pricy *.15); pricy = pricy - (pricy *.15); textko = "Discounted"; }
            if(status == 3 && card == 2) { pricy = pricy - (pricy *.20);  pricy = pricy - (pricy *.20);  textko = "Discounted"; }
 
            payment += pricy;
            transfer = 0;
         }
 
        String dep = platters[initial]; String dep1 = platters[finale];
        System.out.print("-----------------------------------------------------------------\nTerminal "+terminal + " | From  " + dep + " To  " + dep1 + " | Ride Fee: Php " + pricy + " " + textko);
 
        int sta = 0;
        System.out.print("\n(1- Ride Again ");
        if(terminal == 2 && (finale == 0 || finale == 7))
        {
            System.out.print(" | 2- Change Station");
            sta = 1;
        }
        System.out.print(" | any key to Get Off) : ");
        int soample = scanner.nextInt();
 
        if(soample == 1) {
            initial = finale;
            ride = 1;
            lrt2(scanner, payment,terminal,initial,finale,card,status,ride,transfer);
        } else if(soample == 2 && sta == 1)
            ride = 0;
            //terminal101(scanner, payment,card,status,ride);
            transfer = 1;
            if(finale == 0) //recto lrt 1
            {
                ride = 1;
                finale = 10;
                terminal = 1;
                lrt1(scanner,payment,terminal,initial,finale,card,status,ride,transfer);   
            }
 
            if(finale == 7) // cubao mrt 3
            {
                ride = 1;
                terminal = 3;
                finale = 3;
                lrt3(scanner,payment,terminal,initial,finale,card,status,ride,transfer);   
            }
        }    
 
    public static void lrt3(Scanner scanner, double payment, int terminal,int initial,int finale,int card, int status, int ride, int transfer) {
        String lolo;  String codexx = "MRT 3";
        if(transfer == 0) { finale = initial; } else { initial = finale; }
        int platf;
 
        String[] platters = {"North Ave", "Quezon Ave", "Kamuning", "Cubao (Connecting LRT 2)", "Santolan", "Ortigas", "Shaw",
            "Boni", "Guadalupe", "Buendia", "Ayala", "Magallanes", "Taft (Connecting LRT 1)"};
 
        int codex = 0;
        if(ride == 0 || transfer == 1)
        {
             System.out.println("\nWelcome to MRT 3 Terminal (List of Stations)\n-----------------------------------------------------------------");
 
            for(platf = 0; platf < platters.length; platf++) {
                if(platf == 6 || platf == 11 || platf == 17) { System.out.print("\n"+codex + "-" + platters[codex]+" |"); }
                else { System.out.print(codex + "-" + platters[codex]+" | "); }
                codex = codex + 1;
            }
        }
 
        if(transfer == 1)
        {
            lolo = platters[initial];
            System.out.print("\n-----------------------------------------------------------------\n"+codexx+" : From "+lolo+" To : ");
            finale = scanner.nextInt();  
        }
        else
        {
            if(finale != 0)
            {
                lolo = platters[initial];
                System.out.print("\n-----------------------------------------------------------------\n"+codexx+" : From "+lolo+" To : ");
            }
            else
            {
                System.out.print("\n-----------------------------------------------------------------\n"+codexx+" : From: ");
            }
 
 
            if(finale != 0) {  finale = scanner.nextInt(); }
            else { initial = scanner.nextInt(); }
 
            if(finale == 0)
            {
                lolo = platters[initial];
                System.out.print(codexx+" : From "+lolo+" To : ");
                finale = scanner.nextInt();
            }
        }
 
        int[][] LRT1Fares = {
        {0, 13, 13, 16, 16, 20, 20, 20, 24, 24, 24, 28, 28}, //North Avenue
            {13, 0, 13, 13, 16, 16, 20, 20, 20, 24, 24, 24, 28}, //Quezon Avenue
            {13, 13, 0, 13, 13, 16, 16, 20, 20, 20, 24, 24, 24}, //Kamuning
            {16, 13, 13, 0, 13, 13, 16, 16, 20, 20, 20, 24, 24}, //Cubao
            {16, 16, 13, 13, 0, 13, 13, 16, 16, 20, 20, 20, 24}, //Santolan-Annapolis
            {20, 16, 16, 13, 13, 0, 13, 13, 16, 16, 20, 20, 20}, //Ortigas
            {20, 20, 16, 16, 13, 13, 0, 13, 13, 16, 16, 20, 20}, //Shaw
            {20, 20, 20, 16, 16, 13, 13, 0, 13, 13, 16, 16, 20}, //Boni
            {24, 20, 20, 20, 16, 16, 13, 13, 0, 13, 13, 16, 16}, //Guadalupe
            {24, 24, 20, 20, 20, 16, 16, 13, 13, 0, 13, 13, 16}, //Buendia
            {24, 24, 24, 20, 20, 20, 16, 16, 13, 13, 0, 13, 13}, //Ayala
            {28, 24, 24, 24, 20, 20, 20, 16, 16, 13, 13, 0, 13}, //Magallanes
            {28, 28, 24, 24, 24, 20, 20, 20, 16, 16, 13, 13, 0}, //Taft
        };
 
        String textko = "";
        double pricy;
        if(initial == finale) { payment += 0; pricy = 0; transfer = 0; }
        else {
            pricy = LRT1Fares[initial][finale];
 
            if(status == 1 && card == 2) { pricy = pricy - (pricy *.10); pricy = pricy - (pricy *.10); textko = "Discounted"; }
            if(status == 2 && card == 2) { pricy = pricy - (pricy *.15); pricy = pricy - (pricy *.15); textko = "Discounted"; }
            if(status == 3 && card == 2) { pricy = pricy - (pricy *.20);  pricy = pricy - (pricy *.20);  textko = "Discounted"; }
 
            payment += pricy;
            transfer = 0;
         }
 
        String dep = platters[initial]; String dep1 = platters[finale];
        System.out.print("-----------------------------------------------------------------\nTerminal "+terminal + " | From  " + dep + " To  " + dep1 + " | Ride Fee: Php " + pricy + " " + textko);
 
        int sta = 0;
        System.out.print("\n(1- Ride Again ");
        if(terminal == 3 && (finale == 3 || finale == 12))
        {
            System.out.print(" | 2- Change Station");
            sta = 1;
        }
        System.out.print(" | any key to Get Off) ->");
        int soample = scanner.nextInt();
 
        if(soample == 1) {  
            initial = finale;
            ride = 1;
            lrt3(scanner, payment, terminal, initial, finale, card, status, ride, transfer);
        } else if(soample == 2 && sta == 1) {
            ride = 0;
            //terminal101(scanner, payment,card,status,ride);
            transfer = 1;
            if(finale == 3) // cubao lrt 2
            {
                ride = 1;
                finale = 7;
                terminal = 2;
                lrt2(scanner, payment, terminal, initial, finale, card, status, ride, transfer);   
            }
 
            if(finale == 12) // taft lrt 1
            {
                ride = 1;
                terminal = 1;
                finale = 1;
                lrt1(scanner, payment, terminal, initial, finale, card, status, ride, transfer);   
            }
        } else {
            System.out.println("-----------------------------------------------------------------\nTotal Payment " + payment);
        }
    }
}