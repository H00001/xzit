# GET-POST

## Bronser-Server模型

浏览器访问服务器如同我们去商店买笔一样，首先要找到文具店地址「网站的地址」，然后向服务员索要笔「请求访问的资源」，最后服务员给我们把笔拿来（资源返回给了我们），我们就可以使用了「浏览器将访问的结果呈现在页面上。就能够看到了」。

所以在URL能看到这样的结构，例如

```http://baidu.com/pen.html?color=red&size=big```

那么我们能从中分析出，url分为协议，主机地址，资源和参数这样几个部分。

* http是协议，代表所访问的服务类型 -> 要去买东西，而不是要去理发
* baidu.com是主机地址->这家文具店在`xx路xx号`
* /pen.html是资源 -> 我要去买钢笔
* color=red是参数 -> 买红色的钢笔
* size=big是第二个参数 -> 型号大的钢笔

> 参数是key=value对的形式「我们以后会经常遇到这种形」，多个参数通过&连接

正如去买笔一样，和服务员的交流要先说「同志你好，我想要xx」这种约定俗成的，协议就是这样一种规范，浏览器向服务器发送请求的时候，也要遵循一种规范，那么如果浏览器向服务器索要`pen.html`这个资源的话，会向服务器发送这样的字符串

```http
GET /pen.html?color=red&size=big http/1.1
connection:keep-active
host:baidu.com
xxx:xxx

```

1. 我们称前4行这结构为请求头，中间第5行为请求空行，第6行为请求体，当然请求体
2. 我们首先看第一行`GET`是请求方法，除了有`GET`这种请求方法之外，还有`POST`,`PUT`,`HEAD`,`DELETE`,`PATCH`等方法，但是常用的只有 `GET`,`POST`，其中`POST`相比于`GET`除了在首部变成`POST`开头之外，参数位置也稍有不同。
2. `/pen.html?color=red`是资源和参数

3. http是协议

5. 那么来看下POST的报文样式，相比于`GET`，将参数移动到了下面
6. 我们称前4行这结构为请求头，中间第5行为请求空行，第6行为请求体，请求体为color=red&size=big，所以POST吧参数放在请求体
```http
POST /pen.html http/1.1
connection:keep-active
host:baidu.com
xxx:xxx
 
color=red&size=big
```
>POST主要用在登陆

看完了第一行，剩下的行都是属性，例如属性host的属性值是baidu.com，属性的形式是k：v对，也可以自定义属性。多对属性通过换行分割。

这种字符串构建完成之后，浏览器向服务器的主机地址发送了这样的字符串，服务器给浏览器进行响应，产生了我们能够看得见的页面。

