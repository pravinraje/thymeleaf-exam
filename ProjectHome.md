# Thymeleaf exam #
## checkout專案 ##
  * svn checkout https://thymeleaf-exam.googlecode.com/svn/trunk/ thymeleaf-exam
## 修改pom.xml ##
  * 將 `<version>` 1.0-SNAPSHOT `</version>` 修改為 `<version>` **_firstname.lastname_** `</version>`
## 執行程式 ##
  * cd thymeleaf-exam
  * mvn clean install `-DskipTests`
  * mvn spring-boot:run
## 觀看結果 ##
  * 開啟browser，並輸入url: http://localhost:8080


&lt;hr&gt;



## 相關參考鏈結 ##
  * [Bootstrap](http://getbootstrap.com/)<br>
<ul><li><a href='http://www.thymeleaf.org/documentation.html'>Thymeleaf</a><br><br>
<br>
<br>
<hr><br>
<br>
</li></ul>

<h1>請完成以下內容</h1>
<h2>除錯(20%)</h2>
<ul><li>執行org.softleader.App，使其不會出現任何錯誤</li></ul>

<h2>建立首頁(40%)</h2>
<blockquote><table><thead><th> 一般 </th><th> <img src='http://i.imgur.com/EbrXVmu.png' /> </th></thead><tbody>
<tr><td> 錯誤 </td><td> <img src='http://i.imgur.com/PBSFsMY.png' /> </td></tr>
</blockquote><ul><li>檔案名稱：<b>index.html</b>
</li></ul><ol><li>載入 <b>bootstrap.css</b>
</li><li>建立一個 <b>div</b> ，並給定其css為 <b>container</b> ，並在其內容加入下列項目<br>
<ol><li><b>h1</b> 並給定其css為 <b>text-muted</b>
</li><li><b>div</b> 並給定其css為 <b>alert alert-danger</b> ，當有錯誤訊息時，則顯示<br>
</li><li><b>form</b> form submit的位置為 <b>/signin</b> ，並在其內容加入下列項目<br>
<ol><li><b>div</b> 並給定其css為 <b>form-group</b> ，並在其內容加入下列項目<br>
<ol><li><b>label</b> 並加入當滑鼠點擊此 <b>label</b> 時，<b>input</b> 則會 <b>focus</b>
</li><li><b>input</b> 並給定其css為 <b>form-control</b>
</li></ol></li><li><b>button</b> 並給定其css為 <b>btn btn-success</b> ，並在其內容加入下列項目<br>
<ol><li><b>span</b> ，並給定css為 <b>glyphicon glyphicon-log-in</b></li></ol></li></ol></li></ol></li></ol></tbody></table>

<h2>建立清單頁(40%)</h2>
<blockquote><table><thead><th> <img src='http://i.imgur.com/ggha0P0.png' /> </th></thead><tbody>
</blockquote><ul><li>檔案名稱：<b>list.html</b>
</li></ul><ol><li>載入 <b>bootstrap.css</b>
</li><li>建立一個 <b>div</b> ，並給定其css為 <b>container</b> ，並在其內容加入下列項目<br>
<ol><li><b>h1</b> 並給定其css為 <b>text-muted</b>
</li><li><b>table</b> 於畫面上顯示 <b>user collection</b> 資料內容，並給定其css為 <b>table table-striped</b>
</li><li>當角色為 <b>admin</b> 者，其username欄位設定css為 <b>danger</b></li></ol></li></ol></tbody></table>

<h2>繳交結果</h2>
<ol><li>執行 <b>mvn clean install</b>
</li><li>執行 <b>mvn source:jar</b>
</li><li>將 <b>thymeleaf-exam-<i>firstname.lastname</i>-sources.jar</b> 與 <b>thymeleaf-exam-<i>firstname.lastname</i>.jar</b> 寄到 <b>steven.wang@softleader.com.tw</b>
</li><li>請確保打包出來的 <b>jar</b> 是可執行且內容正確