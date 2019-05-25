import java.util.HashSet;

public class Chromosome {
    //each gene is a character. Every Chromosome contains n genes.
    char[] genes;

    public Chromosome(){};

    public Chromosome(char[] genes){
        this.genes = genes;
    }

    public char[] getGenes() {
        return genes;
    }


    public void setGenes(char[] genes) {
        this.genes = genes;
    }
}
