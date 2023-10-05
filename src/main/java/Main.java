import java.util.Scanner;

public class Main {

    public static  void main (String[] args){
        //ファイルパス
        String FilePath = "C:\\Users\\Owner\\Desktop\\User.txt";
        Scanner scanner = new Scanner(System.in);
        boolean StartMenu = true;

        //メニューの表示
        while (StartMenu) {
            System.out.println("実行するメニューの番号を入力してください ");
            System.out.println("1：登録　2：検索　0:終了　＞");
            try {
                int ChoiceMenu = -1;
                ChoiceMenu = scanner.nextInt();

                if (ChoiceMenu < 0 || ChoiceMenu > 2) {
                    System.out.println("入力された番号のメニューはありません。");
                } else {
                    switch (ChoiceMenu) {
                        case 1:  //登録
                            System.out.println("登録します。");
                           if (!Register.writeTxt(FilePath)){
                               System.out.println("はじめからやり直してください。");
                               System.out.println(" ");
                           }
                            break;
                        case 2:  //検索
                            System.out.println("検索します。");
                            String[] data = new String[2];
                            data = Search.searchMenu() ;
                            if(!Search.readTxt(FilePath,data)){
                                System.out.println("はじめからやり直してください。");
                                System.out.println(" ");
                            }
                            break;
                        case 0:  //終了
                            System.out.println("終了します");
                            StartMenu = false;
                            break;
                        default:  //その他
                            System.out.println("入力された番号のメニューはありません。");
                    }
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("無効な入力です。整数を入力してください。＞");
            }
        }
    }
}
