package kspcalc.stagecalc;

import java.util.HashMap;

import kspcal.utils.Parts;
import kspcalc.math.StageMathVanilla;

public interface StageCalc {
	public void doMath();
	public int getStageIndex();
	public StageMathVanilla getStage();
	public void setStageCalculator(HashMap<Parts, Integer> stageParts, int stage);
}
