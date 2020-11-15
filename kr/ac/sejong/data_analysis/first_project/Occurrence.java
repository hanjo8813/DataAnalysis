package kr.ac.sejong.data_analysis.first_project;

public class Occurrence {
	private int id;
	private int occurrence;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOccurrence() {
		return occurrence;
	}

	public void setOccurrence(int occurrence) {
		this.occurrence = occurrence;
	}
	
	public Occurrence(int id) {
		super();
		this.id = id;
	}
	
	public Occurrence(int id, int occurrence) {
		super();
		this.id = id;
		this.occurrence = occurrence;
	}
	public Occurrence()
	{
		
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Occurrence occ = (Occurrence) obj;
		return this.id == occ.getId();
	}
	@Override
	public String toString() {
		return id + " -> " + occurrence;
	}

}
