# getClientIP
获取客户端真实IP

## 方法一

[原博地址](http://www.cnblogs.com/ITtangtang/p/3927768.html)

request.getRemoteAddr() 192.168.239.196

request.getHeader("X-Forwarded-For") 58.63.227.162, 192.168.237.178, 192.168.238.218

request.getHeader("X-Real-IP") 192.168.238.218

所以访问的流程应该是这样，客户端58.63.227.162发出请求，经过192.168.237.178, 192.168.238.218两层转发，到了192.168.239.196这台NGINX上，NGINX就把X-Real-IP头设成了自己看到的remote_addr，也就是直接发给到他的192.168.238.218，这时候resin收到这个包，对resin来说直接发给他的remote_addr就是NGINX的ip，也就是192.168.239.196，那么resin里面的request.getRemoteAddr()就是192.168.239.196，那么在resin里拿最原始的ip逻辑（也就是拿能够知道的最外层的ip）应该是这样：

            如果XFF不为空，拿XFF的左边第一个

            如果XFF为空，拿XRI

            如果XRI为空，只能拿request.getRemoteAddr()，也就是只能拿到最直接发给他的机器ip了
            
```java
public static String getIp2(HttpServletRequest request) {
     String ip = request.getHeader("X-Forwarded-For");
     if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
         //多次反向代理后会有多个ip值，第一个ip才是真实ip
         int index = ip.indexOf(",");
         if(index != -1){
             return ip.substring(0,index);
         }else{
             return ip;
         }
     }
     ip = request.getHeader("X-Real-IP");
     if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
         return ip;
     }
     return request.getRemoteAddr();
 }
```

## 方法二


[原博地址](http://newleague.iteye.com/blog/858741)

实际的iisforward附加头如下：
```
WL-Proxy-Client-IP=211.161.1.239  
Proxy-Client-IP=211.161.1.239  
X-Forwarded-For=211.161.1.239  
WL-Proxy-Client-Keysize=   
WL-Proxy-Client-Secretkeysize=   
X-WebLogic-Request-ClusterInfo=true  
X-WebLogic-KeepAliveSecs=30  
X-WebLogic-Force-JVMID=-327089098  
WL-Proxy-SSL=false  
```

java代码如下：
```java
private String getIpAddr() {   
     String ipAddress = null;   
     //ipAddress = this.getRequest().getRemoteAddr();   
     ipAddress = this.getRequest().getHeader("x-forwarded-for");   
     if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {   
      ipAddress = this.getRequest().getHeader("Proxy-Client-IP");   
     }   
     if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {   
         ipAddress = this.getRequest().getHeader("WL-Proxy-Client-IP");   
     }   
     if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {   
      ipAddress = this.getRequest().getRemoteAddr();   
      if(ipAddress.equals("127.0.0.1")){   
       //根据网卡取本机配置的IP   
       InetAddress inet=null;   
    try {   
     inet = InetAddress.getLocalHost();   
    } catch (UnknownHostException e) {   
     e.printStackTrace();   
    }   
    ipAddress= inet.getHostAddress();   
      }   
            
     }   
  
     //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割   
     if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15   
         if(ipAddress.indexOf(",")>0){   
             ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));   
         }   
     }   
     return ipAddress;    
  }   
```
 
