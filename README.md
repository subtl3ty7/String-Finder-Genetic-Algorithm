# String-Finder-Genetic-Algorithm
A Genetic Algorithm to find any String of any length with any characters provided in Gene Pool.

This Java program uses a genetic algorithm to find the correct input String provided by the user.
The algorithm steps follows:

1- Initialize random individual population of user input size 

2- Calculate fitness of each individuals and sort them in ascending order.

3- Perform elitism by letting the first 10% of the population (with lowest fitness scores) to pass to the next generation.

4- For the remaining population size, select parents from first 50% of the current population.

5- Mate (aka Gene Crossover) the parents with a chance of 10% Gene Mutation (for maintaining diversity in population)

6- Go to 2 unless an Individual from any generation with fitness value 0 found.


The program finds the fitness value by comparing the genes(Chromosome) to the target String and based off on character differences. (Lower fitness means, Individual's genes are more close to finding a solution.)
Genetic Algorithms are inspired from natural evolution and selection. They provide useful solutions for most optimization and search problems. Genetic Algorithms are also often used with Neural Networks in Self-Learning problems such as finishing a game, reaching a solution efficiently etc. and is called Neuro-evolution.

This program is for demonstration purposes.
