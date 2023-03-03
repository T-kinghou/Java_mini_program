package HouseRent;

public class HouseService {
    private com.hspedu.HouseRent.House houses[];
    private int houseNums = 0;//记录房屋数量
    private int idCounter = 1;
    //findById方法
    public com.hspedu.HouseRent.House findByTd(int findId){
        for (int i = 0; i < idCounter; i++) {
            if(houses[i].getId()==findId){
                return houses[i];
            }
        }
        return null;
    }

    //del方法，删除房屋信息
    public boolean del(int delId){
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if(delId==houses[i].getId()){
                index = i;
            }
        }
        if(index == -1){
            return false;
        }
        for(int i = index;i<houseNums-1;i++){
            houses[i]=houses[i+1];
            houseNums--;
        }
        houses[--houseNums]=null;
        return true;
    }
    public HouseService(int size){
        houses = new com.hspedu.HouseRent.House[size];
    }

    public com.hspedu.HouseRent.House[] list(){
        return houses;
    }
    //add方法，添加新对象，并判断是否成功
    public boolean add(com.hspedu.HouseRent.House newHouse){
        if(houseNums == houses.length){//不能再添加
            System.out.println("出租表已满，不能再添加~~");
            return false;
        }
        houses[houseNums++] = newHouse;
        newHouse.setId(idCounter++);
        return true;
    }
}
