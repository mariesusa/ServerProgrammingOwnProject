package ServerProgramming.PhysicalRecordings.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Condition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String condition;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "condition")
	private List<Condition> conditions;
	
	public Condition() {}
	
	public Condition(String condition) {
		super();
		this.condition = condition;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public List<Condition> getConditions() {
		return conditions;
	}
	
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	
	@Override
	public String toString() {
		return "Condition [id=" + id + ", condition=" + condition + "]";
	}

}
