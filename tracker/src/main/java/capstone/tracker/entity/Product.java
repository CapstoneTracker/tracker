package capstone.tracker.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_tbl")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int uID;
  private int prodName;
  private int loc;
  private int qty;
  private int date;
}