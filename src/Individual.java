public class Individual {

    private Chromosome chromosome;
    private int fitness; //number of different genes from target string
    private String target, gene_pool;


    //Empty Constructor
    public Individual(){

    }
    //Constructor to create a random Individual (Used at the beginning)
    public Individual(String gene_pool,String target){
        this.gene_pool = gene_pool;
        this.target = target;
        char[] genes = createGenesFromGenePool();
        this.chromosome = new Chromosome(genes);
        this.fitness = calculateFitness(genes);
    }

    //Creates a gene of random characters from genepool in length of target String
    public char[] createGenesFromGenePool(){
        char[] genes = new char[target.length()];

        for (int i = 0; i < target.length(); i++){
            int random_integer = (int)(Math.random() * (gene_pool.length()));
            genes[i] = gene_pool.charAt(random_integer);
        }
        return genes;
    }


    //Calculate the fitness of this individual
    public int calculateFitness(char[] genes){
        int temp = 0;
        for (int i = 0; i < genes.length; i++){
            if(genes[i] != target.charAt(i)){
                temp++;
            }
        }
        return temp;
    }

    //Returns a random character from gene pool
    public char mutate(){
        int random_integer = (int)(Math.random() * (gene_pool.length()));
        return gene_pool.charAt(random_integer);
    }

    //Mates this individual with a partner
    public Individual mate(Individual partner){
        Individual child = new Individual();
        child.setGene_pool(gene_pool);
        child.setTarget(target);
        char[] parent1_genes = this.chromosome.getGenes();
        char[] parent2_genes = partner.getChromosome().getGenes();
        char[] child_genes = new char[target.length()];
        Chromosome child_Chromosome = new Chromosome();

        //for each gene, if probability is lower than 45, inherit parent1,
        // if probability is lower than 90, inherit parent2,
        // else with 10% chance place a mutated gene.
        for (int i = 0; i < child_genes.length; i++){
            int probability = (int)(Math.random() * (101));

            if(probability < 45){
                child_genes[i] = parent1_genes[i];
            }
            else if(probability < 90){
                child_genes[i] = parent2_genes[i];
            } else{
                child_genes[i] = mutate();
            }
        }
        child_Chromosome.setGenes(child_genes);
        child.setChromosome(child_Chromosome);
        return child;
    }

    //Setters & Getters
    public void setGene_pool(String gene_pool) {
        this.gene_pool = gene_pool;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setChromosome(Chromosome chromosome) {
        this.chromosome = chromosome;
        fitness = calculateFitness(this.chromosome.getGenes());
    }

    public Chromosome getChromosome() {
        return chromosome;
    }

    public int getFitness() {
        return fitness;
    }
}
