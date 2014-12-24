package com.jtalics.aponic.track;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

import com.jtalics.aponic.Chord;
import com.jtalics.aponic.ChordClass;
import com.jtalics.aponic.ChordFactory;
import com.jtalics.aponic.MusicalKey;
import com.jtalics.aponic.OctaveNote;

public class TestTrack extends TrackBuilder {

	public TestTrack(int ticksPerBeat) {
		super(ticksPerBeat);
	}
	
	@Override
	public Track buildTrack(Track track) throws InvalidMidiDataException {
		
		turnOnGeneralMidi(track);
		setTempo(track,60); // 1M microsec per beat * 60M microsec / min = 60BPM
		setTrackName(track,"test track");

		int channel=10;
		setOmniOff(track, channel);
		setPolyOn(track);
		ChordFactory chordFactory = ChordFactory.getInstance();
		
		double beat=0.0;
		for (int voice = 0; voice < 128; voice++) {
			System.out.println("VOICE "+voice+": "+voiceNames[voice]);
			setVoice(track,channel,voice, beat);
			Chord chord = ChordFactory.getChord(MusicalKey.CMaj,ChordClass.Maj,4,0);
			addChord(track,channel,beat,chord,0.5);

			beat++;
		}
		eot(track, beat);
		return track;
	}
	
	public static void main(String[] args) {

	}

}
