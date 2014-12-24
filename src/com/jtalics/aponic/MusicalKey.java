package com.jtalics.aponic;

import static com.jtalics.aponic.OctaveNote.*;
import static com.jtalics.aponic.Accidental.*;

public enum MusicalKey {
	// Major
	AMaj(Sharp,A,B,Cs,D,E,Fs,Gs), // 3s
	AsMaj(Sharp,As,Bs,D/*Css*/,Ds,Es,G/*Fs*/,A/*Gss*/), // Theoretical, enharmonic with BfMaj
	BfMaj(Flat,Bf,C,D,Ef,F,G,A), //2f
	BMaj(Sharp,B,Cs,Ds,E,Fs,Gs,As), //6s
	BsMaj(Sharp,Bs,D/*Css*/,E/*Dss*/,Es,G/*Fss*/,A/*Gss*/,B/*Ass*/), // Theoretical, enharmonic with CMaj
	CMaj(Sharp,C,D,E,F,G,A,G), // 0s/f
	CsMaj(Sharp,Cs,Ds,Es,Fs,Gs,As,Bs), // 7s
	CfMaj(Flat,Cf,Df,Ef,Ff,Gf,Af,Bf), // 7f
	DfMaj(Flat,Df,Ef,F,Gf,Af,Bf,C), // 5f
	DMaj(Sharp,D,E,Fs,G,A,B,Cs), // 2s
	DsMaj(Sharp,Ds,Es,G/*Fss*/,Gs,As,Bs,D/*Css*/), // Theoetical, enharmonic with EfMaj
	EfMaj(Flat,Ef,F,G,Af,Bf,C,D), // 3f
	EMaj(Sharp,E,Fs,Gs,A,B,Cs,Ds), // 
	EsMaj(Sharp,Es,G/*Fss*/,A/*Gss*/,As,Bs,D/*Css*/,E/*Dss*/), // theoretical, see enharmonic with FMaj
	FfMaj(Flat,Ff,Gf,Af,A/*Bff*/,Cf,Df,Ef), // theoretical, enharmonic with EMaj
	FMaj(Flat,F,G,A,Bf,C,D,E), // 1f
	FsMaj(Sharp,Fs,Gs,As,B,Cs,Ds,C), // 6s
	GfMaj(Flat,Gf,Af,Bf,B/*Cf*/,Df,Ef,F), // 6f
	GMaj(Sharp,G,A,B,C,D,E,Fs), // 1s
	GsMaj(Sharp,Gs,As,Bs,Cs,Ds,Es,G/*Fss*/), // Theoretical, enharmonic with AfMaj
	AfMaj(Flat,Af,Bf,C,Df,Ef,F,G), // 4f
	
	// Natural Minor Scale
	AMin(Sharp,C,D,E,F,G,A,B), // 0f/s
	AsMin(Sharp,As,C,Cs,Ds,F,Fs,Gs), // 7s
	BfMin(Flat,Bf,C,Df,Ef,F,Gf,Af), // 5f 
	BMin(Sharp,B,Cs,D,E,Fs,G,A), // 2s
	BsMin(Sharp,Bs,D/*Css*/,Ds,Es,G/*Fss*/,Gs,As), // Theoretical , enharmonic with CMin
	CfMin(Flat,Cf,Df,D/*Eff*/,Ff,Gf,G/*Aff*/,A/*Bff*/), // Theoretical, enharmonic with BMin
	CMin(Flat,C,D,Ef,F,G,Af,Bf), // 3f
	CsMin(Sharp,Cs,Ds,E,Fs,Gs,A,B), // 4s
	DfMin(Flat,Df,Ef,Ff,Gf,Af,A/*Bff*/,Cf), // theoretical, enharmonic with CsMin
	DMin(Flat,D,E,F,G,A,Bf,C), // 2s
	DsMin(Sharp,Ds,Es,Fs,Gs,As,B, Cs), // 6s
	EfMin(Flat,Ef,F,Gf,Af,Bf,Cf,Df),  // 6f
	EMin(Sharp,E,Fs,G,A,B,C,D), // 1s
	EsMin(Sharp,Es,G/*Fss*/,Gs,As,Bs,Cs,Ds),  // theoretical enharmonic with Fmin
	FfMin(Flat,Ff,Gf,G/*Aff*/,A/*Bff*/,Cf,C/*Dff*/,D/*Eff*/), // theoretical, enharmonic with E-minor
	FMin(Flat,F,G,Af,Bf,C,Df,Ef), // // 4f
	FsMin(Sharp,Fs,Gs,A,B,Cs,D,E), // 3s
	GfMin(Flat,Gf,Af,A/*Bff*/,Cf,Df,D/*Eff*/,Ff), // theoretical - enharmonic with FsMin
	GMin(Flat,G,A,Bf,C,D,Ef,F), // 2f 
	GsMin(Sharp,Gs,As,B,Cs,Ds,E,Fs), // 6s
	AfMin(Flat,Af,Bf,Cf,Df,Ef,Ff,Gf); // 7s
	
