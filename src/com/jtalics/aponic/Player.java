package com.jtalics.aponic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;

class Player implements MetaEventListener {

	// Midi meta event
	public static final int END_OF_TRACK_MESSAGE = 47;

	private Sequencer sequencer;

	private boolean loop;

	private boolean paused;

	public Player() {
		try {
/*
			Synthesizer synth = MidiSystem.getSynthesizer();
			Soundbank soundbank = synth.getDefaultSoundbank();
			boolean b = synth.isSoundbankSupported(soundbank);
			boolean loaded = synth.loadAllInstruments(soundbank);
			for (Instrument inst : synth.getLoadedInstruments()) {
				System.out.println(inst.getName());
			}
			
			for (Instrument inst : synth.getAvailableInstruments()) {
				System.out.println(inst.getName());
			}
*/
			MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
			MidiDevice midiDevice = null;
			for (int i = 0; i < infos.length; i++) {
				midiDevice = MidiSystem.getMidiDevice(infos[i]);
				if (midiDevice.getDeviceInfo().getName().equals("USB Audio Device [2]")) {
					break;
				}
				midiDevice = null;
			}
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			Receiver receiver = midiDevice.getReceiver();
			sequencer.getTransmitter().setReceiver(receiver);			
		}
		catch (MidiUnavailableException ex) {
			sequencer = null;
		}
	}

	/**
	 * Loads a sequence from the file system. Returns null if an error occurs.
	 */
	public Sequence getSequence(String filename) {
		try {
			return getSequence(new FileInputStream(filename));
		}
		catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Loads a sequence from an input stream. Returns null if an error occurs.
	 */
	public Sequence getSequence(InputStream is) {
		try {
			if (!is.markSupported()) {
				is = new BufferedInputStream(is);
			}
			Sequence s = MidiSystem.getSequence(is);
			is.close();
			return s;
		}
		catch (InvalidMidiDataException ex) {
			ex.printStackTrace();
			return null;
		}
		catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Plays a sequence, optionally looping. This method returns immediately. The
	 * sequence is not played if it is invalid.
	 */
	public void play(Sequence sequence, boolean loop) {
		if (sequencer != null && sequence != null && sequencer.isOpen()) {
			try {
				sequencer.setSequence(sequence);
				sequencer.start();
				this.loop = loop;
			}
			catch (InvalidMidiDataException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * This method is called by the sound system when a meta event occurs. In this
	 * case, when the end-of-track meta event is received, the sequence is
	 * restarted if looping is on.
	 */
	@Override
	public void meta(MetaMessage event) {
		if (event.getType() == END_OF_TRACK_MESSAGE) {
			if (sequencer != null && sequencer.isOpen() && loop) {
				sequencer.start();
			}
		}
	}

	/**
	 * Stops the sequencer and resets its position to 0.
	 */
	public void stop() {
		if (sequencer != null && sequencer.isOpen()) {
			sequencer.stop();
			sequencer.setMicrosecondPosition(0);
		}
	}

	/**
	 * Closes the sequencer.
	 */
	public void close() {
		if (sequencer != null && sequencer.isOpen()) {
			sequencer.close();
		}
	}

	/**
	 * Gets the sequencer.
	 */
	public Sequencer getSequencer() {
		return sequencer;
	}

	/**
	 * Sets the paused state. Music may not immediately pause.
	 */
	public void setPaused(boolean paused) {
		if (this.paused != paused && sequencer != null && sequencer.isOpen()) {
			this.paused = paused;
			if (paused) {
				sequencer.stop();
			}
			else {
				sequencer.start();
			}
		}
	}

	/**
	 * Returns the paused state.
	 */
	public boolean isPaused() {
		return paused;
	}
}