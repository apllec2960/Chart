package vo;

public class Tips {
   private int index;
   private double total;
   private double tip;
   private String sex;
   private String smoker;
   private String day;
   private String time;
   private int size;
   @Override
   public String toString() {
      return "tips [index=" + index + ", total=" + total + ", tip=" + tip + ", sex=" + sex + ", smoker=" + smoker
            + ", day=" + day + ", time=" + time + ", size=" + size + "]";
   }
   public int getIndex() {
      return index;
   }
   public void setIndex(int index) {
      this.index = index;
   }
   public double getTotal() {
      return total;
   }
   public void setTotal(double total) {
      this.total = total;
   }
   public double getTip() {
      return tip;
   }
   public void setTip(double tip) {
      this.tip = tip;
   }
   public String getSex() {
      return sex;
   }
   public void setSex(String sex) {
      this.sex = sex;
   }
   public String getSmoker() {
      return smoker;
   }
   public void setSmoker(String smoker) {
      this.smoker = smoker;
   }
   public String getDay() {
      return day;
   }
   public void setDay(String day) {
      this.day = day;
   }
   public String getTime() {
      return time;
   }
   public void setTime(String time) {
      this.time = time;
   }
   public int getSize() {
      return size;
   }
   public void setSize(int size) {
      this.size = size;
   }
   
   
}