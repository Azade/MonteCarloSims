//==============================================================================
//   Modern Portfolio Theory - Monte Carlo Simulation second file
//   March 2020
//==============================================================================

public class Percentile {
    double tenth_percentile, median, ninetieth_percentile;

    Percentile(double tenth_percentile, double median, double ninetieth_percentile) {
        this.tenth_percentile = tenth_percentile;
        this.median = median;
        this.ninetieth_percentile = ninetieth_percentile;
    }

    public double get_tenth_percentile() {
        return tenth_percentile;
    }

    public double get_median() {
        return median;
    }

    public double get_ninetieth_percentile() {
        return ninetieth_percentile;
    }
}