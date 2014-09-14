package finitesets;

public class FSBranch implements FiniteSet {

    int root;
    FiniteSet left;
    FiniteSet right;

    public FSBranch(int root) {
        this.root = root;
        this.left = new FSEmpty();
        this.right = new FSEmpty();
    }

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
        if (this.member(elt)) {
            // don't want duplicates in sets: if already
            // a member, return the set
            return this;
        } else {
            if (this.root > elt) {
                // if root > elt, elt must go to the left of root
                if (this.left.isEmptyHuh()) {
                    // if left is empty, create a branch with root elt
                    this.left = new FSBranch(elt);
                } else {
                    // if left is not empty, add elt to left branch
                    this.left.add(elt);
                }
            } else {
                // if root < elt, elt must go to the right of root
                if (this.right.isEmptyHuh()) {
                    // if right is empty, create a branch with root elt
                    this.right = new FSBranch(elt);
                } else {
                    // if right is not empty, add elt to right branch
                    this.right.add(elt);
                }
            }
        }
        // return the set with elt added
        return this;
    }

    // remove(elt) returns a set containing all elts of (this) set except elt
    public FiniteSet remove(int elt) {
        return this;
    }

    // union(u) returns a set containing all elts of (this) set
    // and all elts of set u
    public FiniteSet union(FiniteSet u) {
        FiniteSet temp = new FSEmpty();
       // ...
        return temp;
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
        // true iff root is a member of u and the left and right branches are
        // also contained in u
        return u.member(this.root) && this.left.equal(u) && this.right.equal(u);
    }

    // subset(u) returns true if (this) set is a subset of set u
    public boolean subset(FiniteSet u) {
        // returns true if this and u are equal, or...
        return this.equal(u) ||
               // if the length of the difference b/t this and u
               // is equal to the length of u minus the length of this
               // (all elts of this were present in u s.t. they were removed
               // by diff method --> length(diff) = length(u) - length(this))
               this.diff(u).cardinality() == u.cardinality() - this.cardinality();
    }
}
