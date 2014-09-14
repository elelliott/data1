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
    
    // empty() returns a new instance of the empty set
    public FiniteSet empty() {
        return new FSEmpty();
    }
    
    // cardinality() returns number of elts in set (length)
    public int cardinality() {
        // length = length of left branch + length of right branch + root
        return 1 + left.cardinality() + right.cardinality();
    }

    // isEmptyHuh() returns true if set is empty
    public boolean isEmptyHuh() {
        // instance of FSBranch is never empty, return false
        return false;
    }
    
    // member(elt) returns true if elt is a member of (this) set
    public boolean member(int elt) {
        if (this.root == elt) {
            // if root = elt, elt is a member of the set
            return true;
        } else {
            // if root != elt, check in the left and right branches
            return this.left.member(elt) || this.right.member(elt);
        }
    }
    
    // add(elt) returns a set containing all elements of (this) set and elt
    public FiniteSet add(int elt) {
       return this;
    }
    
    // remove(elt) returns a set containing all elts of (this) set except elt
    public FiniteSet remove(int elt) {
        return this;
    }
    
    // union(u) returns a set containing all elts of (this) set
    // and all elts of set u
    public FiniteSet union(FiniteSet u) {
        return this;
    }
    
    // inter(u) returns a set containing all elts that are included in
    // BOTH (this) set and set u
    public FiniteSet inter(FiniteSet u) {
        return this;
    }
    
    // diff(u) returns a set containing elts of set u except those that
    // also appear in (this) set
    public FiniteSet diff(FiniteSet u) {
        return this;
    }
    
    // equal(u) returns true if (this) set and set u contain exactly
    // the same elements
    public boolean equal(FiniteSet u) {
        return false;
    }
    
    // subset(u) returns true if (this) set is a subset of set u
    public boolean subset(FiniteSet u) {
        return false;
    }
}