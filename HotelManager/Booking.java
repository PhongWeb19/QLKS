public class Booking {
    private String idRoom;
    private String idCustomer;
    public Booking()
    {
        idRoom = "";
        idCustomer = "";
    }
    public Booking(String idRoom , String idCustomer)
    {
        this.idRoom = idRoom;
        this.idCustomer = idCustomer;
    }
    public void setIdRoom(String idRoom)
    {
        this.idRoom = idRoom;
    }
    public String getIdRoom()
    {
        return idRoom;
    }
    public void setIdCustomer(String idCustomer)
    {
        this.idCustomer = idCustomer;
    }
    public String getIdCustomer()
    {
        return idCustomer;
    }
}