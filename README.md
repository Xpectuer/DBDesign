***接口列表***

**url: ecctf.top:18080**

>APIs

`/testBoot`
```
/getRegion/{id}  #获得特定Id的中国地区实时数据

/getRegions  #获得所有实时数据

/getChina/{id}  #按id获得中国的折线图（0.0.3版本弃用）

/getWorld/{id}  #按id获得世界某地区的折线图（0.0.3版本弃用）

/getRank/{type}/{num} #获得中国或者世界实时排名（前20位）
# @param type='world' / 'china'
# @param num=[0-20]  #欲获取的排名之范围
```

`/history`
```
/getById/{type}/{id}/{gran}  #获取20天内数据,输入粒度gran
# @param type='world' / 'china'
# @param gran=[0-10]

/getDashBoard #获取dashboard数据
```