package com.jtalics.aponic.track;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

import com.jtalics.aponic.*;
import com.jtalics.aponic.Pitch;

public class TestArpegTrack extends TrackBuilder {

	public TestArpegTrack(int ticksPerBeat) {
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
		int voice = 18;
		for (MusicalKey musicalKey : MusicalKey.values()) {
			//System.out.println("MusicalKey: "+ musicalKey);
			setVoice(track,channel,voice, beat);
			Chord chord = ChordFactory.getChord(musicalKey,ChordClass.Maj,4,0);
			addArpeggio(track,channel,beat,chord,1.0);

			beat++;
		}
		eot(track, beat);
		return track;
	}
	
	public static void main(String[] args) {

	}

}
