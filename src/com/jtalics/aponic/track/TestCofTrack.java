package com.jtalics.aponic.track;

import java.util.Random;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

import com.jtalics.aponic.*;

public class TestCofTrack extends TrackBuilder {

	public TestCofTrack(int ticksPerBeat) {
		super(ticksPerBeat);
	}
	
	@Override
	public Track buildTrack(Track track) throws InvalidMidiDataException {
		
		turnOnGeneralMidi(track);
		
//		setTempo(track,120); // 1M microsec per beat * 60M microsec / min = 60BPM
		setTrackName(track,"test track");

		int channel=0;
		setOmniOff(track, channel);
		setPolyOn(track);
		ChordFactory chordFactory = ChordFactory.getInstance();
		
		double beat=0.0;
		int voice = 21;
		MusicalKey musicalKey = MusicalKey.AMin;
		int n=0;
		setVoice(track,channel,voice, beat);
		Random r = new Random();
		while(n++<5000) {
			System.out.println("MusicalKey: "+ musicalKey);
			Chord chord = ChordFactory.getChord(musicalKey,ChordClass.Maj,4,0);
			addChord(track,channel,beat,chord,1.0);
			switch(r.nextInt(3)) {
			case 0:
				musicalKey = musicalKey.fourth;
				break;
			case 1:
				musicalKey = musicalKey.fifth;
				break;
			case 2:
				musicalKey = musicalKey.relative;
				break;
			}
			beat++;
		}
		eot(track, beat);
		return track;
	}
	
	public static void main(String[] args) {

	}

}
