# 说明

## mall-config
mall-config 是配置中心。所有服务的配置都保存在配置中心。

## mall-gateway
mall-gateway 是网关服务，进行请求的拦截和转发。功能和zuul一样。这里选择gateway完全因为技术拓展。

## mall-eureka 
mall-eureka 是服务注册管理中心。所有的服务都会注册到mall-eureka 中，包括config 和gateway 也不例外。


## mall-login
注册模块