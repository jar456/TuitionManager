
public class Instate extends Student {
   
   private int funds;
   
   public Instate(String fname, String lname, int credit, int funds) {
      super(fname, lname, credit);
      
      this.funds = funds;
   }

   @Override
   public int tuitionDue() {
      // TODO Auto-generated method stub
      return 0;
   }

}
