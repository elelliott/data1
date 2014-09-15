package finitesets;

public class FSEmpty implements FiniteSet {
    int root;
    
    public FSEmpty() {  }
    
    // empty() returns new empty set
    public FiniteSet empty() {
        return new FSEmpty();
    };
    
    // cardinality method returns length of set
    public int cardinality() {
        // empty set has 0 elements
        return 0;
    };
    
    // isEmptyHuh() returns true if set is empty
    public boolean isEmptyHuh() {
        // always true that empty set is empty; return true
        return true;
    }
    
    // member(elt) returns true if elt is a member of set
    public boolean member(int elt) {
        // elt will never be contained in an empty set; return false
        return false;
    }
    
    // add(elt) returns (this) set with elt also included
    public FiniteSet add(int elt) {
        // (this) set is empty, so return a new set containing one element, elt
        return new FSBranch(elt);
    }
    
    // remove(elt) returns an equivalent set with elt removed
    public FiniteSet remove(int elt) {
        // remove something from empty set: return an empty set.
        return this;
    }
    
    // union(u) returns a set containing all elements from both sets
    public FiniteSet union(FiniteSet u) {
        // empty set contains no elements: return u
        return u;
    }
    
    // inter(u) returns a set containing elements contained in both sets
    public FiniteSet inter(FiniteSet u) {
        // empty set contains no elements, thus has no elts in
        // common with u: return empty set
        return this;
    }
    
    // diff(u) returns set containing elts of set u except those that
    // also appear in (this) set
    public FiniteSet diff(FiniteSet u) {
        // empty sets contain no elts, so no elts are excluded from u
        // return u
        return u;
    }
    
    // equal(u) returns true if both sets contain exactly the same elts
    public boolean equal(FiniteSet u) {
        // empty set contains no elts, so return true if set u is
        // also empty
        return u.isEmptyHuh();
    }
    
    // subset(u) returns true if (this) set is a subset of u
    public boolean subset(FiniteSet u) {
        // the empty set is a subset of ANY set: return true
        return true;
    }
    
}