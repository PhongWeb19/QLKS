import java.util.Scanner;
public class MainInterface{
    private static int choice = 0;
    private static int choiceMax = 5;

    public static void main(String[] args){
        MainMenu();
    }
    
    private static void ClearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static void MainMenu(){
        while(choice != 1){
            switch (choice){
                case 0 : 
                    Menu();
                    break;
                case 1: 
                    break;
                case 3:
                    // RoomMenu();
                    break;
                case 5 :
                    BookingMenu();
                default:
                    break;
            }
        }
    }

    private static void Menu(){
        Scanner sc = new Scanner(System.in);
        int isChoose = 0;
        do{
            ClearScreen();
            isChoose = 1;
            System.out.println("1 : Exit");
            System.out.println("2 : Staff Manager");
            System.out.println("3 : Room Manager");
            System.out.println("4 : Customer Manager");
            System.out.println("5 : Booking Manager");
            System.out.println();
            System.out.print("Please Input Your Choice: ");
            choice = sc.nextInt();
            if(choice > choiceMax || choice <= 0){
                isChoose = 0;
                System.out.println("Error");
                sc.nextLine();
            }
        }while(isChoose == 0);
    }
    private static void BookingMenu(){
        ListBooking lb = new ListBooking();
        int choose ;
        Scanner sc = new Scanner(System.in);
        System.out.println("1.add");
        System.out.println("2.fix");
        System.out.println("3.delete");
        System.out.println("4.find");
        System.out.println("Nhap phuong an : ");
        choose = sc.nextInt();
        switch (choose) {
            case 1:
                ClearScreen();
                lb.AddBooking();
                break;
            case 2 :
                ClearScreen();
                lb.ShowListBooking();
                lb.FixBooking();
                break;
            case 3 :
                ClearScreen();
                lb.ShowListBooking();
                lb.DeleteBooking();
                break;
            case 4 :
                ClearScreen();
                lb.ShowListBooking();
                lb.FindBooking();
                break;
            default:
                break;
        }
    }

}


