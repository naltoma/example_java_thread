import java.util.ArrayList;

/**
 * レジスタッフクラス。
 * コンストラクタで受け取った顧客（customers）が空になるまで処理し続ける。
 */
public class CashRegister extends Thread {
    String name; //スタッフの名前
    int numberOfCustomer; //処理した顧客数
    int totalTime; //処理した総合時間
    ArrayList<Integer> customers; //顧客の列
    boolean doStop = false; //falseの間、会計処理を続ける。trueになったら処理終了。

    CashRegister(String name, ArrayList<Integer> customers){
        this.name = name;
        numberOfCustomer = 0;
        totalTime = 0;
        this.customers = customers;
    }

    /**
     * 並行処理するメイン部分。
     * 顧客がいることを確認し、いる間は会計処理し続ける。
     * 顧客列が空になったら会計処理を終了。
     */
    @Override
    public void run(){
        int time;
        while( doStop == false ) {
            if (customers.isEmpty() == true) { //空になった場合
                doStop = true;
            } else { //顧客がいる場合
                synchronized (customers) {
                    time = customers.remove(0);
                }
                numberOfCustomer++;
                totalTime += time;
                System.out.println(name + ": time=" + time + ", totalTime=" + totalTime);
            }
        }
    }

    /**
     * クラス概要を確認しやすくするための処理。
     * @return 呼び出された時点での、処理した顧客数と総処理時間。
     */
    @Override
    public String toString(){
        String result = name + ": num=" + numberOfCustomer + ", totalTime=" + totalTime;
        return result;
    }
}