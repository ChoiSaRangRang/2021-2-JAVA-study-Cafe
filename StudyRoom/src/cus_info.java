
public class cus_info {
   private String name;
   private int seat_no;
   private int in_time;
   
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
   public cus_info() {
      seat_no=0;
      in_time=0;
   }
   public cus_info(String name, int seat_no, int in_time) {
      super();
      this.name = name;
      this.seat_no = seat_no;
      this.in_time = in_time;
   }
   
}