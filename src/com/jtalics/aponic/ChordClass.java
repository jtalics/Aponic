package com.jtalics.aponic;

public enum ChordClass {
	Maj(new int[]{4,7}),        // major 0,4,7
	MajMaj7(new int[]{4,7,11}), // major major seventh 0,4,7,11
	MajMin7(new int[]{4,7,10}), // major minor seventh 0,4,7,10
	Aug(new int[]{4,8}),        // augmented 0,4,8
	AugMaj7(new int[]{4,8,11}), // augmented major seventh 0,4,8,11
	AugMin7(new int[]{4,8,10}), // augmented minor seventh 0,4,8,10

	Min(new int[]{3,7}),        // minor 0,3,7
	MinMin7(new int[]{3,7,10}), // minor minor seventh 0,3,7,10
	MinMaj7(new int[]{3,7,11}), // minor major seventh 0,3,7,11
	Dim(new int[]{3,6}),        // diminished 0,3,6 - eerie and ominous
	Dim7(new int[]{3,6,9}),     // diminished seventh 0,3,6,9 
	Dim7Half(new int[]{3,6,10});// half diminished seventh 0,3,6,10
	
	final int[] semitones; 

	private ChordClass(int[] semitones) {
		this.semitones = semitones;
	}
	
}