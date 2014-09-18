package finitesets;

import java.util.Random;

public class FiniteSets {

    ///////////////////////
    /////// TESTING ///////
    ///////////////////////
    
    
    // reiteration of empty method as bypass of static requirement
    // returns a fresh empty set
    public static FiniteSet empty() {
        return new FSEmpty();
    }

    // a randomizer for number generation
    static Random randomizer = new Random();

    // randFS : no input --> fs
    // generates a random finite set of random length (max. 100) and
    // random entries (each element max. value 50)
    public static FiniteSet randFS() {
        FiniteSet tree = empty();
        int numElts = randomizer.nextInt() % 100;
        for (int i = 0; i < numElts; i++) {
            // add method ensures no duplicates arise
            tree = tree.add(randomizer.nextInt() % 50);
        }
        return tree;
    }

    //////////////////////////// PROPERTIES ////////////////////////////
    
    // for all x y s, x.union(y).subset(s) = x.subset(s) && y.subset(s)
    public static void checkUnionSubset() {
        for (int i = 0; i < 15; i++) {
            FiniteSet x = randFS();
            FiniteSet y = randFS();
            FiniteSet s = randFS();
            boolean answer = (x.union(y).subset(s) == (x.subset(s) && y.subset(s)));
            System.out.println(answer + " should be " + true);
        }
    }

    // for all x y, max(x.cardinality(), y.cardinality()) <= 
    //           x.union(y).cardinality() <= x.cardinality() + y.cardinality()
    public static void checkUnionCard() {
        for (int i = 0; i < 15; i++) {
            FiniteSet x = randFS();
            FiniteSet y = randFS();
            int xlength = x.cardinality();
            int ylength = y.cardinality();
            boolean answer = ((Math.max(xlength, ylength) <= (x.union(y).cardinality()))
                    && (x.union(y).cardinality() <= (xlength + ylength)));
            System.out.println(answer + " should be " + true);
        }
    }

    // for all t u x, t.inter(u).member(x) = t.member(x) && u.member(x)
    public static void checkMemberInter() {
        for (int i = 0; i < 15; i++) {
            FiniteSet t = randFS();
            FiniteSet u = randFS();
            // x % 50 to mirror element value restriction in randFS
            int x = randomizer.nextInt() % 50;
            boolean answer = (t.inter(u).member(x) == (t.member(x) && u.member(x)));
            System.out.println(answer + " should be " + true);
        }
    }

    // for all t x y, t.add(x).member(y) = true <-> x = y \/ t.member(y) = true
    public static void checkMemberAdd() {
        for (int i = 0; i < 15; i++) {
            FiniteSet t = randFS();
            int x = randomizer.nextInt() % 50;
            int y = randomizer.nextInt() % 50;
            boolean answer = (t.add(x).member(y) == ((x == y) || t.member(y)));
            System.out.println(answer + " should be " + true);
        }
    }

    // t.union(s).member(x) = true <-> s.member(x) = true \/ t.member(x) = true
    public static void checkMemberUnion() {
        for (int i = 0; i < 15; i++) {
            FiniteSet s = randFS();
            FiniteSet t = randFS();
            int x = randomizer.nextInt() % 50;
            boolean answer = (t.union(s).member(x) == (s.member(x) || t.member(x)));
            System.out.println(answer + " should be " + true);
        }
    }

    // for all t u, t.subset(u) = true <-> t.equal(u) || 
    //           t.diff(u).cardinality() == u.cardinality() - t.cardinality()
    public static void checkSubEqualDiff() {
        for (int i = 0; i < 15; i++) {
            FiniteSet t = randFS();
            FiniteSet u = randFS();
            boolean answer = (t.subset(u) == (t.equal(u)
                    || t.diff(u).cardinality() == u.cardinality() - t.cardinality()));
            System.out.println(answer + " should be " + true);
        }
    }

    // FOR ESSAY: Establish a standard, say why it's a good standard,
    //            then cite lines of code that illustrate the standard is met
    
    public static void main(String[] args) {
        System.out.println("Union & Subset property check:");
        checkUnionSubset();
        System.out.println("Union & Cardinality property check:");
        checkUnionCard();
        System.out.println("Member & Inter property check:");
        checkMemberInter();
        System.out.println("Member & Add property check:");
        checkMemberAdd();
        System.out.println("Member & Union property check:");
        checkMemberUnion();
        System.out.println("Subset, Equal, Diff/Cardinality property check:");
        checkSubEqualDiff();

    }

}
