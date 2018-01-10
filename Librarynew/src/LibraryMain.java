import org.hibernate.SQLQuery;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;

import javax.imageio.spi.ServiceRegistry;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
public class LibraryMain{
	public static void main(String[] args){
 try
 {
	 
	 SessionFactory factory = new AnnotationConfiguration().addAnnotatedClass(Book.class).addAnnotatedClass(Customer.class).addAnnotatedClass(book_issue.class).configure().buildSessionFactory();
	 Session session = factory.openSession();
     Transaction tx=session.beginTransaction(); 
 	
  
     Book suppi1=new Book();
	 suppi1.setBookid(11);
	 suppi1.setNoofcopies(10);
	 suppi1.setBookname("Tea");
	
	
	  Customer cust1=new Customer();
	
	 cust1.setCustomerid(181);
	 cust1.setCustomerage(11);
	 cust1.setCustomername("Utkarsh Mathur");

	 book_issue book_iss=new book_issue();
	 //book_iss.setIssue_id(1);
	 book_iss.setNo_of_days(10);
	 book_iss.setStart_date(null);
	 book_iss.setBook(suppi1);
	 book_iss.setCustomer(cust1);
	 
	 session.save(suppi1);
	 session.save(cust1);
	 session.save(book_iss);
	 //session.update(book_iss);
	 tx.commit();
	 
session.flush();	
session.close();
factory.close();

 }
 catch(Exception e) {
	 System.out.println(e.getMessage());
 } 
}

}