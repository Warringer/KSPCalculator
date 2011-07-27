package kspcalc.stagecalc;

import java.util.HashMap;

import kspcal.utils.Parts;
import kspcalc.math.StageMath;

public interface StageCalc {
	public void doMath();
	public int getStageIndex();
	public StageMath getStage();
	public void setStageCalculator(HashMap<Parts, Integer> stageParts, int stage);
}
