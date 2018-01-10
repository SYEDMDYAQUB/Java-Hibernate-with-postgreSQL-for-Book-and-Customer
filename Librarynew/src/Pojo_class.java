import org.hibernate.SQLQuery;

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
public class Pojo_class{

//<---->DISPLAY THE CONTENTS OF THE TABLE
public static void print1(Session session, String query)
{
	SQLQuery qry = session.createSQLQuery(query);
	List l =qry.list();
	 System.out.println("Total Number Of Records : "+l.size());
	 Iterator it = l.iterator();
	 
	 
	 while(it.hasNext())
	 {
	 Object o[] = (Object[])it.next();
	 
	 for(Object item:o)
	 {
		 System.out.print(item+"   |   ");
	 }
	 System.out.println();
	 //System.out.println("Supplierid : "+o[0]+ "\t Supplierphoneno : "+o[1]);
	 
	 } 
}


//<----->INSERTING IN THE TABLE
public static void insert(Session session,ArrayList<Object> obj) 
{
	for(Object i:obj)
	 {
		session.save(i);
	 }
//	 session.update(suppi);
}

//<----->DELETION FROM A TABLE
public static void delete(Session session, String tablename)
{
	
	/*Supplier cat = new Supplier();
	 cat.setSupplierId(10);
	 session.delete(cat);*/
	 //ORRR
	 SQLQuery del=session.createSQLQuery("delete from "+tablename);
     del.executeUpdate();
     
}
	public static void main(String[] args){
 try
 {
	 SessionFactory factory = new AnnotationConfiguration().addAnnotatedClass(Book.class).addAnnotatedClass(Customer.class).configure().buildSessionFactory();
	 Session session = factory.openSession();
     Transaction tx=session.beginTransaction();
 	ArrayList<Object> obj=new ArrayList(); 
 	
     System.out.println("INSERTION IN THE BOOK'S TABLE");
     Book suppi=new Book();
	 suppi.setBookid(21);
	 suppi.setNoofcopies(8);
	 suppi.setBookname("Reema1");
	 obj.add(suppi);

	 System.out.println("PRINTING OF BOOK'S TABLE");
	String query1="select * from Book ";
	print1(session,query1);
	

	
	System.out.println("INSERTION IN THE CUSTOMER'S TABLE");
	
	Customer cust=new Customer();
	
	 cust.setCustomerid(7);
	 cust.setCustomerage(21);
	 cust.setCustomername("Yaqub");
	 obj.add(cust);
	 
	 insert(session,obj);
	 System.out.println("PRINTING OF CUSTOMER'S TABLE");
	 String query2="select * from customer ";
	 print1(session,query2);
	 
	 
	 session.flush();
	
	 
	 
	//insert(session);
	delete(session,"book");
	delete(session,"customer");
	 tx.commit();
 session.close();
 factory.close();

 }
 catch(Exception e) {
	 System.out.println(e.getMessage());
 } 
}

}