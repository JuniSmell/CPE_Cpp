CPE：11946

題目：

今天有兩個人要委託其他人幫忙傳訊息，但因為怕被看到內容，所以就把內容加密。
內容範例如下：
H3LL0 MY L0V3, 1 M H499Y 83C4U53 500N 1 W1LL 83 70 Y0UR 51D3.
7H15 71M3 W17H0U7 Y0U H45 833N 373RN4L. 1 1NV173 Y0U 70 7H3 200
0N3 70 533 7H3 238R43 4ND 60R1L43.

解碼後為：

HELLO MY LOVE, I M HAPPY BECAUSE SOON I WILL BE TO YOUR SIDE.
THIS TIME WITHOUT YOU HAS BEEN ETERNAL. I INVITE YOU TO THE ZOO
ONE TO SEE THE ZEBRAS AND GORILAS.

今天要實作一個解碼器，輸入密文，輸出明文。

輸入：第一行先輸入有幾篇密文要被解密，第二行開始輸入密文，篇與篇之間要空出一行。

輸出：輸出解碼後的明文，同樣篇與篇之間要空出一行。

思路：

1.觀察範例文章後，可以得到對應碼：0：O;1：I;2：Z;3：E;4：A;5：S;6：G;7：T;8：B;9：P
2.輸入為好幾段字串，這裡我使用"getline()"函數來處理，注意的是，getline(cin,s)會讀取放在"cin"函數內的資料，而cin不會把"\n"存入目標，所以會留在cin裡面，這時記得要呼叫"cin.ignore()"，把內部的殘值清掉，否則會讀到錯誤的內容。