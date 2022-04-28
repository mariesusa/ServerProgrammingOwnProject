package ServerProgramming.PhysicalRecordings.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Recording {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1, max=500)
	private String artist;
	
	@Size(min=1, max=500)
	private String title;
	
	@Min(value = 1)
	private int year;
	
	private String label;
	private String comment;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "formatid")
	private Format format;
	
	@ManyToOne
	@JoinColumn(name = "conditionid")
	private Condition condition;
	
	@ManyToOne
	@JoinColumn(name = "genreid")
	private Genre genre;
	
	public Recording() {}
	
	public Recording(String artist, String title, int year, String label, String comment, double price, Format format, Condition condition, Genre genre) {
		super();
		this.artist = artist;
		this.title = title;
		this.year = year;
		this.label = label;
		this.comment = comment;
		this.price = price;
		this.format = format;
		this.condition = condition;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		if (this.format != null || this.condition != null || this.genre != null)
		return "Recording [id=" + id + ", artist=" + artist + ", title=" + title + ", year=" + year + ", label=" + label + ", comment=" + comment + ", price=" + price + ", format=" + this.getFormat() + ", condition=" + this.getCondition() + ", genre=" + this.getGenre() + "]";
		else {
			return "Recording [id=" + id + ", artist=" + artist + ", title=" + title + ", year=" + year + ", label=" + label + ", comment=" + comment + ", price=" + price + "]";
		}
	}
}
