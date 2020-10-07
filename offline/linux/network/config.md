

# 配置网络

```
vi /etc/sysconfig/network-script/ifcfg-ens33
# modify
* BOOTPROTO=dbcp -> static
+ IPADDR=10.0.10.x # x is 1, 2, 3 or 4
+ NETMASK=255.0.0.0
+ GATEWAY=10.0.0.2
# save
vi /etc/hostname
# input your hostname and save
vi /etc/hosts
# input as
10.0.10.1   ubuntu-1
10.0.10.2   ubuntu-2
10.0.10.3   ubuntu-3
10.0.10.4   ubuntu-4
# 这里是主机对应ip地址的映射
service NetworkManager stop
systemctl disable NetworkManager
reboot
# 生成公钥和私钥
ssh-keygen -t ed25519 	 	
# 分发到其他机器
ssh-copy-id root@ubuntu-x
# 连接测试
ssh root@ubuntu-x
```

