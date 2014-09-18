package finitesets;

public class FiniteSets {

    ///////////////////////
    /////// TESTING ///////
    ///////////////////////
    
    // reiteration of empty method as bypass of static requirement
    // returns a fresh empty set
    public static FiniteSet empty() {
        return new FSEmpty();
    }

    // for all x y s, x.union(y).subset(s) = x.subset(s) && y.subset(s)
    // for all x y, max(x.cardinality(), y.cardinality()) <= 
    //           x.union(y).cardinality() <= x.cardinality() + y.cardinality()
    // for all t u x, (member inter(t u) x) = member t x && member u x
    // FOR ESSAY: Establish a standard, say why it's a good standard,
    //            then cite lines of code that illustrate the standard is met
    static FiniteSet tree = empty();
    static FiniteSet tree2 = empty().add(1).add(2);
    static FiniteSet tree3 = empty().add(1).add(2).add(4).add(5);

    public static int test() {
        return tree.add(4).add(5).add(3).cardinality();
    }

    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(tree2.remove(1).cardinality());
        System.out.println(tree2.remove(2).member(2));
        System.out.println(tree2.union(tree3).member(4));
        System.out.println(tree2.union(tree3).cardinality());
        System.out.println(tree2.inter(tree3).member(2));
        System.out.println(tree2.isEmptyHuh());
        System.out.println(tree.isEmptyHuh());
        System.out.println(tree2.diff(tree3).member(2));
        System.out.println(tree.equal(tree2.remove(2).remove(1)));
        System.out.println(tree2.subset(tree3));

    }

}