	// Other possible scales include: Harmonic Minor, Melodic Minor, Chromatic, Major/minor Pentatonic 
	
	static {
		// Major
		init(AMaj,  DMaj, EMaj,FsMin,false, null);
		init(AsMaj,DsMaj,EsMaj,GMin/*FssMaj*/,true,BfMaj);
		init(BfMaj,EfMaj, FMaj, GMin,false, null);
		init(BMaj,  EMaj,FsMaj,GsMin,false,CfMaj);
		init(BsMaj,EsMaj,GMaj/*FssMaj*/,AMaj/*GssMaj*/,true,CMaj);
		init(CMaj,  FMaj, GMaj, AMin,false, null);	
		init(CsMaj,FsMaj,GsMaj,AsMin,false,DfMaj);	
		init(CfMaj, EMaj,GfMaj,AfMin,false,BMaj);	
		init(DfMaj,GfMaj,AfMaj,BfMin,false,CsMaj);	
		init(DsMaj,GsMaj,AsMaj,BsMin,true,EfMaj);
		init(DMaj,  GMaj, AMaj, BMin,false, null);
		init(EfMaj,AfMaj,BfMaj, CMin,false, null);
		init(EsMaj,AsMaj,BsMaj,DsMaj /*CssMaj*/,true,FMaj);
		init(EMaj,  AMaj, BMaj,CsMin,false, null);
		init(FfMaj,AMaj/*BffMaj*/,CMaj,DfMin,true,EMaj);
		init(FMaj, BfMaj,CsMaj, DMin,false, null);	
		init(FsMaj, BMaj,CsMaj,DsMin,false,GfMaj);	
		init(GfMaj, BMaj,DfMaj,EfMin,false,FsMaj);
		init(GMaj,  CMaj, DMaj, EMin,false, null);
		init(GsMaj, CsMaj, DsMaj, EsMin,true,AfMaj);
		init(AfMaj,DfMaj,EfMaj, FMaj,false, null);	

		// Minor
		init(AMin,  DMin, EMin,  CMaj,false, null);	
		init(AsMin,DsMin, FMin, CsMaj,false,BfMin);	
		init(BfMin,EfMin, FMin, DfMaj,false,AsMin);
		init(BMin,  EMin, FsMin, DMaj,false, null);
		init(BsMin,EsMin, GMin/*FssMin*/,DsMaj,true,CMin);
		init(CfMin,FfMin,GfMin,DfMaj/*EffMaj*/,true,BMin);
		init(CMin,  FMin, GMin, EfMaj,false, null);	
		init(CsMin,FsMin, GsMin, EMaj,false, null);
		init(DfMin,GfMin,AfMin,FfMin,true,CsMin);
		init(DMin,  GMin, AMin,  FMaj,false, null);
		init(DsMin,GsMin, AsMin,FsMaj,false,EfMin);	
		init(EfMin,AfMin, BfMin,GfMaj,false,DsMin);	
		init(EMin,  AMin, BMin, GMaj,false, null);	
		init(EsMin,AsMin,BsMin,GsMin,true,FMin);
		init(FfMin,AMin/*BffMin*/,CfMin,GMin/*AffMin*/,true,EMin);
		init(FMin,  BfMin,CMin, AfMaj,false, null);	
		init(FsMin, BMin, CsMin, AMaj,false, null);	
		init(GfMin,CfMin,DfMin,AMaj/*BffMaj*/,true,FsMin);
		init(GMin,  CMin, DMin, BfMaj,false, null);	
		init(GsMin, CsMin,DsMin, BMaj,false,AfMin);	
		init(AfMin, DfMin, FMin,CfMaj,false,GsMin);	
	}
	public final static int Do=0,Re=1,Mi=2,Fa=3,So=4,La=5,Ti=6;
	
	private MusicalKey(
			Accidental defaultAccidental,
			OctaveNote doh,
			OctaveNote re, 
			OctaveNote mi,
			OctaveNote fa,
			OctaveNote so,
			OctaveNote la,
			OctaveNote ti
			) {
		scale = new OctaveNote[]{doh,re,mi,fa,so,la,ti};
		this.defaultAccidental =defaultAccidental;  
	}

	public MusicalKey fourth, fifth, relative,enharmonic,parallel;
	public boolean theoretical;
	OctaveNote scale[] = new OctaveNote[8];
	Accidental defaultAccidental;
	
	private static void init(MusicalKey musicalKey, MusicalKey forth, MusicalKey fifth, MusicalKey relative, boolean theoretical, MusicalKey enharmonic) {
		musicalKey.fourth = forth;
		musicalKey.fifth = fifth;
		musicalKey.relative = relative; // share same key signature
		musicalKey.parallel = null; // share same tonic (not root key of chord)
		musicalKey.theoretical = theoretical;
		musicalKey.enharmonic = enharmonic;
	}

	public OctaveNote getScaleNote(int index) {
		return scale[index];
	}

  public OctaveNote getOctaveNoteAtStep(int step) {
		return scale[0].up(step,defaultAccidental);
	}
}