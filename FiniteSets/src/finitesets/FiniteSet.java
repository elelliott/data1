package finitesets;

interface FiniteSet {

    // empty() returns a new empty set
    FiniteSet empty();
    // t.cardinality() returns the number of elts in set t
    int cardinality();
    // t.isEmptyHuh() returns true if set t is empty, false otherwise
    boolean isEmptyHuh();
    // t.member(elt) returns true if elt is an element of set t, false otherwise
    boolean member(int elt);
    // t.add(elt) returns a set containing elt and everything in set t
    FiniteSet add(int elt);
    // t.remove(elt) returns the set that results when elt is removed from set t
    FiniteSet remove(int elt);
    // t.union(u) returns the set that contains all elements from sets t and u
    FiniteSet union(FiniteSet u);
    // t.inter(u) returns the set that contains the elements which are contained
    // in set t AND in set u
    FiniteSet inter(FiniteSet u);
    // t.diff(u) returns the set containing the elements that are contained
    // in set u except the elements that are also members of set t
    FiniteSet diff(FiniteSet u);
    // t.equal(u) returns true if the sets contain the same
    // elements, false otherwise
    boolean equal(FiniteSet u);
    // t.subset(u) returns true if set t is a subset of set u, false otherwise
    boolean subset(FiniteSet u);
    
    
}
