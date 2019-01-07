import java.util.ArrayList;
import java.util.Random;

public class ThreadExample {
    public static void main(String[] args){
        //step 1: 客の準備
        int numberOfCustomer = 10;
        ArrayList<Integer> customers = initCustomer(numberOfCustomer);
        System.out.println(customers);

        //step 2: レジスタッフの用意
        int numberOfRegisters = 2;
        CashRegister[] cashRegisters = new CashRegister[numberOfRegisters];
        for(int i=0; i<numberOfRegisters; i++){
            String name = "register_" + i;
            cashRegisters[i] = new CashRegister(name, customers);
            cashRegisters[i].start();
        }

        //step 3: 全顧客の処理を終えるまで待つ
        try{
            for(Thread th : cashRegisters){
                th.join();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        //step 4: レジスタッフ毎に処理した内容の確認4
        for(int i=0; i<numberOfRegisters; i++) {
            System.out.println(cashRegisters[i]);
        }
    }

    /**
     * 顧客の列を用意。
     * @param num 顧客数。
     * @return 顧客列。顧客毎に処理にかかる時間を値に持つ。
     */
    public static ArrayList<Integer> initCustomer(int num){
        Random generator = new Random(0);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=0; i<num; i++){
            int time = (int)(generator.nextDouble() * 10); //処理時間
            temp.add(time);
        }
        return temp;
    }
}