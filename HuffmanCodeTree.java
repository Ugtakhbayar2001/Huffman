public class HuffmanCodeTree{

    private HuffmanNode root;
    
    public HuffmanCodeTree(HuffmanNode root)
    {
        this.root = root;
    }
    public HuffmanCodeTree(HuffmanCodeBook codebook)
    {
        //create new node
        root = new HuffmanNode(null, null);
        //for each character in the codebook
        for(Character c : codebook)
        {
            //create a new node
            put(codebook.getSequence(c), c);
        }
    }
    public void put(BinarySequence seq, char letter)
    {
        //move the root
        HuffmanNode node = root;
        for(boolean b : seq)
        {
            if(b)
            {
                if(node.getOne() == null)
                {
                    node.setOne(new HuffmanNode(null, null));
                }
                node = node.getOne();
            }
            else
            {
                if(node.getZero() == null)
                {

                    node.setZero(new HuffmanNode(null, null));
                }
                node = node.getZero();
            }
        }
        //if you ever arrive at a leaf
        if(node.isLeaf())
        {
            //add the data from that leaf to your output, and reset node
            //to the root.
            node.setData(letter);
            node = root;
        }
        

    }

    public boolean isValid()
    {
        return root.isValid();
    }
    public String decode(BinarySequence s)
    {
        //create a variable “node” and have it store the root node of the tree
        HuffmanNode node = root;
        StringBuilder sb = new StringBuilder();
        for(boolean b : s)
        {
            if(node != null)
            {
                if(b && node.getOne() != null)
                {
                    node = node.getOne();
                }
                else if(!b && node.getZero() != null)
                {
                    node = node.getZero();
                }
                //if you ever arrive at a leaf
                if(node.isLeaf())
                {
                    //add the data from that leaf to your output, and reset node
                    //to the root.
                    sb.append(node.getData());
                    node = root;
                }
            }
        }
        //if you ever arrive at a leaf
        if(node!=null && node.isLeaf())
        {
            //add the data from that leaf to your output, and reset node
            //to the root.
            sb.append(node.getData());
        }
        return sb.toString();
    }
}

