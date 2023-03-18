package ro.usv.rf.exceptions;

public class DimensiuniDiferite extends RuntimeException {
        public DimensiuniDiferite(int p1, int p2){
            super("p1=" + p1 +", p2=" + p2);
        }
}