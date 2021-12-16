import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {


    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        JSONObject jsonObject = JSON.parseObject("{\"list\":[{\"id\":7,\"name\":\"1111\"}]}");
        JSONArray list = jsonObject.getJSONArray("list");
        for (int x = 0; x<list.size(); x++) {
            JSONObject jsonObject1 = list.getJSONObject(x);
            System.out.print(jsonObject1.get("id"));
            System.out.println(jsonObject1.get("name"));
        }
    }
}
