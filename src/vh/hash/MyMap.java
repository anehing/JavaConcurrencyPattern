package vh.hash;

/**
 * Created by ane on 3/2/15.
 */
public class MyMap<K,V> {
    private int size;                         //当前容量
    private static int INIT_CAPACITY = 16;    //默认容量
    private Entry<K,V> [] container;          //实际存储数据的数组对象
    private static float LOAD_FACTOR = 0.75f; //装载因子
    private int max;                          //能存储的最大数 capacity*factor


    // 自己设置容量和装载因子的构造器
    public MyMap(int init_Capaticy,float load_factor){
        if(init_Capaticy < 0)
            throw new IllegalArgumentException("Illegal initial capacity: "
                    + init_Capaticy);
        if(load_factor<=0 || Float.isNaN(load_factor))
            throw new IllegalArgumentException("Illegal load factor: "  + load_factor);
        this.LOAD_FACTOR = load_factor;
        max = (int) (init_Capaticy * load_factor);
        container = new Entry[init_Capaticy];
    }

    // 使用默认参数的构造器
    public MyMap() {
        this(INIT_CAPACITY, LOAD_FACTOR);
    }


    /**
     * 存
     *
     * @param k
     * @param v
     * @return
     */
    public boolean put(K k,V v){
       /**
        1.计算K的hash值
        因为自己很难写出对不同的类型都适用的Hash算法，故调用JDK给出的hashCode()方法来计算hash值
        **/
        int hash = k.hashCode();
        //将所有信息封装为一个Entry
        Entry< K,V> temp=new Entry(k,v,hash);
        if(setEntry(temp,container)){
            size++; //大小加1
            return true;
        }
        return false;
    }


    /**
     * 扩容的方法
     *
     * @param newSize
     *            新的容器大小
     */
    private void reSize(int newSize) {
        Entry< K, V>[] newTable = new Entry[newSize];       // 1.声明新数组
        max = (int) (newSize * LOAD_FACTOR);
        for (int j = 0; j < container.length; j++) {        // 2.复制已有元素,即遍历所有元素，每个元素再存一遍
            Entry< K, V> entry = container[j];
            //因为每个数组元素其实为链表，所以…………
            while (null != entry) {
                setEntry(entry, newTable);
                entry = entry.next;
            }
        }
        // 3.改变指向
        container = newTable;
    }

    /**
     * 取
     *
     * @param k
     * @return
     */

    public V get(K k){
        Entry< K, V> entry = null;
        int hash = k.hashCode();                           // 1.计算K的hash值
        int index = indexFor(hash, container.length);      // 2.根据hash值找到下标
        entry = container[index];                          // 3.根据index找到链表
        if(null == entry){
            return null;
        }
        while(null != entry){                              // 4。若不为空，遍历链表，比较k是否相等,如果k相等，则返回该value
            if (k == entry.key || entry.key.equals(k)){
                return entry.value;
            }
            entry = entry.next;
        }
        return null;                                     // 如果遍历完了不相等，则返回空

    }


    /**
     *将指定的结点temp添加到指定的hash表table当中
     * 添加时判断该结点是否已经存在
     * 如果已经存在，返回false
     * 添加成功返回true
     * @param temp
     * @param table
     * @return
     */
     public boolean setEntry(Entry<K,V> temp,Entry[] table){
         int index = indexFor(temp.hash,table.length);     //根据hash值找到下标
         Entry< K, V> entry = table[index];                //根据下标找到对应元素
         if(null!=entry){                                  //若存在
             while(null != entry){                         //遍历整个链表，判断是否相等
                //相等则不存，返回false
                if((temp.key == entry.key||temp.key.equals(entry.key)) &&
                        temp.hash == entry.hash && (temp.value==entry.value||temp.value.equals(entry.value))){
                    return false;
                 }
                 else if (temp.key == entry.key && temp.value != entry.value){
                    entry.value = temp.value;
                    return true;
                }
                 //不相等则比较下一个元素
                 else if(temp.key != entry.key){
                    if(null==entry.next){          //到达队尾，中断循环
                        break;
                    }
                    entry = entry.next;           // 没有到达队尾，继续遍历下一个元素
                }
             }
             addEntry2Last(entry,temp);           // 当遍历到了队尾，如果都没有相同的元素，则将该元素挂在队尾
             return true;
         }
         // 4.若不存在,直接设置初始化元素
         setFirstEntry(temp,index,table);
         return true;
     }

    private void addEntry2Last(Entry< K, V> entry, Entry< K, V> temp) {
        if (size > max) {
            reSize(container.length * 4);
        }
        entry.next=temp;

    }
    /**
     * 将指定结点temp，添加到指定的hash表table的指定下标index中
     * @param temp
     * @param index
     * @param table
     */
    private void setFirstEntry(Entry< K, V> temp, int index, Entry[] table) {
        if (size > max) {                 // 1.判断当前容量是否超标，如果超标，调用扩容方法
            reSize(table.length * 4);
        }
        table[index] = temp;              // 2.不超标，或者扩容以后，设置元素
        temp.next=null;                  //因为每次设置后都是新的链表，需要将其后接的结点都去掉
    }

    /**
     * 根据hash码，容器数组的长度,计算该哈希码在容器数组中的下标值
     *
     * @param hashcode
     * @param containerLength
     * @return
     */
    public int indexFor(int hashcode, int containerLength) {
        return hashcode & (containerLength - 1);
    }

    /**
     * 用来实际保存数据的内部类,因为采用挂链法解决冲突，此内部类设计为链表形式
     *
     * @param < K>key
     * @param < V>
     *            value
     */
    class Entry<K,V>{
        Entry<K,V> next;    //下个节点
        K key;              // key
        V value;            // value
        int hash;           // 这个key对应的hash码，作为一个成员变量，当下次需要用的时候可以不用重新计算

        Entry(K k, V v, int hash) {
            this.key = k;
            this.value = v;
            this.hash = hash;

        }

        //相应的getter()方法
    }
}
