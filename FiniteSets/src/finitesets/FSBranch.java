package finitesets;

public class FSBranch implements FiniteSet {
    int root;
    FiniteSet left;
    FiniteSet right;
    
    public FSBranch(int root, FiniteSet left, FiniteSet right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }
    
    public FiniteSet empty() {
        return new FSEmpty();
    }
    
    public int cardinality() {
        return 1 + left.cardinality() + right.cardinality();
    }

    public boolean isEmptyHuh() {
        return false;
    }
    
    public boolean member(int elt) {
        return false;
    }
    
    public FiniteSet add(int elt) {
        return this;
    }
    
    public FiniteSet remove(int elt) {
        return this;
    }
    
    public FiniteSet union(FiniteSet u) {
        return this;
    }
    
    public FiniteSet inter(FiniteSet u) {
        return this;
    }
    public FiniteSet diff(FiniteSet u) {
        return this;
    }
    public boolean equal(FiniteSet u) {
        return false;
    }
    public boolean subset(FiniteSet u) {
        return false;
    }
}