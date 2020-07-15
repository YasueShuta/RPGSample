/* GachaSample:
 * キャラクターにセリフphrase、レア度rarityを追加
 * ガチャで引いたとき、setPhraseで決めたセリフを話す。%name%を入れるとplayerの名前と置き換わる。
 * レア度をsetRarityで1,2,3,4,5の5段階でセット可能。ガチャで引いたときもレア度が表示される。ガチャを引いたときの確率はCharacter.javaのgetProb内で決められている。
*/
import java.util.*;
import animation.*;

class Main {
    public static void main(String[] args) {
        MyApp.main(args);        
    }
}