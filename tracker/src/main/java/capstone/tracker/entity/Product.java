package capstone.tracker.entity;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="uID")
  private int uID;
  private String prodName;
  private String loc;
  private int qty;
  @CreationTimestamp
  private Date date;

  public Product(String prodName, int qty, String loc){
    this.prodName = prodName;
    this.qty=qty;
    this.loc=loc;
  }
}