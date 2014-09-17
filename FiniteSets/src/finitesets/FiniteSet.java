package finitesets;

public interface FiniteSet {
    
    // this finite set implementation uses binary search trees with
    // requirements such that:
    //      : trees are not consructed with duplicate roots
    //      : anything in the left branch is smaller than the root and
    //        anything in the right branch is larger than the root

    // empty : no input --> fs
    // returns a new empty set
    FiniteSet empty();
    // cardinality : fs --> int
    // t.cardinality() returns the number of elts in set t
    int cardinality();
    // isEmptyHuh : fs --> bool
    // t.isEmptyHuh() returns true if set t is empty, false otherwise
    boolean isEmptyHuh();
    // member : fs, int --> bool
    // t.member(elt) returns true if elt is an element of set t, false otherwise
    boolean member(int elt);
    // add : fs, int --> fs
    // t.add(elt) returns a set containing elt and everything in set t
    // ENSURES that no duplicate roots can be added to set t
    FiniteSet add(int elt);
    // remove : fs, int --> fs
    // t.remove(elt) returns the set that results when elt is removed from set t
    // REQUIRES that set t has no duplicate roots
    FiniteSet remove(int elt);
    // union : fs, fs --> fs
    // t.union(u) returns the set that contains all elements from sets t and u
    FiniteSet union(FiniteSet u);
    // inter : fs, fs --> fs
    // t.inter(u) returns the set that contains the elements which are contained
    // in set t AND in set u
    FiniteSet inter(FiniteSet u);
    // diff : fs, fs --> fs
    // t.diff(u) returns the set containing the elements that are contained
    // in set u except the elements that are also members of set t
    FiniteSet diff(FiniteSet u);
    // equal : fs, fs --> bool
    // t.equal(u) returns true if the sets contain the same
    // elements, false otherwise
    boolean equal(FiniteSet u);
    // subset : fs, fs --> bool
    // t.subset(u) returns true if set t is a subset of set u, false otherwise
    boolean subset(FiniteSet u);
    
    
}
