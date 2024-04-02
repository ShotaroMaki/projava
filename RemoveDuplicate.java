package projava;

public class RemoveDuplicate {
    public static void main(String[] args) {
        var data = "3694215";
        var builder = new StringBuilder();
        // 奇数番目の文字をつづく偶数番目の文字列と入れ替えて出力
        // for (int i = 0; i < data.length(); i++) {
        // if (i % 2 == 0 && i + 1 < data.length()) {
        // builder.append(data.charAt(i + 1));
        // builder.append(data.charAt(i));
        // i++;
        // } else {
        // builder.append(data.charAt(i));
        // }
        // }

        // １つ後の要素と比べて大きい方を格納した配列を出力
        for (int i = 0; i < data.length(); i++) {
            if (i < data.length() - 1 && data.charAt(i) < data.charAt(i + 1)) {
                builder.append(data.charAt(i + 1));
            } else {
                builder.append(data.charAt(i));
            }
        }
        var result = builder.toString();
        System.out.println(result);
    }
}
