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
        // returns true if this element = elt, if not: checks in left
        // and right branches
        return this.root == elt || this.left.member(elt) || this.right.member(elt);
    }

    // add(elt) returns a set containing all elements of (this) set and elt
    // prevents duplication
    public FiniteSet add(int elt) {
        if (this.member(elt)) {
            // don't want duplicates in sets: if already
            // a member, return the set
            return this;
        } else {
            if (this.root > elt) {
                // if root > elt, elt must be added to the left of root
                return new FSBranch(this.root, this.left.add(elt), this.right);
            } else {
                // if root < elt, elt must be added to the right of root
                return new FSBranch(this.root, this.left, this.right.add(elt));
            }
        }
    }

    // remove(elt) returns a set containing all elts of (this) set except elt
    // REQUIRES that trees not contain duplicates (ensured by add method)
    public FiniteSet remove(int elt) {
        // elt must be a member of this to be removed from this
        if (this.member(elt)) {
            if (this.root == elt) {
                // if this.root is elt, return a new set that combines the
                // left and right branches of this (excluding elt)
                return this.left.union(this.right);
            } else {
                // if this.root is not elt, return a set containing elt
                // with any instance of elt removed from the rest of the set
                return new FSBranch(this.root,
                        this.left.remove(elt), this.right.remove(elt));
            }
        } else {
            // if elt is not a member of this, return this
            return this;
        }
    }

    // union(u) returns a set containing all elts of (this) set
    // and all elts of set u
    public FiniteSet union(FiniteSet u) {
        // place set u into a temporary variable
        FiniteSet temp = u;
        // temp should include this.root (add checks for membership)
        // and the its unions with the left and right branches of this
        temp = temp.add(this.root).union(this.left).union(this.right);
        // return the temp set containing everything in u and all things in
        // this that are not duplicates of elts of u
        return temp;
    }

    // inter(u) returns a set containing all elts that are included in
    // BOTH (this) set and set u
    public FiniteSet inter(FiniteSet u) {
        if (u.member(this.root)) {
            // if this.root is a member of u, return a new set of this.root
            // and the intersections with u of the left and right branches
            return new FSBranch(this.root, this.left.inter(u), this.right.inter(u));
        } else {
            // if this.root is not a member of u, it is skipped; return
            // the union of the intersections of u with left and right branches
            return this.left.inter(u).union(this.right.inter(u));
        }
    }

    // diff(u) returns a set containing elts of set u except those that
    // also appear in (this) set
    public FiniteSet diff(FiniteSet u) {
        // place set u into a temporary variable
        FiniteSet temp = u;
        if (temp.member(this.root)) {
            // if this.root is a member of temp, return the union of the left
            // and right branches that have been differenced with temp
            // when this.root is removed from it
            return this.left.diff(temp.remove(this.root))
                    .union(this.right.diff(temp.remove(this.root)));
        } else {
            // if this.root is not a member of temp, ignore it and
            // return the union of the left and right branches
            // that have been differenced with temp
            return this.left.diff(temp).union(this.right.diff(temp));
        }
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
        // returns true if this.root is a member u, AND the left AND
        // right branches are also subsets of u
        return u.member(this.root) && this.left.subset(u) && this.right.subset(u);
    }
    
}
