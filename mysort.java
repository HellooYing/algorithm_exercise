import java.util.*;
public class mysort {
    public static void main(String[] args) throws Exception {
        String[] b={"FEP(1):前端处理器","PBX(1):用户交换机","ISOC(1)：一个组织，Internet Society","RFC(1): 文档，Rwquest For Comment 收集网络信息","C....(1)","PDU(1):在对等层次上传送数据基本单元","SAP(1):相同层次间的逻辑接口","STP(2):屏蔽双绞线","UTP(2):非屏蔽双绞线","ASK(2):振幅键控","FSK(2):频字键控","PSK(2):相位键控","blue tooth(2):蓝牙","infrared(2):红外线","lightwave(2):光波","DTE(2):数据终端设备（主机，路由器）","DCE(2):数据电路端接设备（交换机，集线器）","Modem(2):调制解调器","DTR(2):表示DTE通电（就绪）","DSR(2):表示DCE通电（就绪）","CD(2):载波检测","RTS(2):请求发送","CTS(2):允许发送","T(2):发送","RI(2):振铃指示",
"FCS(3):帧校验序列","ARQ(3):自动重传请求，一种可靠传输协议","HDLC(3):高级数据链路控制","ARANET(3):IMP-IMP","ppp(3):点对点协议","MTU(3):最大传输单元","LCP(3):链路控制协议","NCP(3):网络控制协议",
"CSMA(4):载波侦听多点接入","ALOHA(4):随机接入","CSMA/CD(4):CD是冲突检测","TDM(4):时分复用","FDM(4):频分复用","WDM(4):波分复用","CDM(4):码分复用",
"IEEE(5):美国电气工程师协会","MAC(5):媒体接入控制","LLC(5):逻辑接入控制（逻辑链路控制）","10-BASE-5(5):标准以太网","DMA(5):一种网卡于内存交互的方式，ProgramI/O,Share Memory也是","10-BASE-I(5)细缆以外网:","HUB(5):集线器","RJ-45(5):连接器（水晶头）","10-BASE-TX(5):快速以太网","IBM Token Ring和FDDI(5):一种令牌环网","FDDI(5):光纤分布式数据接口","FLP(5):Fast Link Pulse 快速连接脉冲，快速链路脉冲","LWL(5):长波激光光源","1000-BASE-LX/CX(5):千兆以太网","SL(5):短波激光光源",
"Repeater(6):中继器","ICMP(6):IP层差错与控制报文传输的协议，网际控制报文协议","ARP,RARP(6):IP地址与MAC地址转换协议","IGMP(6):用于组播的协议","VC(6):虚电路","datagram(6):数据报（IP的）","CIDR(6):无分类编址","PDU(6):基本数据单元","IHL(6):首部长度","TOS(6):区分服务","checksum(6):首部校验和","MTU(6):最大传输单元","identifier(6):标识，同一数据报的标识相同","Source quench(6):源点抑制","Redirect(6):改变路由","AS(6)自治系统:","Rou ted Protocal(6):路由传输协议","Routing Protocal(6):路由选择协议","DV(6):距离向量算法","link-state database(6):链路状态数据库","VPN(6):虚拟专用网","NAT(6):网络地址转换","NAPT(6):网络地址与端口转换",
"Qos(7):增强网络层提供的服务","TPDU(7):传输协议数据单元","URG(7):TCP报文首部字段，代表紧急数据","ACK(7):TCP报文首部字段，确认","PSH(7):TCP报文首部字段，尽快交付","RST(7):TCP报文首部字段，复位，标识TCP连接有严重差错，必须释放重连接","SYN(7):TCP报文首部字段，连接请求/连接接受","FIN(7):TCP报文首部字段，释放链接","MSS(7):TCP报文段中数据字段的最大长度","thernet(7):赋予以太网地址","socket(7):套接字",
"DNS(8):域名系统","GUI(8):为用户提供图形用户界面","zone(8):区域","Cache(8):DNS中的高速缓存","gateway(8):网关","relay host(8):中继主机","POP3(8):一个协议，应用层，负责接收邮件，脱机协议","IMAP(8):一个应用层协议，负责接收邮件，联机协议","SMTP(8):简单的邮件传输协议","MIME(8):多用途Internet邮件扩展","WWW(8):万维网","HTML(8):超文本标记语言","Hypertext(8):超文本","Hypermedie(8):超媒体","Home Page(8):主页","URL(8):统一资源定位器","HTTP(8):超文本传输协议"};
        //（1）代表第一章，图片上有标明是第几章,逗号和双引号要英语的
        String[] a = new mysort().answer(b);
        for(String ss:a){
            System.out.println(ss);
        }
    }

    public String[] answer(String[] B) {
        Arrays.sort(B);
        return B;
    }
}