package BinaryTree.AdvancedTree;

public class SegmentTree {

    public void createSegmentTree(int[] input, INode[] segmentTree, int low, int high, int index) {
        if(low > high) return;
        if(low == high) {
            segmentTree[index] = new INode(low, high, input[low]);
            return;
        }
        int mid = low + (high - low) / 2;
        createSegmentTree(input, segmentTree, low, mid, (2*index+1));
        createSegmentTree(input, segmentTree, mid+1, high, (2*index+2));
        segmentTree[index] = new INode(low, high, Math.min(segmentTree[(2*index+1)].data, segmentTree[(2*index+2)].data));
    }
    public int findInRange(INode[] segmentTree, int low, int high, int askedStart, int askedEnd, int index) {
        if(index >= segmentTree.length) return Integer.MAX_VALUE;
        if(askedStart <= low && askedEnd >= high) return segmentTree[index].data;
        if(low > askedEnd || high < askedStart) return Integer.MAX_VALUE;

        int mid = low + (high - low) / 2;
        int left = findInRange(segmentTree, low, mid, askedStart, askedEnd, 2*index+1);
        int right = findInRange(segmentTree, mid+1, high, askedStart, askedEnd, 2*index+2);
        return Math.min(left, right);
    }

    public class INode {
        int low;
        int high;
        int data;
        public INode(int low, int high, int data) {
            this.low = low;
            this.high = high;
            this.data = data;
        }
    }
}
