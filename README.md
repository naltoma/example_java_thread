# スレッドの実装例
## 概要
- 会計処理を待つ顧客をArrayListで実装し、複数のレジスタッフで処理する例。
    - synchronized を導入するところまで実装してあるが、後述の通り競争状態が起こりうる状態。
- 解説ページ
    - [Thread（スレッド）入門](https://github.com/naltoma/java_intro/blob/master/thread_racecondition_join.md)

## 動作確認環境
- OpenJDK 10.0.2
