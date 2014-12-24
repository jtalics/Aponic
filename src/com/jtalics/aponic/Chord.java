package com.jtalics.aponic;

public class Chord {
	public static final byte LOG_ON = 0x01;
	public final Pitch pitches[];
	public final String name;
	
	public String getName() {
		return name;
	}

	public Chord(String name, Pitch[] pitches) {
		this.name=name;
		this.pitches = pitches;
	}
	
	@Override
	public String toString() {
		return name;
	}
}