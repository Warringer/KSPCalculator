package kspcalc.stagecalc;

import java.awt.Dimension;

import kspcalc.math.StageMath;

public interface StageCalc {
	public void doMath();
	public int getStageIndex();
	public StageMath getStage();
	public String getName();
	public Dimension getPrefferedSize();
}
