## 下载命令：

```bash
# 下载
wget https://dev.mysql.com/get/mysql57-community-release-el7-9.noarch.rpm
# 安装rpm
rpm -ivh mysql57-community-release-el7-9.noarch.rpm
# 安装完成后，就可以使用yum命令安装mysql了：
yum -y install glibc.i686
yum -y install mysql-server
# 启动mysql：
systemctl start mysqld
# 查看mysql状态：
systemctl status mysqld
获取mysql的临时密码：
grep 'temporary password' /var/log/mysqld.log
# 登录mysql：（密码为上一步骤获取的临时密码）
mysql -u root -p(此处不用输入密码，按下回车后会专门要你再输入密码的)
# 登录成功后，做任何操作都会被要求先修改密码
show databases;
# 请注意：如果修改的密码太过简单，依然会提示error，修改失败
# 因为5.7及以上版本的数据库对密码做了强度要求，默认密码的要求必须是大小写字母数字特殊字母的组合且至少要8位长度
ALTER USER 'root'@'localhost' IDENTIFIED BY '新的密码';
# 按照系统的默认要求，修改密码：
ALTER USER 'root'@'localhost' IDENTIFIED BY 'xxxxx';
# 修改完成后，即可愉快的操作数据库：
show databases;
```

## 扩展一：
修改密码的强度：
```
set global validate_password_policy=0;--表示将密码安全等级设置为low
set global validate_password_length=6;--表示将密码长度设置为最小6位
ALTER USER 'root'@'localhost' IDENTIFIED BY ‘123’;
```

## 外网访问
```
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY '123456' 
# 这里的123456为你给新增权限用户设置的密码，%代表所有主机，也可以具体到你的主机ip地址
flush privileges;     
# 这一步一定要做，不然无法成功！ 这句表示从mysql数据库的grant表中重新加载权限数据


```