import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="customer")
public class Customer{
 @Id
 @Column(name="customer_id")
 private int Customerid;
 @Column(name="customer_age")
 private int Customerage; 
 @Column(name="customer_name")
 private String Customername;
public int getCustomerid() {
	return Customerid;
}
public void setCustomerid(int customerid) {
	this.Customerid = customerid;
}
public int getCustomerage() {
	return Customerage;
}
public void setCustomerage(int customerage) {
	this.Customerage = customerage;
}
public String getCustomername() {
	return Customername;
}
public void setCustomername(String customername) {
	this.Customername = customername;
}

}
 