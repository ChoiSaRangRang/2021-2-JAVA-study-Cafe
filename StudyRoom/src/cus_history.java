
public class cus_history {
   private int id;
   private String name;
   private int seat_no;
   private int in_time;
   private int out_time;
   private int income;
   
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public int getIncome() {
      return income;
   }
   public void setIncome(int income) {
      this.income = income;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getSeat_no() {
      return seat_no;
   }
   public void setSeat_no(int seat_no) {
      this.seat_no = seat_no;
   }
   public int getIn_time() {
      return in_time;
   }
   public void setIn_time(int in_time) {
      this.in_time = in_time;
   }
   public int getOut_time() {
      return out_time;
   }
   public void setOut_time(int out_time) {
      this.out_time = out_time;
   }
   
   public cus_history() {
      super();
      // TODO Auto-generated constructor stub
   }
   
   public cus_history(int id, String name, int seat_no, int in_time, int out_time, int income) {
      super();
      this.id = id;
      this.name = name;
      this.seat_no = seat_no;
      this.in_time = in_time;
      this.out_time = out_time;
      this.income = income;
   }
}