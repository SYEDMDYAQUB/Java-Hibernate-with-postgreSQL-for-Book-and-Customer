import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name="Book")
public class Book{
 @Id
 @Column(name="book_id")
 private int Bookid;
 @Column(name="book_name")
 private String Bookname; 
 @	Column(name="no_of_copies")
 private int Noofcopies;
 

 public int getBookid() {
	return Bookid;
}
public void setBookid(int bookid) {
	this.Bookid = bookid;
}
public String getBookname() {
	return Bookname;
}
public void setBookname(String bookname) {
	this.Bookname = bookname;
}
public int getNoofcopies() {
	return Noofcopies;
}
public void setNoofcopies(int noofcopies) {
	this.Noofcopies = noofcopies;
}

}