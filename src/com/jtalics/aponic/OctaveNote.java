package com.jtalics.aponic;

public enum OctaveNote {
	C(0,Accidental.Natual),
	Cs(1,Accidental.Sharp),
	Df(1,Accidental.Flat),
	D(2,Accidental.Natual),
	Ds(3,Accidental.Sharp),
	Ef(3,Accidental.Flat),
	E(4,Accidental.Natual),
	Es(5,Accidental.Sharp),
	Ff(4,Accidental.Flat),
	F(5,Accidental.Natual),
	Fs(6,Accidental.Sharp),
	Gf(6,Accidental.Flat),
	G(7,Accidental.Natual),
	Gs(8,Accidental.Sharp),
	Af(8,Accidental.Flat),
	A(9,Accidental.Natual),
	As(10,Accidental.Sharp),
	Bf(10,Accidental.Flat),
	B(11,Accidental.Natual),
	Bs(0,Accidental.Sharp),
	Cf(11,Accidental.Flat);
	
	private static final OctaveNote steps[][] = new OctaveNote[12][];
	static {
		steps[0]=new OctaveNote[]{Bs,C};
		steps[1]=new OctaveNote[]{Cs,Df};
		steps[2]=new OctaveNote[]{D};
		steps[3]=new OctaveNote[]{Ds,Ef};
		steps[4]=new OctaveNote[]{E,Ff};
		steps[5]=new OctaveNote[]{F};
		steps[6]=new OctaveNote[]{Fs,Gf};
		steps[7]=new OctaveNote[]{G};
		steps[8]=new OctaveNote[]{Gs,Af};
		steps[9]=new OctaveNote[]{A};
		steps[10]=new OctaveNote[]{As,Bf};
		steps[11]=new OctaveNote[]{B,Cf};
	}

	private final int step;
	private final Accidental accidental;
	
	private OctaveNote(int step, Accidental accidental) {
		this.step = step;
		this.accidental = accidental;
	}

	private static OctaveNote[] getStepNames(int step) {
		return steps[step];
	}
	
	public OctaveNote up(int steps, Accidental defaultAccidental) {
		OctaveNote[] octaveNotes = this.steps[(step+steps)%12];
		if (octaveNotes.length == 1) {
			return octaveNotes[0];
		}
		OctaveNote nat = null;
		for (OctaveNote octaveNote : octaveNotes) {
			if (octaveNote.accidental == defaultAccidental) {
				return octaveNote;
			}
			if (octaveNote.accidental == Accidental.Natual) {
				nat = octaveNote;
			}
		}
		return nat;
	}
}