package graphs;

public class YoungestCommonAncestor {
    public static void main(String[] args) {
        AncestralTree A = new AncestralTree('A');
        AncestralTree B = new AncestralTree('B');
        AncestralTree C = new AncestralTree('C');
        AncestralTree D = new AncestralTree('D');
        AncestralTree E = new AncestralTree('E');
        AncestralTree F = new AncestralTree('F');
        AncestralTree G = new AncestralTree('G');
        AncestralTree H = new AncestralTree('H');
        AncestralTree I = new AncestralTree('I');

        A.ancestor = null;
        B.ancestor = A;
        C.ancestor = A;
        D.ancestor = B;
        E.ancestor = B;
        F.ancestor = C;
        G.ancestor = C;
        H.ancestor = D;
        I.ancestor = D;

        AncestralTree result = getYoungestCommonAncestor(A, E, I);
        System.out.println(result.name);
    }

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int depthOne = getDescendantDepth(descendantOne, topAncestor);
        int depthTwo = getDescendantDepth(descendantTwo, topAncestor);

        if (depthOne > depthTwo) {
            return backtrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo);
        } else {
            return backtrackAncestralTree(descendantTwo, descendantOne, depthTwo - depthOne);
        }
    }

    public static int getDescendantDepth(AncestralTree descendant, AncestralTree topAncestor) {
        int depth = 0;
        while (descendant != topAncestor) {
            descendant = descendant.ancestor;
            depth++;
        }
        return depth;
    }

    public static AncestralTree backtrackAncestralTree(
            AncestralTree lowerDescendant, AncestralTree higherDescendant, int diff) {
       while (diff > 0) {
           lowerDescendant = lowerDescendant.ancestor;
           diff--;
       }
       while (lowerDescendant != higherDescendant) {
           lowerDescendant = lowerDescendant.ancestor;
           higherDescendant = higherDescendant.ancestor;
       }
        return lowerDescendant;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
