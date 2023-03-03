package HouseRent;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';//根据用户选择
    private HouseRent.HouseService houseService = new HouseRent.HouseService(10);
    //修改房屋信息
    public void update(){
        System.out.println("\t==========修改房屋信息==========");
        System.out.println("请输入要修改的房屋编号(-1退出)");
        int updateId = Utility.readInt();
        if(updateId==-1){
            System.out.println("\t\t---你已放弃修改房屋信息---");
            return;
        }
        //根据输入的ID查找对象
        HouseRent.House house = houseService.findByTd(updateId);
        if(house==null){
            System.out.println("\t\t-----你输入的编号不存在-----");
            return;
        }
        System.out.print("姓名: "+house.getName()+" --> ");
        String name = Utility.readString(8,"");//如果用户不修改信息，默认""
        if(!"".equals(name)){
            house.setName(name);
        }
        System.out.print("电话: "+house.getPhone()+" --> ");
        String phone = Utility.readString(12,"");
        if(!"".equals(phone)){
            house.setPhone(phone);
        }
        System.out.print("地址: "+house.getAddress()+" --> ");
        String address = Utility.readString(8,"");
        if(!"".equals(address)){
            house.setAddress(address);
        }
        System.out.print("租金: "+house.getRent()+" --> ");
        int rent = Utility.readInt(-1);
        if(rent!=-1){
            house.setRent(rent);
        }
        System.out.print("状态: "+house.getState()+" --> ");
        String state = Utility.readString(3,"");
        if(!"".equals(state)){
            house.setName(phone);
        }
    }
    //查找房屋信息
    public void findHouse(){
        System.out.println("\t-------查找房屋信息---------");
        System.out.print("请输入要查找的房屋ID: ");
        int findId = Utility.readInt();
        HouseRent.House house = houseService.findByTd(findId);
        if(house!=null){
            System.out.println(house);
        }else{
            System.out.println("\t\t----查找的房屋ID不存在----");
        }
    }
    //退出
    public void exit(){
        char c = Utility.readConfirmSelection();
        if(c=='Y'){
            loop=false;
        }
    }
    //删除房屋
    public void delHouse(){
        System.out.println("======删除房屋信息======");
        System.out.println("----请输出你要删除的房屋ID(-1退出)");
        int delId = Utility.readInt();
        if(delId == -1){
            System.out.println("放弃删除");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if(choice=='Y'){//删除
            if(houseService.del(choice)){
                System.out.println("\t\t\t删除成功...");
            }else{
                System.out.println("\t\t---该房屋ID不存在，删除失败---");
            }
        }else{
            System.out.println("\t\t-----放弃删除-----");
        }
    }
    //添加房屋
    public void addHouse(){
        System.out.println("-------添加房屋-------");
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        System.out.print("电话: ");
        String phone = Utility.readString(12);
        System.out.print("地址: ");
        String address = Utility.readString(16);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("状态: ");
        String state = Utility.readString(3);
        HouseRent.House house = new HouseRent.House(name,phone,address,rent,state);
        if(houseService.add(house)){
            System.out.println("---添加房屋成功---");
        }else{
            System.out.println("--添加房屋失败--");
        }

    }
    //显示房屋列表
    public void listHouses(){
        System.out.println("==========房屋列表=========");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        HouseRent.House houses[] = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i]!=null) {
                System.out.println(houses[i]);
                continue;
            }
            break;
        }
        System.out.println("-----房屋显示完毕----");
    }
    public void mainMenu() {
        do {
            System.out.println("==========房屋出租系统菜单=========");
            System.out.println("\t\t\t1.新 增 房 源");
            System.out.println("\t\t\t2.查 找 房 源");
            System.out.println("\t\t\t3.删 除 房 屋 信 息");
            System.out.println("\t\t\t4.修 改 房 屋 信 息");
            System.out.println("\t\t\t5. 房 屋 列 表");
            System.out.println("\t\t\t6. 退   出");
            System.out.println("请输入你的选择(1-6)");
            key = Utility.readChar();
            switch( key ){
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;

            }
        } while (loop);
    }
}
