package coms309.demo2.model;
import javax.persistence.*;
@Entity
@Table(name = "insurance")
public class InsuranceProvider {

	@Column(name = "name")
	private String name;
}
