package InBit;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Auther:vincent-Dou
 */
public class Sequence implements ISequence {
    //数组
    private Object[] element;
    //数组总长度
    private int eleSize;
    //数组已经使用的长度
    private int useSize;
    //构造函数
    public Sequence(){
        this.element = new Object[20];
        eleSize = 20;
    }
    @Override
    public boolean add(int pos, Object data) {
        //是否合法
        if(pos < 0 || pos > useSize){
            return false;
        }
        //扩容
        if(useSize == element.length){
            element = Arrays.copyOf(element,element.length*2);
//            System.out.println(element.length);
//            element = System.arraycopy();
//            System.arraycopy(element,useSize,element,);
        }
        //在之间插入
        for(int i = this.useSize; i > pos; i--){
            element[i] = element[i-1];
        }
        this.element[pos] = data;
        this.useSize++;
        return true;
    }

    @Override
    public int search(Object key) {
        //查找值对应的下标
        if(key == null){
            throw new UnsupportedOperationException("插入的值不能为空");
        }
        if(isEmpty()){
            return -1;
        }
        for(int i = 0; i < this.useSize; i++){
            if(this.element[i].equals(key)){
                return i;
            }
        }
        return  -1;
    }
    private boolean isEmpty(){
        return this.useSize == 0 ;
    }

    @Override
    public boolean contains(Object key) {
        if(key == null){
            throw new UnsupportedOperationException();
        }
        if(isEmpty()){
            return false;
        }
        for(int i = 0; i < this.useSize; i++){
            if(this.element[i].equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if(pos >= useSize || pos < 0){
            return null;
        }
        return this.element[pos];
    }

    @Override
    public Object remove(Object key) {
        int temp = search(key);
        if(temp == -1){
            return null;
        }
        Object oldData = this.element[temp];
        if(temp == useSize){
            element[useSize] = null;
            useSize--;
            return oldData;
        }
        for(int i = temp; i < useSize - 1; i++ ){
            element[i] = element[i+1];
        }
        element[useSize] = null;
        useSize --;
        return oldData;
    }

    @Override
    public int size() {
        return this.useSize;
    }

    @Override
    public void display() {
        if(useSize == 0){
            System.out.println("没有元素");
        }
        for(int i = 0; i < useSize; i++){
            System.out.print(element[i] + "|");
        }
    }

    @Override
    public void clear() {
        for(int i = 0; i < useSize; i++){
            element[i] = null;
        }
        this.useSize = 0;
    }
}
