# 配置hive

1. 使用xftp进行文件移动到`/opt/software/` 下面
2. 使用 `root`用户登录
3. `cd /opt/software/`
4. `tar -zxvf hive-1.1.0-cdh5.14.2.tar.gz`
5. 更改权限 `chown -R hadoop hive-1.1.0-cdh5.14.2.tar.gz`
6. 切换用户 `su - hadoop`
7. 编辑 `.bashrc`文件
8. 生效文件`source .bashrc`
9. 切换目录 `cd /opt/software/hive-1.1.0-cdh5.14.2`
10. 执行hive `./bin/hive`
11. 测试 `show databases`
12. 如果提示错误那么`mv metastore_db metastore_db_1 && ./bin/schematool -dbType derby -initSchema`