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
public class Format {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String format;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "format")
	private List<Format> formats;
	
	public Format() {}
	
	public Format(String format) {
		super();
		this.format = format;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public List<Format> getFormats() {
		return formats;
	}
	
	public void setFormats(List<Format> formats) {
		this.formats = formats;
	}
	
	@Override
	public String toString() {
		return "Format [id=" + id + ", format=" + format + "]";
	}

}
