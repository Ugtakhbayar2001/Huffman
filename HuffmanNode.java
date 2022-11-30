public class HuffmanNode {

    private HuffmanNode zero;
    private HuffmanNode one;
    private Character data;
    
    public boolean isValid()
    {
        //base cases
        if(zero == null && one == null && data != null)
        {
            return true;
        }
        if(zero == null || one == null)
        {
            return false;
        }
        //recursive cases
        return zero.isValid() && one.isValid();
    }
    public boolean isLeaf() {
        return (zero == null && one == null);
    }
    
    public HuffmanNode(HuffmanNode zero, HuffmanNode one){
        
        this.zero = zero;
        this.one = one;
        this.data = null;
    }

    public HuffmanNode(char data){
        this.data = data;
        this.zero = null;
        this.one = null;
    }
    //setters and getters
    public HuffmanNode getZero(){
        return zero;
    }
    public HuffmanNode getOne(){
        return one;
    }
    public Character getData(){
        return data;
    }
    public void setZero(HuffmanNode zero){
        this.zero = zero;
    }
    public void setOne(HuffmanNode one){
        this.one = one;
    }
    public void setData(Character data){
        this.data = data;
    }


}

