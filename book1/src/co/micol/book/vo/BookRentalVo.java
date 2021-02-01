package co.micol.book.vo;

import java.sql.Date;

public class BookRentalVo {
   private Date rentaldate;
   private String bookcode;
   private String memberid;
   private String returndate;

   public Date getRentaldate() {
      return rentaldate;
   }

   public void setRentaldate(Date rentaldate) {
      this.rentaldate = rentaldate;
   }

   public String getBookcode() {
      return bookcode;
   }

   public void setBookcode(String bookcode) {
      this.bookcode = bookcode;
   }

   public String getMemberid() {
      return memberid;
   }

   public void setMemberid(String memberid) {
      this.memberid = memberid;
   }

   public String getReturndate() {
      return returndate;
   }

   public void setReturndate(String returndate) {
      this.returndate = returndate;
   }

}