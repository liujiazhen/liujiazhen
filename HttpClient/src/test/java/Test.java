import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.*;

public class Test {

    private static final String ENCODING = "GBK";

/* 返回值案例
<?xml version="1.0" encoding="GBK"?>
<CLEcdsData>
	<opRep>
		<retCode></retCode>
        <retMsg></retMsg>
        <serialNo>1234567890123</serialNo>
        <opResult>
            <list>
				<pyeeName>aaa</pyeeName>
				<pyeeAcctsvcr>ddd</pyeeAcctsvcr>
			</list>
			<list>
				<pyeeName>bbb</pyeeName>
				<pyeeAcctsvcr>ccc</pyeeAcctsvcr>
			</list>
		</opResult>
	</opRep>
</CLEcdsData>
 */
    /**
     * 根据XML字符串生成JavaBean
     * <p>
     * xmlStr xml字符串
     *
     * @return 接口返回值转为map
     */
    private static Map<String, Object> xml2Entity(String xmlStr) {
        Document document;
        try {
            document = DocumentHelper.parseText(xmlStr);
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }
        Map<String, Object> resultMap = new HashMap<>(4);

        Element root = document.getRootElement();
        Element opRep = root.element("opRep");
        String serialNo = opRep.elementText("serialNo");
        String retCode = opRep.elementText("retCode");
        String retMsg = opRep.elementText("retMsg");

        resultMap.put("retCode", retCode);
        resultMap.put("retMsg", retMsg);
        resultMap.put("serialNo", serialNo);

        Element opResult = opRep.element("opResult");
        List<Element> elementList = opResult.elements("list");

        List<ECD7071Output> outputList = new ArrayList<>();
        for (Element element : elementList) {
            ECD7071Output temp = new ECD7071Output();
            temp.setPyeeName(element.elementText("pyeeName"));
            temp.setPyeeAcctsvcr(element.elementText("pyeeAcctsvcr"));
            outputList.add(temp);
        }
        resultMap.put("result", outputList);
        return resultMap;
    }


    public static void main(String[] args) {
        String s = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<CLEcdsData>\n" +
                "\t<opRep>\n" +
                "\t\t<retCode></retCode>\n" +
                "        <retMsg></retMsg>\n" +
                "        <serialNo>1234567890123</serialNo>\n" +
                "        <opResult>\n" +
                "            <list>\n" +
                "\t\t\t\t<pyeeName>aaa</pyeeName>\n" +
                "\t\t\t\t<pyeeAcctsvcr>ddd</pyeeAcctsvcr>\n" +
                "\t\t\t</list>\n" +
                "\t\t\t<list>\n" +
                "\t\t\t\t<pyeeName>bbb</pyeeName>\n" +
                "\t\t\t\t<pyeeAcctsvcr>ccc</pyeeAcctsvcr>\n" +
                "\t\t\t</list>\n" +
                "\t\t</opResult>\n" +
                "\t</opRep>\n" +
                "</CLEcdsData>";

        Map<String, Object> map = xml2Entity(s);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey()+"="+next.getValue());
        }

    }
}
