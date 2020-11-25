package f2_stream;

public class f2_Email implements Comparable<f2_Email>{
	private int source;
	private int destination;
	
	public f2_Email(int source, int destination) {
		super();
		this.source = source;
		this.destination = destination;
	}
	
	public int getSource() {
		return source;
	}
	
	public void setSource(int source) {
		this.source = source;
	}
	
	public int getDestination() {
		return destination;
	}
	
	public void setDestination(int destination) {
		this.destination = destination;
	}

	@Override
	public int compareTo(f2_Email o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
