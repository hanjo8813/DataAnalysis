package kr.ac.sejong.data_analysis.first_project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Comparable {
	private int from;
	private int to;
	private long t;

	public Message(int from, int to, long t) {
		super();
		this.from = from;
		this.to = to;
		this.t = t;
	}

	@Override
	public String toString() {
		// https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		return from + " -> " + to + " at " + sdf.format(new Date(t*1000));
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public long getT() {
		return t;
	}

	public void setT(long t) {
		this.t = t;
	}

    @Override
	public int compareTo(Object o) {
		Message another_msg = (Message)o;
		if(this.t> another_msg.to)
			return 1;
		else if(this.t < another_msg.to)
			return -1;
		else
			return 0;
	}
}

// Message 클래스