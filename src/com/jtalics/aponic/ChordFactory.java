package com.jtalics.aponic;
import java.util.HashMap;
import java.util.Map;


public class ChordFactory {

	private static Map<String, Chord> chordMap = new HashMap<String, Chord>();
	private static Map<String, Chord[]> chordProgressionMap = new HashMap<String, Chord[]>();
	private static ChordFactory self;
		
	public enum CofPath {
		Alternative(new Leg[]{}/*"r,o; i,i"*/),
		Canon(new Leg[]{}/*"C,Gi; Amo,r,o; Emr,i; F, C, F,C"*/),
		Cliche(new Leg[]{}/*"C,G,Am,F"*/),
		Cliche2(new Leg[]{}/*"C,Am,Em,Bdim"*/),
		Creepy(new Leg[]{}/*"C,Am,F,G"*/),
		Creepy2(new Leg[]{}/*"C,Am,Dm,G"*/),
		Endless(new Leg[]{}/*"C,Am,Dm,F"*/),
		Energetic(new Leg[]{}/*"C,Em,F,Am"*/),
		Grungy(new Leg[]{}/*"C,F,Em,Am"*/),
		Memories(new Leg[]{}/*"C,F,C,G"*/),
		Rebellious(new Leg[]{}/*"F,C,F,G"*/),
		Sad(new Leg[]{}/*"C,F,G,G"*/),
		Simple(new Leg[]{}/*"C,F"*/),
		Simple2(new Leg[]{}/*"C,G"*/),
		Wistful(new Leg[]{}/*"C,C,F,Am"*/);
	
		public enum Step {
			// which neighbor?
			Relative,
			Fourth,
			Fifth,
			Stay
		}

		public enum Mod {
			Aug5, // fifth up one semitone
			Dim5, // fifth down one semitone
			Maj7, // add seventh
			Min7, // add minor seventh
			Dim7,  // add diminished (minor) seventh
			None
		}

		public static class Leg {
			private final Step[] cofSteps;
			private final Mod cofMod;

			public Leg(Step[] cofSteps, Mod cofMod) {
				this.cofSteps = cofSteps;
				this.cofMod = cofMod;
			}
		}
		
		public final Leg[] legs;

		private CofPath(Leg[] legs) {
			this.legs=legs;
		}
	}
	
	public static ChordFactory getInstance() {
		if (self == null) {
			return self;
		}
		return self = new ChordFactory();
	}

	public static Chord getChord(MusicalKey musicalKey, ChordClass chordClass, int octave, int inversion) {

		String name = musicalKey.name()+"-"+octave+"-"+inversion;
		Chord chord = chordMap.get(name);
		if (chord != null) {
			return chord;
		}
		
		Pitch[] pitches = new Pitch[chordClass.semitones.length+1];
		int i=0;
		pitches[i++] =Pitch.getPitch(musicalKey.scale[0],octave);
		for (int step : chordClass.semitones) {
			OctaveNote octaveNote = musicalKey.getOctaveNoteAtStep(step);
			pitches[i++] = Pitch.getPitch(octaveNote,octave);
		}
		chord = new Chord(name,pitches);
		chordMap.put(name,chord);
		
		return chord;
	}
/*	
	public static Chord[] getChordProgression(String name,int octave, int inversion) {
		Chord[] chordProgression = chordProgressionMap.get(name);
		if (chordProgression != null) {
			return chordProgression;
		}
		switch(name) {
		
		}
		Pitch[] pitches = new Pitch[chordClass.semitones.length+1];
		int i=0;
		pitches[i++] =Pitch.getPitch(musicalKey.scale[0],octave);
		for (int step : chordClass.semitones) {
			OctaveNote octaveNote = musicalKey.getOctaveNoteAtStep(step);
			pitches[i++] = Pitch.getPitch(octaveNote,octave);
		}

		chord = new Chord(name,pitches);
		chordMap.put(name,chord);
		
		return chord;		
	}
	Chord[] alternative = new Chord[]{AMaj,FMaj,CMaj,GMaj};
	Chord[] canon = new Chord[]{CMaj,GMaj,AMaj,EMaj,FMaj,CMaj,FMaj,GMaj};
	MusicalKey[] cliche = new Chord[]{CMaj,GMaj,AMaj,FMaj};
	MusicalKey[]  = new MusicalKey[]{};
	MusicalKey[]  = new MusicalKey[]{};
	MusicalKey[]  = new MusicalKey[]{};
	MusicalKey[]  = new MusicalKey[]{};
	MusicalKey[]  = new MusicalKey[]{};
	MusicalKey[]  = new MusicalKey[]{};
	MusicalKey[]  = new MusicalKey[]{};
*/
}