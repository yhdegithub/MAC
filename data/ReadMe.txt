1.  mac_company2.txt是IEEE的MAC授权机构的所有分配的（MAC块 ， 厂家）的数据库
    其他的pc_200.txt , phone_800.txt ,router_1000.txt则是测试集找到的对应商家 ， 当然其中有无效的mac地址（在文件夹Invalid_mac中），其在权威机构未经注册（不知为何） ， 所以单独列举了测试集中无效的mac块。其中无效pc_mac 有 26/200 ， phone_mac 7/800 , router 0/1000.
    注意 ： 这里的无效，仅仅是指未向官方缴费授权 ，但实际中也可能不影响使用。 



2. 判断一个mac来自哪种设备 ，这里采用的方法是 ：
   1) 根据mac_company2.txt找到此mac地址的商家 (是Apple,是Xiaomi ,还是3com,,,,,,)。
   2) 根据主流商家的产品 ，推测这个设备是哪种（pc,router,phone）. 比如3com就只卖路由器 ， 一旦确定是3com家的产品 ，就断定这个是router。 至于同时生产几种设备的厂家 ，就只好估计一个mac块是连续分配的了。 

3.  2中具体的判断，我已添加到 judge.txt中去了 ， 建议先扫一眼排好序的pc_200.txt , phone_800.txt ,router_1000.txt三个文件 ， 在来看   