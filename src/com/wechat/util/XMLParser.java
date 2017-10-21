package com.wechat.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wechat.protocol.refundquery.RefundOrderData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class XMLParser {

    public static String toXML(Object o) {
        XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        xStream.autodetectAnnotations(true);
        return xStream.toXML(o);
    }

    public static String toXML(String alias, Object o) {
        XStream xStream = new XStream();
        xStream.alias(alias, o.getClass());
        return xStream.toXML(o);
    }

    public static Map<String, Object> getMapFromXML(String xmlString) throws ParserConfigurationException, IOException, SAXException {

        //这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream is = Util.getStringStream(xmlString);
        Document document = builder.parse(is);

        //获取到document里面的全部结点
        NodeList allNodes = document.getFirstChild().getChildNodes();
        Node node;
        Map<String, Object> map = new HashMap<String, Object>();
        int i = 0;
        while (i < allNodes.getLength()) {
            node = allNodes.item(i);
            if (node instanceof Element) {
                map.put(node.getNodeName(), node.getTextContent());
            }
            i++;
        }
        return map;

    }

    public static String toCDATAXml(String alias, Object obj) {
        XStream xstream = new XStream(new XppDriver() {
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    // 对那些xml节点的转换增加CDATA标记   true增加  false反之
                    boolean cdata = false;

                    @Override
                    public void setValue(String text) {

                        if (text != null && !"".equals(text)) {
                            //浮点型判断
                            Pattern patternInt = Pattern.compile("[0-9]*(\\.?)[0-9]*");
                            //整型判断
                            Pattern patternFloat = Pattern.compile("[0-9]+");
                            //如果是整数或浮点数 就不要加[CDATA[]了
                            if (patternInt.matcher(text).matches() || patternFloat.matcher(text).matches()) {
                                cdata = false;
                            } else {
                                cdata = true;
                            }
                        }
                        super.setValue(text);
                    }

                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
                        } else {
                            writer.write(text);
                        }
                    }
                };
            }
        });
        xstream.alias(alias, obj.getClass());
        return xstream.toXML(obj);
    }

    public static String toCDATAXml(Object obj) {
        return toCDATAXml("xml", obj);
    }


    /**
     * 从RefunQueryResponseString里面解析出退款订单数据
     *
     * @param refundQueryResponseString RefundQuery API返回的数据
     * @return 因为订单数据有可能是多个，所以返回一个列表
     */
    public static List<RefundOrderData> getRefundOrderList(String refundQueryResponseString) throws IOException, SAXException, ParserConfigurationException {
        List list = new ArrayList();

        Map<String, Object> map = XMLParser.getMapFromXML(refundQueryResponseString);

        int count = Integer.parseInt((String) map.get("refund_count"));
        Util.log("count:" + count);

        if (count < 1) {
            return list;
        }

        RefundOrderData refundOrderData;

        for (int i = 0; i < count; i++) {
            refundOrderData = new RefundOrderData();

            refundOrderData.setOutRefundNo(Util.getStringFromMap(map, "out_refund_no_" + i, ""));
            refundOrderData.setRefundID(Util.getStringFromMap(map, "refund_id_" + i, ""));
            refundOrderData.setRefundChannel(Util.getStringFromMap(map, "refund_channel_" + i, ""));
            refundOrderData.setRefundFee(Util.getIntFromMap(map, "refund_fee_" + i));
            refundOrderData.setCouponRefundFee(Util.getIntFromMap(map, "coupon_refund_fee_" + i));
            refundOrderData.setRefundStatus(Util.getStringFromMap(map, "refund_status_" + i, ""));
            list.add(refundOrderData);
        }

        return list;
    }

}
