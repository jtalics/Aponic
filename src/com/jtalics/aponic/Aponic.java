package com.jtalics.aponic;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;

import com.jtalics.aponic.track.TestCofTrack;

public class Aponic implements MetaEventListener {

	public static final int CONTROLLER_CHORD_CHANGE = 28;
	private static final int TICKS_PER_BEAT = 10000;

	public static void main(String[] args) throws InvalidMidiDataException {
		new Aponic().run();
	}

	private final Player player = new Player();

	public void run() throws InvalidMidiDataException {


		Sequence sequence = loadSequence(new Sequence(Sequence.PPQ, TICKS_PER_BEAT));
		Sequencer sequencer = player.getSequencer();
		sequencer.setTempoInBPM(500);
		sequencer.addMetaEventListener(this);
		
		player.play(sequence, true);
		
		// turn off the drums
		//System.out.println("Playing (without drums)...");
		
		//sequencer.setTrackMute(DRUM_TRACK, true);
	}

	@Override
	public void meta(MetaMessage event) {
		switch(event.getType()) {
		case Player.END_OF_TRACK_MESSAGE:
			System.out.println("Exiting...");
			player.close();
			System.exit(0);
			break;
		case Chord.LOG_ON:
			System.out.println(new String(event.getData()));
			break;
		default:
			break;	
		}
	}

	static Sequence loadSequence(Sequence sequence) throws InvalidMidiDataException {

		Track t = sequence.createTrack();
		int ticksPerBeat = sequence.getResolution();
		new TestCofTrack(ticksPerBeat).buildTrack(t);
		return sequence;
	}

}

