import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class ListBooking {

    public ListBooking(){

    }

    private int countBooking = 0;
    // Clear
    private void ClearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    // Lấy danh sách Booking
    private ArrayList<Booking> getListBooking(){
        ArrayList<Booking> books = new ArrayList<>();
        File file = new File("books.txt");
        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                countBooking++;
                books.add(new Booking(sc.nextLine(),sc.nextLine()));
            }
        } catch (FileNotFoundException e ){
            System.out.println("File Not Found");
        }
        return books;
    }
    // Xuất danh sách Booking
    public void ShowListBooking(){
        ArrayList<Booking> books = getListBooking();
        Scanner sc = new Scanner(System.in);
        System.out.print("ID Room   ID Customer\n");
        for(Booking book : books)
        {
            System.out.println(book.getIdRoom()+ "  "+book.getIdCustomer());
        }
    }
    private void UpdateFile(ArrayList<Booking> books, String idRoom){
        try {
            FileWriter fileWriter = new FileWriter("books.txt", false);
            for(Booking book : books){
                if(!idRoom.equals(book.getIdRoom())){
                    fileWriter.write(book.getIdRoom() + "\n");
                    fileWriter.write(book.getIdCustomer() + "\n");
                }   
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
}
// Thêm Booking
    public void AddBooking(){
        Scanner sc = new Scanner(System.in);
        System.out.print("ID Room : ");
        String idRoom = sc.nextLine();
        System.out.print("ID Customer : ");
        String idCustomer = sc.nextLine();
        try{
            FileWriter filewriter = new FileWriter("books.txt",true);
            filewriter.write(idRoom + "\n");
            filewriter.write(idCustomer + "\n");
            filewriter.close();
        } catch ( IOException e ){
            System.out.print("Error"+ e.getMessage());
        }
    }
    // Xóa Booking
    public void DeleteBooking(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Booking> books = getListBooking();
        System.out.print("Input ID Room To Delete : ");
        String idRoom = sc.nextLine(); 
        int check = 0;
        for(Booking book : books){
            if(idRoom.equals(book.getIdRoom())){
                check++;
            }
        } 
        if(check == 0){
            System.out.print("ID Is Not Founded !!");
            sc.nextLine();
            return ;
        }
        UpdateFile(books, idRoom);
        if(check>=1){
            System.out.print("Deleted");
            sc.nextLine();
        }
    }
    // Sửa Booking
    public void FixBooking(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Booking> books = getListBooking();
        ClearScreen();
        ShowListBooking();
        System.out.println();
        System.out.print("Input ID Room To Fix : ");
        String idRoom = sc.nextLine();
        ClearScreen();
        for ( Booking book : books){
            if(idRoom.equals(book.getIdRoom())){
                System.out.print("ID Room    ID Customer ");
                System.out.print(book.getIdRoom()+"  "+book.getIdCustomer());
            }
        }
        System.out.println();
        FixBookingMenu(idRoom);
    }
    private void FixBookingMenu(String idRoom){
        Scanner sc = new Scanner(System.in);
        ArrayList<Booking> books = getListBooking();
        int isChoose = 0;
        int changeChoice = 0;
        do{
            isChoose = 1;
            System.out.print("1. Change ID Room : \n");
            System.out.print("2. Change ID Customer : \n");
            System.out.print("Please Input Your Order : ");
            changeChoice = sc.nextInt();
            if(changeChoice < 0 || changeChoice > 2)
            {
                isChoose = 0;
                System.out.print("There Is No Choice Found !!");
                sc.nextLine();
            }
        } while ( isChoose != 1);
        ClearScreen();
        sc.nextLine();
        String changeText = "";
        switch (changeChoice) {
            case 1:
                System.out.print("ID Room : ");
                changeText = sc.nextLine();
                break;
            case 2 :
                System.out.print("ID Customer : ");
                changeText = sc.nextLine();
                break;
            default:
                break;
        }
        for(Booking book : books){
            if(idRoom.equals(book.getIdRoom()))
            {
                if(changeChoice==1){
                    book.setIdRoom(changeText);
                }
                if(changeChoice==2){
                    book.setIdCustomer(changeText);
                }
            }
        }
        ClearScreen();
        WriteFile(books);
        System.out.println("Change is successful !!");
        sc.nextLine();
    }
    // Ghi vào file mới 
    private void WriteFile(ArrayList<Booking> books){
        try {
                FileWriter fileWriter = new FileWriter("books.txt", false);
                for(Booking book : books){
                    fileWriter.write(book.getIdRoom() + "\n");
                    fileWriter.write(book.getIdCustomer() + "\n");
                }
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error" + e.getMessage());
            }
    }
    // Tìm Booking
    public void FindBooking(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Booking> books = getListBooking();
        System.out.print("Input ID Room To Find : ");
        String idRoom = sc.nextLine();
        for(Booking book : books){
            if(idRoom.equals(book.getIdRoom())){
                System.out.println("ID Room    ID Customer");
                System.out.println(book.getIdRoom() + "  " + book.getIdCustomer());
                sc.nextLine();
                return;
            }
        }
        System.out.println("Booking is not Founded");
    }
}