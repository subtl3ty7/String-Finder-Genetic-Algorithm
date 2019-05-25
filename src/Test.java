import java.util.*;

public class Test {


    public static void main(String[] args) {

        final String gene_pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890,.-;:_!\"#%&/()=?@${[]}";

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Please enter the target string: ");
        String target = scanner.next();
        System.out.println(target);
        System.out.println("How big do you want your population to be? I recommend at least 1000 individuals for diversity and less dependency on mutations");
        int population_size = scanner.nextInt();
        //Start Generation from 1
        int generation = 1;
        boolean found = false;
        //Create a population of input size as list of random individuals. This is generation 1.
        List<Individual> population = new ArrayList<>(population_size);
        for (int i = 0; i < population_size; i++) population.add(new Individual(gene_pool,target));



        while(!found){

            //Sort population on their fitness levels. Best one is the one with less fitness level.
            Collections.sort(population, Comparator.comparing(Individual::getFitness));

            //If the best one is 0, meaning we reached our target string, stop searching.
            if (population.get(0).getFitness() <= 0){
                found = true;
                break;
            }

            //Create new empty generation of size population_size
            List<Individual> new_generation = new ArrayList<>(population_size);

            //Get 10 percent of the population_size
            int percent = (10*population_size)/100;
            //Only first (best) 10 percent of the population can go in next generation. (ELITISM)
            for (int i = 0; i < percent; i++) new_generation.add(population.get(i));

            //Get rest of population
            percent = population_size - percent;
            //For remaining 90 percent of population_size
            for (int i = 0; i < percent; i++){
                //We are only gonna mate the first 50 percent of the current population
                int random_int = (int)(Math.random() * ((population_size/2)+1));
                Individual parent1 = population.get(random_int);
                random_int = (int)(Math.random() * ((population_size/2)+1));
                Individual parent2 = population.get(random_int);

                //An Individual can not mate with itself.
                while(parent1.equals(parent2)){
                    random_int = (int)(Math.random() * ((population_size/2)+1));
                    parent2 = population.get(random_int);
                }
                //Add the resulting child to new generation
                Individual child = parent1.mate(parent2);
                new_generation.add(child);
            }
            //Replace the population with new generation
            population = new_generation;

            System.out.println("Generation: " + generation + " | String: " + Arrays.toString(population.get(0).getChromosome().getGenes()) + " | Fitness: " + population.get(0).getFitness());
            generation++; //Increase Generation count by one
        }

        System.out.println("Generation: " + generation + " | String: " + Arrays.toString(population.get(0).getChromosome().getGenes()) + " | Fitness: " + population.get(0).getFitness());










    }
}
