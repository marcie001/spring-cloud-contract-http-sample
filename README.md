# Spring Cloud Contract Sample

Spring Cloud Contract で HTTP Server/Client のサンプル。
[公式ドキュメント](http://cloud.spring.io/spring-cloud-contract/spring-cloud-contract.html)を参考に書いてみた。

## 構成

|パス|内容|
|----|----|
|client/src/main/java|クライアントのコード|
|client/src/test/java|クライアントのテストコード|
|server/src/main/java|サーバのコード|
|server/src/test/java|サーバのテストコード|
|server/src/test/resources/contracts|contract ファイル|

## 実行方法

まずサーバとそのスタブをインストールする。

```
$ cd server
$ ./mvnw clean install
```

次にクライアントをビルドする。

```
$ cd client
$ ./mvnw clean package
```

スタブだけを動かしたいときは [wiremock-standalone の jar をダウンロード](http://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-standalone/)して WireMock サーバを起動する。
コマンドラインオプションなど詳しくは [WireMock の公式ドキュメント](http://wiremock.org/docs/running-standalone/)にある。

```
$ java -jar wiremock-standalone-2.6.0.jar --root-dir server/target/stubs/META-INF/com.example.cdchttpsample/server/0.0.1-SNAPSHOT/ --global-response-templating
```

