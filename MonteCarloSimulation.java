//==============================================================================
//   Modern Portfolio Theory - Monte Carlo Simulation
//   March 2020
//==============================================================================
import java.util.*;

public class MonteCarloSimulation{
    double initial_investment;
    double inflation_rate;
    int period; 

    MonteCarloSimulation(){}
    MonteCarloSimulation(double initial_investment, double inflation_rate, int period){
        this.initial_investment = initial_investment;
        this.inflation_rate = inflation_rate;
        this.period = period;
    }

    // ==============================================================================================================================
  
    public Percentile calc_func(int sims_no, double mean, double sD){
        
        double[] array_results = new double[sims_no];
        Percentile values = new Percentile(0,0,0);
        Random randomNo = new Random(); // create random object

        for(int j=0;j<sims_no;j++){
            array_results[j] = this.initial_investment;
            for(int i=0;i<this.period;i++) array_results[j] = array_results[j]*(1+mean + sD*randomNo.nextGaussian())*(1-this.inflation_rate);
        }

        Arrays.sort(array_results);

        values.tenth_percentile = array_results[sims_no/10]; // 10th percentile value
        values.median = array_results[sims_no/2];  // Median value
        values.ninetieth_percentile = array_results[sims_no/10*9]; // 90th percentile value

        return values;
    } // End calc_func()
    // ==============================================================================================================================

    public static void main(String args[]) {
        // --------------------------------------------------------
        double initial_investment = 100000; // $100000
        double inflation_rate = 3.5/100; //3.5% inflation_rate per year
        int period = 20; //Number of years
     // --------------------------------------------------------       
        int sims_no = 10000; // Number of simulations
        double mean_Aggressive = 9.4324/100;
        double sD_Aggressive = 15.675/100;
        double mean_Conservative = 6.189/100;
        double sD_Conservative = 6.3438/100;
    // --------------------------------------------------------

        //Conservative
        MonteCarloSimulation portfolio = new MonteCarloSimulation(initial_investment, inflation_rate, period);

        // Aggressive
        Percentile percentiles = portfolio.calc_func(sims_no, mean_Aggressive, sD_Aggressive);
        System.out.printf("\n-------------------\n\tAggressive:\n10th Percentile:\t $%.2f \nMedian:\t\t\t\t $%.2f \n90th Percentile:\t $%.2f", 
            percentiles.get_tenth_percentile(),percentiles.get_median(), percentiles.get_ninetieth_percentile());
        
        // Conservative
        percentiles = portfolio.calc_func(sims_no, mean_Conservative, sD_Conservative);
        System.out.printf("\n\n-------------------\n\tConservative:\n10th Percentile:\t $%.2f \nMedian:\t\t\t\t $%.2f \n90th Percentile:\t $%.2f\n", 
            percentiles.get_tenth_percentile(),percentiles.get_median(), percentiles.get_ninetieth_percentile());


    }// End main()
    // ==============================================================================================================================
}
